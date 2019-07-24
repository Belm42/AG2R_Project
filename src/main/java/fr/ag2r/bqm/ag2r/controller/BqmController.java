package fr.ag2r.bqm.ag2r.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.ag2r.bqm.ag2r.dao.EvenementRepository;
import fr.ag2r.bqm.ag2r.dao.ParticipantRepository;
import fr.ag2r.bqm.ag2r.entites.Evenement;
import fr.ag2r.bqm.ag2r.entites.Participant;
import fr.ag2r.bqm.ag2r.service.BqmService;

@Controller
public class BqmController {
    @Autowired
    ParticipantRepository participantRepository;
    @Autowired
    EvenementRepository eventRepository;
    @Autowired
    BqmService bqmService;

    @RequestMapping("/user/event/bqm")
    public String rotation(Model model, Integer id) {
        Evenement evenementBqm = eventRepository.findById(id).get();
        List<Participant> participantBqm = evenementBqm.getParticipants();
        bqmService.setNombrePersonne(evenementBqm.getNombreParticipant());
        bqmService.setNombreTable(evenementBqm.getNombreTable());
        bqmService.setNombrePersonneParTable(evenementBqm.getNombreParticipantTable());

        //Un sous dossier dans "template" serais plsu claire.
        List<List<List<Participant>>> bqmRotation;
        bqmRotation = bqmService.bqmRotation(participantBqm);
        model.addAttribute("bqmEvent", evenementBqm);
        model.addAttribute("bqmRotation", bqmRotation);
        return "bqmDisplay";
    }
}