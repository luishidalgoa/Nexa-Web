package Nexa.luishidalgoa.com.Nexa.Repository.Publications;
import Nexa.luishidalgoa.com.Nexa.Model.domain.publications.Share;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface RepositoryShare extends JpaRepository<Share,Long> {
    @Query(value = "select d.* from nexadatabase.share d RIGHT JOIN nexadatabase.publication p on d.id_publication=p.id where d.id_publication=?1", nativeQuery = true)
    public List<Share> findById(int id);
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO nexadatabase.share(id_publication, user_name,date_shared) VALUES (?1,?2,CURRENT_TIMESTAMP)",nativeQuery = true)
    public void save(Integer id, String username);

    @Query(value = "select d.* from nexadatabase.share d JOIN nexadatabase.publication p on d.id_publication=p.id where d.id_publication=?1 and d.user_name=?2 order by date_shared", nativeQuery = true)
    public Share findShare(int id, String username);
    @Transactional
    @Modifying
    @Query(value = "DELETE from nexadatabase.share where id_publication=?1 and user_name=?2",nativeQuery = true)
    public void delete(int id, String username);
    @Transactional
    @Modifying
    @Query(value = "DELETE from nexadatabase.share where id_publication=?1",nativeQuery = true)
    public void delete(int id);
}
