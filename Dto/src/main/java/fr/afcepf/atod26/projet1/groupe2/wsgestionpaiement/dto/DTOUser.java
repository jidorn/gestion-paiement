package fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.dto;

import java.util.List;

/**
 * la classe dtoUser.
 */
public class DTOUser {
    /**
     * identifiant.
     */
    private int id;
    /**
     * numero de la carte bancaire de l'utilisateur.
     */
    private int numeroCarteBancaire;
    /**
     * Le mois d'expiration de la carte.
     */
    private int dateExpirationMois;
    /**
     * l'annee d'expiration de la carte.
     */
    private int dateExpirationAnnee;
    /**
     * le cryptogramme.
     */
    private int cryptogramme;

    /**
     * la liste.
     */
    private List<DTOCompte> compteList;

    /**
     * constructeur.
     */
    public DTOUser() {
    }

    /**
     * constructeur avec les parametres.
     *
     * @param paramId                  id.
     * @param paramNumeroCarteBancaire num.
     * @param paramDateExpirationMois  mois.
     * @param paramDateExpirationAnnee annee.
     * @param paramCryptogramme        crypto.
     * @param paramCompteList          liste.
     */
    public DTOUser(int paramId,
                   int paramNumeroCarteBancaire,
                   int paramDateExpirationMois,
                   int paramDateExpirationAnnee,
                   int paramCryptogramme,
                   List<DTOCompte> paramCompteList) {
        id = paramId;
        numeroCarteBancaire = paramNumeroCarteBancaire;
        dateExpirationMois = paramDateExpirationMois;
        dateExpirationAnnee = paramDateExpirationAnnee;
        cryptogramme = paramCryptogramme;
        compteList = paramCompteList;
    }

    /**
     * constructeur avec les parametres sans l'id.
     *
     * @param paramNumeroCarteBancaire num.
     * @param paramDateExpirationMois  mois.
     * @param paramDateExpirationAnnee annee.
     * @param paramCryptogramme        crypto.
     */
    public DTOUser(int paramNumeroCarteBancaire,
                   int paramDateExpirationMois,
                   int paramDateExpirationAnnee,
                   int paramCryptogramme) {
        numeroCarteBancaire = paramNumeroCarteBancaire;
        dateExpirationMois = paramDateExpirationMois;
        dateExpirationAnnee = paramDateExpirationAnnee;
        cryptogramme = paramCryptogramme;
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
    public List<DTOCompte> getCompteList() {
        return compteList;
    }

    /**
     * le setter.
     * @param paramCompteList le setter.
     */
    public void setCompteList(List<DTOCompte> paramCompteList) {
        compteList = paramCompteList;
    }
}
