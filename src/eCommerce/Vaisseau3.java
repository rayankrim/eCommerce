package eCommerce;

public class Vaisseau3 extends Vaisseau{

	public Vaisseau3() {
		super( 10, new Produit[]{new ProduitDangereux(10), new ProduitRegulier(10)});	}
}