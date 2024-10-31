public class Adherent extends Personne {
    private int numAdherent;

    public Adherent(String nom, String prenom, String email, String tel, int age, int numAdherent) {
        super(nom, prenom, email, tel, age);
        this.numAdherent = numAdherent;
    }

    //redefinition de la methode afficher pour inclure le numero d'adherent
    @Override
    public void afficher() {
        System.out.println("Numéro Adhérent: " + numAdherent);
        super.afficher();
    }
}
