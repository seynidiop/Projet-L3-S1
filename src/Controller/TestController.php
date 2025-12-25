<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Attribute\Route;

class TestController extends AbstractController
{
    #[Route('/test/index', name: 'app_test')]
    public function index(): Response
    {
        return $this->render('test/index.html.twig', [
            'title' => 'Test Render + Symfony',
            'status' => 'Tout fonctionne correctement 🚀'
        ]);
    }
}
