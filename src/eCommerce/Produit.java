package eCommerce;

public abstract class Produit {

    protected String nom;
    protected double poids;


    public Produit(String nom, double poids){
        this.nom = nom;
        this.poids = poids;
    }

    public double getPoids() {
        return poids;
    }



}
