package utilitaire;

import metier.Compte;

public class Utils {

    // Afficher les détails d'un compte proprement
    public static void afficherCompte(Compte compte) {
        System.out.println("=================================");
        compte.afficherDetails();
        System.out.println("=================================");
    }

    // Afficher un message d'opération réussie
    public static void afficherSucces(String message) {
        System.out.println( message);
    }

    // Afficher un message d'erreur
    public static void afficherErreur(String message) {
        System.out.println(" Erreur : " + message);
    }

    // Formater un montant
    public static String formatMontant(double montant) {
        return String.format("%.2f MAD", montant);
    }
}
