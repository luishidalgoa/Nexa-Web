package Nexa.luishidalgoa.com.Nexa.Controller;

import Nexa.luishidalgoa.com.Nexa.Model.domain.publications.Publication;
import Nexa.luishidalgoa.com.Nexa.Services.Publications.ServiceLikes;
import Nexa.luishidalgoa.com.Nexa.Services.Publications.ServicePublication;
import Nexa.luishidalgoa.com.Nexa.Services.Publications.ServiceShare;
import Nexa.luishidalgoa.com.Nexa.Services.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
@Controller
public class ControllerPublication {
    @Autowired
    private final ServicePublication servicesPublications;
    @Autowired
    private final ServiceLikes serviceLikes;
    @Autowired
    private final ServiceShare serviceShare;
    @Autowired
    private final ServiceUser serviceUser;
    public ControllerPublication(ServicePublication servicesPublications, ServiceLikes serviceLikes, ServiceShare serviceShare, ServiceUser serviceUser){
        this.servicesPublications=servicesPublications;
        this.serviceLikes=serviceLikes;
        this.serviceShare=serviceShare;
        this.serviceUser=serviceUser;
    }
    @PostMapping("/newPublication")
    public RedirectView savePublication(@ModelAttribute("newPublication") Publication publication){
        publication.setUser_name(ControllerHome.getUser().getUser_name());
        if(findUser(publication.getUser_name())){
            servicesPublications.Save(publication);
        }
        return new RedirectView("/home");
    }
    @GetMapping("/deletePublication/{id}")
    public RedirectView deletePublication(@PathVariable("id")Integer id){
        servicesPublications.DeletePublication(id);
        return new RedirectView("/home");
    }
    @GetMapping("/liked/{id}")
    public RedirectView liked(@PathVariable("id")Integer id){
        if(serviceLikes.findLike(id,ControllerHome.getUser().getUser_name())==null){
            serviceLikes.save(id,ControllerHome.getUser().getUser_name());
        }else{
            serviceLikes.delete(id, ControllerHome.getUser().getUser_name());
        }
        return  new RedirectView("/home");
    }
    @GetMapping("/share/{id}")
    public RedirectView shared(@PathVariable("id")Integer id){
        if(serviceShare.findShare(id,ControllerHome.getUser().getUser_name())==null){
            serviceShare.save(id,ControllerHome.getUser().getUser_name());
        }else{
            serviceShare.delete(id, ControllerHome.getUser().getUser_name());
        }
        return  new RedirectView("/home");
    }

    /**
     * Comprueba si el usuario que realiza la publicacion existe
     * @param username
     * @return
     */
    public boolean findUser(String username){
        if(serviceUser.searchUser(username)!=null){
            return true;
        }
        return false;
    }
}
