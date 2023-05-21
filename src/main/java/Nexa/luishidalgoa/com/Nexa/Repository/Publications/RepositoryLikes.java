package Nexa.luishidalgoa.com.Nexa.Repository.Publications;
import Nexa.luishidalgoa.com.Nexa.Model.domain.publications.likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RepositoryLikes extends JpaRepository<likes,Long> {
    @Query(value = "select l.* from nexadatabase.likes l JOIN nexadatabase.publication p on l.id_publication=p.id where l.id_publication=?1", nativeQuery = true)
    public List<likes> findLike(int id_publication);
    @Query(value = "select l.* from nexadatabase.likes l JOIN nexadatabase.publication p on l.id_publication=p.id where l.id_publication=?1 and l.user_name=?2", nativeQuery = true)
    public likes findLike(int id, String username);
    /**
     * Esta consulta agregara un like a la publicacion deseada. Insertando de este modo el usuario
     * que le dio a like y la publicacion a la que se lo dio
     * @param id
     * @param username
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO nexadatabase.likes(id_publication, user_name,date_shared) VALUES (?1,?2,CURRENT_TIMESTAMP)",nativeQuery = true)
    public void save(Integer id, String username);
    @Transactional
    @Modifying
    @Query(value = "Delete from nexadatabase.likes where id_publication=?1 and user_name=?2",nativeQuery = true)
    public void delete(int id, String username);
    @Transactional
    @Modifying
    @Query(value = "DELETE from nexadatabase.likes where id_publication=?1",nativeQuery = true)
    public void delete(int id);
}
