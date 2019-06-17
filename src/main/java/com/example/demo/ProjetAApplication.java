/* TODO by Djer : devrait etre "fr.ag2r.bqm.groupeA" */
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetAApplication.class, args);
    }
    /*
    @Override
    public void run(String... args) throws Exception {
    
        participantsRepository.save(new Participants("BELMOUMENE", "Mohammed", "CNAM", "moh@yahoo.fr", 5063,
                "Directeur", "Experience 10 ans"));
        participantsRepository
                .save(new Participants("ALSHAMY", "Bilel", "SFR", "bil42@yahoo.fr", 1896, "PDG", "Experience 19 ans"));
        participantsRepository.save(new Participants("LE GRAND", "BERNARD", "FREE", "legrand69@gmail.fr", 3540, "PDG",
                "Experience 19 ans"));
        participantsRepository.save(new Participants("LE PETIT", "Theo", "Orange", "theolepetit@gmail.fr", 3940, "PDG",
                "Experience 19 ans"));
    
        participantsRepository.findAll().forEach(p -> {
            System.out.println(p.getNom());
    
        });
    
       } */

}
