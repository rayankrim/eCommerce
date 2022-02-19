package eCommerce;


public class Port {
	
    private int VaisseauArrive=0;
    private Vaisseau vaisseau;
    private int noPort;


    public Port(int noPort) {
        vaisseau=null;
        this.noPort = noPort;
    }
    
    public void atterrirVaisseau(Vaisseau vaisseauEnApproche) throws EcrasementVaisseauException{

        if (vaisseau != null)
            throw new EcrasementVaisseauException(vaisseauEnApproche);
        vaisseau = vaisseauEnApproche;
        VaisseauArrive=0;
    }

    public void avancerVaisseau(){

        if (vaisseau != null)
            if (VaisseauArrive++ == 1){
                vaisseau = null;          
                VaisseauArrive = 0;
            }
    }

    private boolean vaisseauSurPort(){
    	
        return vaisseau != null;
    }

    @Override
    public String toString() {
        if (VaisseauArrive>=3 &&vaisseauSurPort())
            return "(" + noPort + ") Occupe par:" + vaisseau;
        return "(" + noPort + ") Libre";
    }
}