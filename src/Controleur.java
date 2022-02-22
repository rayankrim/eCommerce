import eCommerce.*;

import java.util.Scanner;

public class Controleur {
    

    private EspaceCommercial espaceCommercial;



    public static void main(String[] args) throws ChargementException {
        Controleur controleur = new Controleur();
        controleur.communiquerAvecItineraire(new Itineraire());
        controleur.debuterLaJournee();


        Vaisseau v1 = new Vaisseau1();
        ProduitRegulier pr = new ProduitRegulier(1);
        Port p10 = new Port(10);

        v1.charger(pr,p10);

        v1.afficherBilanTransaction();
        System.out.println(v1.afficherBilanTransaction());


    }


    public void communiquerAvecItineraire(EspaceCommercial espaceCommercial){

        this.espaceCommercial = espaceCommercial;
    }
    


    public void debuterLaJournee(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Combien de cycle voulez-vous jouer ?");
        int cycle = new Scanner(System.in).nextInt();

        if(cycle<1){
            System.out.println("Ok tu joues pas");
        }


        int valeur = 1;
        Scanner lectureClavier = new Scanner(System.in);

        try{
            while(cycle > 0){
                System.out.println(espaceCommercial.afficherItineraire());

                System.out.println(afficherMenu());
                valeur = lectureClavier.nextInt();
                switch(valeur){
                    case 1: espaceCommercial.passerTour();
                        break;
                    case 2: System.out.println("Entrer le noSerie du vaisseau : ");
                        int noSerie = lectureClavier.nextInt();
                        System.out.println("Entrer le no du port : ");
                        int noPort = lectureClavier.nextInt();
                        espaceCommercial.faireAtterrirVaisseau(noSerie, noPort);
                        break;
                    case 3 :
                        System.out.println("Entrer le noSerie du vaisseau : ");
                        int numSerie = lectureClavier.nextInt();
                        espaceCommercial.afficherBilanTransactionVaisseau(numSerie);
                }
                cycle--;
            }
        }
        catch(EcrasementVaisseauException eae){

            System.out.println(eae.getMessage());
            eae.printStackTrace();
        }
        catch(Exception e){

            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Fin de la journee!");
    }

    private String afficherMenu(){
        StringBuilder sb = new StringBuilder();

        sb.append("----------\n");
        sb.append("1) Faire survoler un nouveau vaisseau\n");
        sb.append("2) Faire atterrir un vaisseau\n");
        sb.append("3) Voir l'historique d'un vaisseau\n");
        sb.append("---------\n");
        sb.append("Votre choix?");

        return sb.toString();
    }
}