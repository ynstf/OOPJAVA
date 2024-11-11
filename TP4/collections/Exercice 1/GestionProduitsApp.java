import java.util.*;

class GestionProduitsApp{
    public static void main(String[] args){
        Produit p1 = new Produit(1,"pc",20000.5);
        Produit p2 = new Produit(2,"phone",24400.5);
        Produit p3 = new Produit(3,"car",2077800.5);

        List<Produit> listeProduits=new ArrayList<>();


        System.out.println("add products to list : ");
        listeProduits.add(p1);
        listeProduits.add(p2);
        listeProduits.add(p3);
        listeProduits.forEach((p) -> System.out.println(p.getNom()));

        System.out.println("remove the seconde element : ");
        listeProduits.remove(1);
        listeProduits.forEach((p) -> System.out.println(p.getNom()));

        System.out.println("update value of the first element : ");
        listeProduits.set(0,p2);
        listeProduits.forEach((p) -> System.out.println(p.getNom()));

        Scanner scan = new Scanner(System.in);
        System.out.print("enter name to search : ");
        String name = scan.nextLine();

        System.out.println("");
        System.out.println("the values found contain "+ name + " : ");
        for (Produit p:listeProduits) {
            if (p.getNom().equalsIgnoreCase(name)){
                System.out.println("Id : "+ p.getId());
                System.out.println("Name : "+ p.getNom());
                System.out.println("Prix : "+ p.getPrix());
                System.out.println();
                }
            }
        



    }

}