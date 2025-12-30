<?php
namespace App\DTO;
use \DateTimeImmutable;
use App\Entity\Burger;
use App\Entity\Menu;


class CommandeSearchDTO
{
    public ?string $produitType = null ;
    public ?\DateTimeInterface $datecommande = null;
    public ?String $phone=null;
    public ?Burger $burger = null;
    public ?Menu $menu = null;
}