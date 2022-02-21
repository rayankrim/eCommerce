package eCommerce;

public class Planete4 extends Planete {
	
	Planete4(int id, int totalports) {
		super(4, 2,new Produit[]{
				new ProduitRegulier(20),new ProduitDangereux(20)}
				,"Planete 4");
	}
}
