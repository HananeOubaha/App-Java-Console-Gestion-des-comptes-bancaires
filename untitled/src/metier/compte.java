package metier;

import java.util.ArrayList;
import java.util.List;

public abstract class Compte {

    protected String code;
    protected double solde;
    protected List<Operation> operations;

    // Constructeur
    public Compte(String code, double solde) {
        this.code = code;
        this.solde = solde;
        this.operations = new ArrayList<>();
    }

    // Méthodes abstraites
    public abstract void retirer(double montant);
    public abstract double calculerInteret();  //
    public abstract void afficherDetails();

    // Méthode commune
    public void verser(double montant) {
        if (montant > 0) {
            solde = solde + montant;
            System.out.println("Versement de " + montant + " effectué avec succès. Nouveau solde : " + solde);
        } else {
            System.out.println("Montant invalide !");
        }
    }

    // Getters
    public String getCode() {
        return code;
    }

    public double getSolde() {
        return solde;
    }
}
