package fr.ag2r.bqm.ag2r.test;

import java.util.ArrayList;
import java.util.List;

public class Algo {

    private static Integer nombreTable = 5;
    private static Integer nombrePersonne = nombreTable * nombreTable;
    private static Integer nombrePersonneParTable = nombreTable; //Le nombre de personne par table soit égal au nombre de tables.
    private static List<Integer> list = new ArrayList<>();
    private static Integer nombreTour = nombreTable;
    static List<Integer> subListe = new ArrayList<>();
    static List<Integer> subListe2 = new ArrayList<>();

    public static void main(String[] args) {
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

            subListe = list.subList(fromIndex, toIndex);
            fromIndex += nombrePersonneParTable;
            toIndex += nombrePersonneParTable;
            listDeListe.add(subListe);
            // Essayer de formater la phrase.
            System.out.println("Le point départ table " + r + " : " + subListe);

        }
        for (int k = 0; k < nombreTour; k++) {
            System.out.println("-------------------");
            System.out.println("rotation " + (k + 1));
            for (int j = 0; j < nombreTable; j++) {
                subListe2.clear();
                int suiteNombre = 0;
                // 
                int limiteTable = 0;
                for (int i = 0; i < nombrePersonneParTable; i++) {
                    limiteTable += nombrePersonneParTable;
                    int somme = j + suiteNombre;
                    while (limiteTable <= somme) {
                        somme = somme - nombrePersonneParTable;
                    }
                    int valeur = list.get(somme);
                    subListe2.add(valeur);
                    suiteNombre += (nombreTable + k);

                }
                System.out.println(" " + "table" + (j + 1) + " :" + subListe2);

            }

        }

    }
}