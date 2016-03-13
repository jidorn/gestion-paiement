package fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.dto;

import java.util.Date;

/**
 * la classe dto du credit.
 */
public class DTOCredit extends DTOOperation {

    /**
     * constructeur par defaut.
     */
    public DTOCredit() {
    }

    /**
     * constructeur avec params.
     *
     * @param paramId            id.
     * @param paramMontant       montant.
     * @param paramLibelle       libelle.
     * @param paramDateOperation dateOperation.
     */
    public DTOCredit(int paramId,
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
    public DTOCredit(double paramMontant,
                     String paramLibelle,
                     Date paramDateOperation) {
        super(paramMontant, paramLibelle, paramDateOperation);
    }

}
