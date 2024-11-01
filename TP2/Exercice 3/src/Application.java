import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		
		Ordinateur ordinateur1 = new Ordinateur("Dell S 114", "Dell", 1500, "Ordinateur portable puissant", 10, "Portables");
        Ordinateur ordinateur2 = new Ordinateur("MacBook Pro", "Apple", 2000, "Ordinateur portable haut de gamme", 5, "Portables");
        Ordinateur ordinateur3 = new Ordinateur("Acer EliteBook", "Acer", 1500, "Ordinateur portable abordable", 15, "Portables");

        //informations de l'ordinateur
        ordinateur1.afficherDetails();
        
        //calculer du prix
        int quantite = 3;
        double prixTotal = ordinateur1.calculerPrixTotal(quantite);
        System.out.println("Prix pour " + quantite + " unités : " + prixTotal + "MAD");


		//création d'une catégorie et ajout d'ordinateurs
        Categorie portables = new Categorie("Portables", "Ordinateurs portables");


		//ajouter des ordinateurs dans la catégorie
        portables.ajouterOrdinateur(ordinateur1);
        portables.ajouterOrdinateur(ordinateur2);
        portables.ajouterOrdinateur(ordinateur3);

		System.out.println();
		//affichage des ordinateurs de la catégorie
        portables.afficherOrdinateurs();

		System.out.println();
		//affichage de liste des ordinateurs par un prix donné
        portables.rechercherParPrix(1500);

        System.out.println();
        //déclarez et instanciez un client
        Client client = new Client("youness", "atif", "21 Rue 3", "YOUNESS.ATIF@GMAIL.COM", "casablanca", "0605153098");
        System.out.println("detail du client youness atif");
        client.afficherDetailsClient();

        
        System.out.println();
        //déclarez et instanciez une commande du client
        Commande commande = new Commande("CMD0001", client, LocalDate.now(), "En cours");
        client.ajouterCommande(commande);
        System.out.println("detail du Commande CMD0001");
        commande.afficherDetailsCommande();

        System.out.println();
        //déclarer et instanciee une liste de trois lignes de commandes pour la commande et les ordinateurs créés
        LigneCommande ligneCommande1 = new LigneCommande(2, commande, ordinateur1);
        LigneCommande ligneCommande2 = new LigneCommande(1, commande, ordinateur2);
        LigneCommande ligneCommande3 = new LigneCommande(3, commande, ordinateur3);
        List<LigneCommande> lignesCommande = new ArrayList<>();
        lignesCommande.add(ligneCommande1);
        lignesCommande.add(ligneCommande2);
        lignesCommande.add(ligneCommande3);

        //affichez touts les informations de la commande
        System.out.println("Détails de la commande : ");
        commande.afficherDetailsCommande();

        System.out.println("\nLignes de commande : ");
        for (LigneCommande ligne : lignesCommande) {
            ligne.afficherDetailsLigneCommande();
            System.out.println();
        }


	}



}