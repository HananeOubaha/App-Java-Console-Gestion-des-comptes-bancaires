package metier;

public class CompteEpargne extends Compte {
    private double tauxInteret;

    // constructuer
    public CompteEpargne(String code, double solde, double tauxInteret) {
        super(code,solde);
        this.tauxInteret = tauxInteret;
    }
    // REDIFINITON LA methode abstraite retirer
    @Override
    public void retirer(double montant) {
        if (montant <= 0) {
            System.out.println("Retrait innaceptable : solde insuffisant .");
            return;
        }
        this.solde -= montant;
        System.out.println("Retrait de " + montant + "effectué avec succés.Nouveau solde = " + this.solde);
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