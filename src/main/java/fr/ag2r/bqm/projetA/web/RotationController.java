package fr.ag2r.bqm.projetA.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RotationController {

    private Integer nombreTable = 5;
    private Integer nombrePersonne = nombreTable * nombreTable;
    private Integer nombrePersonneParTable = nombreTable; //Le nombre de personne par table soit égal au nombre de tables.
    private List<Integer> list = new ArrayList<>();
    private Integer nombreTour = nombreTable;
    private List<ListeChifre> youpi = new ArrayList<ListeChifre>();

    @RequestMapping("/user/algo/index")
    public String rotation(final Model model) {
        list.clear();
        youpi.clear();
        for (int i = 0; i < nombrePersonne; i++) {

            list.add(i + 1);
        }
        int tempsParticipant = (nombrePersonneParTable * (nombreTour + 1) * 1);
        int tempsRotation = (nombreTour + 1) * 2;
        System.out.println("Temps du meeting : " + (tempsParticipant + tempsRotation) + " minutes");
        System.out.println(list);
        int fromIndex = 0;
        int toIndex = nombrePersonneParTable;
        List<List<Integer>> listDeListe = new ArrayList<List<Integer>>();
        for (int r = 1; r <= nombreTable; r++) {
            ListeChifre subListe = new ListeChifre();
            subListe.listChiffre = list.subList(fromIndex, toIndex);
            fromIndex += nombrePersonneParTable;
            toIndex += nombrePersonneParTable;
            listDeListe.add(subListe.listChiffre);
            // Essayer de formater la phrase.
            System.out.println("Le point départ table " + r + " : " + subListe);
            youpi.add(subListe);
        }
        for (int k = 0; k < nombreTour; k++) {
            System.out.println("-------------------");
            System.out.println("rotation " + (k + 1));
            for (int j = 0; j < nombreTable; j++) {
                ListeChifre subListe2 = new ListeChifre();
                int suiteNombre = 0;
                int limiteTable = 0;
                for (int i = 0; i < nombrePersonneParTable; i++) {
                    limiteTable += nombrePersonneParTable;
                    int somme = j + suiteNombre;
                    while (limiteTable <= somme) {
                        somme = somme - nombrePersonneParTable;
                    }
                    Integer valeur = list.get(somme);
                    subListe2.listChiffre.add(valeur);
                    suiteNombre += (nombreTable + k);

                }
                System.out.println(" " + "table" + (j + 1) + " :" + subListe2);
                youpi.add(subListe2);

            }

        }
        System.out.println(youpi);
        model.addAttribute("youpi", youpi);
        return "algo";

    }
}