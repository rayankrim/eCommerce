package eCommerce;

public class Vaisseau2 extends Vaisseau{

	public Vaisseau2() {
		super( 8, new Produit[]{new ProduitDangereux(10)});
	}
}