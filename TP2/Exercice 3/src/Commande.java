import java.time.LocalDate;

public class Commande {

    private String reference;
    private Client client;
    private LocalDate dateCommande;
    private String etatCommande;


    public Commande(String reference, Client client, LocalDate dateCommande, String etatCommande) {
        this.reference = reference;
        this.client = client;
        this.dateCommande = dateCommande;
        this.etatCommande = etatCommande;
    }

    //Getters et Setters
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getEtatCommande() {
        return etatCommande;
    }

    public void setEtatCommande(String etatCommande) {
        this.etatCommande = etatCommande;
    }

    // Méthode pour afficher les détails de la commande
    public void afficherDetailsCommande() {
        System.out.println("Référence de la commande : " + reference);
        System.out.println("Client : " + client);
        System.out.println("Date de la commande : " + dateCommande);
        System.out.println("État de la commande : " + etatCommande);
    }
}