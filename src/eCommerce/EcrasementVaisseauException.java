package eCommerce;

public class EcrasementVaisseauException extends Exception {
    Vaisseau vaisseauEcrase;

    EcrasementVaisseauException(Vaisseau vaisseau){
        vaisseauEcrase = vaisseau;
    }

    @Override
    public String getMessage() {
        return "Le vaisseau " + vaisseauEcrase + " s'est ecrase!";
    }


}
