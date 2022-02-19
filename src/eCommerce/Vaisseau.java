package eCommerce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public abstract class Vaisseau {

	private int noSerie;
	private double niveauEssence;
	private final Produit[] produitsRegle;
	private ArrayList<Produit> produits = new ArrayList<>();

	//transaction
	Map<Port, List<Produit>> mapTransaction =
			new HashMap<Port, List<Produit>>();





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
					updateStockageActuel(produit, true, port);
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

	private void updateStockageActuel(Produit produit, boolean charger, Port port) {
		if (charger) {
			this.addStockageActuel(produit, port);
		} else {
			this.removeStockageActuel(produit, port);
		}
	}

	private void addStockageActuel(Produit produit, Port port){
		if (produits.size() == 0) {
			produits.add(produit);
			try {
				mapTransaction.get(port).add(produit);
			} catch (NullPointerException e) {
				mapTransaction.put(port, new ArrayList<>());
				mapTransaction.get(port).add(produit);
			}
		} else {
			for (int i = 0; i < produits.size(); i++) {
				if (produits.get(i).getClass().equals(produit.getClass())) {
					this.produits.get(i).setPoids(this.produits.get(i).getPoids() + produit.getPoids());
				}
			}
		}
	}

	private void removeStockageActuel(Produit produit, Port port){
		for (int i = 0; i < produits.size(); i++) {
			if (produits.get(i).getClass().equals(produit.getClass())) {
				//regle metier a ajouter : on peut pas enlever + que ce quon a
				this.produits.get(i).setPoids(this.produits.get(i).getPoids() - produit.getPoids());
				Produit produitPoidsNegatif = produit;
				produitPoidsNegatif.setPoids(- produitPoidsNegatif.getPoids());
				mapTransaction.get(port).add(produitPoidsNegatif);
			}
		}
	}

	public void afficherBilanTransaction() {
		StringBuilder sb = new StringBuilder();

		sb.append("--- bilan des transactions --- \n");
		for (Map.Entry mapentry : mapTransaction.entrySet()) {
			sb.append("clé: " + mapentry.getKey()
					+ " | valeur: " + mapentry.getValue());

		}
	}

	@Override
	public String toString() {
		return "(NS:" + noSerie + ", ESS:" + niveauEssence + ") " ;
	}
}



