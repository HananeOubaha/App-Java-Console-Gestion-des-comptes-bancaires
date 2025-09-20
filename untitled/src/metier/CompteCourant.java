package metier;

public class CompteCourant extends Compte {
    private double decouvert;

    // Constructeur
    public CompteCourant(double solde, double decouvert) {
        super(solde);
        this.decouvert = decouvert;
    }

    // Redéfinition de la méthode retirer()
    @Override
    public void retirer(double montant, String destination) throws OperationException {
        if (montant <= 0) {
            throw new OperationException("Montant inacceptable pour effectuer un retrait.");
        }
        double nouveauSolde = this.solde - montant;
        if (nouveauSolde < -decouvert) {
            throw new OperationException("Impossible d'effectuer un retrait : vous dépassez la limite de découvert.");
        }
        this.solde = nouveauSolde;
        Retrait r = new Retrait(montant, destination);
        this.operations.add(r);
        System.out.println(" Retrait de " + montant + " MAD effectué. Nouveau solde : " + this.solde + " MAD");
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
        System.out.println("Code              : " + code);
        System.out.println("Solde             : " + solde + " MAD");
        System.out.println("Découvert autorisé: " + decouvert + " MAD");
        System.out.println("========================");
    }

    @Override
    public String toString() {
        return "CompteCourant{" +
                "code='" + code + '\'' +
                ", solde=" + solde +
                ", decouvert=" + decouvert +
                '}';
    }

    // Getters et Setters
    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
}
