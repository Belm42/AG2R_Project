package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.dao.EvenementRepository;

@Controller
public class EvenementController {
    @Autowired
    private EvenementRepository eventRepository;

    public void maMethode() {

    }

}
