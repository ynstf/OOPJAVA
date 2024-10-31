public class Livre {
    private int ISBN;
    private String titre;
    private Auteur auteur;

    public Livre(int isbn, String titre , Auteur auteur){
        this.ISBN = isbn;
        this.titre = titre;
        this.auteur = auteur;
    }

    public void afficher() {
        System.out.println("Numéro ISBN: " + ISBN);
        System.out.println("Titre: " + titre);
        auteur.afficher();
    }

}