package Nexa.luishidalgoa.com.Nexa.Services.Publications;

import Nexa.luishidalgoa.com.Nexa.Model.domain.publications.likes;

import java.util.List;

public interface InterfaceServiceLikes {
    public List<likes> findById(int id);
    public void save(Integer id, String username);
    public likes findLike(int id, String username);
    public void delete(int id, String username);
    public void delete(int id);
}
