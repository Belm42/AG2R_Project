package fr.ag2r.bqm.ag2r.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.ag2r.bqm.ag2r.entites.Participant;

@Service
public class BqmService {
    private Integer nombreTable;
    private Integer nombrePersonne;
    private Integer nombrePersonneParTable;

    public List<List<List<Participant>>> bqmRotation(List<Participant> participantBqm) {
        List<Participant> listParticipantTotal = new ArrayList<>();
        List<List<Participant>> listAffichage = new ArrayList<List<Participant>>();
        List<List<List<Participant>>> listAffichageFinal = new ArrayList<List<List<Participant>>>();

        for (Participant participant : participantBqm) {

            listParticipantTotal.add(participant);
        }
        firstRotation(listParticipantTotal, listAffichage);
        logicalRotation(listAffichage, listParticipantTotal);
        displayRotation(listAffichage, listAffichageFinal);
        return listAffichageFinal;
    }

    public void firstRotation(List<Participant> listParticipantTotal, List<List<Participant>> listMiddle) {
        int fromIndex = 0;
        int toIndex = nombrePersonneParTable;
        for (int r = 1; r <= nombreTable; r++) {
            List<Participant> subListe = new ArrayList<Participant>();
            subListe = listParticipantTotal.subList(fromIndex, toIndex);
            fromIndex += nombrePersonneParTable;
            toIndex += nombrePersonneParTable;
            // Essayer de formater la phrase.
            listMiddle.add(subListe);
        }
    }

    public void logicalRotation(List<List<Participant>> listMiddle, List<Participant> listParticipantTotal) {
        for (int k = 0; k < nombreTable; k++) {
            for (int j = 0; j < nombreTable; j++) {
                List<Participant> subListe2 = new ArrayList<Participant>();
                int suiteNombre = 0;
                int limiteTable = 0;
                for (int i = 0; i < nombrePersonneParTable; i++) {
                    limiteTable += nombrePersonneParTable;
                    int indexParticipant = j + suiteNombre;
                    while (limiteTable <= indexParticipant) {
                        indexParticipant = indexParticipant - nombrePersonneParTable;
                    }
                    Participant participant = listParticipantTotal.get(indexParticipant);
                    subListe2.add(participant);
                    suiteNombre += (nombreTable + k);

                }
                listMiddle.add(subListe2);
            }
        }
    }

    public void displayRotation(List<List<Participant>> listMiddle, List<List<List<Participant>>> listAffichage) {

        int fromIndex = 0;
        int toIndex = nombrePersonneParTable;
        for (int r = 0; r <= nombreTable; r++) {
            List<List<Participant>> subListe = new ArrayList<List<Participant>>();
            subListe = listMiddle.subList(fromIndex, toIndex);
            fromIndex += nombrePersonneParTable;
            toIndex += nombrePersonneParTable;
            listAffichage.add(subListe);
        }

    }

    public Integer getNombreTable() {
        return nombreTable;
    }

    public Integer getNombrePersonne() {
        return nombrePersonne;
    }

    public Integer getNombrePersonneParTable() {
        return nombrePersonneParTable;
    }

    public void setNombreTable(Integer nombreTable) {
        this.nombreTable = nombreTable;
    }

    public void setNombrePersonne(Integer nombrePersonne) {
        this.nombrePersonne = nombrePersonne;
    }

    public void setNombrePersonneParTable(Integer nombrePersonneParTable) {
        this.nombrePersonneParTable = nombrePersonneParTable;
    }
}
