package eCommerce;

public class Planete2 extends Planete {
	
	Planete2(int id, int totalports) {
		super(id, totalports,new Produit[]{new ProduitRegulier(20),new ProduitDangereux(20)});
		// TODO Auto-generated constructor stub
	}
	int id=2;
	int totalports = 2;
}
