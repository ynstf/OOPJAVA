package dao;

import entities.Client;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierClientImpl implements IMetier<Client> {
    private List<Client> clients;
    private static final String FILENAME = "./data/clients.dat";

    public MetierClientImpl() {
        this.clients = new ArrayList<>();
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }
        List<Client> loadedClients = getAll();
        if (loadedClients != null) {
            this.clients = loadedClients;
        }
    }

    @Override
    public Client add(Client client) {
        clients.add(client);
        saveAll();
        return client;
    }

    @Override
    public List<Client> getAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            return (List<Client>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erreur lors de la lecture du fichier: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public Client findByNom(String nom) {
        return clients.stream()
                .filter(c -> c.getNom().equalsIgnoreCase(nom))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(String nom) {
        clients.removeIf(c -> c.getNom().equalsIgnoreCase(nom));
        saveAll();
    }

    @Override
    public void saveAll() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(clients);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde: " + e.getMessage());
        }
    }
}
