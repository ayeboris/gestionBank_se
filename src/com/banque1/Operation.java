package com.banque1;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Operation {
    private Date dateOperations;
    private String typeOperation;
    private int montant;

    private String etatOperation;
    private Compte compte;

    public Operation() {
    }

    public Operation(Date dateOperations, String typeOperation, int montant, Compte compte) {
        this.dateOperations = dateOperations;
        this.typeOperation = typeOperation;
        this.montant = montant;
        this.compte = compte;
        this.etatOperation="SUCCES";
    }
    public Operation(Date dateOperations, String typeOperation, int montant, Compte compte, String etatOperation) {
        this.dateOperations = dateOperations;
        this.typeOperation = typeOperation;
        this.montant = montant;
        this.compte = compte;
        this.etatOperation= etatOperation;
    }

    //Transaction : Oµpération entre 2 comptes
    public void transaction(Date dateOperations, String typeOperation, int montant, Compte compteSource, Compte compteDestination){
        //Reponse de l'operation
        String etatOperation;

        if(compteSource.getSoldeCourant() >= montant && typeOperation=="DEPOT"){
            if (!compteSource.equals(compteDestination)){
                //Reponse de l'operation
                etatOperation = "SUCCES";

                //Créditer le compte auteur
                compteSource.setSoldeCourant(compteSource.getSoldeCourant()-montant);
                //Debiter le compte du destinataire
                compteDestination.setSoldeCourant(compteDestination.getSoldeCourant()+montant);

                //Enregistrement de l'operation
                compteSource.getOperations().add(new Operation( dateOperations,  typeOperation, montant,  compteSource,etatOperation));
                compteDestination.getOperations().add(new Operation( dateOperations,  "RETRAIT", montant,  compteDestination,etatOperation));

            }else {
                System.out.println("IMPOSSIBLE DE TRANSFERER DE L ARGENT SUR LE MEME COMPTE");
            }

        }
        if(compteSource.getSoldeCourant() < montant && typeOperation=="DEPOT"){
            if (!compteSource.equals(compteDestination)){
                //Reponse de l'operation
                etatOperation = "ECHEC";

                //Enregistrement de l'operation

                //Enregistrement de l'operation
                compteSource.getOperations().add(new Operation( dateOperations,  typeOperation, montant,  compteSource, etatOperation));
                compteDestination.getOperations().add(new Operation( dateOperations,  "RETRAIT", montant,  compteDestination, etatOperation));
            }else {
                System.out.println("IMPOSSIBLE DE TRANSFERER DE L ARGENT SUR LE MEME COMPTE");
            }
        }

        if(compteSource.getSoldeCourant() >= montant && typeOperation=="RETRAIT"){
            if (!compteSource.equals(compteDestination)){
                // Verifier le code de validation
                int code = 123; //ThreadLocalRandom.current().nextInt();
                System.out.println("Donner le code de validation : "+code);
                Scanner sc =new Scanner(System.in);
                int reponse= sc.nextInt();

                if(reponse==code){
                    //Créditer le compte auteur
                    compteSource.setSoldeCourant(compteSource.getSoldeCourant()-montant);
                    //Debiter le compte du destinataire
                    compteDestination.setSoldeCourant(compteDestination.getSoldeCourant()+montant);

                    //Reponse de l'operation
                    etatOperation = "SUCCES";
                    //Enregistrement de l'operation

                    //Enregistrement de l'operation
                    compteSource.getOperations().add(new Operation( dateOperations,  typeOperation, montant,  compteSource, etatOperation));
                    compteDestination.getOperations().add(new Operation( dateOperations,  "DEPOT", montant,  compteDestination,etatOperation));
                }else {
                    System.out.println("Mot de passe de validation incorrecte");
                }
            }else {
                System.out.println("IMPOSSIBLE DE TRANSFERER DE L ARGENT SUR LE MEME COMPTE");
            }

        }
        if(compteSource.getSoldeCourant() < montant && typeOperation=="RETRAIT"){
            if (!compteSource.equals(compteDestination)){
                //Reponse de l'operation
                etatOperation = "ECHEC";

                //Enregistrement de l'operation
                compteSource.getOperations().add(new Operation( dateOperations,  typeOperation, montant,  compteSource,etatOperation));
                compteDestination.getOperations().add(new Operation( dateOperations,  "DEPOT", montant,  compteDestination,etatOperation));

            }else {
                System.out.println("IMPOSSIBLE DE TRANSFERER DE L ARGENT SUR LE MEME COMPTE");
            }
        }
    }

    public String getEtatOperation() {
        return etatOperation;
    }

    public void setEtatOperation(String etatOperation) {
        this.etatOperation = etatOperation;
    }

    public Date getDateOperations() {
        return dateOperations;
    }

    public void setDateOperations(Date dateOperations) {
        this.dateOperations = dateOperations;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "dateOperations=" + dateOperations +
                ", typeOperation='" + typeOperation + '\'' +
                ", montant=" + montant +
                ", etatOperation='" + etatOperation + '\'' +
                '}';
    }
}
