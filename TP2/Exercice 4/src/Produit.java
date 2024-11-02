public class Produit{
    private int id;
    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int nombreStock;

    public Produit(int id,String nom,String marque,double prix,String description,int nombreStock){
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nombreStock = nombreStock;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter and Setter for marque
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    // Getter and Setter for prix
    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for nombreStock
    public int getNombreStock() {
        return nombreStock;
    }

    public void setNombreStock(int nombreStock) {
        this.nombreStock = nombreStock;
    }

    // Method to display product information
    public void afficherInfos() {
        System.out.println("ID: " + id);
        System.out.println("Nom: " + nom);
        System.out.println("Marque: " + marque);
        System.out.println("Prix: " + prix + " EUR");
        System.out.println("Description: " + description);
        System.out.println("Nombre en Stock: " + nombreStock);
        System.out.println("----------------------------------");
    }

}