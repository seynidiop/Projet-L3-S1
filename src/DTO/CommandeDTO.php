<?php

namespace App\DTO;

use App\Entity\Commande;
use App\Entity\Complement;
use App\Entity\Menu;



class CommandeDTO 
{
    public ?int $id = null;
    public ?string $nomClient = null;
    public ?string $numeroClient = null;
    public ?string $nature = null;
    public ?string $complement = null;
    public ?string $etat = null;
    public ?\DateTimeInterface $date = null;
    public ?float $montant = null;
    public ?string $type = null;
    public ?string $statut = null;


    public static function fromEntity(\App\Entity\Commande $commande): self
    {
        $dto = new self();
        $dto->id = $commande->getId();
        $dto->nomClient = $commande->getClient() ? $commande->getClient()->getFirstName() : null;
        $dto->numeroClient = $commande->getClient() ? $commande->getClient()->getPhone() : null;
        $dto->nature = $commande->getBurger() ? "Burger" : ($commande->getMenu() ? "Menu" : null);
        $dto->complement = $commande->getComplement() ? $commande->getComplement()->getName() : "Aucun";
        $dto->etat = $commande->getStatut();
        $dto->date = $commande->getDatecommande();
        $dto->montant = $commande->getMontanttotal() !== null ? (float)$commande->getMontanttotal() : null;
        $dto->type = $commande->getTypecons();
       

        return $dto;
    }

    public static function toEntityArray(array $entities): array
    {
        return array_map(function(Commande $entity){
            return self::fromEntity($entity);
        }, $entities);
    }
}