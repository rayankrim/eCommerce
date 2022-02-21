package eCommerce;

public class Planete3 extends Planete {
	
	Planete3(int id, int totalports) {
		super(3, 3,new Produit[]{
				new ProduitRegulier(10),new ProduitDangereux(10)},"Planete 3");
	}
}
