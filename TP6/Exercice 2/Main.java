import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DossierContact dossier = new DossierContact();
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        System.out.println("Bienvenue dans votre annuaire téléphonique!");
        System.out.println("Les contacts sont stockés dans le dossier 'contacts'");

        while (continuer) {
            System.out.println("\nMenu des options :");
            System.out.println("1. Rechercher un numéro de téléphone");
            System.out.println("2. Ajouter un nouveau contact");
            System.out.println("3. Supprimer un contact");
            System.out.println("4. Changer le numéro de téléphone d'un contact");
            System.out.println("5. Quitter ce programme");
            System.out.print("Votre choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer le retour à la ligne

            switch (choix) {
                case 1:
                    System.out.print("Entrez le nom à rechercher : ");
                    String nomRecherche = scanner.nextLine();
                    String numero = dossier.rechercherContact(nomRecherche);
                    if (numero != null) {
                        System.out.println("Numéro de téléphone : " + numero);
                    } else {
                        System.out.println("Contact non trouvé.");
                    }
                    break;

                case 2:
                    System.out.print("Entrez le nom : ");
                    String nomAjout = scanner.nextLine();
                    System.out.print("Entrez le numéro : ");
                    String numeroAjout = scanner.nextLine();
                    dossier.ajouterContact(nomAjout, numeroAjout);
                    System.out.println("Contact ajouté avec succès.");
                    break;

                case 3:
                    System.out.print("Entrez le nom du contact à supprimer : ");
                    String nomSuppression = scanner.nextLine();
                    if (dossier.supprimerContact(nomSuppression)) {
                        System.out.println("Contact supprimé avec succès.");
                    } else {
                        System.out.println("Contact non trouvé.");
                    }
                    break;

                case 4:
                    System.out.print("Entrez le nom du contact : ");
                    String nomModif = scanner.nextLine();
                    System.out.print("Entrez le nouveau numéro : ");
                    String nouveauNumero = scanner.nextLine();
                    if (dossier.changerNumero(nomModif, nouveauNumero)) {
                        System.out.println("Numéro modifié avec succès.");
                    } else {
                        System.out.println("Contact non trouvé.");
                    }
                    break;

                case 5:
                    continuer = false;
                    if (dossier.estModifie()) {
                        System.out.println("Les modifications ont été sauvegardées dans les fichiers.");
                    }
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
        scanner.close();
    }
}