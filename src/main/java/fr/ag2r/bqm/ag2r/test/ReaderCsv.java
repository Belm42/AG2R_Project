package fr.ag2r.bqm.ag2r.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderCsv {
    static List<List<String>> listDeListe = new ArrayList<List<String>>();

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("\\Users\\house\\OneDrive\\Bureau\\employees.csv"));
        Integer line = countLine(scanner);
        scanner.close();
        scanner = new Scanner(new File("\\Users\\house\\OneDrive\\Bureau\\employees.csv"));
        wordList(scanner);
        scanner.close();
        displayList(line);

    }

    public static Integer countLine(Scanner scanner) throws FileNotFoundException {

        Integer count = 0;
        while (scanner.hasNextLine()) {
            count++;
            scanner.nextLine();
        }
        return count;
    }

    public static void wordList(Scanner scanner) {
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

    public static void displayList(Integer line) {
        //Récuperer les données de chaque ligne d'une colonne.
        for (int j = 0; j < 6; j++) {
            List<String> list2 = new ArrayList<>();
            for (int i = 1; i < line; i++) {

                list2.add(listDeListe.get(i).get(j));
            }
            System.out.println(list2.get(0));
        }

    }
}
