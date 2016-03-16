package fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.data;

import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.entities.*;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.exception.BanqueException;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * class dao.
 */
@Service
public class DaoUser implements IDaoUser {
    /**
     * libelle de l'operation.
     */
    private String libelle;
    /**
     * logger pour les logs.
     */
    private Logger log = Logger.getLogger(DaoUser.class);

    /**
     * mon {@link HibernateTemplate}.
     */
    private HibernateTemplate hibernateTemplate;

    /**
     * Le setter.
     *
     * @param paramSessionFactory Le setter.
     */
    @Autowired
    public void setHibernateTemplate(SessionFactory paramSessionFactory) {
        hibernateTemplate = new HibernateTemplate(paramSessionFactory);
    }

    @Override
    @Transactional
    public User connexion(User paramUser) throws BanqueException {
        log.info("user : " + paramUser.getNumeroCarteBancaire());
        log.info("user : " + paramUser.getCryptogramme());
        User user;
        String query =
                "SELECT u FROM User u "
                        + "WHERE u.numeroCarteBancaire = :paramCarte "
                        + "AND u.cryptogramme= :paramCrypto";
        String[] noms = {"paramCarte", "paramCrypto"};
        Object[] valeurs =
                {paramUser.getNumeroCarteBancaire(),
                        paramUser.getCryptogramme()};
        List<User> userList = (List) hibernateTemplate
                .findByNamedParam(query, noms, valeurs);
        if (userList.size() == 1) {
            user = userList.get(0);
            log.info("le user DAO :" + user.getNumeroCarteBancaire());
            return user;
        } else {
            throw new BanqueException("Probleme de connexion !",
                    BanqueException.ErrorCode.CONNEXION_FAILED);
        }
    }

    @Override
    @Transactional
    public int envoieMailCheckCode() {
        return 0;
    }

    @Override
    @Transactional
    public double debit(double paramMontant, Compte paramCompte)
            throws BanqueException {
        libelle = "debit";
        Operation debit = new Debit(paramMontant,
                libelle, new Date(), paramCompte);
        hibernateTemplate.save(debit);
        return paramMontant;
    }

    @Override
    @Transactional
    public double credit(double paramMontant, Compte paramCompte)
            throws BanqueException {
        libelle = "credit";
        Operation credit = new Credit(paramMontant,
                libelle,
                new Date(),
                paramCompte);
        hibernateTemplate.save(credit);
        return paramMontant;
    }

    @Override
    @Transactional
    public boolean checkCodeSecurity(int paramCode)
            throws BanqueException {
        return false;
    }

    @Override
    @Transactional
    public Compte getCompteByUser(User paramUser) {
        log.info("idUser du getCompteDao : " + paramUser.getId());
        String[] noms = {"pUser"};
        Object[] valeurs = {paramUser.getId()};
        List<Compte> compteList = (List) hibernateTemplate.findByNamedParam(
                "SELECT c FROM Compte c WHERE c.user.id = :pUser", noms,
                valeurs);
        return compteList.get(0);
    }

    @Override
    @Transactional
    public List<Operation> getOperationByCompte(Compte paramCompte) {
        String[] noms = {"pCompte"};
        Object[] valeurs = {paramCompte.getId()};
        return (List) hibernateTemplate.findByNamedParam(
                "SELECT o FROM Operation o WHERE o.compte.id = :pCompte", noms,
                valeurs);
    }

    @Override
    @Transactional
    public boolean verifierSoldeCompte(double paramMontant, Compte paramCompte)
            throws BanqueException {
        double soldeTotal = 0;
        log.info("le compte :"+paramCompte.getId());
        log.info("le montant :"+paramMontant);
        List<Operation> operationList = getOperationByCompte(paramCompte);
        for (Operation operation : operationList) {
            if (operation.getClass().equals(Credit.class)) {
                soldeTotal += operation.getMontant();
            } else {
                soldeTotal -= operation.getMontant();
            }
            log.info("le solde : " + soldeTotal);
        }
        log.info("le solde total: " + soldeTotal);
        return soldeTotal >= paramMontant;
    }
}
