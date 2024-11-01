class Manager extends Employe {
    
    private String service;

    public Manager(String nom,String prenom,String email,String telephone,double salaire,String service) {
        super(nom, prenom, email, telephone, salaire);
        this.service = service;
    }

    public String getService(){
        return service;
    }

    @Override
    public double calculerSalire() {

        return super.calculerSalire() + (super.calculerSalire() * 0.20);

    }

}