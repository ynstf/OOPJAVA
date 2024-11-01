class Ingenieur extends Employe {

    public Ingenieur(String nom,String prenom,String email,String telephone,double salaire) {
        super(nom, prenom, email, telephone, salaire);
    }

    @Override
    public double calculerSalire() {
        return super.calculerSalire();
    }
}