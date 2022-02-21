package eCommerce;

import java.util.List;

public class Trafic {

    private Planete planete;
    private Vaisseau vaisseau;
    private Chemin chemin;
    private int nbPlanete;
    private int i;

    public Trafic(Vaisseau vaisseau, Chemin chemin){
        i=0;
        List<Planete> planetes = chemin.getChemin();
        setPlanete(planetes.get(i));
        this.vaisseau = vaisseau;
        this.chemin = chemin;
    }

    private void setPlanete(Planete planete) {
        this.planete = planete;
    }

    public Planete getPlanete(){
        return planete;
    }

    public void avancer() {
        List<Planete> planetes = chemin.getChemin();
        nbPlanete = planetes.size() - 1;
        if (i < nbPlanete) {
            i++;
            setPlanete(planetes.get(i));

            if (i == nbPlanete) {
                vaisseau.setCheminFinal(true);
            }

        }
    }

    @Override
    public String toString(){
        List<Planete> planetes = chemin.getChemin();
        String cheminVaisseau = "Chemin : Vaisseau NS : " + vaisseau.getNoSerie() + " chemin" +
                "entre toutes les planetes : \n";
        cheminVaisseau +="\t";
        for (Planete planete : planetes ){
            cheminVaisseau += planete.getNom() + " ****   --->   ****\n";
        }
        cheminVaisseau += "Fin.";
        cheminVaisseau += "Le vaisseau est sur la planete : " + planete.getNom() +"\n";
        return cheminVaisseau;
    }





}
