package entities;

public class Document {
	 private static int compteur = 0;
	    private final int numEnreg;
	    private String titre;

	    public Document(String titre) {
	        this.numEnreg = ++compteur;
	        this.titre = titre;
	    }

	    public int getNumEnreg() { return numEnreg; }
	    public String getTitre() { return titre; }
	    public void setTitre(String titre) { this.titre = titre; }

	    @Override
	    public String toString() {
	        return "Document[id=" + numEnreg + ", titre=" + titre + "]";
	    }

}
