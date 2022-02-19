package eCommerce;

public class DechargementException extends Exception{
		
	Produit produitCharge;

    DechargementException(Produit produit){
    	produitCharge = produit;
    }

    public String getMessage() {
        return "Impossible de décharger le produit " + produitCharge + " !";
    }

}
