package entities;

public class Bibliotheque {
	private Document[] documents;
    private int nbDocuments;

    public Bibliotheque(int capacite) {
        documents = new Document[capacite];
        nbDocuments = 0;
    }

    public boolean ajouter(Document doc) {
        if (nbDocuments == documents.length) {
            // agrandir le tableau
            Document[] tmp = new Document[documents.length * 2];
            System.arraycopy(documents, 0, tmp, 0, documents.length);
            documents = tmp;
        }
        documents[nbDocuments++] = doc;
        return true;
    }

    public boolean supprimer(Document doc) {
        for (int i = 0; i < nbDocuments; i++) {
            if (documents[i] == doc) {
                // décaler les éléments
                for (int j = i; j < nbDocuments - 1; j++) {
                    documents[j] = documents[j + 1];
                }
                documents[--nbDocuments] = null;
                return true;
            }
        }
        return false;
    }

    public Document document(int numEnreg) {
        for (int i = 0; i < nbDocuments; i++) {
            if (documents[i].getNumEnreg() == numEnreg) {
                return documents[i];
            }
        }
        return null;
    }

    public void afficherDocuments() {
        System.out.println("Documents dans la bibliothèque :");
        for (int i = 0; i < nbDocuments; i++) {
            System.out.println(documents[i]);
        }
    }

    public void afficherAuteurs() {
        System.out.println("Liste des auteurs :");
        for (int i = 0; i < nbDocuments; i++) {
            if (documents[i] instanceof Livre) {
                Livre l = (Livre) documents[i];
                System.out.println(l.getAuteur());
            }
        }
    }

}
