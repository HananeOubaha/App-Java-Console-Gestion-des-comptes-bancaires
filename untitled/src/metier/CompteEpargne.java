package metier;

public class CompteEpargne extends Compte {
    private double tauxInteret;

    // Constructeur
    public CompteEpargne(double solde, double tauxInteret) {
        super(solde);
        this.tauxInteret = tauxInteret;
    }

    // Redéfinition de la méthode retirer
    @Override
    public void retirer(double montant, String destination) throws OperationException {
        if (montant <= 0) {
            throw new OperationException("Montant de retrait invalide.");
        }
        if (this.solde < montant) {
            throw new OperationException("Retrait refusé : solde insuffisant.");
        }
        this.solde -= montant;
        Retrait r = new Retrait(montant, destination);
        this.operations.add(r);
        System.out.println(" Retrait de " + montant + " MAD effectué. Nouveau solde : " + this.solde + " MAD");
    }

    @Override
    public double calculerInteret() {
        return this.solde * this.tauxInteret;
    }

    @Override
    public void afficherDetails() {
        System.out.println("=== Compte Épargne ===");
        System.out.println("Code            : " + code);
        System.out.println("Solde           : " + solde + " MAD");
        System.out.println("Taux d'intérêt  : " + tauxInteret * 100 + " %");
        System.out.println("========================");
    }

    @Override
    public String toString() {
        return "CompteEpargne{" +
                "code='" + code + '\'' +
                ", solde=" + solde +
                ", tauxInteret=" + tauxInteret +
                '}';
    }

    // Getter et Setter
    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
}
