package fr.ag2r.bqm.projetA.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
public class Participant implements Serializable {

    /** serialVersionUID  */
    private static final long serialVersionUID = 2789864048707708L;

    // Déclaration des variables 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Size(min = 2, max = 20)
    private String nom;

    @NonNull
    @Size(min = 2, max = 20)
    private String prenom;
    @NonNull
    @Size(min = 2, max = 20)

    private String entreprise;
    @NonNull
    @Size(min = 5, max = 20)
    private String mail;

    @NonNull
    @Size(min = 10, max = 11)
    private String tel;

    @NonNull
    @Size(min = 2, max = 20)
    private String fonction;

    @NonNull
    @Size(min = 5, max = 250)
    private String presentation;

    // Plusieurs participants peuvent assister à un evenements.
    @ManyToOne(fetch = FetchType.LAZY)
    private Evenement evenement;

    // Générer un constructeurs par défaut (Sans parametres) pour JPA.
    public Participant() {
        super();
    }

    public Participant(String nom, String prenom, String entreprise, String mail, String tel, String fonction,
            String presentation, Evenement evenement) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.entreprise = entreprise;
        this.mail = mail;
        this.tel = tel;
        this.fonction = fonction;
        this.presentation = presentation;
        this.evenement = evenement;
        //TODO by Djer : comme vous avez un  lien bi-directionnel JPA entre Evennement et Participant il faut penser à faire lien (si CE participants n'est pas dans la liste des participants de l'Evennement, l'ajouter, sinon .... ??) : https://vladmihalcea.com/jpa-hibernate-synchronize-bidirectional-entity-associations/
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
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
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
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
    public String getPresentation() {
        return presentation;
    }

    /**
     * @param presentation the presentation to set
     */
    public void setPresentation(String présentation) {
        this.presentation = présentation;
    }

}