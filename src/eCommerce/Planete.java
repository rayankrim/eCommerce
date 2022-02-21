package eCommerce;


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



	public int getTotalports() {
		return totalports;
	}



	public Produit[] getProduits() {
		return produits;
	}



	public Port getPorts() {
		return ports;
	}



	public int getId() {
		return id;
	}

}


