package presentation;

import metier.*;

public class Main {
    public static void main(String[] args) {
        BanqueService service = new BanqueService();

        // création comptes
        Compte c1 = service.creerCompteCourant(1000.0, 500.0);
        Compte c2 = service.creerCompteEpargne(2000.0, 0.03);

        System.out.println("Comptes créés:");
        System.out.println(c1.getCode() + " solde=" + c1.getSolde());
        System.out.println(c2.getCode() + " solde=" + c2.getSolde());

        try {
            // versement
            service.verser(c1.getCode(), 200.0, "Dépôt espèces");
            // retrait
            service.retirer(c1.getCode(), 500.0, "ATM");
            // virement c2 -> c1
            service.virement(c2.getCode(), c1.getCode(), 300.0);

            System.out.println("Solde c1 après opérations: " + service.getSolde(c1.getCode()));
            System.out.println("Opérations de " + c1.getCode() + ":");
            for (Operation op : service.getOperations(c1.getCode())) {
                op.afficherDetails();
                System.out.println("----");
            }
        } catch (OperationException ex) {
            System.out.println("Erreur métier : " + ex.getMessage());
        }
    }
}
