import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        List<String> mots = new ArrayList<>();

        mots.add("Hello");
        mots.add("everyone");
        mots.add("in");
        mots.add("this");
        mots.add("TP");
        mots.add("thank");
        mots.add("you");
        mots.add("very");
        mots.add("match");

        System.out.println(mots);

        List<String> filteredListA = mots.stream()
                                    .filter(s -> s.contains("a"))
                                    .collect(Collectors.toList());
        System.out.println(filteredListA);

        List<String> filteredList3 = mots.stream()
                                    .filter(s -> s.length()>3)
                                    .map(r -> new StringBuilder(r).reverse().toString())
                                    .collect(Collectors.toList());
        System.out.println(filteredList3);

        List<Character> flattenedListE = mots.stream()
                                                  .filter(s -> s.contains("e")) // Filtrer les chaînes contenant "e"
                                                  .flatMap(s -> s.chars() // Convertir chaque chaîne en un flux d'entiers (codes ASCII des caractères)
                                                              .mapToObj(c -> (char) c)) // Convertir les entiers en caractères
                                                  .collect(Collectors.toList()); // Collecter le résultat dans une liste
        System.out.println(flattenedListE);


        List<String> upperCaseList = mots.stream()
                                         .map(s -> s.toUpperCase()) //.map(String::toUpperCase) Transformer chaque chaîne en majuscules
                                         .collect(Collectors.toList());  // Collecter les chaînes transformées dans une liste
        System.out.println(upperCaseList);


        List<Integer> upperCaseListLen = mots.stream()
                                        .map(s -> s.length()) 
                                        .collect(Collectors.toList());  // Collecter les chaînes transformées dans une liste
        System.out.println(upperCaseListLen);



        // Transformer chaque chaîne en une liste de ses caractères, puis aplatir toutes les listes en une seule
        List<Character> flattenedList = mots.stream()
                                           .flatMap(s -> s.chars()  // Convertir chaque chaîne en un flux de codes ASCII des caractères
                                                         .mapToObj(c -> (char) c))  // Convertir les codes ASCII en caractères
                                           .collect(Collectors.toList());  // Collecter tous les caractères dans une liste
        System.out.println(flattenedList);


        // Transformer chaque mot en "Nom - Index"
        List<String> listIndex = IntStream.range(0, mots.size())  // Créer un stream d'index
                                      .mapToObj(i -> mots.get(i) + " - " + i)  // Créer la chaîne "Nom - Index"
                                      .collect(Collectors.toList());  // Collecter les résultats dans une liste

        System.out.println(listIndex);

        listIndex.forEach(System.out::println);
    }
}