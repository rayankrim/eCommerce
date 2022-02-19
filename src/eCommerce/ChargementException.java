package eCommerce;

public class ChargementException extends Exception{
	
	Produit produitCharge;

    ChargementException(Produit produit){
    	produitCharge = produit;
    }

    public String getMessage() {
        return "Il n'y a plus d'espace de stockage disponible pour le produit " + produitCharge + " !";
    }

}
