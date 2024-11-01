abstract class Employe{
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private double salaire;

    public Employe(String nom,String prenom,String email,String telephone,double salaire){
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.telephone = telephone;
    this.salaire = salaire;
    }

    public String getNom(){
        return nom;
    }
    public String getPrenom(){
        return prenom;
    }


    public double calculerSalire(){
        return salaire;
    }
}