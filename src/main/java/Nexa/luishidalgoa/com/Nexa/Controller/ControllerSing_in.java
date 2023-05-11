package Nexa.luishidalgoa.com.Nexa.Controller;

import Nexa.luishidalgoa.com.Nexa.Model.Utils.Login;
import Nexa.luishidalgoa.com.Nexa.Model.domain.User.User;
import Nexa.luishidalgoa.com.Nexa.Services.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ControllerSing_in {
    @Autowired
    private final ServiceUser serviceUser;
    public ControllerSing_in(ServiceUser serviceUser){
        this.serviceUser=serviceUser;
    }
    @PostMapping("/Sign_in")
    public RedirectView sing_in(@ModelAttribute("User")User user){
        User aux= Login.Sing_in(user.getUser_name(),user.getPass(),serviceUser);
        if(aux!=null){
            ControllerHome.setUser(aux);
            new RedirectView("/Home");
        }
        return new RedirectView("/Sing_in");
    }

    @GetMapping("/index")
    public RedirectView indexRedirect(Model model){
        return new RedirectView("/Sign_in");
    }
    @GetMapping("/")
    public RedirectView defaultRedirect(Model model){
        return new RedirectView("/Sign_in");
    }
}
