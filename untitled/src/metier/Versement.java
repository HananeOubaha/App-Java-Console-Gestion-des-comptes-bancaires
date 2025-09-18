package metier ;
public class Versement extends Operation {
    private String source;

    //constructeur
    public Versement(double montant , String source) {
        super(montant);
        this.source = source;
    }

    @Override
     public void afficherDetails() {
        super.afficherDetails();
        System.out.println("Source : " + source);
    }
}
