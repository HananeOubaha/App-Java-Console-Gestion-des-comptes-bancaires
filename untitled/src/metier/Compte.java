package metier;

import java.util.ArrayList;
import java.util.List;

public abstract class Compte {

    protected String code;
    protected double solde;
    protected List<Operation> operations;

    // conteur initialiser par 1
    private static int compteur = 1 ;

    // Constructeur
    public Compte(String code, double solde) {
        this.code = code;
        this.solde = solde;
        this.operations = new ArrayList<>();
    }
    // generation d'un code unique
    private String genererCodeUnique(){
        String codeUnique = String.format("CPT-%0.5d",compteur);
        compteur++;
        return codeUnique;
    }

    // Méthodes abstraites
    public abstract void retirer(double montant, String destination) throws OperationException;
    public abstract double calculerInteret();  //
    public abstract void afficherDetails();

    // Méthode commune
    public void verser(double montant,String source) throws OperationException {
        if (montant <= 0) {
            throw new OperationException("Le montant du versement doit être positif.");
        }
        this.solde += montant;
        Versement v = new Versement(montant, source);
        this.operations.add(v);
    }

    // Getters
    public String getCode() {
        return code;
    }

    public double getSolde() {
        return solde;
    }
    public List<Operation> getListeOperations() { return operations; }

}
