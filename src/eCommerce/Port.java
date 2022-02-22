package eCommerce;


import java.util.Vector;

public class Port {


	
    private Vaisseau vaisseau;
    private int noPort;
    private int cycle;
    private int fileAttente;
    private Vaisseau prochainVaisseau;



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
            if(fileAttente == 0){

            return "(" + noPort + ") Occupe par:" + vaisseau+
                    " ( cycle restant : " + cycle + ")";
            }else {
                return "(" + noPort + ") Occupe par:" + vaisseau+
                        " et il y a un vaisseau en attente ( cycle restant : " + cycle + ")";

            }

        return "(" + noPort + ") Libre";
    }


    public void atterrirVaisseau(Vaisseau vaisseauEnApproche) throws EcrasementVaisseauException{

        if (vaisseau != null) {
            if (verifierFile()) {
                fileAttente++;
                cycle = 0;
            }
            else
                throw new EcrasementVaisseauException(vaisseauEnApproche);
        }
        else vaisseau = vaisseauEnApproche;
    }

    private boolean verifierFile(){
        return fileAttente < 1;
    }

    public void avancerVaisseau() {

        fileAttente--;
        vaisseau= prochainVaisseau;
        if (vaisseau != null)
            if (cycle++ == 5){

                vaisseau = null;
                cycle = 0;
            }
    }


}