package fr.ag2r.bqm.projetA.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderCsv {
    public static void main(String[] args) throws FileNotFoundException {

        List<String> list2 = new ArrayList<>();
        List<List<String>> listDeListe = new ArrayList<List<String>>();
        Scanner scanner = new Scanner(new File("\\Users\\house\\OneDrive\\Bureau\\employees.csv"));

        //Delimiter pour chaque daut de ligne
        scanner.useDelimiter("\n");

        while (scanner.hasNext()) {
            List<String> list = new ArrayList<>();
            // Virgule ou point virgule selon le formatage de base
            String[] line = (scanner.next().split(";"));
            // Faire liste pour chaque donné dans une ligne
            for (String wordInLine : line) {
                list.add(wordInLine);
            }
            listDeListe.add(list);
        }
        //Récuperer les données de chaque ligne d'une colonne.
        for (int j = 0; j < 5; j++) {
            list2.clear();
            for (int i = 1; i < 9; i++) {

                list2.add(listDeListe.get(i).get(j));
            }
            System.out.println(listDeListe.get(0).get(j));
            System.out.println(list2);
        }
        scanner.close();
    }
}
