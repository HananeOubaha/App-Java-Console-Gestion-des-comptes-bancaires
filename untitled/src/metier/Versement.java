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
        System.out.println("=== Détails du Versement ===");
        System.out.println("Numéro   : " + numero);
        System.out.println("Date     : " + date);
        System.out.println("Montant  : " + montant + " MAD");
        System.out.println("Source   : " + source);
        System.out.println("============================");
    }
    @Override
    public String toString() {
        return "Versement{" +
                "numero='" + numero + '\'' +
                ", date=" + date +
                ", montant=" + montant +
                ", source='" + source + '\'' +
                '}';
    }

    // Getter
    public String getSource() {
        return source;
    }
}
