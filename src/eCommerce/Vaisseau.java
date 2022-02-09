package eCommerce;

public abstract class Vaisseau {
	
	protected double capaciteMax;
	protected double stockage;
	
	//A mettre dans la classe produit
	protected String nomProduit;
	protected double poidsProduit;
	

	public void charger(Produit Produit) {
		
		//On verifie qu'il y a de la place pour le produit qu'on veut charger
		double balance = capaciteMax - stockage + this.poidsProduit;
		
		//Condition pour charger un nouveau produit
		if(balance > 0) {
			stockage += poidsProduit;
			System.out.println("on charge le machin");
		
		}
		
	}
	public void decharger(Produit Produit){
		//On retire le produit
		stockage -= poidsProduit;
		System.out.println("on decharge le bail");
		
		}
	}
