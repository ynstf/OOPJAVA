class Employe {
    private String nom;
    private String departement;
    private double salaire;

    // Constructeur
    public Employe(String nom, String departement, double salaire) {
        this.nom = nom;
        this.departement = departement;
        this.salaire = salaire;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getDepartement() {
        return departement;
    }

    public double getSalaire() {
        return salaire;
    }

    // Méthode toString pour afficher les informations de l'employé
    @Override
    public String toString() {
        return "Nom: " + nom + ", Département: " + departement + ", Salaire: " + salaire;
    }
}