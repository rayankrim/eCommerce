package eCommerce;

public class Planete4 extends Planete {
	
	Planete4(int id, int totalports) {
		super(id, totalports,new Produit[]{
				new ProduitDangereux(10),
				new ProduitDangereux(10),
				new ProduitDangereux(10)});
		// TODO Auto-generated constructor stub
	}
	int id=4;
	int totalports = 2;
}
