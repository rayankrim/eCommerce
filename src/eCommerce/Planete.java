package eCommerce;

public abstract class Planete {
	
	protected int produits_achetes;
	protected Port ports;
	protected int id;
	protected int totalports;

	
	
	Planete(int id, int totalports)
	{
        this.id = id;
        this.totalports=totalports;
    }


	
	@Override
	public String toString() 
	{
		return "Planete []";
	}

}


