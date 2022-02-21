package eCommerce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Planete {

	private Port ports;
	private int id;
	private int totalports;
	private Produit produit;
	private final Produit[] produitsRegle;
	private ArrayList<Produit> produits = new ArrayList<>();

	Map<Port, List<Produit>> mapTransaction =
			new HashMap<Port, List<Produit>>();



	Planete(int id, int totalports,  Map<Produit, Integer> capacitemMax, Map<Produit, Integer> ressources,Produit[] produitsRegle)
	{
		this.produits = produits;
		this.id = id;
		this.totalports=totalports;
		this.produitsRegle=produitsRegle;
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
	public String toString() 
	{
		return "Planete []";
	}


	public void charger(Produit produit, Port port) throws ChargementException {

		// On verifie qu'il y a de la place pour le produit qu'on veut charger
		for (Produit produitRegle : this.produitsRegle) {
			if (produitRegle.getClass().equals(produit.getClass())) {
				double balance = produitRegle.getPoids() - this.getStockageActuel(produit) -
						produit.getPoids();
				// Condition pour charger un nouveau produit
				if (balance >= 0) {
					updateStockageActuel(produit, true, port);
					System.out.println("on charge le machin");
				} else {
					throw new ChargementException(produit);
				}
				return;
			}
			else {
				throw new ChargementException(produit);

			}
		}
	}


	public void decharger(Produit produit, Port port, Planete planete) throws DechargementException {
		// On retire le produit

		double balance = this.getStockageActuel(produit) - produit.getPoids();
		if( balance >= 0 ) {
			updateStockageActuel(produit, false, port);
			System.out.println("on decharge le bail");
		}

		else {
			throw new DechargementException(produit);
		}

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




}


