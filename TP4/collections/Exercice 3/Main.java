import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Création d'un HashSet pour stocker des chaînes de caractères
        HashSet<String> groupeA = new HashSet<>();
        HashSet<String> groupeB = new HashSet<>();
        // Ajout d'éléments à l'ensemble
        groupeA.add("Youness");
        groupeA.add("Said");
        groupeA.add("Ahmad");
        groupeA.add("imane");
        groupeA.add("akram");
        groupeB.add("imane");
        groupeB.add("akram");
        groupeB.add("achraf");
        groupeB.add("kamal");
        groupeB.add("salma");

        
        Set<String> intersection = new HashSet<>(groupeA);
        intersection.retainAll(groupeB);
        System.out.println("Intersection of the two groups : " + intersection);

        Set<String> union = new HashSet<>(groupeA);
        union.addAll(groupeB);
        System.out.println("Union of the two groups : " + union);




    }
}