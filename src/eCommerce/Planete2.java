package eCommerce;

public class Planete2 extends Planete {
	
	Planete2(int id, int totalports) {
		super(2, 2,new Produit[]{new ProduitRegulier(20),new ProduitDangereux(20)}
				,"Planete2");
	}
}
