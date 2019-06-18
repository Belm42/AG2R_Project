package fr.ag2r.bqm.projetA.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
public class Evenement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvenement;

    @NonNull
    @Size(min = 1)
    private String nomEvenement;

    @NonNull
    @Size(min = 1)
    private Date dateEvenement;

    @NonNull
    @Size(min = 1)
    private Integer nombreParticipant;

    @NonNull
    @Size(min = 1)
    private Integer nombreParticipantTable;

    @NonNull
    @Size(min = 1)
    private Integer nombreTable;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evenement", fetch = FetchType.LAZY)
    private List<Participant> participants;

    public Evenement() {
        super();
    }

    public Evenement(String nomEvenement, Date dateEvenement, Integer nombreParticipant, Integer nombreParticipantTable,
            Integer nombreTable, List<Participant> participants) {
        super();
        this.nomEvenement = nomEvenement;
        this.dateEvenement = dateEvenement;
        this.nombreParticipant = nombreParticipant;
        this.nombreParticipantTable = nombreParticipantTable;
        this.nombreTable = nombreTable;
        //TODO by Djer : comme vous avez un  lien bi-directionnel  JPA entre Evennement et Participant il faut penser à faire lien. EN général on éviter de laisser passer une liste potentiellement "mal compélté" et on créer une mathode "addParticipants" qui ajoute dans la list de l'évènnment et s'assure que l'Evennement de ce particpants est bien positionné (et "remooveParticipant") : https://vladmihalcea.com/jpa-hibernate-synchronize-bidirectional-entity-associations/
        this.participants = participants;
    }

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
     * @return the dateEvenement
     */
    public Date getDateEvenement() {
        return dateEvenement;
    }

    /**
     * @param dateEvenement the dateEvenement to set
     */
    public void setDateEvenement(Date dateEvenement) {
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

}
