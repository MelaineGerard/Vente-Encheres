package fr.melaine.gerard.enchere;

import fr.melaine.gerard.enchere.managers.MenuManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class VenteEnchere extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(VenteEnchere.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Vente aux enchères");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue dans le programme de vente aux enchères !");

        int choice = -1;

        while (choice < 1 || choice > 3) {
            System.out.println("Veuillez choisir une option :");
            System.out.println("1 - Version CLI");
            System.out.println("2 - Version GUI");
            System.out.println("3 - Quitter");

            choice = scanner.nextInt();
        }

        switch (choice) {
            case 1:
                System.out.println("Vous avez choisi la version CLI");
                handleCli();
                break;
            case 2:
                System.out.println("Vous avez choisi la version GUI");
                launch();
                break;
            case 3:
                System.out.println("Au revoir !");
                System.exit(0);
                break;
        }

        System.exit(0);
    }

    private static void handleCli() {
        int choice = 0;

        while (choice != 6) {
            MenuManager.displayMenu();
            choice = MenuManager.askChoice();
            MenuManager.handleChoice(choice);
        }
    }
}
