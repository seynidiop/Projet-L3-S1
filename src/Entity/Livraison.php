<?php

namespace App\Entity;

use App\Repository\LivraisonRepository;
use Doctrine\ORM\Mapping as ORM;

#[ORM\Entity(repositoryClass: LivraisonRepository::class)]
class Livraison
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\ManyToOne]
    #[ORM\JoinColumn(nullable: false)]
    private ?client $client = null;

    #[ORM\ManyToOne(inversedBy: 'livraisons')]
    #[ORM\JoinColumn(nullable: false)]
    private ?livreur $livreur = null;

    #[ORM\ManyToOne]
    #[ORM\JoinColumn(nullable: false)]
    private ?commande $commande = null;

    #[ORM\ManyToOne(inversedBy: 'livraisons')]
    #[ORM\JoinColumn(nullable: false)]
    private ?zone $zone = null;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getClient(): ?client
    {
        return $this->client;
    }

    public function setClient(?client $client): static
    {
        $this->client = $client;

        return $this;
    }

    public function getLivreur(): ?livreur
    {
        return $this->livreur;
    }

    public function setLivreur(?livreur $livreur): static
    {
        $this->livreur = $livreur;

        return $this;
    }

    public function getCommande(): ?commande
    {
        return $this->commande;
    }

    public function setCommande(?commande $commande): static
    {
        $this->commande = $commande;

        return $this;
    }

    public function getZone(): ?zone
    {
        return $this->zone;
    }

    public function setZone(?zone $zone): static
    {
        $this->zone = $zone;

        return $this;
    }
}
