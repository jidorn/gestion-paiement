package fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

/**
 * classe credit.
 */
@Entity
@DiscriminatorValue(value = "CREDIT")
public class Credit extends Operation {
    /**
     * constructeur par defaut.
     */
    public Credit() {
    }

    /**
     * constructeur avec params.
     *
     * @param paramId            id.
     * @param paramMontant       montant.
     * @param paramLibelle       libelle.
     * @param paramDateOperation dateOperation.
     */
    public Credit(int paramId,
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
    public Credit(double paramMontant,
                  String paramLibelle,
                  Date paramDateOperation) {
        super(paramMontant, paramLibelle, paramDateOperation);
    }

    /**
     * constructeur avec tout les params.
     *
     * @param paramMontant       Montant.
     * @param paramLibelle       libelle.
     * @param paramDateOperation la date.
     * @param paramCompte        le compte.
     */
    public Credit(double paramMontant,
                  String paramLibelle,
                  Date paramDateOperation,
                  Compte paramCompte)  {
        super(paramMontant, paramLibelle, paramDateOperation, paramCompte);
    }

}
