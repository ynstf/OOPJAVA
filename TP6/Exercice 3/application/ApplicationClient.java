package application;

import dao.MetierClientImpl;
import entities.Client;
import java.util.List;
import java.util.Scanner;

public class ApplicationClient {
    private static final Scanner scanner = new Scanner(System.in);
    private static final MetierClientImpl metierClient = new MetierClientImpl();

    public static void main(String[] args) {
        boolean continuer = true;
        while (continuer) {
            afficherMenu();
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choix) {
                case 1:
                    afficherClients();
                    break;
                case 2:
                    rechercherClient();
                    break;
                case 3:
                    ajouterClient();
                    break;
                case 4:
                    supprimerClient();
                    break;
                case 5:
                    sauvegarderClients();
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
        System.out.println("\n=== Gestion des Clients ===");
        System.out.println("1. Afficher la liste des clients");
        System.out.println("2. Rechercher un client par nom");
        System.out.println("3. Ajouter un nouveau client");
        System.out.println("4. Supprimer un client par nom");
        System.out.println("5. Sauvegarder les clients");
        System.out.println("6. Quitter");
        System.out.print("Votre choix: ");
    }

    private static void afficherClients() {
        List<Client> clients = metierClient.getAll();
        if (clients.isEmpty()) {
            System.out.println("Aucun client trouvé.");
            return;
        }
        System.out.println("\nListe des clients:");
        clients.forEach(System.out::println);
    }

    private static void rechercherClient() {
        System.out.print("Entrez le nom du client à rechercher: ");
        String nom = scanner.nextLine();
        Client client = metierClient.findByNom(nom);
        if (client != null) {
            System.out.println("Client trouvé: " + client);
        } else {
            System.out.println("Aucun client trouvé avec ce nom.");
        }
    }

    private static void ajouterClient() {
        System.out.println("\nAjout d'un nouveau client");
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Prénom: ");
        String prenom = scanner.nextLine();
        System.out.print("Adresse: ");
        String adresse = scanner.nextLine();
        System.out.print("Téléphone: ");
        String tel = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Client nouveauClient = new Client(nom, prenom, adresse, tel, email);
        metierClient.add(nouveauClient);
        System.out.println("Client ajouté avec succès!");
    }

    private static void supprimerClient() {
        System.out.print("Entrez le nom du client à supprimer: ");
        String nom = scanner.nextLine();
        metierClient.delete(nom);
        System.out.println("Client(s) supprimé(s) avec succès!");
    }

    private static void sauvegarderClients() {
        metierClient.saveAll();
        System.out.println("Clients sauvegardés avec succès!");
    }
}
