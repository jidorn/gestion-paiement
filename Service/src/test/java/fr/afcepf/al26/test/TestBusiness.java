package fr.afcepf.al26.test;

import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.data.IDaoUser;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.dto.DTOCompte;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.dto.DTOCredit;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.dto.DTOOperation;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.dto.DTOUser;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.entities.*;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.exception.BanqueException;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.service.IUser;
import fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.service.UserService;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Stagiaire on 03/03/2016.
 */
public class TestBusiness {
    private static IUser service;
    private static IDaoUser mockData;
    private static User pasBonUser;
    private static User retourConnexionBonne;
    private static DTOUser pasBonUserDTO;
    private static DTOUser retourConnexionBonneDTO;
    private static  int numeroCarte = 123456789;
    private static  int moisExpi = 11;
    private static  int anneeExpi = 15;
    private static  int crypto = 456;
    private static  int mauvaisCrypto = 852;
    private static  int identifiantCredit = 1;
    private static  int identifiantDebit = 2;
    private static  double montantCredit = 565;
    private static  double montantDebit = 135;
    private static  String libelleCredit = "credit";
    private static  String libelleDebit = "debit";
    private static Compte compte;
    private static DTOCompte dtoCompte;
    private static Operation operation;
    private static DTOOperation dtoOperation;
    private static List<Compte> compteList = new ArrayList<>();
    private static List<Operation> operationList = new ArrayList<>();
    private static List<DTOCompte> dtoCompteList = new ArrayList<>();
    private static List<DTOOperation> dtoOperationList = new ArrayList<>();

    @BeforeClass
    public static void init(){
        operation = new Credit(identifiantCredit, montantCredit, libelleCredit, new Date());
        dtoOperation = new DTOCredit(identifiantCredit, montantCredit, libelleCredit, new Date());
        operationList.add(operation);
        dtoOperationList.add(dtoOperation);
        operation = new Debit(identifiantDebit, montantDebit, libelleDebit, new Date());
        dtoOperation = new DTOCredit(identifiantDebit, montantDebit, libelleDebit, new Date());
        dtoOperationList.add(dtoOperation);
        operationList.add(operation);
        pasBonUser = new User(numeroCarte, moisExpi, anneeExpi, mauvaisCrypto, compteList);
        retourConnexionBonne = new User(numeroCarte, moisExpi, anneeExpi, crypto, compteList);
        pasBonUserDTO = new DTOUser(numeroCarte,moisExpi,anneeExpi,mauvaisCrypto);
        retourConnexionBonneDTO = new DTOUser(numeroCarte,moisExpi,anneeExpi,crypto);
        compte = new Compte(operationList, retourConnexionBonne);
        dtoCompte = new DTOCompte(dtoOperationList,retourConnexionBonneDTO);
        compteList.add(compte);
        dtoCompteList.add(dtoCompte);
        service = new UserService();
        mockData = EasyMock.createMock(IDaoUser.class);
        try {
            EasyMock.expect(mockData.connexion(retourConnexionBonne))
                    .andReturn(retourConnexionBonne);
            EasyMock.expect(mockData.connexion(pasBonUser))
                    .andThrow(new BanqueException(BanqueException.ErrorCode.CONNEXION_FAILED));
            ((UserService) service).setDaoUser(mockData);
            EasyMock.replay(mockData);
        } catch (BanqueException paramE) {
            paramE.printStackTrace();
        }
    }
/*
    @Test
    public void testConnexionNominale(){
        try {
            DTOUser retour = service.connexion(retourConnexionBonneDTO);
            Assert.assertNotNull(retour);
            Assert.assertEquals(retourConnexionBonneDTO.getId(),retour.getId());
            Assert.assertEquals(retourConnexionBonneDTO.getNumeroCarteBancaire(),retour.getNumeroCarteBancaire());
            Assert.assertEquals(retourConnexionBonneDTO.getDateExpirationMois(),retour.getDateExpirationMois());
            Assert.assertEquals(retourConnexionBonneDTO.getDateExpirationAnnee(),retour.getDateExpirationAnnee());
            Assert.assertEquals(retourConnexionBonneDTO.getCryptogramme(),retour.getCryptogramme());
        } catch (BanqueException paramE) {
            Assert.fail("erreur qui ne devrait pas arrive car cas nominal : " + paramE.getMessage());
        }
    }

    @Test(expected = BanqueException.class)
    public void testConnexionException()
            throws BanqueException{
        service.connexion(pasBonUserDTO);
    }
    */
}
