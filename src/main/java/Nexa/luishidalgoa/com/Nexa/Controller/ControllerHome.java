package Nexa.luishidalgoa.com.Nexa.Controller;

import Nexa.luishidalgoa.com.Nexa.Model.DTO.*;
import Nexa.luishidalgoa.com.Nexa.Model.domain.publications.Publication;
import Nexa.luishidalgoa.com.Nexa.Model.domain.User.User;
import Nexa.luishidalgoa.com.Nexa.Services.*;
import Nexa.luishidalgoa.com.Nexa.Services.Publications.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class ControllerHome {
    @Autowired // AUTOWIRED PASA EL PARAMETRO AUTOMATICA AL CONSTRUCTOR
    private final InterfaceServicePublication servicesPublications;
    @Autowired // AUTOWIRED PASA EL PARAMETRO AUTOMATICA AL CONSTRUCTOR
    private InterfaceServiceUser servicesUser;
    @Autowired // AUTOWIRED PASA EL PARAMETRO AUTOMATICA AL CONSTRUCTOR
    private InterfaceServiceLikes servicesLike;
    @Autowired // AUTOWIRED PASA EL PARAMETRO AUTOMATICA AL CONSTRUCTOR
    private InterfaceServiceShare servicesDifussion;

    private static User user;

    public ControllerHome(ServicePublication servicesPublications, ServiceUser serviceUser, ServiceLikes serviceLikes, ServiceShare serviceDifussion){
        this.servicesPublications=servicesPublications;
        this.servicesUser=serviceUser;
        this.servicesLike=serviceLikes;
        this.servicesDifussion=serviceDifussion;
    }
    @GetMapping("/home")
    public Object getPublications(Model model){
        model.addAttribute("user",user);
        model.addAttribute("publication",new Publication());
        model.addAttribute("newPublication",new Publication());
        model.addAttribute("publications",publicationsList());
        model.addAttribute("users",recommendUsers());
        return "WebApp/En/Home";
    }

    @GetMapping("/perfil/{username}") //El usurname debe existir en la base de datos
    public Object getUser(Model model, @PathVariable(name="username") String username){

        model.addAttribute("user",servicesUser.searchUser(username));
        return "/WebApp/En/Perfil";
    }

    public Set<User> recommendUsers(){
        Set<User>users = new HashSet<>();
        List<User>findAll=servicesUser.findAll();
        for(int i=0;users.size()<4 && users.size()!=findAll.size();i++){
            users.add(findAll.get(i));
        }
        return users;
    }

    /**
     * Este metodo devolvera las ultimas publicaciones
     * @return
     */
    public List<publicationDTO> publicationsList(){
        List<publicationDTO> publicationDTOS = new ArrayList<>();
        for (Publication p: servicesPublications.findAll()){
            publicationDTOS.add(new publicationDTO(servicesUser.searchUser(p.getUser_name()),p,servicesLike.findById(p.getId()),
                    servicesDifussion.findById(p.getId())));
        }
        return publicationDTOS;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        ControllerHome.user = user;
    }

}
