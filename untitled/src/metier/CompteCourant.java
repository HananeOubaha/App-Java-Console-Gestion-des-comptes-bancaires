package metier;

public class CompteCourant extends Compte {
    private double decouvert;

    // Constructeur
    public CompteCourant(String code, double solde, double decouvert) {
        super(code, solde);
        this.decouvert = decouvert;
    }

    // Redéfinition de la méthode retirer()
    @Override
    public void retirer(double montant) {
        if (montant <= 0) {
            System.out.println("Montant inacceptable pour effectuer un retrait.");
            return;
        }
        double nouveauSolde = this.solde - montant;

        if (nouveauSolde < -decouvert) {
            System.out.println("Impossible d'effectuer un retrait : vous dépassez la limite de découvert.");
            return;
        }
        this.solde = nouveauSolde;
        System.out.println("Retrait de " + montant + " effectué. Nouveau solde : " + this.solde);
    }

    // Redéfinition de la méthode calculerInteret()
    @Override
    public double calculerInteret() {
        return 0.0; // Les comptes courants n'ont pas d'intérêt
    }

    // Redéfinition de la méthode afficherDetails()
    @Override
    public void afficherDetails() {
        System.out.println("=== Compte Courant ===");
        System.out.println("Code: " + code);
        System.out.println("Solde: " + solde);
        System.out.println("Découvert autorisé: " + decouvert);
    }

    // Getters et Setters
    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
}
