package application;

import dao.MetierProduitImpl;
import entities.Produit;
import java.util.List;
import java.util.Scanner;

public class ApplicationProduit {
    private static final Scanner scanner = new Scanner(System.in);
    private static final MetierProduitImpl metierProduit = new MetierProduitImpl();

    public static void main(String[] args) {
        boolean continuer = true;
        while (continuer) {
            afficherMenu();
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choix) {
                case 1:
                    afficherProduits();
                    break;
                case 2:
                    rechercherProduit();
                    break;
                case 3:
                    ajouterProduit();
                    break;
                case 4:
                    supprimerProduit();
                    break;
                case 5:
                    sauvegarderProduits();
                    break;
                case 6:
                    continuer = false;
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Choix invalide!");
            }
        }
    }

    private static void afficherMenu() {
        System.out.println("\n=== Gestion des Produits ===");
        System.out.println("1. Afficher la liste des produits");
        System.out.println("2. Rechercher un produit par nom");
        System.out.println("3. Ajouter un nouveau produit");
        System.out.println("4. Supprimer un produit par nom");
        System.out.println("5. Sauvegarder les produits");
        System.out.println("6. Quitter");
        System.out.print("Votre choix: ");
    }

    private static void afficherProduits() {
        List<Produit> produits = metierProduit.getAll();
        if (produits.isEmpty()) {
            System.out.println("Aucun produit trouvé.");
            return;
        }
        System.out.println("\nListe des produits:");
        produits.forEach(System.out::println);
    }

    private static void rechercherProduit() {
        System.out.print("Entrez le nom du produit à rechercher: ");
        String nom = scanner.nextLine();
        Produit produit = metierProduit.findByNom(nom);
        if (produit != null) {
            System.out.println("Produit trouvé: " + produit);
        } else {
            System.out.println("Aucun produit trouvé avec ce nom.");
        }
    }

    private static void ajouterProduit() {
        System.out.println("\nAjout d'un nouveau produit");
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Marque: ");
        String marque = scanner.nextLine();
        System.out.print("Prix: ");
        double prix = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Nombre en stock: ");
        int stock = scanner.nextInt();

        Produit nouveauProduit = new Produit(nom, marque, prix, description, stock);
        metierProduit.add(nouveauProduit);
        System.out.println("Produit ajouté avec succès!");
    }

    private static void supprimerProduit() {
        System.out.print("Entrez le nom du produit à supprimer: ");
        String nom = scanner.nextLine();
        metierProduit.delete(nom);
        System.out.println("Produit(s) supprimé(s) avec succès!");
    }

    private static void sauvegarderProduits() {
        metierProduit.saveAll();
        System.out.println("Produits sauvegardés avec succès!");
    }
}
