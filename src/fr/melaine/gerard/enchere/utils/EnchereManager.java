package fr.melaine.gerard.enchere.utils;

import fr.melaine.gerard.enchere.entities.Enchere;
import fr.melaine.gerard.enchere.entities.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnchereManager {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Enchere> enchereList = new ArrayList<>();
    public static void createEnchere() {
        String name = "";

        while (name.isBlank()) {
            System.out.print("Nom de l'enchère : ");
            name = scanner.nextLine().trim();
        }

        Enchere enchere = new Enchere(name);
        enchereList.add(enchere);
        System.out.println("Création d'une enchère");
    }

    public static void displayEncheres() {
        if (enchereList.isEmpty()) {
            System.out.println("Aucune enchère n'a été créée");
            return;
        }
        System.out.println("Liste des enchères :");

        for (Enchere enchere : enchereList) {
            System.out.printf("%d- %s%n", enchereList.indexOf(enchere) + 1, enchere);
        }
    }

    public static void createItemInEnchere() {
        Enchere enchere = getEnchere();

        if (enchere == null) return;

        String name = "";

        while (name.isBlank()) {
            System.out.print("Nom du produit : ");
            name = scanner.nextLine().trim();
        }

        String poids = "";

        while (poids.isBlank()) {
            System.out.print("Poids du produit : ");
            poids = scanner.nextLine().trim();
        }

        int finalPoids = Integer.parseInt(poids);

        double startingPrice = 0;

        while (startingPrice <= 0) {
            System.out.print("Prix de départ du produit : ");
            startingPrice = Double.parseDouble(scanner.nextLine());
        }

        enchere.getItems().add(new Item(name, finalPoids, startingPrice));

        System.out.println("Ajout d'un produit à une enchère");
    }

    public static void displayItemsInEnchere() {
        Enchere enchere = getEnchere();
        if (enchere == null) return;

        if (enchere.getItems().isEmpty()) {
            System.out.println("Aucun produit n'a été ajouté à cette enchère");
            return;
        }

        System.out.printf("Liste des produits de l'enchère %s :%n", enchere.getName());

        for (Item item : enchere.getItems()) {
            System.out.printf("%d- %s%n", enchere.getItems().indexOf(item) + 1, item);
        }
    }

    private static Enchere getEnchere() {

        if (enchereList.isEmpty()) {
            System.out.println("Aucune enchère n'a été créée");
            return null;
        }
        int enchereIndex = -1;

        while (enchereIndex < 0 || enchereIndex > enchereList.size()) {
            System.out.print("Numéro de l'enchère : ");
            enchereIndex = Integer.parseInt(scanner.nextLine());
        }

        return enchereList.get(enchereIndex - 1);
    }
}
