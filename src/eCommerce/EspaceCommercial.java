package eCommerce;


public interface EspaceCommercial {

	public String afficherItineraire();
    public void charger(int noSerie, int noPlanete);
    public void decharger(int noSerie, int noPlanete);
    public void passerTour() throws EcrasementVaisseauException;

    public void faireAtterrirVaisseau(int noSerie, int noPiste)
            throws EcrasementVaisseauException;

}
