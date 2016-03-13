package fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * la classe operation.
 */
@Entity
@Table(name = "operation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_OPERATION")
public class Operation {

    /**
     * id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_operation")
    private int id;

    /**
     * montant.
     */
    @Column(name = "montant_operation")
    private double montant;

    /**
     * libelle.
     */
    @Column(name = "libelle_operation")
    private String libelle;

    /**
     * la date de l'operation.
     */
    @Column(name = "date_operation")
    private Date dateOperation;

    /**
     * le compte.
     */
    @ManyToOne
    @JoinColumn(name = "numero_compte")
    private Compte compte;

    /**
     * constructeur par defaut.
     */
    public Operation() {
    }

    /**
     * constructeur avec params.
     *
     * @param paramId            id.
     * @param paramMontant       montant.
     * @param paramLibelle       libelle.
     * @param paramDateOperation dateOperation.
     */
    public Operation(int paramId,
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
    public Operation(double paramMontant,
                     String paramLibelle,
                     Date paramDateOperation) {
        montant = paramMontant;
        libelle = paramLibelle;
        dateOperation = paramDateOperation;
    }

    /**
     * constructeur avec tout les params.
     *
     * @param paramMontant       Montant.
     * @param paramLibelle       Libelle.
     * @param paramDateOperation Operation.
     * @param paramCompte        Compte.
     */
    public Operation(double paramMontant,
                     String paramLibelle,
                     Date paramDateOperation,
                     Compte paramCompte) {
        montant = paramMontant;
        libelle = paramLibelle;
        dateOperation = paramDateOperation;
        compte = paramCompte;
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
