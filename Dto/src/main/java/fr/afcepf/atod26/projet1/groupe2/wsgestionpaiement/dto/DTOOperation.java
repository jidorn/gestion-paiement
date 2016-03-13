package fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.dto;

import java.util.Date;

/**
 * la classe dto operation.
 */
public class DTOOperation {

    /**
     * id.
     */
    private int id;

    /**
     * montant.
     */
    private double montant;

    /**
     * libelle.
     */
    private String libelle;

    /**
     * la date de l'operation.
     */
    private Date dateOperation;

    /**
     * constructeur par defaut.
     */
    public DTOOperation() {
    }

    /**
     * constructeur avec params.
     *
     * @param paramId            id.
     * @param paramMontant       montant.
     * @param paramLibelle       libelle.
     * @param paramDateOperation dateOperation.
     */
    public DTOOperation(int paramId,
                        double paramMontant,
                        String paramLibelle,
                        Date paramDateOperation) {
        id = paramId;
        montant = paramMontant;
        libelle = paramLibelle;
        dateOperation = paramDateOperation;
    }

    /**
     * constructeur avec params sans id.
     *
     * @param paramMontant       montant.
     * @param paramLibelle       libelle.
     * @param paramDateOperation date de l'operation.
     */
    public DTOOperation(double paramMontant,
                        String paramLibelle,
                        Date paramDateOperation) {
        montant = paramMontant;
        libelle = paramLibelle;
        dateOperation = paramDateOperation;
    }

    /**
     * le getter.
     *
     * @return le getter.
     */
    public int getId() {
        return id;
    }

    /**
     * le setter.
     *
     * @param paramId le setter.
     */
    public void setId(int paramId) {
        id = paramId;
    }

    /**
     * le getter.
     *
     * @return le getter.
     */
    public double getMontant() {
        return montant;
    }

    /**
     * le setter.
     *
     * @param paramMontant le setter.
     */
    public void setMontant(int paramMontant) {
        montant = paramMontant;
    }

    /**
     * le getter.
     *
     * @return le getter.
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * le setter.
     *
     * @param paramLibelle le setter.
     */
    public void setLibelle(String paramLibelle) {
        libelle = paramLibelle;
    }

    /**
     * le getter.
     *
     * @return le getter.
     */
    public Date getDateOperation() {
        return dateOperation;
    }

    /**
     * le setter.
     *
     * @param paramDateOperation le setter.
     */
    public void setDateOperation(
            Date paramDateOperation) {
        dateOperation = paramDateOperation;
    }
}
