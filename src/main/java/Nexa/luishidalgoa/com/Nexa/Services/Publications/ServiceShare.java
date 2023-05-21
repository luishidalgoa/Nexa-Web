package Nexa.luishidalgoa.com.Nexa.Services.Publications;

import Nexa.luishidalgoa.com.Nexa.Model.domain.publications.*;
import Nexa.luishidalgoa.com.Nexa.Repository.Publications.RepositoryShare;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceShare implements InterfaceServiceShare {
    RepositoryShare repositoryShare;

    public ServiceShare(RepositoryShare repositoryShare) {
        this.repositoryShare = repositoryShare;
    }

    public List<Share> findById(int id){
        return repositoryShare.findById(id);
    }

    @Override
    public void save(Integer id, String username) {
        repositoryShare.save(id,username);
    }

    @Override
    public Share findShare(int id, String username) {
        return repositoryShare.findShare(id,username);
    }

    @Override
    public void delete(int id, String username) {
        repositoryShare.delete(id,username);
    }

    @Override
    public void delete(int id) {
        repositoryShare.delete(id);
    }
}
