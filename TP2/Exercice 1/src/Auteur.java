public class Auteur extends Personne {
    private int numAuteur;

    public Auteur(String nom, String prenom, String email, String tel, int age, int numAuteur) {
        super(nom, prenom, email, tel, age);
        this.numAuteur = numAuteur;
    }

    //redefinition de la methode afficher pour inclure le numero d'Auteur
    @Override
    public void afficher() {
        System.out.println("Numéro Auteur: " + numAuteur);
        super.afficher();
    }
}
