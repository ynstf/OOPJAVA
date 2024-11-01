public class Application{
    public static void main(String[] args) {

        Ingenieur ing1 = new Ingenieur("atif","youness","younessatif@gmail.com","0605153098",12500.98,"python developer");

        Manager mang1 = new Manager("ahmadi","said","saidsaid@gmail.com","0663728168",18500.68,"IT");

        System.out.println("Ingenieur : ");
        System.out.println("nom : " +ing1.getNom());
        System.out.println("prenom : " +ing1.getPrenom());
        System.out.println("specialite : " +ing1.getSpecialite());
        System.out.println("salaire : " +ing1.calculerSalire()+ " MAD");
        System.out.println();

        System.out.println();
        System.out.println("Manager : ");
        System.out.println("nom : " +mang1.getNom());
        System.out.println("prenom : " +mang1.getPrenom());
        System.out.println("service : " +mang1.getService());
        System.out.println("salaire : " +mang1.calculerSalire()+ " MAD");
        System.out.println();

        
        
        
    }
}