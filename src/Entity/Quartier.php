<?php

namespace App\Entity;

use App\Repository\QuartierRepository;
use Doctrine\ORM\Mapping as ORM;

#[ORM\Entity(repositoryClass: QuartierRepository::class)]
class Quartier
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\Column(length: 255)]
    private ?string $nom = null;

    #[ORM\ManyToOne(inversedBy: 'quartiers')]
    #[ORM\JoinColumn(nullable: false)]
    private ?zone $zone = null;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNom(): ?string
    {
        return $this->nom;
    }

    public function setNom(string $nom): static
    {
        $this->nom = $nom;

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
