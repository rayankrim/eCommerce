package eCommerce;
import eCommerce.Vaisseau;
import eCommerce.EcrasementVaisseauException;

public class Port {
    boolean occupe=false;
    int VaisseauArrive=0;
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