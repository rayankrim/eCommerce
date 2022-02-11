package eCommerce;
import eCommerce.Vaisseau;
import eCommerce.EcrasementVaisseauException;

public class Port {
    boolean occupe=false;
    protected int VaisseauArrive=0;
    private Vaisseau vaisseau;
    private int noPort;


    public Port(int noPort) {
        vaisseau=null;
        this.noPort = noPort;
    }

    private boolean vaisseauSurPort(){
    	VaisseauArrive++;
        return vaisseau != null;
    }

    @Override
    public String toString() {
        if (VaisseauArrive>=3 &&vaisseauSurPort())
            return "(" + noPort + ") Occupe par:" + vaisseau;
        return "(" + noPort + ") Libre";
    }
}