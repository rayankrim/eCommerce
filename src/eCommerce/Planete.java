package eCommerce;

import java.util.ArrayList;

public abstract class Planete {

	//private int produits_achetes;
	private Port ports;
	private int id;
	private int totalports;
	private  Produit[] produits;

	
	
	Planete(int id, int totalports, Produit[] produits)
	{
		this.produits = produits;
        this.id = id;
        this.totalports=totalports;
    }


	
	@Override
	public String toString() 
	{
		return "Planete []";
	}

}


