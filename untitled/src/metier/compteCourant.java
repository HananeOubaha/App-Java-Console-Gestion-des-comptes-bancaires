package metier ;

public class CompteCourant extends Compte{
    private double decouvert ;

    // constructeur
    public CompteCourant(String code, double solde, double decouvert){
        super(code,solde);
        this.decouvert = decouvert ;
    }

    // redefinition de la  méthode retirer()
    public void retirer(double montant){
        if (montant <= 0) {
            System.out.println("Montant innacceptable pour effectuer un retrait . ") ;
            return ;
        }
        // création d'une variable temporaire pour représenter l'état du solde après opperation
        double nouveauSolde = this.solde - montant;

        if (nouveauSolde < -decouvert){
            System.out.println("impossible d'effectuer un retrait : vous dépassez la deouvert limite ");
            return ;
        }
        this.solde = nouveauSolde;
        System.out.println("Retrait de " + montant + " effectué. Votre Nouveau solde est " + this.solde);
    }
    //redifinition de ma methode calculerInteret()
    public double calculerIneteret(){
        // un compte courant sans ineterets
        return 0.0;
    }
    //redifinition de la methode afficherDetails()
    public void afficherDetails() {
        System.out.println("===Compte Courant ===");
        System.out.println("Code: " + code);
        System.out.println("Solde: " + solde);
        System.out.println("Découvert autorisé: " + decouvert);
    }

    // getter / setter
    public double getDeouvert(){
        return decouvert;
    }
    public void setdeouvert(double decouvert){
        this.decouvert=decouvert;
    }
}
