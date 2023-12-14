import com.banque1.Client;
import com.banque1.Compte;
import com.banque1.Operation;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Client client_1= new Client(1,"KOUAO","BORIS");
        Compte compte_1 = new Compte(1,"2345",client_1);
        client_1.setCompte(compte_1);

        Operation opt1 = new Operation(new Date(2023,12,01),"RETRAIT",10000,compte_1);
        compte_1.addOperation(opt1);

        Operation opt2 = new Operation(new Date(),"DEPOT",46000,compte_1);
        compte_1.addOperation(opt2);

        Operation opt3 = new Operation(new Date(2023,12,01),"RETRAIT",10000,compte_1);
        compte_1.addOperation(opt3);


        //Affiche les informations du compte
        System.out.println("INFORMATION DU COMPTE 1");
        System.out.println( "Numero compte :\t"+compte_1.getNumero());
        System.out.println( "SOLDE :\t"+compte_1.getSoldeCourant());
        System.out.println( "NOM COMPLET DU CLIENT :\t"+client_1.getNom()+" "+client_1.getPrenom());

        //Affiche les opérations du compte
        System.out.println("OPERATION\t\t\t\t\t\t" +" - "+ "TYPE OPERATION\t"+" - "+"MONTANT\t"+" - "+ "ETAT OPERATION");
        for (Operation op1 : compte_1.getOperations()){
            System.out.println(op1.getDateOperations() +" \t\t- "+ op1.getTypeOperation()+" \t\t\t- "+op1.getMontant()+" \t- "+ op1.getEtatOperation());
        }

        //Compte 2
        Client client_2= new Client(1,"AYE","BOBO");
        Compte compte_2 = new Compte(1,"2345",client_1);
        client_2.setCompte(compte_2);

        Operation opt11 = new Operation(new Date(2023,12,01),"DEPOT",10000,compte_2);
        compte_2.addOperation(opt11);
        //Affiche les informations du compte
        System.out.println("INFORMATION DU COMPTE 2");
        System.out.println( "Numero compte :\t"+compte_2.getNumero());
        System.out.println( "SOLDE :\t"+compte_2.getSoldeCourant());
        System.out.println( "NOM COMPLET DU CLIENT :\t"+client_2.getNom()+" "+client_2.getPrenom());

        //Affiche les opérations du compte
        System.out.println("OPERATION\t\t\t\t\t\t" +" - "+ "TYPE OPERATION\t"+" - "+"MONTANT\t"+" - "+ "ETAT OPERATION");
        for (Operation op2 : compte_2.getOperations()){
            System.out.println(op2.getDateOperations() +" \t\t- "+ op2.getTypeOperation()+" \t\t\t- "+op2.getMontant()+" \t- "+ op2.getEtatOperation());
        }
//==================| EFFECTUER UNE TRANSACTION |============================================================================

        Operation transaction =new Operation();
        transaction.transaction(new Date(),"DEPOT",1000,compte_1,compte_2);
//=======================================================================================================================
        //Affiche les comptes bancaires des deux comptes ==============================
        System.out.println("INFORMATION DU COMPTE 1");
        System.out.println( "Numero compte :\t"+compte_1.getNumero());
        System.out.println( "SOLDE :\t"+compte_1.getSoldeCourant());
        System.out.println( "NOM COMPLET DU CLIENT :\t"+client_1.getNom()+" "+client_1.getPrenom());

        //Affiche les opérations du compte
        System.out.println("OPERATION\t\t\t\t\t\t" +" - "+ "TYPE OPERATION\t"+" - "+"MONTANT\t"+" - "+ "ETAT OPERATION");
        for (Operation op1 : compte_1.getOperations()){
            System.out.println(op1.getDateOperations() +" \t\t- "+ op1.getTypeOperation()+" \t\t\t- "+op1.getMontant()+" \t- "+ op1.getEtatOperation());
        }

        //Compte 2

        //Affiche les informations du compte
        System.out.println("=====================INFORMATION DES TRANSACTIONS===============\n");
        System.out.println("INFORMATION DU COMPTE 2");
        System.out.println( "Numero compte :\t"+compte_2.getNumero());
        System.out.println( "SOLDE :\t"+compte_2.getSoldeCourant());
        System.out.println( "NOM COMPLET DU CLIENT :\t"+client_2.getNom()+" "+client_2.getPrenom());

        //Affiche les opérations du compte
        System.out.println("OPERATION\t\t\t\t\t\t" +" - "+ "TYPE OPERATION\t"+" - "+"MONTANT\t"+" - "+ "ETAT OPERATION");
        for (Operation op2 : compte_2.getOperations()){
            System.out.println(op2.getDateOperations() +" \t\t- "+ op2.getTypeOperation()+" \t\t\t- "+op2.getMontant()+" \t- "+ op2.getEtatOperation());
        }

    }
}