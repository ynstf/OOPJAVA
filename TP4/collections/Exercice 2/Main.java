import java.util.*;

class Main{
    public static void main(String[] args){
        Map<String,Double> qde=new HashMap<>();

        System.out.println("insert ...");
        qde.put("youness",14.5);
        qde.put("said",16.75);
        qde.put("ahmad",12.25);
        qde.put("imane",10.5);
        qde.put("akram",11.0);
        qde.put("achraf",17.0);
        qde.put("kamal",18.0);
        qde.put("salma",9.0);

        //afficher les valeurs avec foreach et l'expression l'ambda
        //qde.forEach((nom, valeur) -> System.out.println("Nom: " + nom + ", Valeur: " + valeur));
        System.out.println("show ...");
        qde.keySet().forEach(k-> System.out.println(k+" :"+qde.get(k)));
        System.out.println();

        System.out.println("add 1 to student 'youness' ...");
        qde.put("youness",qde.get("youness")+1);
        qde.keySet().forEach(k-> System.out.println(k+" :"+qde.get(k)));
        System.out.println();


        System.out.println("delete 'ahmad' note ...");
        qde.remove("ahmad");
        qde.keySet().forEach(k-> System.out.println(k+" :"+qde.get(k)));
        System.out.println();


        System.out.println("show size of the map ...");
        System.out.println(qde.size());
        System.out.println();

        double avg = 0.0;
        for (double valeur : qde.values()) {avg += valeur;}
        avg = avg / qde.size();

        double maxValue = Double.MIN_VALUE; // Initialise avec la plus petite valeur possible
        for (double valeur : qde.values()) {
            if (valeur > maxValue) {
                maxValue = valeur;
            }
        }

        double minValue = Double.MAX_VALUE; // Initialise avec la plus petite valeur possible
        for (double valeur : qde.values()) {
            if (valeur < minValue) {
                minValue = valeur;
            }
        }

        System.out.println("avg : "+avg);
        System.out.println("max : "+maxValue);
        System.out.println("min : "+minValue);
        System.out.println();

        boolean is20 = false;
        for (double valeur : qde.values()) {
            if (valeur == 20) {is20 = true;}
        }
        if (is20) System.out.println("20 exist");
        else System.out.println("20 not exist");



        
    }

}