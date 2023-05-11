package Nexa.luishidalgoa.com.Nexa.Repository;

import Nexa.luishidalgoa.com.Nexa.Model.domain.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryUser extends JpaRepository<User,Long> {
    @Query(value = "select * from nexadatabase.user where user_name=?1",nativeQuery = true)
    public User searchUser(String username);
    @Query(value = "select * from nexadatabase.user",nativeQuery = true)
    public List<User> findAll();
    @Query(value="call nexadatabase.UserSave(?1,?2,?3)",nativeQuery = true)
    public void save(String username,String pass,String bio);
}
