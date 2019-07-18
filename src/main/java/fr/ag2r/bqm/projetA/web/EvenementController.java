
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

import fr.ag2r.bqm.projetA.dao.EvenementRepository;
import fr.ag2r.bqm.projetA.entites.Evenement;

@Controller
public class EvenementController {
    @Autowired
    private EvenementRepository eventRepository;

    @RequestMapping("user/event/index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "motCle", defaultValue = "") String motCle) {
        Page<Evenement> pageEvenement = eventRepository.findBynomEvenementContainsIgnoreCase(motCle,
                PageRequest.of(page, 10));
        model.addAttribute("listeEvenements", pageEvenement.getContent());
        model.addAttribute("pages", new int[pageEvenement.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("motCle", motCle);

        return "evenement";

    }

    //    @RequestMapping("user/event/participant")
    //    public String participantEvent(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
    //            @RequestParam(name = "motCle", defaultValue = "") String motCle) {
    //        Page<Evenement> pageEvenement = eventRepository.findBynomEvenementContainsIgnoreCase(motCle,
    //                PageRequest.of(page, 10));
    //        model.addAttribute("listeEvenements", pageEvenement.getContent());
    //        model.addAttribute("pages", new int[pageEvenement.getTotalPages()]);
    //        model.addAttribute("currentPage", page);
    //        model.addAttribute("motCle", motCle);
    //
    //        return "evenementParticipant";
    //    }

    @GetMapping("/admin/event/delete")
    public String delete(int id, int page, String motCle) {
        eventRepository.deleteById(id);
        return "redirect:/user/event/index?page =" + page + "&motCle=" + motCle;
    }

    @GetMapping("/admin/event/formEvenement")
    public String form(Model model) {
        model.addAttribute("evenement", new Evenement());
        return "formEvenement";
    }

    @GetMapping("/admin/event/edit")
    public String edit(Model model, int id) {
        Evenement evenement1 = eventRepository.findById(id).get();
        model.addAttribute("evenement", evenement1);
        return "editEvenement";
    }

    @PostMapping("/admin/event/save")
    public String save(Model model, @Valid Evenement evenement, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formEvenement";
        }
        eventRepository.save(evenement);
        return "redirect:/user/event/index";
    }

}