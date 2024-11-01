import java.util.ArrayList;
import java.util.List;

class Categorie{

    private String nom;
    private String description;
    private List<Ordinateur> ordinateurs;

    public Categorie(String nom, String description) {
        this.nom = nom;
        this.description = description;
        this.ordinateurs = new ArrayList<>();
    }

    // Getter 
    public String getNom(){
        return this.nom;
    }
    public String getDescription(){
        return this.description;
    }

    // setter 
    public void setNom(String nom){
        this.nom = nom ;
    }
    public void setDescription(String description){
        this.description = description ;
    }

    //methode pour afficher tous les ordinateurs de la catégorie
    public void afficherOrdinateurs() {
        System.out.println("Ordinateurs dans la catégorie " + nom + " :");
        for (Ordinateur ordinateur : ordinateurs) {
            ordinateur.afficherDetails();
        }
    }

        //methode pour ajouter un ordinateur dans la catégorie
    public void ajouterOrdinateur(Ordinateur ordinateur) {
        //vérification de la présence de l'ordinateur dans la liste
        if (!ordinateurs.contains(ordinateur)) {
            ordinateurs.add(ordinateur);
            System.out.println("Ordinateur ajouté avec succès : " + ordinateur.getNom());
        } else {
            System.out.println("L'ordinateur existe déjà dans la catégorie.");
        }
    }

    //methode pour supprimer un ordinateur de la catégorie
    public void supprimerOrdinateur(Ordinateur ordinateur) {
        if (ordinateurs.contains(ordinateur)) {
            ordinateurs.remove(ordinateur);
            System.out.println("Ordinateur supprimé : " + ordinateur.getNom());
        } else {
            System.out.println("L'ordinateur n'existe pas dans la catégorie.");
        }
    }

    //methode pour afficher liste des ordinateurs par un prix donné
    public void rechercherParPrix(double prix) {
        System.out.println("Ordinateurs ont le prix " + prix + "(MAD) :");
        for (Ordinateur ordinateur : ordinateurs) {
            if (ordinateur.getPrix()==prix){
                ordinateur.afficherDetails();
                System.out.println();
            }
        }
    }






}