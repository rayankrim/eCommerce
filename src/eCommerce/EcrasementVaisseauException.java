package eCommerce;

public class EcrasementVaisseauException extends Exception {

    Vaisseau vaisseauEcrasee;

    EcrasementVaisseauException(Vaisseau vaisseau){
        vaisseauEcrasee = vaisseau;
    }

    public String getMessage() {
        return "Le vaisseau " + vaisseauEcrasee + " s'est ecrasee!";
    }
}

