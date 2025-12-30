<?php

namespace App\Form;

use App\Entity\Burger;
use App\Entity\Client;
use App\Entity\Commande;
use App\Entity\Complement;
use App\Entity\Menu;
use App\Entity\Zone;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\DateType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use App\DTO\CommandeSearchDTO;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\HiddenType;

class CommandeSearchType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('produitType', ChoiceType::class, [
                'choices' => [
                    'Tous'   => null,
                    'Burger' => 'burger',
                    'Menu'   => 'menu',
                ],
                'attr' => [
                    'class' => 'search',
                ],
                'placeholder' => false,   // empêche un choix vide en plus
                'required' => false,
            ])


            // 2️⃣ Filtre par date
            ->add('datecommande', DateType::class, [
                'widget' => 'single_text',
                'input' => 'datetime_immutable',
                'required' => false,
                'attr' => [
                    'class' => 'search',
                ],
            ])
                ->add('burger', EntityType::class, [
                'class' => Burger::class,
                'required' => false,
                'choice_label' => 'name',
                'attr' => [
                'style' => 'display:none;',
            ],
            ])
            ->add('menu', EntityType::class, [
                'class' => Menu::class,
                'choice_label' => 'nom',
                'required' => false,
                
                'attr' => [
                'style' => 'display:none;',
                'hidden' => true,
         ],
            ])
            // 3️⃣ Filtre par client
            ->add('phone', TextType::class, [
                'attr' => [
                    'class' => 'search',
                    'placeholder' => 'Saisir un numéro de téléphone',
                    'type'=>'submit'
                ],
                'required' => false,
            ])
             ->add('btnSubmit', SubmitType::class, [
                'label' => 'Filtrer',
                'attr' => [
                    'class' => 'filter',
                    'type'=>'submit'],
            ])
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => CommandeSearchDTO::class,
            'method' => 'GET',        // 🔥 recommandé pour les filtres
            'csrf_protection' => false,
            'default_data' => "Tous",
            'attr'=>['data-turbo'=>'false']
        ]);
    }
}
