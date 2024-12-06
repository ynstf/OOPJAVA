package dao;

import entities.Produit;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit> {
    private List<Produit> produits;
    private static final String FILENAME = "./data/produits.dat";

    public MetierProduitImpl() {
        this.produits = new ArrayList<>();
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }
        List<Produit> loadedProduits = getAll();
        if (loadedProduits != null) {
            this.produits = loadedProduits;
        }
    }

    @Override
    public Produit add(Produit produit) {
        produits.add(produit);
        saveAll();
        return produit;
    }

    @Override
    public List<Produit> getAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            return (List<Produit>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erreur lors de la lecture du fichier: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public Produit findByNom(String nom) {
        return produits.stream()
                .filter(p -> p.getNom().equalsIgnoreCase(nom))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(String nom) {
        produits.removeIf(p -> p.getNom().equalsIgnoreCase(nom));
        saveAll();
    }

    @Override
    public void saveAll() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(produits);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde: " + e.getMessage());
        }
    }
}
