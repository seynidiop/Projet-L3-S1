<?php

namespace App\Entity;

use App\Repository\CommandeRepository;
use Doctrine\DBAL\Types\Types;
use Doctrine\ORM\Mapping as ORM;

#[ORM\Entity(repositoryClass: CommandeRepository::class)]
class Commande
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\ManyToOne]
    private ?burger $burger = null;

    #[ORM\ManyToOne]
    private ?menu $menu = null;

    #[ORM\ManyToOne]
    private ?complement $complement = null;

    #[ORM\Column(type: Types::DECIMAL, precision: 10, scale: 0)]
    private ?string $price = null;

    #[ORM\Column(type: Types::DATE_IMMUTABLE)]
    private ?\DateTimeImmutable $datecommande = null;

    #[ORM\Column(length: 255)]
    private ?string $statut = null;

    #[ORM\Column(length: 255)]
    private ?string $modepaiement = null;

    #[ORM\Column(length: 255)]
    private ?string $typecons = null;

    #[ORM\Column(type: Types::DECIMAL, precision: 10, scale: 0)]
    private ?string $montanttotal = null;

    #[ORM\Column]
    private ?bool $archived = null;

    #[ORM\ManyToOne]
    #[ORM\JoinColumn(nullable: false)]
    private ?client $client = null;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getBurger(): ?burger
    {
        return $this->burger;
    }

    public function setBurger(?burger $burger): static
    {
        $this->burger = $burger;

        return $this;
    }

    public function getMenu(): ?menu
    {
        return $this->menu;
    }

    public function setMenu(?menu $menu): static
    {
        $this->menu = $menu;

        return $this;
    }

    public function getComplement(): ?complement
    {
        return $this->complement;
    }

    public function setComplement(?complement $complement): static
    {
        $this->complement = $complement;

        return $this;
    }

    public function getPrice(): ?string
    {
        return $this->price;
    }

    public function setPrice(string $price): static
    {
        $this->price = $price;

        return $this;
    }

    public function getDatecommande(): ?\DateTimeImmutable
    {
        return $this->datecommande;
    }

    public function setDatecommande(\DateTimeImmutable $datecommande): static
    {
        $this->datecommande = $datecommande;

        return $this;
    }

    public function getStatut(): ?string
    {
        return $this->statut;
    }

    public function setStatut(string $statut): static
    {
        $this->statut = $statut;

        return $this;
    }

    public function getModepaiement(): ?string
    {
        return $this->modepaiement;
    }

    public function setModepaiement(string $modepaiement): static
    {
        $this->modepaiement = $modepaiement;

        return $this;
    }

    public function getTypecons(): ?string
    {
        return $this->typecons;
    }

    public function setTypecons(string $typecons): static
    {
        $this->typecons = $typecons;

        return $this;
    }

    public function getMontanttotal(): ?string
    {
        return $this->montanttotal;
    }

    public function setMontanttotal(string $montanttotal): static
    {
        $this->montanttotal = $montanttotal;

        return $this;
    }

    public function isArchived(): ?bool
    {
        return $this->archived;
    }

    public function setArchived(bool $archived): static
    {
        $this->archived = $archived;

        return $this;
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
}
