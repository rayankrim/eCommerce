package eCommerce;
import eCommerce.EcrasementVaisseauException;

public class Port {
    private Vaisseau vaisseau;
    private int noPort;


    public Port(int noPort) {
        vaisseau=null;
        this.noPort = noPort;
    }

    private boolean vaisseauSurPort(){

        return vaisseau != null;
    }

    @Override
    public String toString() {
        if (vaisseauSurPort())
            return "(" + noPort + ") Occupe :" + vaisseau;
        return "(" + noPort + ") Libre";
    }
}