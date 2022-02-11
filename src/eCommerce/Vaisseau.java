package eCommerce;

public abstract class Vaisseau {
	
	protected double capaciteMax;
	protected double stockage;
	protected Produit produit;
	protected int produitscharges=0;
	protected int produitsdecharges=0;

	public void charger(Produit Produit) {
		
		
		//On verifie qu'il y a de la place pour le produit qu'on veut charger
		double balance = capaciteMax - stockage + this.produit.getPoids();
		
		//Condition pour charger un nouveau produit
		if(balance > 0) 
		{
			stockage += this.produit.getPoids();
			produitscharges++;
			System.out.println("on charge le machin");		
		}
		
	}
	public void decharger(Produit Produit){
		//On retire le produit
		stockage -= this.produit.getPoids();
		produitsdecharges--;
		System.out.println("on decharge le bail");
		
		}
	}
