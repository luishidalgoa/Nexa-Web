package Nexa.luishidalgoa.com.Nexa.Repository.Publications;

import Nexa.luishidalgoa.com.Nexa.Model.domain.publications.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public interface RepositoryPublication extends JpaRepository<Publication,Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO nexadatabase.publication(publication_date, text, user_name) VALUES(CURRENT_TIMESTAMP,?1,?2)",nativeQuery = true)
    public void Save(String text, String user_name);
    @Query(value = "select * from nexadatabase.publication order by publication_date desc ",nativeQuery = true)
    public List<Publication> findAll();
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM nexadatabase.publication where id=?1",nativeQuery = true)
    public void delete(int id);
}
