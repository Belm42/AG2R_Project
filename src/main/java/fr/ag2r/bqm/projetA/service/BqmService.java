package fr.ag2r.bqm.projetA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.ag2r.bqm.projetA.web.ListeChifre;

@Service
public class BqmService {
    //TODO by Djer : un Controller est un "Singleton" TOUS tes utilsiateur vont utilsie la même instance. EN générale on PAS d'attribbut pour "stocker" un etat dans les controller
    private Integer nombreTable = 5; //devrait etre lut en BDD à partir d'un ID d'evennement
    private Integer nombrePersonne = nombreTable * nombreTable; //devrait etre lut en BDD à partir d'un ID d'evennement
    private Integer nombrePersonneParTable = nombreTable; //Le nombre de personne par table soit égal au nombre de tables.
    private List<Integer> list = new ArrayList<>(); //A déclarer dans la méthode qui l'utilise, cela tévitera en plus des "clear" systématiques
    private Integer nombreTour = nombreTable; //A mettre ailleur, mais je ne sait pas trop ou, je ne le compre pas trop. (semble être la "durée" d'un tour de table ?)
    private List<ListeChifre> youpi = new ArrayList<ListeChifre>();//A déclarer dans la méthode qui l'utilise, cela tévitera en plus des "clear" systématiques

    public List<ListeChifre> bqmRotation() {
        list.clear();
        youpi.clear();
        for (int i = 0; i < nombrePersonne; i++) {

            list.add(i + 1);
        }
        int fromIndex = 0;
        int toIndex = nombrePersonneParTable;
        //TODO by Djer non de varaible pas très claire....
        List<List<Integer>> listDeListe = new ArrayList<List<Integer>>();
        for (int r = 1; r <= nombreTable; r++) {
            ListeChifre subListe = new ListeChifre();
            subListe.listChiffre = list.subList(fromIndex, toIndex);
            fromIndex += nombrePersonneParTable;
            toIndex += nombrePersonneParTable;
            listDeListe.add(subListe.listChiffre);
            // Essayer de formater la phrase.
            youpi.add(subListe);
        }
        for (int k = 0; k < nombreTour; k++) {
            //TODO by Djer : pas de SysOut sur un Serveur !!
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
                youpi.add(subListe2);

            }
        }
        return youpi;
    }
}
