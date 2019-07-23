
package fr.ag2r.bqm.projetA.web;

import java.util.List;

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

import fr.ag2r.bqm.projetA.dao.EvenementRepository;
import fr.ag2r.bqm.projetA.dao.ParticipantRepository;
import fr.ag2r.bqm.projetA.entites.Evenement;
import fr.ag2r.bqm.projetA.entites.Participant;

@Controller
public class EvenementController {
    @Autowired
    private EvenementRepository eventRepository;
    @Autowired
    private ParticipantRepository participantRepository;

    @RequestMapping("user/event/index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "motCle", defaultValue = "") String motCle) {
        Page<Evenement> pageEvenement = eventRepository.findByNomEvenementContainsIgnoreCase(motCle,
                PageRequest.of(page, 10));
        model.addAttribute("listeEvenements", pageEvenement.getContent());
        model.addAttribute("pages", new Integer[pageEvenement.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("motCle", motCle);

        //TODO by Djer : il est possible de crée des "sous-dossier" dnas le dossier template (par exemple un sous dossier "event", et de le référencer ici "event/searchResult" par exemple)
        return "evenement";

    }

    @GetMapping("/admin/event/delete")
    public String delete(Integer id, Integer page, String motCle) {
        eventRepository.deleteById(id);
        return "redirect:/user/event/index?page =" + page + "&motCle=" + motCle;
    }

    @GetMapping("/admin/event/create")
    public String create(Model model) {
        model.addAttribute("evenement", new Evenement());
        //Un sous dossier dans "template" serais plsu claire.
        return "createEvenement";
    }

    @GetMapping("/admin/event/edit")
    public String edit(Model model, Integer id) {
        Evenement evenementEdit = eventRepository.findById(id).get();
        model.addAttribute("evenementEdit", evenementEdit);
        //Un sous dossier dans "template" serais plsu claire.
        return "editEvenement";
    }

    @GetMapping("/admin/event/manage")
    public String manage(Model model, Integer id) {
        List<Participant> participantManage = participantRepository.findByEvenement(null);
        Evenement evenementManage = eventRepository.findById(id).get();
        model.addAttribute("participantManage", participantManage);
        model.addAttribute("evenementManage", evenementManage);
        //Un sous dossier dans "template" serais plsu claire.
        return "manageEvenement";
    }

    @RequestMapping("/admin/event/addPart")
    public String addPart(Model model, Integer idevenement, Integer idparticipant) {
        Evenement evenementaddpart = eventRepository.findById(idevenement).get();
        Participant participantadd = participantRepository.findById(idparticipant).get();
        evenementaddpart.addParticipant(participantadd);
        participantRepository.save(participantadd);
        eventRepository.save(evenementaddpart);
        //Un sous dossier dans "template" serais plsu claire.

        return "redirect:/user/event/index";

    }

    @RequestMapping("/admin/event/removePart")
    public String manage(Model model, Integer idevenement, Integer idparticipant) {
        Evenement evenementaddpart = eventRepository.findById(idevenement).get();
        Participant participantadd = participantRepository.findById(idparticipant).get();
        evenementaddpart.removePaticipant(participantadd);
        participantRepository.save(participantadd);
        eventRepository.save(evenementaddpart);
        //Un sous dossier dans "template" serais plsu claire.

        return "redirect:/user/event/index";

    }

    @PostMapping("/admin/event/save")
    public String save(Model model, @Valid Evenement evenement, BindingResult bindingResult) {
        //TODO by Djer : Evite les multiples return. Avec une variable "templateName" que tu valorise dans le if ca marchera aussi
        if (bindingResult.hasErrors()) {
            return "createEvenement";
        }
        eventRepository.save(evenement);
        return "redirect:/user/event/index";
    }

}