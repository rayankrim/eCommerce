package eCommerce;

import eCommerce.EcrasementVaisseauException;

public interface EspaceCommercial {

	public String afficherPlanete();
    public void charger(int noSerie, int noPlanete)throws EcrasementVaisseauException;
    public void decharger(int noSerie, int noPlanete)
		throws EcrasementVaisseauException;

}
