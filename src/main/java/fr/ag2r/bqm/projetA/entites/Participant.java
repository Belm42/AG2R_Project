package fr.ag2r.bqm.projetA.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Participant implements Serializable {

    /** serialVersionUID  */
    private static final long serialVersionUID = 2789864048707708L;

    // Déclaration des variables 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 2, max = 50)
    private String nom;

    @NotNull
    @Size(min = 2, max = 50)
    private String prenom;
    @NotNull
    @Size(min = 2, max = 50)

    private String entreprise;
    @NotNull
    @Size(min = 5, max = 50)
    private String mail;

    @NotNull
    @Size(min = 1, max = 50)
    private String fonction;

    @NotNull
    @Size(min = 1, max = 50)
    private String secteur;

    // Plusieurs participants peuvent assister à un evenements.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEvenement")
    private Evenement evenement;

    // Générer un constructeurs par défaut (Sans parametres) pour JPA.
    public Participant() {
        super();
    }

    public Participant(String nom, String prenom, String entreprise, String mail, String fonction, String secteur,
            Evenement evenement) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.entreprise = entreprise;
        this.mail = mail;
        this.fonction = fonction;
        this.secteur = secteur;
        this.evenement = evenement;
        //Vérifie si la liste des participants de l'Evennement contient "this", si NON : 
        //Ajoute un "evenement.addParticipant(this)".

    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prénom) {
        this.prenom = prénom;
    }

    /**
     * @return the entreprise
     */
    public String getEntreprise() {
        return entreprise;
    }

    /**
     * @param entreprise the entreprise to set
     */
    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the fonction
     */
    public String getFonction() {
        return fonction;
    }

    /**
     * @param fonction the fonction to set
     */
    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    /**
     * @return the presentation
     */
    public String getSecteur() {
        return secteur;
    }

    /**
     * @param presentation the presentation to set
     */
    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    /**
     * @return the evenement
     */
    public Evenement getEvenement() {
        return evenement;
    }

    /**
     * @param evenement the evenement to set
     */
    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

}
