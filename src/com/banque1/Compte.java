package com.banque1;

import java.util.ArrayList;
import java.util.List;

public class Compte {
    private int id;
    private String numero;
    private double soldeCourant;

    private List<Operation> operations = new ArrayList<Operation>();
    private Client client;

    public Compte() {
        this.soldeCourant = 0;
    }

    public Compte(int id, String numero, Client client) {
        this.id = id;
        this.numero = numero;
        this.soldeCourant = 0;
        this.client = client;
    }

    public Compte(int id, String numero, Client client, double capital) {
        this.id = id;
        this.numero = numero;
        this.soldeCourant = capital;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSoldeCourant() {
        return soldeCourant;
    }

    public void setSoldeCourant(double soldeCourant) {
        this.soldeCourant = soldeCourant;
    }

    public List<Operation> getOperations() {
        return operations;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addOperation(Operation operation){
        operations.add(operation);

        if(operation.getTypeOperation().equals("DEPOT")){
            soldeCourant = soldeCourant + operation.getMontant();
            operation.setEtatOperation("SUCCES");
        }

        if(operation.getTypeOperation().equals("RETRAIT")){
            if(getSoldeCourant() > operation.getMontant()) {
                soldeCourant = soldeCourant - operation.getMontant();
                operation.setEtatOperation("SUCCES");
            }
            else {
                System.out.println("Solde insuffisant : " + getSoldeCourant() + " / Echec retrait : " + operation.getMontant());
                operation.setEtatOperation("ECHEC");

            }
        }
    }


    @Override
    public String toString() {
        return "Compte{" +
                "id=" + this.id +
                ", numero='" + this.numero + '\'' +
                ", soldeCourant=" + this.soldeCourant +
                ", operations=" + this.operations +
                ", client=" + this.client +
                '}';
    }
}
