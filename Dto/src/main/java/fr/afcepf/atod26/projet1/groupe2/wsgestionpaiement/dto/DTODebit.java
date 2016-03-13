package fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.dto;

import java.util.Date;

/**
 * la classe dto du debit.
 */
public class DTODebit extends DTOOperation {

    /**
     * constructeur par defaut.
     */
    public DTODebit() {
    }

    /**
     * constructeur avec params.
     *
     * @param paramId            id.
     * @param paramMontant       montant.
     * @param paramLibelle       libelle.
     * @param paramDateOperation dateOperation.
     */
    public DTODebit(int paramId,
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
    public DTODebit(double paramMontant,
                    String paramLibelle,
                    Date paramDateOperation) {
        super(paramMontant, paramLibelle, paramDateOperation);
    }
}
