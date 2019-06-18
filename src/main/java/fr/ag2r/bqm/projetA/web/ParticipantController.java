package fr.ag2r.bqm.projetA.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.ag2r.bqm.projetA.dao.ParticipantRepository;
import fr.ag2r.bqm.projetA.entites.Participant;

@Controller
public class ParticipantController {

    @Autowired
    private ParticipantRepository participantRepository;

    //Dans le controller on doit creer des methodes

    //TODO by Djer : ce code est dasn un controller "Participant" mais rien dans l'URL ne l'indique (on ne sait pas si un consul l'inden d'un Evennement, d'un aprticipants, d'un truc "plus général". Pensser à precciser "/user|admin\participant|evennement/xxxxxx.
    @RequestMapping("/user/index") //"/user/index"
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "motCle", defaultValue = "") String motCle) {
        // recupérer la liste des participants
        Page<Participant> pageParticipant = participantRepository.findByNomContainsIgnoreCase(motCle,
                PageRequest.of(page, 10));
        // On va stocker la liste dans le model
        model.addAttribute("listeParticipants", pageParticipant.getContent());
        model.addAttribute("pages", new int[pageParticipant.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("motCle", motCle);
        // on revient sur la vue pour les afficher
        return "participants";
    }

    /*@RequestMapping("/addParticipant")
    public String AddParticipant(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom,
            @RequestParam("entreprise") String entreprise, @RequestParam("mail") String mail,
            @RequestParam("tel") int tel, @RequestParam("fonction") String fonction,
            @RequestParam("presentation") String presentation) {
        Participant participants = new Participant(nom, prenom, entreprise, mail, tel, fonction, presentation);
        participantRepository.save(participants);
        return "participants";
    }*/

    @GetMapping("/admin/delete")
    public String delete(int id, int page, String motCle) {
        participantRepository.deleteById(id);
        return "redirect:/user/index?page =" + page + "&motCle=" + motCle;
    }

    @GetMapping("/admin/formParticipant")
    public String form(Model model) {
        model.addAttribute("participants", new Participant());
        return "formParticipant";
    }

    @GetMapping("/admin/edit")
    public String edit(Model model, int id) {
        Participant participants = participantRepository.findById(id).get();
        model.addAttribute("participants", participants);
        return "editParticipant";
    }

    @PostMapping("/admin/save")
    public String save(Model model, @Valid Participant participants, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "formParticipant";

        participantRepository.save(participants);
        return "redirect:/user/index";
    }

    @GetMapping("/")
    public String def() {

        return "redirect:/user/index";
    }

    @GetMapping("/403")
    public String notAutorized() {

        return "403";
    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }

}
