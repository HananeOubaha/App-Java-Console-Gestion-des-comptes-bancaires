package metier;

import com.sun.corba.se.spi.orb.Operation;

import java.util.ArrayList;

public abstract class  compte {

    protected string code;
    protected double solde;
    protected List<Operation> operations;

    // constructeur
    public compte(string code , double solde){
        this.code = code;
        this.solde=solde;
        this.operations=new ArrayList<>();
    }
    // methodes abstracts
    public abstract void retirer(double montant);
    public abstract double calculerIneret();
    public abstract void afficherDetails();