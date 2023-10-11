package metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Compte {
    protected int code;
    protected double solde;
    protected List<Operation> operations = new ArrayList<>();

    public Compte() {
        super();
    }

    public Compte(int code, double solde, List<Operation> operations) {
        this.code = code;
        this.solde = solde;
        this.operations = operations;
    }
    public void verser(double mnt) {
        Versement v = new Versement(operations.size()+1, new Date(), mnt);
        operations.add(v);
        solde += mnt;
    }
    public abstract void retirer(double mnt);
    public void virement(double mnt, Compte compte2){
        retirer(mnt);
        compte2.verser(mnt);
    }
    public double consulterSolde() {
        return solde;
    }
    public abstract void updateSolde();
    public List<Operation> getOperations() {
        return operations;
    }
    public double totalVersement() {
        double somme = 0;
        for(Operation o: operations) {
            if (o instanceof Versement) {
                somme = somme + o.getMontant();
            }
        }
        return somme;
    }
    public double totalRetraits() {
        double somme = 0;
        for(Operation o: operations) {
            if (o instanceof Retrait) {
                somme = somme + o.getMontant();
            }
        }
        return somme;
    }
}
