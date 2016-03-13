package fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.data;

import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.entities.Compte;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.entities.Operation;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.entities.User;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.exception.BanqueException;

import java.util.List;

/**
 * interface des users.
 */
public interface IDaoUser {
    /**
     * methode de connexion.
     *
     * @param paramUser le user qui se connecte.
     * @return le user avec identifiant.
     * @throws BanqueException exception.
     */
    User connexion(User paramUser) throws BanqueException;

    /**
     * methode envoie du code par mail.
     *
     * @return le code.
     */
    int envoieMailCheckCode();

    /**
     * operation de debit.
     *
     * @param paramMontant le montant.
     * @param paramCompte  le compte.
     * @return le montant.
     * @throws BanqueException exception.
     */
    double debit(double paramMontant, Compte paramCompte)
            throws BanqueException;

    /**
     * operation de credit.
     *
     * @param paramMontant le montant.
     * @param paramCompte  le compte.
     * @return le montant.
     * @throws BanqueException exception.
     */
    double credit(double paramMontant, Compte paramCompte)
            throws BanqueException;

    /**
     * methode de verification du code.
     *
     * @param paramCode le code.
     * @return le resultat de la verification.
     * @throws BanqueException exception.
     */
    boolean checkCodeSecurity(int paramCode) throws BanqueException;

    /**
     * bla.
     *
     * @param paramUser user.
     * @return le compte.
     */
    Compte getCompteByUser(User paramUser);

    /**
     * get.
     *
     * @param paramCompte le compte.
     * @return les operations.
     */
    List<Operation> getOperationByCompte(Compte paramCompte);

    /**
     * methode de verification de solde.
     *
     * @param paramMontant le montant a retirer du compte.
     * @param paramCompte  le compte.
     * @return le résultat.
     * @throws BanqueException exception.
     */
    boolean verifierSoldeCompte(double paramMontant, Compte paramCompte)
            throws BanqueException;
}
