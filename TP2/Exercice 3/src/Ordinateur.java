public class Ordinateur {

    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int nombreEnStock;
    private String categorie;

    public Ordinateur(String nom, String marque, double prix, String description, int nombreEnStock, String categorie) {
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nombreEnStock = nombreEnStock;
        this.categorie = categorie;
    }
    
    //getters
    public String getNom(){
        return this.nom;
    }
    public String getMarque(){
        return this.marque;
    }
    public double getPrix(){
        return this.prix;
    }
    public String getDescription(){
        return this.description;
    }
    public int getNombreEnStock(){
        return this.nombreEnStock;
    }
    public String getCategorie(){
        return this.categorie;
    }

    // setters
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setMarque(String marque){
        this.marque=marque;
    }
    public void setPrix(double prix){
        this.prix=prix;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public void setNombreEnStock(int nombreEnStock){
        this.nombreEnStock=nombreEnStock;
    }
    public void setCategorie(String categorie){
        this.categorie=categorie;
    }



    public double calculerPrixTotal(int quantite) {
        if (quantite <= 0) {
            System.out.println("Quantité invalide");
            return 0;
        } else if (quantite > nombreEnStock) {
            System.out.println("Quantité demandée supérieure au stock disponible");
            return 0;
        }
        return quantite * prix;
    }

    public void afficherDetails() {
        System.out.println("Nom : " + nom);
        System.out.println("Marque : " + marque);
        System.out.println("Prix unitaire : " + prix + "MAD");
        System.out.println("Description : " + description);
        System.out.println("Stock disponible : " + nombreEnStock);
        System.out.println("Catégorie : " + categorie);
    }


}