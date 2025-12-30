<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Attribute\Route;
use App\Repository\CommandeRepository;


class DashboardController extends AbstractController
{
   #[Route('/dashboard/index', name: 'app_dashboard')]
    public function index(CommandeRepository $commandeRepository): Response
    {
        return $this->render('dashboard/index.html.twig', [
            'mostSoldBurger' => $commandeRepository->getMostSoldBurger(),
            'todayTotal' => $commandeRepository->getTodayCompletedTotal(),
            'commandesEnCours' => $commandeRepository->countEnCours(),
            'commandesCompletes' => $commandeRepository->countTodayCompletedOrders(),
            'topBurgers' => $commandeRepository->getTop3MostSoldBurgers(),

        ]);
    }

}
