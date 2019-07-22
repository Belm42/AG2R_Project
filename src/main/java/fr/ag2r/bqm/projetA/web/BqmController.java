package fr.ag2r.bqm.projetA.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.ag2r.bqm.projetA.service.BqmService;

@Controller
public class BqmController {

    @Autowired
    BqmService bqmService;

    //TODO by Djer ajouté en paramètre de requete l'ID de l'évènnement pour lequel tu souhaites dérouler l'algo de rotation ? 
    @RequestMapping("/user/algo/index")
    public String rotation(final Model model) {
        List<ListeChifre> bob;
        bob = bqmService.bqmRotation();
        model.addAttribute("youpi", bob);
        return "algo";
    }
}