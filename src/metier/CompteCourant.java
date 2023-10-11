package metier;

import java.util.Date;

public class CompteCourant extends Compte {
    private double decouvert;
    @Override
    public void retirer(double mnt) {
        if(solde + decouvert < mnt ) throw new RuntimeException("Solde insuffisant");
        Retrait retrait = new Retrait(operations.size()+1, new Date(), mnt);
        operations.add(retrait);
        solde = solde - mnt;
    }

    @Override
    public void updateSolde() {

    }
    public CompteCourant(int code, double solde, double decouvert) {
        super(code, solde);
        this.decouvert = decouvert;
    }
}
