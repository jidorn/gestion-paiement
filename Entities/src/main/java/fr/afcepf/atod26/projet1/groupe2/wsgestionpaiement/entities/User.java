package fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.entities;


import javax.persistence.*;
import java.util.List;

/**
 * la classe user.
 */
@Entity
@Table(name = "user")
public class User {
    /**
     * identifiant.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id;
    /**
     * numero de la carte bancaire de l'utilisateur.
     */
    @Column(name = "numero_carte")
    private int numeroCarteBancaire;
    /**
     * Le mois d'expiration de la carte.
     */
    @Column(name = "expiration_mois")
    private int dateExpirationMois;
    /**
     * l'annee d'expiration de la carte.
     */
    @Column(name = "expiration_annee")
    private int dateExpirationAnnee;
    /**
     * le cryptogramme.
     */
    @Column(name = "crypto")
    private int cryptogramme;

    /**
     * liste des comptes.
     */
    @OneToMany(mappedBy = "user")
    private List<Compte> compteList;

    /**
     * constructeur.
     */
    public User() {
    }

    /**
     * constructeur avec les parametres.
     *
     * @param paramNumeroCarteBancaire num.
     * @param paramDateExpirationMois  mois.
     * @param paramDateExpirationAnnee annee.
     * @param paramCryptogramme        crypto.
     * @param paramCompteList          liste.
     */
    public User(int paramNumeroCarteBancaire,
                int paramDateExpirationMois,
                int paramDateExpirationAnnee,
                int paramCryptogramme,
                List<Compte> paramCompteList) {
        numeroCarteBancaire = paramNumeroCarteBancaire;
        dateExpirationMois = paramDateExpirationMois;
        dateExpirationAnnee = paramDateExpirationAnnee;
        cryptogramme = paramCryptogramme;
        compteList = paramCompteList;
    }

    /**
     * getter.
     *
     * @return getter.
     */
    public int getId() {
        return id;
    }

    /**
     * setter.
     *
     * @param paramId le setter.
     */
    public void setId(int paramId) {
        id = paramId;
    }

    /**
     * getter.
     *
     * @return getter.
     */
    public int getNumeroCarteBancaire() {
        return numeroCarteBancaire;
    }

    /**
     * le setter.
     *
     * @param paramNumeroCarteBancaire le setter.
     */
    public void setNumeroCarteBancaire(int paramNumeroCarteBancaire) {
        numeroCarteBancaire = paramNumeroCarteBancaire;
    }

    /**
     * getter.
     *
     * @return getter.
     */
    public int getDateExpirationMois() {
        return dateExpirationMois;
    }

    /**
     * le setter.
     *
     * @param paramDateExpirationMois le setter.
     */
    public void setDateExpirationMois(int paramDateExpirationMois) {
        dateExpirationMois = paramDateExpirationMois;
    }

    /**
     * getter.
     *
     * @return getter.
     */
    public int getDateExpirationAnnee() {
        return dateExpirationAnnee;
    }

    /**
     * le setter.
     *
     * @param paramDateExpirationAnnee le setter.
     */
    public void setDateExpirationAnnee(
            int paramDateExpirationAnnee) {
        dateExpirationAnnee = paramDateExpirationAnnee;
    }

    /**
     * getter.
     *
     * @return getter.
     */
    public int getCryptogramme() {
        return cryptogramme;
    }

    /**
     * le setter.
     *
     * @param paramCryptogramme le setter.
     */
    public void setCryptogramme(int paramCryptogramme) {
        cryptogramme = paramCryptogramme;
    }

    /**
     * getter.
     *
     * @return getter.
     */
    public List<Compte> getCompteList() {
        return compteList;
    }

    /**
     * le setter.
     * @param paramCompteList le setter.
     */
    public void setCompteList(List<Compte> paramCompteList) {
        compteList = paramCompteList;
    }
}
