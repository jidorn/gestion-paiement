package fr.afcepf.al26.test;

import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.data.IDaoUser;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.entities.*;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.exception.BanqueException;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.data.DaoUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * classe de test.
 */
public class TestData {
    private User pasBonUser;
    private User retourConnexionBonne;
    private int codeSecurityCorrect = 123;
    private int codeSecurityIncorrect = 163;
    private double debitCorrect = 234;
    private double resultatDebit = 20;
    private double debitIncorrect = 789789780;
    private final int numeroCarte = 123456789;
    private final int moisExpi = 11;
    private final int anneeExpi = 15;
    private final int crypto = 456;
    private final int mauvaisCrypto = 852;
    private final int identifiantCredit = 1;
    private final int identifiantDebit = 2;
    private final double montantCredit = 565;
    private final double montantDebit = 135;
    private final String libelleCredit = "credit";
    private final String libelleDebit = "cebit";
    private Compte compte;
    private Operation operation;
    private List<Compte> compteList = new ArrayList<>();
    private List<Operation> operationList = new ArrayList<>();
    private IDaoUser daoUser = new DaoUser();

    public TestData() {
        operation = new Credit(identifiantCredit, montantCredit, libelleCredit, new Date());
        operationList.add(operation);
        operation = new Debit(identifiantDebit, montantDebit, libelleDebit, new Date());
        operationList.add(operation);
        pasBonUser = new User(numeroCarte, moisExpi, anneeExpi, mauvaisCrypto, compteList);
        retourConnexionBonne = new User(numeroCarte, moisExpi, anneeExpi, crypto, compteList);
        compte = new Compte(operationList, retourConnexionBonne);
        compteList.add(compte);

        daoUser = new DaoUser() {
            @Override
            public User connexion(User paramUser) throws BanqueException {
                if (paramUser.getCryptogramme() == mauvaisCrypto) {
                    throw new BanqueException(BanqueException.ErrorCode.CONNEXION_FAILED);
                } else
                    return retourConnexionBonne;
            }

            @Override
            public boolean verifierSoldeCompte(double paramMontant,
                                               Compte paramCompte)
                    throws BanqueException {
                return paramMontant == debitCorrect;
            }

            @Override
            public double debit(double paramMontant,
                                Compte paramCompte)
                    throws BanqueException {
                if (verifierSoldeCompte(paramMontant, paramCompte)){
                    return resultatDebit;
                }
                else {
                    throw new BanqueException("debit trop eleve", BanqueException.ErrorCode.DEBIT_TROP_ELEVE);
                }
            }

            @Override
            public boolean checkCodeSecurity(int paramCode) throws BanqueException {
                if (paramCode == codeSecurityCorrect){
                    return true;
                }
                else {
                    throw new BanqueException("pas bon code", BanqueException.ErrorCode.MAUVAIS_CODE);
                }
            }
        };
    }

    /**
     * methode d'initialisation avant chaque test.
     * Regénération de la base de donnees pour la coherence des tests.
     */
    @Before
    public void setUp() {
        /*
        BeanFactory bf =
                new ClassPathXmlApplicationContext(
                        "classpath:springData.xml");
        IDaoUser a = (DaoUser) bf.getBean("DaoUser");
        */

        String pathDotBat = Thread.currentThread()
                .getContextClassLoader()
                .getResource("creeBase.bat")
                .getPath();//URL encode %20= espace
        try {
            Process process = Runtime.getRuntime().exec(pathDotBat);
            process.waitFor();
        } catch (IOException | InterruptedException paramE) {
            paramE.printStackTrace();
        }
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
            Assert.assertEquals(retourConnexionBonne.getNumeroCarteBancaire(), retour.getNumeroCarteBancaire());
            Assert.assertEquals(retourConnexionBonne.getDateExpirationMois(), retour.getDateExpirationMois());
            Assert.assertEquals(retourConnexionBonne.getDateExpirationAnnee(), retour.getDateExpirationAnnee());
            Assert.assertEquals(retourConnexionBonne.getCryptogramme(), retour.getCryptogramme());
            Assert.assertEquals(retourConnexionBonne.getCompteList(), retour.getCompteList());
        } catch (BanqueException paramE) {
            Assert.fail("Bien tenté mais...non : " + paramE.getMessage());
        }
    }

    @Test
    public void testVerifSoldeCompteBon(){
        try {
            boolean verif = daoUser.verifierSoldeCompte(debitCorrect, compte);
            Assert.assertNotNull(verif);
            Assert.assertTrue(verif);
        } catch (BanqueException paramE) {
            Assert.fail("Bien tenté mais...non : " + paramE.getMessage());
        }
    }

    @Test
    public void testVerifSoldeCompteMauvais(){
        try {
            boolean verif = daoUser.verifierSoldeCompte(debitIncorrect, compte);
            Assert.assertNotNull(verif);
            Assert.assertFalse(verif);
        } catch (BanqueException paramE) {
            Assert.fail("Bien tenté mais...non : " + paramE.getMessage());
        }
    }

    @Test
    public void testdebitNominal(){
        try {
            double montant = daoUser.debit(debitCorrect, compte);
            Assert.assertNotNull(montant);
            Assert.assertEquals(resultatDebit,montant, 0.1);
        } catch (BanqueException paramE) {
            Assert.fail("Bien tenté mais...non : " + paramE.getMessage());
        }
    }

    @Test(expected = BanqueException.class)
    public void testDebitException() throws BanqueException {
        daoUser.debit(debitIncorrect, compte);
    }

    @Test
    public void testCheckCodeSecurityCorrect(){
        try {
            boolean verif = daoUser.checkCodeSecurity(codeSecurityCorrect);
            Assert.assertNotNull(verif);
            Assert.assertTrue(verif);
        } catch (BanqueException paramE) {
            Assert.fail("Bien tenté mais...non : " + paramE.getMessage());
        }
    }

    @Test(expected = BanqueException.class)
    public void testCheckCodeSecurityIncorrect() throws BanqueException {
        daoUser.checkCodeSecurity(codeSecurityIncorrect);
    }

    /**
     * test en cas d'echec.
     * @throws BanqueException c'est normal.
     */
    @Test(expected = BanqueException.class)
    public void testConnexionException() throws BanqueException {
        daoUser.connexion(pasBonUser);
    }
}
