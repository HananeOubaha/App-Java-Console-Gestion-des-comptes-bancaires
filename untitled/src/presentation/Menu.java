package presentation;

import metier.BanqueService;
import java.util.Scanner;

public class Menu {

    private BanqueService banqueService;
    private Scanner scanner;

    public Menu(BanqueService banqueService) {
        this.banqueService = banqueService;
        this.scanner = new Scanner(System.in);
    }

    public void afficherMenu() {
        int choix = -1;

        do {
            System.out.println("\n=== Menu Banque ===");
            System.out.println("1. Créer un compte");
            System.out.println("2. Effectuer un versement");
            System.out.println("3. Effectuer un retrait");
            System.out.println("4. Effectuer un virement");
            System.out.println("5. Consulter le solde d'un compte");
            System.out.println("6. Consulter les opérations d'un compte");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");

            try {
                choix = Integer.parseInt(scanner.nextLine());
                traiterChoix(choix);
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide !");
            }

        } while (choix != 0);

        System.out.println("Merci d'avoir utilisé l'application !");
    }

    private void traiterChoix(int choix) {
        switch (choix) {
            case 1:
                creerCompte();
                break;
            case 2:
                // Appeler méthode versement
                break;
            case 3:
                // Appeler méthode retrait
                break;
            case 4:
                // Appeler méthode virement
                break;
            case 5:
                // Appeler méthode consulter solde
                break;
            case 6:
                // Appeler méthode consulter opérations
                break;
            case 0:
                System.out.println("Fermeture du menu...");
                break;
            default:
                System.out.println("Option invalide !");
        }
    }
    // methode pour la création du compte
    private void creerCompte() {
        System.out.println("\nCréer un compte : ");
        System.out.println("1. Compte Courant");
        System.out.println("2. Compte Épargne");
        System.out.print("Votre choix : ");

        int typeCompte;
        try {
            typeCompte = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Choix invalide !");
            return;
        }

        System.out.print("Solde initial : ");
        double solde;
        try {
            solde = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Montant invalide !");
            return;
        }

        switch (typeCompte) {
            case 1:
                System.out.print("Découvert autorisé : ");
                double decouvert;
                try {
                    decouvert = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Montant invalide !");
                    return;
                }
                banqueService.creerCompteCourant(solde, decouvert);
                System.out.println("Compte courant créé !");
                break;
            case 2:
                System.out.print("Taux d'intérêt (%) : ");
                double taux;
                try {
                    taux = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Montant invalide !");
                    return;
                }
                banqueService.creerCompteEpargne(solde, taux);
                System.out.println("Compte épargne créé !");
                break;
            default:
                System.out.println("Type de compte invalide !");
        }
    }
}