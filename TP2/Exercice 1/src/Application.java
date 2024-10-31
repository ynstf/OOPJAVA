public class Application {

	public static void main(String[] args) {

		//affichage des informations de l adherent
		Adherent adherent = new Adherent("youness","atif","younessatif@gmail.com","0605153098",24,1212);
		System.out.println("Informations de l'Adherent:");
        adherent.afficher();

		System.out.println();


		//création de l auteur
        Auteur auteur = new Auteur("Martin", "Paul", "paul.martin@example.com", "0698765432", 45, 2001);

		//création et l affichage d'un livre écrit par l'auteur
        Livre livre = new Livre(123456, "clean code", auteur);
		System.out.println("Informations de livre:");
        livre.afficher();

	}

}