public class LigneCommande {
    //attributs de la classe LigneCommande
    private int quantite;
    private Commande commande;
    private Ordinateur ordinateur;

    //constructeur de la classe LigneCommande
    public LigneCommande(int quantite, Commande commande, Ordinateur ordinateur) {
        this.quantite = quantite;
        this.commande = commande;
        this.ordinateur = ordinateur;
    }

    //getters et setters
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Ordinateur getOrdinateur() {
        return ordinateur;
    }

    public void setOrdinateur(Ordinateur ordinateur) {
        this.ordinateur = ordinateur;
    }

    //methode pour calculer le prix total de la ligne de commande
    public double calculerPrixTotal() {
        return quantite * ordinateur.getPrix();
    }

    //methode pour afficher les détails de la ligne de commande
    public void afficherDetailsLigneCommande() {
        System.out.println("Quantité : " + quantite);
        System.out.println("Commande Référence : " + commande.getReference());
        System.out.println("Ordinateur Commandé : " + ordinateur.getNom());
        System.out.println("Prix Total : " + calculerPrixTotal() + "MAD");
    }
}