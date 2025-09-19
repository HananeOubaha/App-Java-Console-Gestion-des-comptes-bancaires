package metier;

import java.util.*;

public class BanqueService {
    private Map<String, Compte> comptes = new HashMap<>();

    // création d'un compte courant et le stocker
    public Compte creerCompteCourant(String code,double solde, double decouvert) {
        CompteCourant c = new CompteCourant(code,solde, decouvert);
        comptes.put(c.getCode(), c);
        return c;
    }

    // création d'un compte épargne et le stocker
    public Compte creerCompteEpargne(String code,double solde, double taux) {
        CompteEpargne c = new CompteEpargne(code,solde, taux);
        comptes.put(c.getCode(), c);
        return c;
    }

    // versement
    public void verser(String code, double montant, String source) throws OperationException {
        Compte c = comptes.get(code);
        if (c == null) throw new OperationException("Compte introuvable : " + code);
        c.verser(montant, source);
    }

    // retrait
    public void retirer(String code, double montant, String destination) throws OperationException {
        Compte c = comptes.get(code);
        if (c == null) throw new OperationException("Compte introuvable : " + code);
        c.retirer(montant, destination);
    }

    // virement
    public void virement(String codeSource, String codeDest, double montant) throws OperationException {
        if (codeSource.equals(codeDest)) throw new OperationException("Code source et destination identiques !");
        Compte src = comptes.get(codeSource);
        Compte dst = comptes.get(codeDest);
        if (src == null) throw new OperationException("Compte source introuvable : " + codeSource);
        if (dst == null) throw new OperationException("Compte destination introuvable : " + codeDest);

        src.retirer(montant, "Virement sortant vers " + codeDest);
        dst.verser(montant, "Virement entrant depuis " + codeSource);
    }

    // consulter solde
    public double getSolde(String code) throws OperationException {
        Compte c = comptes.get(code);
        if (c == null) throw new OperationException("Compte introuvable : " + code);
        return c.getSolde();
    }

    // lister opérations
    public List<Operation> getOperations(String code) throws OperationException {
        Compte c = comptes.get(code);
        if (c == null) throw new OperationException("Compte introuvable : " + code);
        return c.getListeOperations();
    }

    // lister tous les comptes
    public Collection<Compte> getAllComptes() {
        return comptes.values();
    }
}
