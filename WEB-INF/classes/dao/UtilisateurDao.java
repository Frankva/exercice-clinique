package dao;

import java.util.List;

import beans.Utilisateur;

public interface UtilisateurDao {
    void ajouter(Utilisateur utilisateur) throws DaoException;
    List<Utilisateur> lister() throws DaoException;
}
