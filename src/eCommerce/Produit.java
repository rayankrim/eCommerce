package eCommerce;

public abstract class Produit {

    protected String nom;
    protected double poids;
    protected int noSerie;

    private static int noSerieCompteur = 0;

    public Produit(String nom, double poids){
        this.nom = nom;
        this.poids = poids;
        noSerie = noSerieCompteur++;
    }

    public double getPoids() {

        return poids;
    }



}
