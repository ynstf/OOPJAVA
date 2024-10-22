import java.util.Scanner;
public class MyClass {
	public static void main(String[] args) {
		Str content = new Str();
		Scanner scanner = new Scanner(System.in);
		int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Saisir une chaîne de caractères");
            System.out.println("2. Afficher la chaîne saisie");
            System.out.println("3. Inverser la chaîne saisie");
            System.out.println("4. Compter le nombre de mots");
            System.out.println("5. Quitter");
            System.out.print("Choisissez une option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    content.input();
                    break;
                case 2:
                    content.show();
                    break;
                case 3:
                    content.reverse();
                    break;
                case 4:
                    content.countWords();
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
            if (choice != 5) {
                System.out.print("Frappez une touche pour revenir au menu...");
                scanner.nextLine();
            }
        } while (choice != 5);

	}

}