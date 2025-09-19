package presentation;

import metier.*;
import utilitaire.Utils;

import java.util.List;
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
                Utils.afficherErreur("Veuillez entrer un nombre valide !");
            }

        } while (choix != 0);

        Utils.afficherSucces("Merci d'avoir utilisé l'application !");
    }

    private void traiterChoix(int choix) {
        switch (choix) {
            case 1:
                creerCompte();
                break;
            case 2:
                effectuerVersement();
                break;
            case 3:
                effectuerRetrait();
                break;
            case 4:
                effectuerVirement();
                break;
            case 5:
                consulterSolde();
                break;
            case 6:
                consulterOperations();
                break;
            case 0:
                Utils.afficherSucces("Fermeture du menu...");
                break;
            default:
                Utils.afficherErreur("Option invalide !");
        }
    }

    private void creerCompte() {
        System.out.println("\nCréer un compte : ");
        System.out.println("1. Compte Courant");
        System.out.println("2. Compte Épargne");
        System.out.print("Votre choix : ");

        int typeCompte;
        try {
            typeCompte = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            Utils.afficherErreur("Choix invalide !");
            return;
        }

        System.out.print("Solde initial : ");
        double solde;
        try {
            solde = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            Utils.afficherErreur("Montant invalide !");
            return;
        }

        switch (typeCompte) {
            case 1:
                System.out.print("Découvert autorisé : ");
                double decouvert;
                try {
                    decouvert = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    Utils.afficherErreur("Montant invalide !");
                    return;
                }
                CompteCourant compteC = banqueService.creerCompteCourant(solde, decouvert);
                Utils.afficherSucces("Compte courant créé !");
                Utils.afficherCompte(compteC);
                break;

            case 2:
                System.out.print("Taux d'intérêt (%) : ");
                double taux;
                try {
                    taux = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    Utils.afficherErreur("Montant invalide !");
                    return;
                }
                CompteEpargne compteE = banqueService.creerCompteEpargne(solde, taux);
                Utils.afficherSucces("Compte épargne créé !");
                Utils.afficherCompte(compteE);
                break;

            default:
                Utils.afficherErreur("Type de compte invalide !");
        }
    }

    private void effectuerVersement() {
        System.out.print("Code du compte : ");
        String code = scanner.nextLine();

        System.out.print("Montant à verser : ");
        double montant;
        try {
            montant = Double.parseDouble(scanner.nextLine());
            if (montant <= 0) {
                Utils.afficherErreur("Le montant doit être positif !");
                return;
            }
        } catch (NumberFormatException e) {
            Utils.afficherErreur("Montant invalide !");
            return;
        }

        System.out.print("Source du versement : ");
        String source = scanner.nextLine();

        try {
            banqueService.verser(code, montant, source);
            Utils.afficherSucces("Versement effectué avec succès !");
            Utils.afficherCompte(banqueService.getAllComptes()
                    .stream().filter(c -> c.getCode().equals(code)).findFirst().orElse(null));
        } catch (OperationException e) {
            Utils.afficherErreur(e.getMessage());
        }
    }

    private void effectuerRetrait() {
        System.out.print("Code du compte : ");
        String code = scanner.nextLine();

        System.out.print("Montant à retirer : ");
        double montant;
        try {
            montant = Double.parseDouble(scanner.nextLine());
            if (montant <= 0) {
                Utils.afficherErreur("Le montant doit être positif !");
                return;
            }
        } catch (NumberFormatException e) {
            Utils.afficherErreur("Montant invalide !");
            return;
        }

        System.out.print("Destination du retrait (ex: ATM, Chèque, Virement sortant) : ");
        String destination = scanner.nextLine();

        try {
            banqueService.retirer(code, montant, destination);
            Utils.afficherSucces("Retrait effectué avec succès !");
            Utils.afficherCompte(banqueService.getAllComptes()
                    .stream().filter(c -> c.getCode().equals(code)).findFirst().orElse(null));
        } catch (OperationException e) {
            Utils.afficherErreur(e.getMessage());
        }
    }

    private void effectuerVirement() {
        System.out.print("Code du compte source : ");
        String codeSource = scanner.nextLine();
        System.out.print("Code du compte destination : ");
        String codeDest = scanner.nextLine();

        System.out.print("Montant à virer : ");
        double montant;
        try {
            montant = Double.parseDouble(scanner.nextLine());
            if (montant <= 0) {
                Utils.afficherErreur("Le montant doit être positif !");
                return;
            }
        } catch (NumberFormatException e) {
            Utils.afficherErreur("Montant invalide !");
            return;
        }

        try {
            banqueService.virement(codeSource, codeDest, montant);
            Utils.afficherSucces("Virement effectué avec succès !");
            Utils.afficherCompte(banqueService.getAllComptes()
                    .stream().filter(c -> c.getCode().equals(codeSource)).findFirst().orElse(null));
            Utils.afficherCompte(banqueService.getAllComptes()
                    .stream().filter(c -> c.getCode().equals(codeDest)).findFirst().orElse(null));
        } catch (OperationException e) {
            Utils.afficherErreur(e.getMessage());
        }
    }

    private void consulterSolde() {
        System.out.print("Code du compte : ");
        String code = scanner.nextLine();

        try {
            double solde = banqueService.getSolde(code);
            Utils.afficherSucces("Solde du compte " + code + " : " + Utils.formatMontant(solde));
        } catch (OperationException e) {
            Utils.afficherErreur(e.getMessage());
        }
    }

    private void consulterOperations() {
        System.out.print("Code du compte : ");
        String code = scanner.nextLine();

        try {
            List<Operation> ops = banqueService.getOperations(code);
            System.out.println("Opérations de " + code + " :");
            for (Operation op : ops) {
                op.afficherDetails();
                System.out.println("----");
            }
        } catch (OperationException e) {
            Utils.afficherErreur(e.getMessage());
        }
    }
}
