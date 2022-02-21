package eCommerce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class Planete {

	//private int produits_achetes;
	private Port ports;
	private int id;
	private int totalports;
	private  Produit[] produits;
	private Map<Produit, Integer> capacitemMax;
	private Map<Produit, Integer> ressources;
	
	//transaction
		Map<Port, List<Produit>> mapTransaction =
				new HashMap<Port, List<Produit>>();

	
	
	Planete(int id, int totalports,  Map<Produit, Integer> capacitemMax, Map<Produit, Integer> ressources)
	{
		this.produits = produits;
        this.id = id;
        this.totalports=totalports;
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

}


