package dao;

import java.util.List;

public interface IMetier<T> {
    /**
     * Ajoute un objet à la liste
     * @param o l'objet à ajouter
     * @return l'objet ajouté
     */
    T add(T o);

    /**
     * Charge la liste des objets à partir d'un fichier
     * @return la liste des objets
     */
    List<T> getAll();

    /**
     * Trouve un objet par son nom
     * @param nom le nom à rechercher
     * @return l'objet trouvé ou null si non trouvé
     */
    T findByNom(String nom);

    /**
     * Supprime un objet par son nom
     * @param nom le nom de l'objet à supprimer
     */
    void delete(String nom);

    /**
     * Sauvegarde tous les objets dans le fichier
     */
    void saveAll();
}
