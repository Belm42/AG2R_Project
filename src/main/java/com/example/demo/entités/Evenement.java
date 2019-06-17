package com.example.demo.entités;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private String dateEvenement;
    @NonNull
    @Size(min = 1)
    private Integer nombreParticipant;
    @NonNull
    @Size(min = 1)
    private Integer nombreParticipantTable;
    @NonNull
    @Size(min = 1)
    private Integer nombreTable;

    private Evenement() {
        super();
    }

    public Evenement(String nomEvenement, String dateEvenement, Integer nombreParticipant,
            Integer nombreParticipantTable, Integer nombreTable) {
        super();
        this.nomEvenement = nomEvenement;
        this.dateEvenement = dateEvenement;
        this.nombreParticipant = nombreParticipant;
        this.nombreParticipantTable = nombreParticipantTable;
        this.nombreTable = nombreTable;
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

}
