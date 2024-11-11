import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Créer une liste d'employés
        List<Employe> employes = new ArrayList<>();

        // Ajouter des employés à la liste
        employes.add(new Employe("Alice", "Informatique", 55000));
        employes.add(new Employe("Bob", "Marketing", 45000));
        employes.add(new Employe("Charlie", "Ressources Humaines", 50000));
        employes.add(new Employe("David", "Informatique", 60000));

        // Calculer la somme totale des salaires
        double sommeSalaires = employes.stream()
                                      .mapToDouble(Employe::getSalaire)  // Convertir chaque employé en son salaire
                                      .sum();  // Calculer la somme des salaires

        // Afficher la somme des salaires
        System.out.println("Somme totale des salaires : " + sommeSalaires);
        
        System.out.println();

        // Trier les employés par ordre alphabétique du nom
        List<Employe> employesTries = employes.stream()
                                             .sorted((e1, e2) -> e1.getNom().compareTo(e2.getNom()))  // Comparer les noms
                                             .collect(Collectors.toList());  // Collecter les résultats dans une liste

        // Afficher la liste triée des employés
        System.out.println("la liste triée des employés : ");
        System.out.println(employesTries);

        System.out.println();

        Optional<Employe> employeAvecSalaireLePlusBas = employes.stream()
                .min((e1, e2) -> Double.compare(e1.getSalaire(), e2.getSalaire())); // Comparer les salaires
        // Afficher l'employé avec le salaire le plus bas
        System.out.println("l'employé avec le salaire le plus bas : " + employeAvecSalaireLePlusBas);

        System.out.println();

        double seuil = 50000;
        List<Employe> employeSeuil = employes.stream()
                                        .filter(s -> s.getSalaire()>seuil)
                                        .collect(Collectors.toList()); 
        System.out.println("l'employé avec le salaire superieur au seuil : " + employeSeuil);
        
        System.out.println();

        // Utiliser reduce pour trouver l'employé avec le salaire le plus élevé
        Optional<Employe> employeAvecSalaireLePlusEleve = employes.stream()
                .reduce((e1, e2) -> e1.getSalaire() > e2.getSalaire() ? e1 : e2); //.max((e1, e2) -> Double.compare(e1.getSalaire(), e2.getSalaire()));  Comparer les salaires
        // Afficher l'employé avec le salaire le plus élevé
        System.out.println("l'employé avec le salaire le plus élevé : " + employeAvecSalaireLePlusEleve);

        System.out.println();

        String employesConcat = employes.stream()
                .map(Employe::getNom)
                .reduce((nom1, nom2) -> nom1 + " " + nom2)
                .orElse("Aucun employé");
        // Afficher l'employé avec le salaire le plus élevé
        System.out.println("les employés concatiner : " + employesConcat);



    }
}