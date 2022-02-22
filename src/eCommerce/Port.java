package eCommerce;


import java.util.Vector;

public class Port {
	
    private int VaisseauArrive=0;
    private Vaisseau vaisseau;
    private int noPort;
    private int cycle;


    public Port(int noPort) {
        vaisseau=null;
        this.noPort = noPort;
    }

    public int recupererCycle(int cycleDebut){
        return cycleDeBase=cycleDeBase;
    }


    private boolean vaisseauSurPort(){
        return vaisseau != null;
    }

    @Override
    public String toString() {
        if (vaisseauSurPort())
            return "(" + noPort + ") Occupe par:" + vaisseau+ " (" + cycle + "/" + cycleDeBase+ ")";
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
            if (cycle++ == cycleDeBase){
                vaisseau = null;
                cycle = 0;
            }
    }


}