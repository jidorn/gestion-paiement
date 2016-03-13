package fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.service;

import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.dto.DTOCompte;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.dto.DTOUser;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.exception.BanqueException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * interface du service user.
 */
@WebService(targetNamespace = "http://service.wsgestionpaiement.groupe2.projet1.atod26.afcepf.fr")
public interface IUser {

    /**
     * methode de connexion.
     *
     * @param paramUser le user qui se connecte.
     * @return le user avec identifiant.
     * @throws BanqueException si un probleme survient.
     */
    @WebMethod(operationName = "connexionUtilisateur")
    @WebResult(name = "retourUtilisateur")
    DTOUser connexion(@WebParam(name = "utilisateurCandidat")
                      DTOUser paramUser)
            throws BanqueException;

    /**
     * methode envoie du code par mail.
     *
     * @return le code.
     */
    @WebMethod(operationName = "envoieMailCheckCode")
    @WebResult(name = "codeGenere")
    int envoieMailCheckCode();

    /**
     * operation de debit.
     *
     * @param paramMontant le montant.
     * @param paramUser    le user qui se connecte.
     * @return le montant.
     * @throws BanqueException si un probleme survient.
     */
    @WebMethod(operationName = "debit")
    @WebResult(name = "Resultat")
    double debit(@WebParam(name = "montant")
                 double paramMontant,
                 @WebParam(name = "user")
                 DTOUser paramUser)
            throws BanqueException;

    /**
     * operation de credit.
     *
     * @param paramMontant le montant.
     * @param paramUser    le user qui se connecte.
     * @return le montant.
     * @throws BanqueException si un probleme survient.
     */
    @WebMethod(operationName = "credit")
    @WebResult(name = "Resultat")
    double credit(@WebParam(name = "montant")
                  double paramMontant,
                  @WebParam(name = "user")
                  DTOUser paramUser)
            throws BanqueException;

    /**
     * methode de verification du code.
     *
     * @param paramCode le code.
     * @return le resultat de la verification.
     */
    @WebMethod(operationName = "checkCodeSecurity")
    @WebResult(name = "ResultatDuBoolean")
    boolean checkCodeSecurity(@WebParam(name = "leCodeAVerifier")
                              int paramCode);

    /**
     * methode de verification de solde.
     *
     * @param paramMontant le montant a retirer du compte.
     * @param paramCompte  le compte.
     * @return le résultat.
     * @throws BanqueException si un probleme survient.
     */
    @WebMethod(operationName = "verifierSoldeCompte")
    @WebResult(name = "laVerificationDuCode")
    boolean verifierSoldeCompte(@WebParam(name = "montant")
                                double paramMontant,
                                @WebParam(name = "compte")
                                DTOCompte paramCompte)
            throws BanqueException;

    /**
     * premiere methode de vérification
     * des informations de l'utilisateur
     * avant de débiter le compte.
     *
     * @param paramUser le user.
     * @param paramMontant le montant a retirer du compte.
     * @return true si l'utilisateur est authantifié.
     * @throws BanqueException si un probleme survient.
     */
    @WebMethod(operationName = "premierCheck")
    @WebResult(name = "ResultatDeLaMethode")
    boolean premiereVerification(@WebParam(name = "userAChecker")
                                 DTOUser paramUser,
                                 @WebParam(name = "montant")
                                 double paramMontant)
            throws BanqueException;
}
