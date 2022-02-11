package eCommerce;


public interface EspaceCommercial {

	public String afficherPlanete();
    public void charger(int noSerie, int noPlanete);
    public void decharger(int noSerie, int noPlanete);
		throws EcrasementVaisseauException;

}
