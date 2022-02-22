package eCommerce;

import java.util.Enumeration;
import java.util.List;
import java.util.Vector;




public class Itineraire implements EspaceCommercial, Arrivee{

    private Vector<Vaisseau> vaisseauEnSurvol;
    private Vector<Port> ports;
    private Chemin chemin;
    private int i;
    private Planete position;
    private Vaisseau vaisseau;
    
    public Itineraire(){
    	i=0;
        vaisseauEnSurvol = new Vector<Vaisseau>();
        ports = new Vector<Port>();
        ports.add(new Port(0));
        ports.add(new Port(1));
        ports.add(new Port(2));
        new Espace(this).start();
    }

    @Override
    public void survoler(Vaisseau vaisseau) {

        vaisseauEnSurvol.add(vaisseau);
    }

    public String afficherItineraire(){

        StringBuilder sb = new StringBuilder();
 
        sb.append("--- start --- \n");
        sb.append("Vaisseaux en survol\n");
        System.out.println(vaisseauEnSurvol.elements());
        for (Enumeration<Vaisseau> enumVaisseau= vaisseauEnSurvol.elements(); enumVaisseau.hasMoreElements();)
            sb.append(enumVaisseau.nextElement() + "\n");

        sb.append("Etat des ports\n");
        for (Enumeration<Port> enumPiste = ports.elements(); enumPiste.hasMoreElements();)
            sb.append(enumPiste.nextElement() + "\n");

        sb.append("---\n");

        return sb.toString();
    }

    //A checker
    public void passerTour() throws EcrasementVaisseauException{

        faireSurvolerLesVaisseaux();
        faireAvancerVaisseauxSurLesPorts();
    }
    

    public void avancer() {
        List<Planete> planetes = chemin.getChemin();
        if (i < (planetes.size() - 1)) {
            i++;
            setPosition(planetes.get(i));

            if (i == planetes.size() - 1) {
                vaisseau.setCheminFinal(true);
            }

        }
    }


    private void setPosition(Planete planete) {
		// TODO Auto-generated method stub
    	this.position = planete; 
    	}


	@Override
    public void charger(int noSerie, int noPlanete) {

    }

    @Override
    public void decharger(int noSerie, int noPlanete) {

    }

    public void faireAtterrirVaisseau(int noSerie, int noPiste) throws EcrasementVaisseauException{

        if (noPiste < 0 || noPiste > 2)
            noPiste = 0;
        Vaisseau vaisseau = localiserVaisseau(noSerie);
        if (vaisseau != null){
            ports.elementAt(noPiste).atterrirVaisseau(vaisseau);
            vaisseauEnSurvol.remove(vaisseau);
        }
        passerTour();
    }

    @Override
    public void afficherBilanTransactionVaisseau(int noSerie){
        Vaisseau vaisseau = this.localiserVaisseau(noSerie);
        vaisseau.afficherBilanTransaction();
    }

    private void faireAvancerVaisseauxSurLesPorts(){
        for (Enumeration<Port> enumPort = ports.elements(); enumPort.hasMoreElements();)
            enumPort.nextElement().atterissage();
    }

    private void faireSurvolerLesVaisseaux() throws EcrasementVaisseauException{
        for (Enumeration<Vaisseau> enumVaisseau = vaisseauEnSurvol.elements(); enumVaisseau.hasMoreElements();)
            enumVaisseau.nextElement().survol();
    }


    private Vaisseau localiserVaisseau(int noSerie){
        for (Enumeration<Vaisseau> enumVaisseau = vaisseauEnSurvol.elements(); enumVaisseau.hasMoreElements();){
            Vaisseau vaisseau= enumVaisseau.nextElement();
            if (vaisseau.getNoSerie() == noSerie)
                return vaisseau;
        }
        return null;
    }
}