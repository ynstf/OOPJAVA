import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IMetierProduit metier = new MetierProduitImpl();

        // Adding initial products to the list
        metier.add(new Produit(1, "Ordinateur Portable", "Dell", 799.99, "Ordinateur portable avec processeur Intel i5, 8GB RAM, 256GB SSD", 20));
        metier.add(new Produit(2, "Smartphone", "Samsung", 599.99, "Smartphone Galaxy S21 avec 128GB de stockage", 50));
        metier.add(new Produit(3, "Casque Bluetooth", "Sony", 199.99, "Casque sans fil avec réduction de bruit", 30));
        metier.add(new Produit(4, "Téléviseur", "LG", 1199.99, "Téléviseur 4K UHD 55 pouces avec Smart TV", 15));
        metier.add(new Produit(5, "Imprimante", "HP", 99.99, "Imprimante jet d'encre tout-en-un", 25));

        boolean running = true;

        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher des produits par mot clé");
            System.out.println("3. Ajouter un nouveau produit");
            System.out.println("4. Récupérer et afficher un produit par ID");
            System.out.println("5. Supprimer un produit par ID");
            System.out.println("6. Quitter le programme");
            System.out.print("Choisissez une option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.println("\nListe des produits:");
                    for (Produit p : metier.getAll()) {
                        p.afficherInfos();
                    }
                    break;

                case 2:
                    System.out.print("\nEntrez le mot clé pour la recherche: ");
                    String keyword = scanner.nextLine();
                    List<Produit> foundProducts = metier.findByNom(keyword);
                    if (foundProducts.isEmpty()) {
                        System.out.println("Aucun produit trouvé pour le mot clé: " + keyword);
                    } else {
                        System.out.println("Produits trouvés:");
                        for (Produit p : foundProducts) {
                            p.afficherInfos();
                        }
                    }
                    break;

                case 3:
                    System.out.print("\nEntrez l'ID du produit: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline

                    System.out.print("Entrez le nom du produit: ");
                    String nom = scanner.nextLine();

                    System.out.print("Entrez la marque du produit: ");
                    String marque = scanner.nextLine();

                    System.out.print("Entrez le prix du produit: ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline

                    System.out.print("Entrez la description du produit: ");
                    String description = scanner.nextLine();

                    System.out.print("Entrez le nombre en stock: ");
                    int nombreStock = scanner.nextInt();

                    Produit newProduit = new Produit(id, nom, marque, prix, description, nombreStock);
                    metier.add(newProduit);
                    System.out.println("Produit ajouté avec succès.");
                    break;

                case 4:
                    System.out.print("\nEntrez l'ID du produit à récupérer: ");
                    int idToFind = scanner.nextInt();
                    Produit produit = metier.findById(idToFind);
                    if (produit != null) {
                        produit.afficherInfos();
                    } else {
                        System.out.println("Produit non trouvé avec ID: " + idToFind);
                    }
                    break;

                case 5:
                    System.out.print("\nEntrez l'ID du produit à supprimer: ");
                    int idToDelete = scanner.nextInt();
                    metier.delete(idToDelete);
                    System.out.println("Produit supprimé avec succès.");
                    break;

                case 6:
                    System.out.println("Quitter le programme...");
                    running = false;
                    break;

                default:
                    System.out.println("Option invalide, veuillez réessayer.");
                    break;
            }
        }
        scanner.close();
    }
}
