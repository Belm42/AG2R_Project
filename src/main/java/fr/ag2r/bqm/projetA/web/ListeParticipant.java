package fr.ag2r.bqm.projetA.web;

import java.util.ArrayList;
import java.util.List;

import fr.ag2r.bqm.projetA.entites.Participant;

//TODO by Djer : Je ne comprend pas l'intéret de cette classe ... Peut-être que je comprendrais mieu quand les algo de "répartitions" seront codés.....
public class ListeParticipant {

    public List<Participant> listParticipant;

    public ListeParticipant() {
        listParticipant = new ArrayList<Participant>();
    }

    /**
     * @return the listChiffre
     */
    public List<Participant> getlistParticipant() {
        return listParticipant;
    }

    /**
     * @param listChiffre the listChiffre to set
     */
    public void setlistParticipant(List<Participant> listparticipant) {
        this.listParticipant = listparticipant;
    }

}
