import java.io.*;

public class DossierContact {
    private File dossier;
    private boolean modifie;

    public DossierContact() {
        dossier = new File("contacts");
        if (!dossier.exists()) {
            dossier.mkdir();
        }
        modifie = false;
    }

    public void ajouterContact(String nom, String numero) {
        try {
            File fichier = new File(dossier, nom + ".txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(fichier));
            writer.write(numero);
            writer.close();
            modifie = true;
        } catch (IOException e) {
            System.out.println("Erreur lors de l'ajout du contact : " + e.getMessage());
        }
    }

    public boolean supprimerContact(String nom) {
        File fichier = new File(dossier, nom + ".txt");
        if (fichier.exists()) {
            boolean succes = fichier.delete();
            if (succes) {
                modifie = true;
            }
            return succes;
        }
        return false;
    }

    public String rechercherContact(String nom) {
        try {
            File fichier = new File(dossier, nom + ".txt");
            if (fichier.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(fichier));
                String numero = reader.readLine();
                reader.close();
                return numero;
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du contact : " + e.getMessage());
        }
        return null;
    }

    public boolean changerNumero(String nom, String nouveauNumero) {
        File fichier = new File(dossier, nom + ".txt");
        if (fichier.exists()) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fichier));
                writer.write(nouveauNumero);
                writer.close();
                modifie = true;
                return true;
            } catch (IOException e) {
                System.out.println("Erreur lors de la modification du numéro : " + e.getMessage());
            }
        }
        return false;
    }

    public boolean estModifie() {
        return modifie;
    }
}
