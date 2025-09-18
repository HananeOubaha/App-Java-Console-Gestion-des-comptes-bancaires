package metier;

public class Retrait extends Operation{
    private String destination;

    public Retrait(double montant, String destination) {
        super(montant);
        this.destination = destination;
    }

    @Override
    public void afficherDetails() {
        super.afficherDetails();
        System.out.println("Destination : " + destination);
    }
}
