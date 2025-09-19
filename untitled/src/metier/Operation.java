package metier;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Operation {
    protected String numero;
    protected LocalDate date ;
    protected double montant ;

    // constructeur
    public Operation(double montant) {
        this.numero = UUID.randomUUID().toString();
        this.date = LocalDate.now();
        this.montant = montant;
    }
    public void afficherDetails() {
        System.out.println("Numéro : " + numero);
        System.out.println("Date : " + date);
        System.out.println("Montant : " + montant);
    }

    // Getter pour le montant
    public double getMontant() {
        return montant;
    }
    public String getNumero() {
        return numero;
    }
    public LocalDate getDate() {
        return date;
    }
}