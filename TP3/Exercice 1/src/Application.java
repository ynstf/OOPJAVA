class Application{
    public static void main(String[] args){

        Vehicule vehicule = new Vehicule();

        //premier test avec une vitesse acceptable
        try {
            System.out.println("Vitesse testée à 80 km/h.");
            vehicule.testVitesse(80);
            System.out.println("Pas d'exception.");
        } catch (TropViteException e) {
            e.printStackTrace();
        }

        //deuxième test avec une vitesse supérieure à 90, ce qui devrait lancer l'exception
        try {
            System.out.println("Vitesse testée à 100 km/h.");
            vehicule.testVitesse(100);
        } catch (TropViteException e) {
            e.printStackTrace();
        }
        
    }
}