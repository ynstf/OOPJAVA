public class Application {

	public static void main(String[] args) {

		Adherent adherent = new Adherent("youness","atif","younessatif@gmail.com","0605153098",24,1212);
		
		//affichage des informations de l adherent
        System.out.println("Informations de l'Adhérent:");
        adherent.afficher();

	}

}