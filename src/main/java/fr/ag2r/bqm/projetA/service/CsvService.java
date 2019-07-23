package fr.ag2r.bqm.projetA.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvService {

    List<List<String>> listDeListe = new ArrayList<List<String>>();

    public void csvReader() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("\\Users\\house\\OneDrive\\Bureau\\employees.csv"));
        Integer line = countLine(scanner);
        wordList(scanner);
        displayList(line);
        scanner.close();

    }

    public Integer countLine(Scanner scanner) throws FileNotFoundException {

        Integer count = 0;
        while (scanner.hasNextLine()) {
            count++;
            scanner.nextLine();
        }
        return count;
    }

    public void wordList(Scanner scanner) {
        scanner.useDelimiter("\n");

        while (scanner.hasNext()) {
            List<String> list = new ArrayList<>();
            // Virgule ou point virgule selon le formatage de base
            String[] lineString = (scanner.next().split(";"));
            // Faire liste pour chaque donné dans une ligne
            for (String wordInLine : lineString) {
                list.add(wordInLine);
            }
            listDeListe.add(list);
        }
    }

    public void displayList(Integer line) {
        //Récuperer les données de chaque ligne d'une colonne.
        for (int j = 0; j < 5; j++) {
            List<String> list2 = new ArrayList<>();
            for (int i = 1; i < line; i++) {

                list2.add(listDeListe.get(i).get(j));
            }
            System.out.println(list2);
        }

    }
}
