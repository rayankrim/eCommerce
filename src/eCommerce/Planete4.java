package eCommerce;

public class Planete4 extends Planete {
	
	Planete4(int id, int totalports) {
		super(id, totalports,new Produit[]{
				new ProduitRegulier(20),new ProduitDangereux(20)});		// TODO Auto-generated constructor stub
	}
	int id=4;
	int totalports = 2;
}
