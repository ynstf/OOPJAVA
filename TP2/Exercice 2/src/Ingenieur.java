class Ingenieur extends Employe {

    private String specialite;

    public Ingenieur(String nom,String prenom,String email,String telephone,double salaire,String specialite) {
        super(nom, prenom, email, telephone, salaire);
        this.specialite = specialite;
    }
    public String getSpecialite(){
        return specialite;
    }

    @Override
    public double calculerSalire() {

        return super.calculerSalire() + (super.calculerSalire() * 0.15);

    }
}