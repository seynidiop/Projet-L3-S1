<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\Routing\Attribute\Route;
use App\Repository\ClientRepository;
use App\Repository\CommandeRepository;
use App\DTO\CommandeDTO;
use App\DTO\CommandeSearchDTO;
use App\Entity\Commande;

class CommandeController extends AbstractController
{

    public function __construct(private readonly CommandeRepository $commandeRepository,private readonly EntityManagerInterface $manager)
    {
    }

    private const limit=3;

        #[Route('/commande/list', name: 'app_commande_list')]
        public function list(Request $request): Response
        {   
            $filtre = [];
            $searchFormDTO = new CommandeSearchDTO();
            $form = $this->createForm(\App\Form\CommandeSearchType::class, $searchFormDTO,[
                'method' => 'GET',
                'csrf_protection' => false,
            ]);
            $form->handleRequest($request);
            $page=$request->query->get("page",1);
            $offset=($page-1)*self::limit;
            $commandes = $this->commandeRepository->findBy($filtre,["id"=>"DESC"],self::limit,$offset);
            if ($form->isSubmitted() && $form->isValid()) {
                if ($searchFormDTO->phone !== null) {
                $commandes = array_filter($commandes, function ($commande) use ($searchFormDTO) {
                    return $commande->getClient()
                        && str_contains(
                            $commande->getClient()->getPhone(),
                            $searchFormDTO->phone
                        );
                });
                }
                if ($searchFormDTO->produitType !== null) {
                    switch ($searchFormDTO->produitType) {
                        case 'burger':
                            $filtre['menu'] = $searchFormDTO->menu;
                            break;
                        case 'menu':
                            $filtre['burger'] = $searchFormDTO->burger;
                            break;
                        
                        default:
                        
                            break;
                    }
                }
                if ($searchFormDTO->datecommande) {
                    $filtre['datecommande'] = $searchFormDTO->datecommande;
                }
            
            $commandesDTO= CommandeDTO::toEntityArray($commandes);
            $count= $this->commandeRepository->count();
            $nbrePages=ceil($count/self::limit);

            return $this->render('commande/list.html.twig', [
                'commandes' => $commandesDTO,
                'totalPages'=>$nbrePages,
                'currentPage'=>$page,
                'formSearch' => $form->createView(),
            ]);
        }

        $page=$request->query->get("page",1);
            $offset=($page-1)*self::limit;
            $commandes = $this->commandeRepository->findBy($filtre,["id"=>"DESC"],self::limit,$offset);
            $commandesDTO= CommandeDTO::toEntityArray($commandes);
            $count= $this->commandeRepository->count();
            $nbrePages=ceil($count/self::limit);

            return $this->render('commande/list.html.twig', [
                'commandes' => $commandesDTO,
                'totalPages'=>$nbrePages,
                'currentPage'=>$page,
                'formSearch' => $form->createView(),
            ]);
    }

    #[Route('/commande/{id}/terminer', name: 'app_commande_terminer', methods: ['GET'])]
    public function terminerCommande(int $id, EntityManagerInterface $em): Response {
        $commande = $em->getRepository(Commande::class)->find($id);

        if (!$commande) {
            throw $this->createNotFoundException('Commande introuvable');
        }

        // 🔹 Mise à jour de l’état
        $commande->setStatut('Terminé');

        $em->flush();

        $this->addFlash('success', 'Commande marquée comme terminée.');

        return $this->redirectToRoute('app_commande_list');
    }

    #[Route('/commande/{id}/annuler', name: 'app_commande_annuler', methods: ['GET'])]
    public function annulerCommande(int $id,EntityManagerInterface $em): Response {
        $commande = $em->getRepository(Commande::class)->find($id);

        if (!$commande) {
            throw $this->createNotFoundException('Commande introuvable');
        }

        $em->remove($commande);
        $em->flush();

        $this->addFlash('success', 'La commande a été annulée avec succès.');

        return $this->redirectToRoute('app_commande_list');
    }


}