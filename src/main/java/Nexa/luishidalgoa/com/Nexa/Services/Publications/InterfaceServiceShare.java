package Nexa.luishidalgoa.com.Nexa.Services.Publications;

import Nexa.luishidalgoa.com.Nexa.Model.domain.publications.Share;

import java.util.List;

public interface InterfaceServiceShare {
    public List<Share> findById(int id);
    public void save(Integer id, String username);
    public Share findShare(int id, String username);

    /**
     * Elimina el "share" del usuario x en la publicacion x
     * @param id
     * @param username
     */
    public void delete(int id, String username);

    /**
     * Elimina todos los "share" de una publicacion en concreto
     * @param id
     */
    public void delete(int id);
}
