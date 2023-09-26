package fr.melaine.gerard.enchere.entities;

public class Item {
    private final String name;
    private final double poids;
    private final double startingPrice;
    private double currentPrice;

    private User finalBuyer;
    private User currentBuyer;


    public Item(String name, double poids, double startingPrice) {
        this.name = name;
        this.poids = poids;
        this.startingPrice = startingPrice;

        this.currentPrice = startingPrice;
    }

    public String getName() {
        return name;
    }

    public double getPoids() {
        return poids;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public User getCurrentBuyer() {
        return currentBuyer;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public User getFinalBuyer() {
        return finalBuyer;
    }

    public void setFinalBuyer(User finalBuyer) {
        this.finalBuyer = finalBuyer;
    }

    @Override
    public String toString() {
        return "Produit %s de poids %f kg avec un prix de départ de %f € et un prix actuel de %f €".formatted(getName(), getPoids(), getStartingPrice(), getCurrentPrice());
    }

    public void setCurrentBuyer(User user) {
        this.currentBuyer = user;
    }
}