package com.example.tp;

public class Main {

	public static void main(String[] args) {
		// 1. Création des comptes
        Compte compte1 = new Compte(1000.0);
        CompteEpargne ce = new CompteEpargne(500.0, 3.0);
        CompteCourant cc = new CompteCourant(200.0, 300.0);

        // 2. Opérations sur Compte de base
        compte1.afficherDetails();
        compte1.deposer(200);
        compte1.retirer(1500); // refuse
        compte1.afficherDetails();
        System.out.println();

        // 3. Opérations sur CompteEpargne
        ce.afficherDetails();
        ce.appliquerInterets();
        ce.afficherDetails();
        ce.retirer(100);
        ce.afficherDetails();
        System.out.println();

        // 4. Opérations sur CompteCourant
        cc.afficherDetails();
        cc.retirer(400);  // autorisé grâce au découvert
        cc.afficherDetails();
        cc.retirer(200);  // refusé, découvert dépassé
        cc.afficherDetails();
        System.out.println();

        // 5. Polymorphisme
        Compte poly = new CompteEpargne(100, 5);
        poly.afficherDetails();  // appel à CompteEpargne.afficherDetails()
	}

}
