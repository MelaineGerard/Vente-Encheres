package fr.melaine.gerard.enchere.managers;

import fr.melaine.gerard.enchere.entities.Enchere;
import fr.melaine.gerard.enchere.entities.Item;
import fr.melaine.gerard.enchere.entities.User;

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

        int finalPoids = parseInt(poids);

        double startingPrice = 0;

        while (startingPrice <= 0) {
            System.out.print("Prix de départ du produit : ");
            startingPrice = parseDouble(scanner.nextLine());
        }

        enchere.addItem(new Item(name, finalPoids, startingPrice));

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
            enchereIndex = parseInt(scanner.nextLine());
        }

        return enchereList.get(enchereIndex - 1);
    }

    public static void startEnchere() {
        if (enchereList.isEmpty()) {
            System.out.println("Aucune enchère n'a été créée");
            return;
        }

        int enchereIndex = -1;

        while (enchereIndex < 0 || enchereIndex > enchereList.size()) {
            System.out.print("Numéro de l'enchère : ");
            enchereIndex = parseInt(scanner.nextLine());
        }

        Enchere enchere = enchereList.get(enchereIndex - 1);
        if (enchere.getItems().isEmpty()) {
            System.out.println("Aucun produit n'a été ajouté à cette enchère");
            return;
        }


        String input = "";

        while (!input.equals("fin")) {
            System.out.println("Quel est le nom du participant ? ");
            input = scanner.nextLine();

            if (!input.equals("fin")) {
                enchere.addUser(new User(input));
            }
        }

        if (enchere.getUsers().isEmpty()) {
            System.out.println("Aucun participant n'a été ajouté à cette enchère");
            return;
        }

        System.out.printf("Il y a %d participants%n", enchere.getUsers().size());
        System.out.println("L'enchère va commencer !");

        for (Item item : enchere.getItems()) {
            System.out.printf("L'enchère pour le produit %s va commencer !%n", item.getName());
            String currentInput = "";

            while (!currentInput.equals("fin")) {
                currentInput = "";
                while (!currentInput.equals("fin") && (parseInt(currentInput) < 1 || parseInt(currentInput) > enchere.getUsers().size())) {
                    displayUsers(enchere);
                    System.out.println("Quel est le numéro du candidat ? ");
                    currentInput = scanner.nextLine();
                }

                if (!currentInput.equals("fin")) {
                    int userIndex = parseInt(currentInput);
                    User user = enchere.getUsers().get(userIndex - 1);
                    double mise = 0;
                    System.out.printf("Le prix actuel est de %f€%n", item.getCurrentPrice());

                    while (mise <= item.getCurrentPrice()) {
                        System.out.println("Quelle est la mise ? ");
                        mise = parseDouble(scanner.nextLine());
                    }

                    item.setCurrentPrice(mise);
                    item.setCurrentBuyer(user);
                    System.out.printf("Le candidat %s a fait une offre de %f€%n", user.getName(), mise);
                }
            }

            item.setFinalBuyer(item.getCurrentBuyer());
            System.out.printf("Le produit %s a été vendu à %s pour %f€%n", item.getName(), item.getFinalBuyer().getName(), item.getCurrentPrice());
        }

        System.out.println("L'enchère est terminée !");
        System.out.println("Voici le récapitulatif :");

        for (Item item : enchere.getItems()) {
            System.out.printf("Le produit %s a été vendu à %s pour %f€ à %s%n", item.getName(), item.getFinalBuyer().getName(), item.getCurrentPrice(), item.getFinalBuyer().getName());
        }
    }

    private static void displayUsers(Enchere enchere) {
        for (User user : enchere.getUsers()) {
            System.out.printf("%d- %s%n", enchere.getUsers().indexOf(user) + 1, user.getName());
        }
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static double parseDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
