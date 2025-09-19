package metier;

public class Retrait extends Operation{
    private String destination;

    public Retrait(double montant, String destination) {
        super(montant);
        this.destination = destination;
    }

    @Override
    public void afficherDetails() {
        System.out.println("=== Détails du Retrait ===");
        System.out.println("Numéro       : " + numero);
        System.out.println("Date         : " + date);
        System.out.println("Montant      : " + montant + " MAD");
        System.out.println("Destination  : " + destination);
        System.out.println("===========================");
    }

    @Override
    public String toString() {
        return "Retrait{" +
                "numero='" + numero + '\'' +
                ", date=" + date +
                ", montant=" + montant +
                ", destination='" + destination + '\'' +
                '}';
    }

    // Getter
    public String getDestination() {
        return destination;
    }
}
