package eCommerce;

import java.util.ArrayList;



public abstract class Vaisseau {

	protected int noSerie;
	protected double niveauEssence;
	protected final Produit[] produitsRegle;
	protected ArrayList<Produit> produits = new ArrayList<>();


	private static int noSerieCompteur = 0;

	Vaisseau(double niveauEssence, Produit[] produitsRegle) {
		this.produitsRegle = produitsRegle;
		this.noSerie = noSerieCompteur++;
		this.niveauEssence = niveauEssence;
	}

	public void charger(Produit produit) throws ChargementException {
		// On verifie qu'il y a de la place pour le produit qu'on veut charger
		for (Produit produitRegle : this.produitsRegle) {
			if (produitRegle.getClass().equals(produit.getClass())) {
				double balance = produitRegle.getPoids() - this.getStockageActuel(produit) -
						produit.getPoids();
				// Condition pour charger un nouveau produit
				if (balance >= 0) {
					updateStockageActuel(produit, true);
					System.out.println("on charge le machin");
				}
				return;
			}
			else {
				throw new ChargementException(produit);
				
			}
		}
	}

	public void decharger(Produit produit) throws DechargementException {
		// On retire le produit
		
		double balance = this.getStockageActuel(produit) - produit.getPoids();
		if( balance >= 0 ) {
		updateStockageActuel(produit, false);
		System.out.println("on decharge le bail");
		}
		
		else {
			throw new DechargementException(produit);
		}
			
	}

	public void survol() throws EcrasementVaisseauException{
		if (verifierEssence())
			niveauEssence--;
		else
			throw new EcrasementVaisseauException(this);
	}

	private boolean verifierEssence(){

		return niveauEssence > 0;
	}

	public int getNoSerie() {
		return noSerie;
	}

	private double getStockageActuel(Produit produit) {
		for (Produit produitStock : this.produits) {
			if (produitStock.getClass().equals(produit.getClass())) {
				return produitStock.getPoids();
			}
		}
		return 0;
	}

	private void updateStockageActuel(Produit produit, boolean charger) {
		if (charger) {
			if (produits.size() == 0) {
				produits.add(produit);
			} else {
				for (int i = 0; i < produits.size(); i++) {
					if (produits.get(i).getClass().equals(produit.getClass())) {
						this.produits.get(i).setPoids(this.produits.get(i).getPoids() + produit.getPoids());
					}
				}
			}
		} else {
			for (int i = 0; i < produits.size(); i++) {
				if (produits.get(i).getClass().equals(produit.getClass())) {
					this.produits.get(i).setPoids(this.produits.get(i).getPoids() - produit.getPoids());
				}
			}
		}
	}

	@Override
	public String toString() {
		return "(NS:" + noSerie + ", ESS:" + niveauEssence + ") " ;
	}
}



