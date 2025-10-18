package com.example.tp;

public class CompteEpargne  extends Compte {
	private double tauxInteret; // en pourcentage, ex. 2.5 pour 2,5%

    public CompteEpargne(double soldeInitial, double tauxInteret) {
        super(soldeInitial);
        this.tauxInteret = tauxInteret;
    }

    /** Applique les intérêts au solde courant */
    public void appliquerInterets() {
        double interets = solde * tauxInteret / 100.0;
        solde += interets;
        System.out.println("CompteEpargne #" + getNumero()
            + " : intérêts de " + interets);
    }

    @Override
    public void afficherDetails() {
        System.out.println("CompteEpargne #" + getNumero()
            + " — solde = " + solde
            + ", taux = " + tauxInteret + "%");
    }

}
