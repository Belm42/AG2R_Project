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
import fr.ag2r.bqm.projetA.entites.Evenement;
import fr.ag2r.bqm.projetA.entites.Participant;

@Controller
public class ParticipantController {

    @Autowired
    private ParticipantRepository participantRepository;

    private Evenement evenementEntity;

    //Dans le controller on doit creer des methodes

    @RequestMapping("/user/participant/index") //"/user/index"
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "motCle", defaultValue = "") String motCle) {
        // recupérer la liste des participants
        Page<Participant> pageParticipant = participantRepository.findByNomContainsIgnoreCase(motCle,
                PageRequest.of(page, 10));
        // On va stocker la liste dans le model
        model.addAttribute("listeParticipants", pageParticipant.getContent());
        model.addAttribute("pages", new Integer[pageParticipant.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("motCle", motCle);
        // on revient sur la vue pour les afficher
        return "participants";
    }

    @GetMapping("/admin/participant/delete")
    public String delete(Integer id, Integer page, String motCle) {
        participantRepository.deleteById(id);
        return "redirect:/user/participant/index?page =" + page + "&motCle=" + motCle;
    }

    @GetMapping("/admin/participant/create")
    public String form(Model model) {
        model.addAttribute("participants", new Participant());
        return "createParticipant";
    }

    @GetMapping("/admin/participant/edit")
    public String edit(Model model, Integer id) {
        //TODO by Djer : peut renvoyer "null", il faudrait vérifier avant d'ajouter : Javadoc : "Returns:the entity with the given id or Optional#empty() if none found"
        Participant participantEdit = participantRepository.findById(id).get();
        model.addAttribute("participantEdit", participantEdit);
        return "editParticipant";
    }

    @PostMapping("/admin/participant/save")
    public String save(Model model, @Valid Participant participants, BindingResult bindingResult) {
        String templateName = new String();
        //TODO by Djer : Evite les multiples return. Avec une variable "templateName" que tu valorise dans le if ca marchera aussi
        if (bindingResult.hasErrors()) {
            return "createParticipant";
        }
        participantRepository.save(participants);
        return "redirect:/user/participant/index";
    }

}
