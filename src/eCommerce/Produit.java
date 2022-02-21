package eCommerce;

public abstract class Produit {

    private String nom;
    private double poids;
    private int noSerie;

    private static int noSerieCompteur = 0;

    public Produit(String nom, double poids){
        this.nom = nom;
        this.poids = poids;
        noSerie = noSerieCompteur++;
    }

    public double getPoids() {

        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }


	public String getNom() {
		return nom;
	}
    
    
    

}
