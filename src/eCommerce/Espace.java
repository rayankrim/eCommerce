package eCommerce;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Espace extends Thread{

    Arrivee arrivee ;
    private static final int INTERVALLE_MAX = 20000;

    public Espace(Arrivee arrivee){

        this.arrivee = arrivee;
    }

    @Override
    public void run() {
        boolean enAttendantQueLeCielDisparaisseALHorizon = true;
        while(enAttendantQueLeCielDisparaisseALHorizon){

            arrivee.survoler(ajouterVaisseau());

            try{
                long sleepTime = (long)(Math.random() * INTERVALLE_MAX + 1);
                sleep(sleepTime);
            }
            catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }

    private Vaisseau ajouterVaisseau(){

        Vaisseau vaisseau;
        try{
            String classeVaisseau = "eCommerce.Vaisseau" + (int)(Math.random() * 3 + 1);
            vaisseau = (Vaisseau) Class.forName(classeVaisseau).newInstance();
        }
        catch(Exception e){
            e.printStackTrace();
            vaisseau = new Vaisseau1();
        }
        return vaisseau;
    }



}