package eCommerce;

public class Planete3 extends Planete {
	
	Planete3(int id, int totalports) {
		super(id, totalports,new Produit[]{
				new ProduitRegulier(10),
				new ProduitRegulier(10),
				new ProduitRegulier(10)});
		// TODO Auto-generated constructor stub
	}
	int id=3;
	int totalports = 3;
}
