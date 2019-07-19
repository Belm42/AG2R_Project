package fr.ag2r.bqm.projetA.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Evenement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvenement;

    @NotNull
    @Size(min = 2, max = 50)
    private String nomEvenement;

    @NotNull
    @Size(min = 2, max = 50)
    private String dateEvenement;

    @NotNull
    @Max(9999)
    private Integer nombreParticipant;

    @NotNull
    @Max(9999)
    private Integer nombreParticipantTable;

    @NotNull
    @Max(9999)
    private Integer nombreTable;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evenement", fetch = FetchType.LAZY)
    private List<Participant> participants;

    public Evenement() {
        super();
    }

    public Evenement(String nomEvenement, String dateEvenement, Integer nombreParticipant,
            Integer nombreParticipantTable, Integer nombreTable, List<Participant> participant) {
        super();
        this.nomEvenement = nomEvenement;
        this.dateEvenement = dateEvenement;
        this.nombreParticipant = nombreParticipant;
        this.nombreParticipantTable = nombreParticipantTable;
        this.nombreTable = nombreTable;
        //TODO by Djer : comme vous avez un  lien bi-directionnel  JPA entre Evennement et Participant il faut penser à faire lien. EN général on éviter de laisser passer une liste potentiellement "mal compélté" et on créer une mathode "addParticipants" qui ajoute dans la list de l'évènnment et s'assure que l'Evennement de ce particpants est bien positionné (et "remooveParticipant") : https://vladmihalcea.com/jpa-hibernate-synchronize-bidirectional-entity-associations/
        this.participants = participant;
    }

    /*    public void addParticipant(Participant participant) {
        participants.add(participant);
        participant.setEvenement(this);
    }
    
    public void removePaticipant(Participant participant) {
        participants.remove(participant);
        participant.setEvenement(null);
    }   **/

    /**
     * @return the idEvenement
     */
    public Integer getIdEvenement() {
        return idEvenement;
    }

    /**
     * @param idEvenement the idEvenement to set
     */
    public void setIdEvenement(Integer idEvenement) {
        this.idEvenement = idEvenement;
    }

    /**
     * @return the nomEvenement
     */
    public String getNomEvenement() {
        return nomEvenement;
    }

    /**
     * @param nomEvenement the nomEvenement to set
     */
    public void setNomEvenement(String nomEvenement) {
        this.nomEvenement = nomEvenement;
    }

    /**
     * @return 
     * @return the dateEvenement
     */
    public String getDateEvenement() {
        return dateEvenement;
    }

    /**
     * @param dateEvenement the dateEvenement to set
     */
    public void setDateEvenement(String dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    /**
     * @return the nombreParticipant
     */
    public Integer getNombreParticipant() {
        return nombreParticipant;
    }

    /**
     * @param nombreParticipant the nombreParticipant to set
     */
    public void setNombreParticipant(Integer nombreParticipant) {
        this.nombreParticipant = nombreParticipant;
    }

    /**
     * @return the nombreParticipantTable
     */
    public Integer getNombreParticipantTable() {
        return nombreParticipantTable;
    }

    /**
     * @param nombreParticipantTable the nombreParticipantTable to set
     */
    public void setNombreParticipantTable(Integer nombreParticipantTable) {
        this.nombreParticipantTable = nombreParticipantTable;
    }

    /**
     * @return the nombreTable
     */
    public Integer getNombreTable() {
        return nombreTable;
    }

    /**
     * @param nombreTable the nombreTable to set
     */
    public void setNombreTable(Integer nombreTable) {
        this.nombreTable = nombreTable;
    }

    /**
     * @return the participants
     */
    public List<Participant> getParticipants() {
        return participants;
    }

    /**
     * @param participants the participants to set
     */
    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

}
