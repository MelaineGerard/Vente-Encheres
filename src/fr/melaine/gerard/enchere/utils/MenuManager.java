package fr.melaine.gerard.enchere.utils;

import fr.melaine.gerard.enchere.entities.Enchere;

import java.util.Scanner;

public class MenuManager {
    public static void displayMenu() {
        System.out.println("Menu principal :");
        System.out.println("1- Créer une enchère");
        System.out.println("2- Ajouter un produit à une enchère");
        System.out.println("3- Afficher les enchères");
        System.out.println("4- Afficher les produits d'une enchère");
        System.out.println("5- Lancer une enchère");
        System.out.println("6- Quitter");
        System.out.println();
    }

    public static int askChoice() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        while (choice < 1 || choice > 6) {
            System.out.print("Votre choix : ");
            choice = Integer.parseInt(scanner.nextLine());
        }

        return choice;
    }

    public static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                EnchereManager.createEnchere();
                break;
            case 2:
                EnchereManager.createItemInEnchere();
                break;
            case 3:
                EnchereManager.displayEncheres();
                break;
            case 4:
                EnchereManager.displayItemsInEnchere();
                break;
            case 5:
                System.out.println("Lancement d'une enchère");
                break;
            case 6:
                System.out.println("Au revoir !");
                break;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }


}
