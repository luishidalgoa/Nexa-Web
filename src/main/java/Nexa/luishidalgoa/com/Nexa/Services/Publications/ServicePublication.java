package Nexa.luishidalgoa.com.Nexa.Services.Publications;

import Nexa.luishidalgoa.com.Nexa.Model.Utils.Utils;
import Nexa.luishidalgoa.com.Nexa.Model.domain.publications.Publication;
import Nexa.luishidalgoa.com.Nexa.Repository.Publications.RepositoryPublication;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicePublication implements InterfaceServicePublication {
    RepositoryPublication repositoryPublication;
    public ServicePublication(RepositoryPublication repositoryPublication){
        this.repositoryPublication = repositoryPublication;
    }
    @Override
    public List<Publication> findAll() {
        return repositoryPublication.findAll();
    }
    @Override
    public void Save(Publication publication) {
        if(publication.getText().length()<=255){
            repositoryPublication.Save(publication.getText(), publication.getUser_name());
        }
    }

    @Override
    public void DeletePublication(int id){repositoryPublication.delete(id);}
}
