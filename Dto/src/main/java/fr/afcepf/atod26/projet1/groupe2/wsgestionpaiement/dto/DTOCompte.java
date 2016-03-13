package fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.dto;

import java.util.List;

/**
 * la classe du compte.
 */
public class DTOCompte {
    /**
     * identifiant du compte.
     */
    private int id;

    /**
     * liste des operations.
     */
    private List<DTOOperation> dtoOperationList;

    /**
     * user.
     */
    private DTOUser user;

    /**
     * constructeur par defaut.
     */
    public DTOCompte() {
    }

    /**
     * constructeur with params.
     *
     * @param paramId               id.
     * @param paramDtoOperationList liste.
     * @param paramUser             user.
     */
    public DTOCompte(int paramId, List<DTOOperation> paramDtoOperationList, DTOUser paramUser) {
        id = paramId;
        dtoOperationList = paramDtoOperationList;
        user = paramUser;
    }

    /**
     * construction avec liste.
     *
     * @param paramDtoOperationList liste.
     * @param paramUser             user.
     */
    public DTOCompte(List<DTOOperation> paramDtoOperationList, DTOUser paramUser) {
        dtoOperationList = paramDtoOperationList;
        user = paramUser;
    }

    /**
     * construction avec liste.
     *
     * @param paramDtoOperationList liste.
     */
    public DTOCompte(List<DTOOperation> paramDtoOperationList) {
        dtoOperationList = paramDtoOperationList;
    }

    /**
     * le getter.
     *
     * @return le getter.
     */
    public int getId() {
        return id;
    }

    /**
     * le setter.
     *
     * @param paramId le setter.
     */
    public void setId(int paramId) {
        id = paramId;
    }

    /**
     * le getter.
     *
     * @return le getter.
     */
    public List<DTOOperation> getDtoOperationList() {
        return dtoOperationList;
    }

    /**
     * le setter.
     *
     * @param paramDtoOperationList le setter.
     */
    public void setDtoOperationList(List<DTOOperation> paramDtoOperationList) {
        dtoOperationList = paramDtoOperationList;
    }

    /**
     * le getter.
     *
     * @return le getter.
     */
    public DTOUser getUser() {
        return user;
    }

    /**
     * le setter.
     *
     * @param paramUser le setter.
     */
    public void setUser(DTOUser paramUser) {
        user = paramUser;
    }
}
