package Nexa.luishidalgoa.com.Nexa.Services.Publications;

import Nexa.luishidalgoa.com.Nexa.Model.domain.publications.likes;
import Nexa.luishidalgoa.com.Nexa.Repository.Publications.RepositoryLikes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceLikes implements InterfaceServiceLikes {
    RepositoryLikes repositoryLikes;

    public ServiceLikes(RepositoryLikes repositoryLikes) {
        this.repositoryLikes = repositoryLikes;
    }

    public List<likes> findById(int id){
        return repositoryLikes.findLike(id);
    }

    @Override
    public void save(Integer id, String username) {
        repositoryLikes.save(id,username);
    }

    @Override
    public likes findLike(int id, String username) {
        return repositoryLikes.findLike(id,username);
    }

    @Override
    public void delete(int id, String username) {
        repositoryLikes.delete(id,username);
    }

    @Override
    public void delete(int id) {
        repositoryLikes.delete(id);
    }
}
