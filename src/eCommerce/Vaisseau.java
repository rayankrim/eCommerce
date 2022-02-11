package eCommerce;

public abstract class Vaisseau {

	protected double capaciteMax;
	protected double stockage;
	protected int noSerie;

	private static int noSerieCompteur = 0;

	Vaisseau(double capaciteMax) {
		this.capaciteMax = capaciteMax;
		stockage = 0;
		noSerie = noSerieCompteur++;
	}

	public void charger(Produit Produit) {
		// On verifie qu'il y a de la place pour le produit qu'on veut charger
		double balance = capaciteMax - stockage + this.poidsProduit;
		// Condition pour charger un nouveau produit
		if (balance > 0) {
			stockage += poidsProduit;
	protected Produit produit;
	

	public void charger(Produit Produit) {
		
		//On verifie qu'il y a de la place pour le produit qu'on veut charger
		double balance = capaciteMax - stockage + this.produit.getPoids();
		
		//Condition pour charger un nouveau produit
		if(balance > 0) {
			stockage += this.produit.getPoids();
			System.out.println("on charge le machin");
		}
	}

	public void decharger(Produit Produit) {
		// On retire le produit
		stockage -= poidsProduit;
	public void decharger(Produit Produit){
		//On retire le produit
		stockage -= this.produit.getPoids();
		System.out.println("on decharge le bail");
	}

	public int getNoSerie() {
		return noSerie;
	}
}
