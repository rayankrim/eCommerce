package eCommerce;
import eCommerce.Vaisseau;
import eCommerce.EcrasementVaisseauException;

import java.util.Vector;

public class Port {
    boolean occupe=false;
    protected int VaisseauArrive=0;
    private Vaisseau vaisseau;
    private int noPort;
    private int cycle;


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
            return "(" + noPort + ") Occupe par:" + vaisseau;
        return "(" + noPort + ") Libre";
    }


    public void atterrirVaisseau(Vaisseau vaisseauEnApproche) throws EcrasementVaisseauException{

        if (vaisseau != null)
            throw new EcrasementVaisseauException(vaisseauEnApproche);
        vaisseau = vaisseauEnApproche;
        cycle = 0;
    }

    public void avancerVaisseau() {

        if (vaisseau != null)
            if (cycle++ == 5){
                vaisseau = null;
                cycle = 0;
            }
    }
}