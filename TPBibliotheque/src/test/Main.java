package test;

import entities.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Capacité initiale de la bibliothèque : ");
		int n = sc.nextInt();
		sc.nextLine(); // consommer le retour chariot

		Bibliotheque biblio = new Bibliotheque(n);

		// Initialisation avec 2 documents
		biblio.ajouter(new Roman("Le Petit Prince", "Saint-Exupéry", 120, 15.5));
		biblio.ajouter(new Revue("Science et Vie", "Janvier", 2025));

		boolean quitter = false;
		while (!quitter) {
			System.out.println("\nMenu : 1=Ajouter 2=Afficher 3=Supprimer 4=Auteurs 5=Quitter");
			System.out.print("Choix : ");
			int choix = sc.nextInt();
			sc.nextLine(); // consommer retour chariot

			switch (choix) {
			case 1:
				System.out.print("Type (Roman/Manuel/Revue/Dictionnaire) : ");
				String type = sc.nextLine();
				System.out.print("Titre : ");
				String titre = sc.nextLine();
				switch (type) {
				case "Roman":
					System.out.print("Auteur : ");
					String auteur = sc.nextLine();
					System.out.print("Nb pages : ");
					int pages = sc.nextInt();
					System.out.print("Prix : ");
					double prix = sc.nextDouble();
					sc.nextLine();
					biblio.ajouter(new Roman(titre, auteur, pages, prix));
					break;
				case "Manuel":
					System.out.print("Auteur : ");
					auteur = sc.nextLine();
					System.out.print("Nb pages : ");
					pages = sc.nextInt();
					sc.nextLine();
					System.out.print("Niveau : ");
					String niveau = sc.nextLine();
					biblio.ajouter(new Manuel(titre, auteur, pages, niveau));
					break;
				case "Revue":
					System.out.print("Mois : ");
					String mois = sc.nextLine();
					System.out.print("Année : ");
					int annee = sc.nextInt();
					sc.nextLine();
					biblio.ajouter(new Revue(titre, mois, annee));
					break;
				case "Dictionnaire":
					System.out.print("Langue : ");
					String langue = sc.nextLine();
					biblio.ajouter(new Dictionnaire(titre, langue));
					break;
				default:
					System.out.println("Type inconnu.");
				}
				break;
			case 2:
				biblio.afficherDocuments();
				break;
			case 3:
				System.out.print("Numéro d'enregistrement à supprimer : ");
				int num = sc.nextInt();
				sc.nextLine();
				Document d = biblio.document(num);
				if (d != null && biblio.supprimer(d)) {
					System.out.println("Document supprimé.");
				} else {
					System.out.println("Document introuvable.");
				}
				break;
			case 4:
				biblio.afficherAuteurs();
				break;
			case 5:
				quitter = true;
				break;
			default:
				System.out.println("Choix invalide.");
			}
		}
		sc.close();

	}

}
