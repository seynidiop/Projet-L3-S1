<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\Routing\Attribute\Route;
use App\Repository\CommandeRepository;
use App\DTO\CommandeDTO;

class CommandeController extends AbstractController
{

    public function __construct(private readonly CommandeRepository $commandeRepository,private readonly EntityManagerInterface $manager)
    {
    }

    private const limit=5;

    #[Route('/commande/list', name: 'app_commande_list')]
    public function list(Request $request): Response
    {   
        $page=$request->query->get("page",1);
        $offset=($page-1)*self::limit;
        $commandes = $this->commandeRepository->findAll();
        $commandesDTO= CommandeDTO::toEntityArray($commandes);
        $count= $this->commandeRepository->count();
        $nbrePages=ceil($count/self::limit);

        return $this->render('commande/list.html.twig', [
            'commandes' => $commandesDTO,
            'totalPages'=>$nbrePages,
            'currentPage'=>$page
        ]);
    }
}