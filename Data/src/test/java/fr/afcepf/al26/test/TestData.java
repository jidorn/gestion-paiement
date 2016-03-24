package fr.afcepf.al26.test;

import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.data.IDaoUser;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.entities.*;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.exception.BanqueException;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * classe de test.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-context.xml")
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class TestData {
    private Logger log = Logger.getLogger(TestData.class);
    private User pasBonUser;
    private User retourConnexionBonne;
    //private int codeSecurityCorrect = 123;
    private int codeSecurityIncorrect = 163;
    private int identifiantUnique = 1;
    private int numeroCompte = 1;
    private double debitCorrect = 234;
    private double resultatDebit = 234;
    private double debitIncorrect = 789789780;
    private final int numeroCarte = 123456789;
    private final int moisExpi = 11;
    private final int anneeExpi = 15;
    private final int crypto = 456;
    private final int mauvaisCrypto = 852;
    private final int identifiantCredit = 1;
    private final int identifiantDebit = 2;
    private final double montantCredit = 1200;
    private final double montantDebit = 135;
    private final String libelleCredit = "salaire";
    private final String libelleDebit = "cebit";
    private Compte compte;
    private Operation operation;
    private List<Compte> compteList = new ArrayList<>();
    private List<Operation> operationList = new ArrayList<>();

    @Autowired
    private IDaoUser daoUser;

    public TestData() {
        compte = new Compte();
        compte.setId(identifiantUnique);
        User userTemp = new User();
        userTemp.setId(identifiantUnique);
        userTemp.setNumeroCarteBancaire(numeroCarte);
        userTemp.setDateExpirationMois(moisExpi);
        userTemp.setDateExpirationAnnee(anneeExpi);
        userTemp.setCryptogramme(crypto);
        operation = new Credit(identifiantCredit, montantCredit, libelleCredit, new Date(), compte);
        operationList.add(operation);
        operation = new Debit(identifiantDebit, montantDebit, libelleDebit, new Date(), compte);
        operationList.add(operation);
        compte.setOperationList(operationList);
        compte.setUser(userTemp);
        compteList.add(compte);
        userTemp.setCompteList(compteList);
        pasBonUser = new User(numeroCarte, moisExpi, anneeExpi, mauvaisCrypto, compteList);
        retourConnexionBonne = userTemp;
    }

    /**
     * fesfez.
     */
    @Test
    public void testConnexionNominale() {
        try {
            User retour = daoUser.connexion(retourConnexionBonne);
            Assert.assertNotNull(retour);
            Assert.assertNotNull(retour.getId());
            Assert.assertNotNull(retour.getCompteList());
            Assert.assertNotNull(retour.getCryptogramme());
            Assert.assertNotNull(retour.getNumeroCarteBancaire());
            Assert.assertNotNull(retour.getDateExpirationMois());
            Assert.assertNotNull(retour.getDateExpirationAnnee());
            Assert.assertEquals(retourConnexionBonne.getId(), retour.getId());
            Assert.assertEquals(retourConnexionBonne
                    .getNumeroCarteBancaire(), retour.getNumeroCarteBancaire());
            Assert.assertEquals(retourConnexionBonne
                    .getDateExpirationMois(), retour.getDateExpirationMois());
            Assert.assertEquals(retourConnexionBonne
                    .getDateExpirationAnnee(), retour.getDateExpirationAnnee());
            Assert.assertEquals(retourConnexionBonne
                    .getCryptogramme(), retour.getCryptogramme());
        } catch (BanqueException paramE) {
            Assert.fail("Bien tenté mais...non : " + paramE.getMessage());
        }
    }

    @Test
    public void testVerifSoldeCompteBon() {
        try {
            boolean verif = daoUser.verifierSoldeCompte(debitCorrect, compte);
            Assert.assertNotNull(verif);
            log.info("les verifs : " + verif);
            Assert.assertTrue(verif);
        } catch (BanqueException paramE) {
            Assert.fail("Bien tenté mais...non : " + paramE.getMessage());
        }
    }

    @Test
    public void testVerifSoldeCompteMauvais() {
        try {
            boolean verif = daoUser.verifierSoldeCompte(debitIncorrect, compte);
            Assert.assertNotNull(verif);
            Assert.assertFalse(verif);
        } catch (BanqueException paramE) {
            Assert.fail("Bien tenté mais...non : " + paramE.getMessage());
        }
    }

    @Test
    public void testdebitNominal() {
        try {
            double montant = daoUser.debit(debitCorrect, compte);
            Assert.assertNotNull(montant);
            Assert.assertEquals(resultatDebit, montant, 0.1);
        } catch (BanqueException paramE) {
            Assert.fail("Bien tenté mais...non : " + paramE.getMessage());
        }
    }
/*

    @Test
    public void testCheckCodeSecurityCorrect() {
        try {
            boolean verif = daoUser.checkCodeSecurity(codeSecurityCorrect);
            Assert.assertNotNull(verif);
            Assert.assertTrue(verif);
        } catch (BanqueException paramE) {
            Assert.fail("Bien tenté mais...non : " + paramE.getMessage());
        }
    }
*/

    @Test
    public void testCheckCodeSecurityIncorrect() throws BanqueException {
        try {
            boolean verif = daoUser.checkCodeSecurity(codeSecurityIncorrect);
            Assert.assertNotNull(verif);
            Assert.assertFalse(verif);
        } catch (BanqueException paramE) {
            Assert.fail("Bien tenté mais...non : " + paramE.getMessage());
        }
    }

    /**
     * test en cas d'echec.
     *
     * @throws BanqueException c'est normal.
     */
    @Test(expected = BanqueException.class)
    public void testConnexionException() throws BanqueException {
        daoUser.connexion(pasBonUser);
    }
}
