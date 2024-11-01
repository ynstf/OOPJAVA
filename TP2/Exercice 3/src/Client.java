import java.util.ArrayList;
import java.util.List;

public class Client {
    // Attributs de la classe Client
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String ville;
    private String telephone;
    private List<Commande> commandes;

    //constructeur de la classe Client
    public Client(String nom, String prenom, String adresse, String email, String ville, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.ville = ville;
        this.telephone = telephone;
        this.commandes = new ArrayList<>();
    }

    // getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    //methode pour ajouter une commande à la liste, avec vérification d'existence
    public void ajouterCommande(Commande commande) {
        if (!commandes.contains(commande)) {
            commandes.add(commande);
            System.out.println("Commande ajoutée avec succès : " + commande.getReference());
        } else {
            System.out.println("La commande existe déjà.");
        }
    }

    //methode pour supprimer une commande de la liste
    public void supprimerCommande(Commande commande) {
        if (commandes.contains(commande)) {
            commandes.remove(commande);
            System.out.println("Commande supprimée : " + commande.getReference());
        } else {
            System.out.println("La commande n'existe pas dans la liste.");
        }
    }

    //methode pour afficher les détails du client
    public void afficherDetailsClient() {
        System.out.println("Nom : " + nom + " " + prenom);
        System.out.println("Adresse : " + adresse);
        System.out.println("Email : " + email);
        System.out.println("Ville : " + ville);
        System.out.println("Téléphone : " + telephone);
        System.out.println("Commandes effectuées : ");
        for (Commande commande : commandes) {
            System.out.println("- " + commande.getReference() + " (État : " + commande.getEtatCommande() + ")");
        }
    }
}
