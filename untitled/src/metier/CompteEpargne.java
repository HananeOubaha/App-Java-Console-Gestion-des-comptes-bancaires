package metier;

public class CompteEpargne extends Compte {
    private double tauxInteret;

    // constructuer
    public CompteEpargne(double solde, double tauxInteret) {
        super(solde);
        this.tauxInteret = tauxInteret;
    }
    // REDIFINITON LA methode abstraite retirer
    @Override
    public void retirer(double montant,String destination) throws OperationException {
        if (montant <= 0) {
            throw new OperationException("Retrait innaceptable : solde insuffisant .");
        }
        if (this.solde < montant) {
            throw new OperationException("Retrait refusé : solde insuffisant.");
        }
        this.solde = this.solde - montant;
        Retrait r = new Retrait(montant, destination);
        this.operations.add(r);
    }

    @Override
    public double calculerInteret() {
        return this.solde * this.tauxInteret;
    }

    @Override
    public void afficherDetails() {
        System.out.println("=== Compte épargne ===");
        System.out.println("code: " + code);
        System.out.println("Solde: " + solde);
        System.out.println("Taux d'intéret : "+ tauxInteret);
    }

    // getter et setter
    public double getTauxInteret() {
        return tauxInteret;
    }
    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
}