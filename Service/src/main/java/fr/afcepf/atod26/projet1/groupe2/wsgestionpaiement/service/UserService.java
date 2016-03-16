package fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.service;

import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.data.IDaoUser;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.dto.DTOCompte;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.dto.DTOOperation;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.dto.DTOUser;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.entities.Compte;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.entities.Operation;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.entities.User;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.exception.BanqueException;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * la classe.
 */

@WebService(
        targetNamespace =
                "http://service.wsgestionpaiement."
                        + "groupe2.projet1.atod26.afcepf.fr",
        serviceName = "serviceBancaire",
        endpointInterface = "fr.afcepf.atod26.projet1.groupe2"
                + ".wsgestionpaiement.service.IUser"
)
@Service
public class UserService implements IUser {
    /**
     * le user.
     */
    private DTOUser user;
    /**
     * dtoCompte.
     */
    private DTOCompte dtoCompte;
    /**
     * dtoOperation.
     */
    private List<DTOOperation> dtoOperationList;

    /**
     * le logger.
     */
    private Logger log = Logger.getLogger(UserService.class);

    /**
     * le data.
     */
    private IDaoUser daoUser;

    /**
     * le setter.
     *
     * @param paramDaoUser le setter.
     */
    @Autowired
    public void setDaoUser(IDaoUser paramDaoUser) {
        daoUser = paramDaoUser;
    }


    @Override
    public DTOUser connexion(DTOUser paramUser) throws BanqueException {
        User entity = new User();
        DTOOperation dtoOperation = new DTOOperation();
        BeanUtils.copyProperties(paramUser, entity);
        entity = daoUser.connexion(entity);
        log.info("entity apres dao : " + entity.getNumeroCarteBancaire());
        Compte compte = daoUser.getCompteByUser(entity);
        List<Operation> operationList = daoUser.getOperationByCompte(compte);
        DTOUser dto = new DTOUser();
        dtoCompte = new DTOCompte();
        dtoOperationList = new ArrayList<>();
        entity.setCompteList(null);
        BeanUtils.copyProperties(entity, dto);
        BeanUtils.copyProperties(compte, dtoCompte);
        for (Operation operation : operationList) {
            BeanUtils.copyProperties(operation, dtoOperation);
            dtoOperationList.add(dtoOperation);
        }
        user = dto;
        return dto;
    }

    @Override
    public int envoieMailCheckCode() {
        return 0;
    }

    @Override
    public double debit(double paramMontant,
                        DTOUser paramUser)
            throws BanqueException {
        connexion(paramUser);
        Compte entity = new Compte();
        BeanUtils.copyProperties(dtoCompte, entity);
        if (verifierSoldeCompte(paramMontant,
                dtoCompte)) {
            daoUser.debit(paramMontant, entity);
        } else {
            throw new BanqueException("debit trop eleve",
                    BanqueException.ErrorCode.DEBIT_TROP_ELEVE);
        }
        return paramMontant;
    }

    @Override
    public double credit(double paramMontant, DTOUser paramUser)
            throws BanqueException {
        connexion(paramUser);
        Compte entity = new Compte();
        BeanUtils.copyProperties(dtoCompte, entity);
        daoUser.credit(paramMontant, entity);
        return paramMontant;
    }


    @Override
    public boolean checkCodeSecurity(int paramCode) {
        return false;
    }

    @Override
    public boolean verifierSoldeCompte(double paramMontant,
                                       DTOCompte paramCompte)
            throws BanqueException {
        Compte entity = new Compte();
        BeanUtils.copyProperties(paramCompte, entity);
        return daoUser.verifierSoldeCompte(paramMontant, entity);
    }

    @Override
    public boolean premiereVerification(DTOUser paramUser,
                                        double paramMontant)
            throws BanqueException {
        connexion(paramUser);
        if (verifierSoldeCompte(paramMontant,
                dtoCompte)) {
            return true;
        } else {
            throw new BanqueException("solde non approvisionné",
                    BanqueException.ErrorCode.DEBIT_TROP_ELEVE);
        }
    }
}
