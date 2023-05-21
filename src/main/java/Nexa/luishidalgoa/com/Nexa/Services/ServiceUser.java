package Nexa.luishidalgoa.com.Nexa.Services;

import Nexa.luishidalgoa.com.Nexa.Model.domain.User.User;
import Nexa.luishidalgoa.com.Nexa.Repository.RepositoryUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUser implements InterfaceServiceUser {
    RepositoryUser repositoryUser;
    public ServiceUser(RepositoryUser repositoryUser){
        this.repositoryUser = repositoryUser;
    }

    @Override
    public User searchUser(String username) {
        return repositoryUser.searchUser(username);
    }

    @Override
    public List<User> findAll() {
        return repositoryUser.findAll();
    }

    @Override
    public boolean save(String username, String pass, String bio) {
        repositoryUser.save(username,pass,bio);
        if(repositoryUser.searchUser(username)==null){
            return false;
        }
        return true;
    }

    @Override
    public User sing_in(String username, String pass) {
        User user= repositoryUser.searchUser(username);
        if(user!=null && user.getPass().equals(pass)){
            return user;
        }else{
            return null;
        }
    }

}
