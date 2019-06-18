package fr.ag2r.bqm.projetA.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.ag2r.bqm.projetA.dao.EvenementRepository;

@Controller
public class EvenementController {
    @Autowired
    private EvenementRepository eventRepository;

    public void maMethode() {

    }

}
