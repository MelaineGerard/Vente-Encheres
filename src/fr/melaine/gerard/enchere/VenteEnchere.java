package fr.melaine.gerard.enchere;

import fr.melaine.gerard.enchere.managers.MenuManager;

public class VenteEnchere {

    public static void main(String[] args) {
        System.out.println("Bienvenue dans le programme de vente aux enchères !");
        int choice = 0;

        while (choice != 6) {
            MenuManager.displayMenu();
            choice = MenuManager.askChoice();
            MenuManager.handleChoice(choice);
        }
    }
}
