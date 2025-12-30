<?php

namespace App\Repository;

use App\Entity\Commande;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @extends ServiceEntityRepository<Commande>
 */
class CommandeRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Commande::class);
    }

    //    /**
    //     * @return Commande[] Returns an array of Commande objects
    //     */
    //    public function findByExampleField($value): array
    //    {
    //        return $this->createQueryBuilder('c')
    //            ->andWhere('c.exampleField = :val')
    //            ->setParameter('val', $value)
    //            ->orderBy('c.id', 'ASC')
    //            ->setMaxResults(10)
    //            ->getQuery()
    //            ->getResult()
    //        ;
    //    }

    //    public function findOneBySomeField($value): ?Commande
    //    {
    //        return $this->createQueryBuilder('c')
    //            ->andWhere('c.exampleField = :val')
    //            ->setParameter('val', $value)
    //            ->getQuery()
    //            ->getOneOrNullResult()
    //        ;
    //    }

    public function alter(Employe $entity, bool $flush = false): void
    {
        $this->getEntityManager()->persist($entity);

        if ($flush) {
            $this->getEntityManager()->flush();
        }
    }

   public function getMostSoldBurger(): ?array
{
    return $this->createQueryBuilder('c')
        ->select('b.name, COUNT(c.id)')
        ->join('c.burger', 'b')
        ->where('c.statut = :statut')
        ->setParameter('statut', 'Terminé')
        ->groupBy('b.id')
        ->orderBy('COUNT(c.id)', 'DESC')
        ->setMaxResults(1)
        ->getQuery()
        ->getOneOrNullResult();
}


  public function countTodayCompletedOrders(): int
{
    $today = new \DateTimeImmutable('today');
    $tomorrow = $today->modify('+1 day');

    return (int) $this->createQueryBuilder('c')
        ->select('COUNT(c.id)')
        ->where('c.statut = :statut')
        ->andWhere('c.datecommande >= :today')
        ->andWhere('c.datecommande < :tomorrow')
        ->setParameter('statut', 'Terminé')
        ->setParameter('today', $today)
        ->setParameter('tomorrow', $tomorrow)
        ->getQuery()
        ->getSingleScalarResult();
}


   public function getTodayCompletedTotal(): float
{
    $today = new \DateTimeImmutable('today');
    $tomorrow = $today->modify('+1 day');

    return (float) $this->createQueryBuilder('c')
        ->select('SUM(c.montanttotal)')
        ->where('c.statut = :statut')
        ->andWhere('c.datecommande >= :today')
        ->andWhere('c.datecommande < :tomorrow')
        ->setParameter('statut', 'Terminé')
        ->setParameter('today', $today)
        ->setParameter('tomorrow', $tomorrow)
        ->getQuery()
        ->getSingleScalarResult();
}


   public function countEnCours(): int
{
    return (int) $this->createQueryBuilder('c')
        ->select('COUNT(c.id)')
        ->where('c.statut = :statut')
        ->setParameter('statut', 'En cours')
        ->getQuery()
        ->getSingleScalarResult();
}


public function getTop3MostSoldBurgers(): array
{
    return $this->createQueryBuilder('c')
        ->select('b.name, COUNT(c.id)')
        ->join('c.burger', 'b')
        ->where('c.statut = :statut')
        ->andWhere('c.burger IS NOT NULL')
        ->setParameter('statut', 'Terminé')
        ->groupBy('b.id')
        ->orderBy('COUNT(c.id)', 'DESC')
        ->setMaxResults(3)
        ->getQuery()
        ->getResult();
}



}
