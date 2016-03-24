package fr.afcepf.al26.mock;

import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.data.IDaoUser;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.entities.Compte;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.entities.Operation;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.entities.User;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.exception.BanqueException;

import java.util.List;

/**
 * Created by alexandrequere on 24/03/2016.
 */
public class DaoMock implements IDaoUser {
    @Override
    public User connexion(User paramUser) throws BanqueException {
        return null;
    }

    @Override
    public int envoieMailCheckCode() {
        return 0;
    }

    @Override
    public double debit(double paramMontant, Compte paramCompte) throws BanqueException {
        return 0;
    }

    @Override
    public double credit(double paramMontant, Compte paramCompte) throws BanqueException {
        return 0;
    }

    @Override
    public boolean checkCodeSecurity(int paramCode) throws BanqueException {
        return false;
    }

    @Override
    public Compte getCompteByUser(User paramUser) {
        return null;
    }

    @Override
    public List<Operation> getOperationByCompte(Compte paramCompte) {
        return null;
    }

    @Override
    public boolean verifierSoldeCompte(double paramMontant, Compte paramCompte) throws BanqueException {
        return false;
    }
}
