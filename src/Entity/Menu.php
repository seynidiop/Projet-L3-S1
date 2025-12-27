<?php

namespace App\Entity;

use App\Repository\MenuRepository;
use Doctrine\ORM\Mapping as ORM;

#[ORM\Entity(repositoryClass: MenuRepository::class)]
class Menu
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\Column(length: 255)]
    private ?string $nom = null;

    #[ORM\Column(length: 255)]
    private ?string $description = null;

    #[ORM\ManyToOne]
    #[ORM\JoinColumn(name: "burgerid", referencedColumnName: "id", nullable: true)]
    private ?Burger $burgerid = null;

    #[ORM\ManyToOne]
    #[ORM\JoinColumn(name: "complementid", referencedColumnName: "id", nullable: true)]

    private ?Complement $complement = null;
    #[ORM\Column(length: 255)]
    private ?string $imagepath = null;

    #[ORM\Column]
    private ?bool $archived = null;

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

    public function getDescription(): ?string
    {
        return $this->description;
    }

    public function setDescription(string $description): static
    {
        $this->description = $description;

        return $this;
    }

    public function getBurgerid(): ?burger
    {
        return $this->burgerid;
    }

    public function setBurgerid(?burger $burgerid): static
    {
        $this->burgerid = $burgerid;

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

    public function getImagepath(): ?string
    {
        return $this->imagepath;
    }

    public function setImagepath(string $imagepath): static
    {
        $this->imagepath = $imagepath;

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
}
