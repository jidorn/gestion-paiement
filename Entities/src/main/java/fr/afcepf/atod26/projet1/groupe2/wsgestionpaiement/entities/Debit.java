package fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

/**
 * classe debit.
 */
@Entity
@DiscriminatorValue(value = "DEBIT")
public class Debit extends Operation {

    /**
     * constructeur par defaut.
     */
    public Debit() {
    }

    /**
     * constructeur avec params.
     *
     * @param paramId            id.
     * @param paramMontant       montant.
     * @param paramLibelle       libelle.
     * @param paramDateOperation dateOperation.
     */
    public Debit(int paramId,
                 double paramMontant,
                 String paramLibelle,
                 Date paramDateOperation) {
        super(paramId, paramMontant, paramLibelle, paramDateOperation);
    }

    /**
     * constructeur avec params sans id.
     *
     * @param paramMontant       montant.
     * @param paramLibelle       libelle.
     * @param paramDateOperation date de l'operation.
     */
    public Debit(double paramMontant,
                 String paramLibelle,
                 Date paramDateOperation) {
        super(paramMontant, paramLibelle, paramDateOperation);
    }

    /**
     * constructeur avec tout les params pour les tests.
     *
     * @param paramId            id.
     * @param paramMontant       montant.
     * @param paramLibelle       libelle.
     * @param paramDateOperation operation.
     * @param paraCompte         compte.
     */
    public Debit(int paramId,
                 double paramMontant,
                 String paramLibelle,
                 Date paramDateOperation,
                 Compte paraCompte) {
        super(paramId, paramMontant, paramLibelle,
                paramDateOperation, paraCompte);
    }

    /**
     * constructeur avec tout les params.
     *
     * @param paramMontant       Montant.
     * @param paramLibelle       libelle.
     * @param paramDateOperation la date.
     * @param paramCompte        le compte.
     */
    public Debit(double paramMontant,
                 String paramLibelle,
                 Date paramDateOperation,
                 Compte paramCompte) {
        super(paramMontant, paramLibelle,
                paramDateOperation, paramCompte);
    }

}
