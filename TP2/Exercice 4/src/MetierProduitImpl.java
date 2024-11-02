import java.util.List;
import java.util.ArrayList;

public class MetierProduitImpl implements IMetierProduit {

    private List<Produit> produits = new ArrayList<>();

    @Override
    public Produit add(Produit p) {
        produits.add(p);
        return p;
    }

    @Override
    public List<Produit> getAll() {

        return produits;
    }

    @Override
    public List<Produit> findByNom(String motCle) {
        // Filter products where the name contains the search keyword (case-insensitive)
        List<Produit> result = new ArrayList<>();
        for (Produit p:produits){
            if (p.getNom().toLowerCase().contains(motCle.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public Produit findById(long id) {
        // Find the first product with the matching id, or return null if not found
        for(Produit p : produits){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    @Override
    public void delete(long id) {
        produits.remove(findById(id));
    }


}