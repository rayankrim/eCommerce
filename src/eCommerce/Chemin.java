package eCommerce;
import java.util.List;

public class Chemin {

	    private List<Planete> chemin;

	    public Chemin(List<Planete> chemin){
	        setChemin(chemin);
	    }

	    private void setChemin(List<Planete> lechemin){
	        chemin = lechemin;
	    }


	    public List<Planete> getChemin(){
	        return chemin;
	    }


	}

	
	

