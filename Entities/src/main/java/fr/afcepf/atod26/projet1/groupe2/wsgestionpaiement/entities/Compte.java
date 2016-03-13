package fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.entities;

import javax.persistence.*;
import java.util.List;

/**
 * classe du compte.
 */
@Entity
@Table(name = "compte_utilisateur")
public class Compte {
    /**
     * identifiant du compte.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_compte")
    private int id;

    /**
     * liste des operations.
     */
    @OneToMany(mappedBy = "compte")
    private List<Operation> operationList;

    /**
     * le user.
     */
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    /**
     * constructeur par defaut.
     */
    public Compte() {
    }

    /**
     * constructeur with params.
     *
     * @param paramOperationList liste.
     * @param paramUser          user.
     */
    public Compte(List<Operation> paramOperationList, User paramUser) {
        operationList = paramOperationList;
        user = paramUser;
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
    public List<Operation> getOperationList() {
        return operationList;
    }

    /**
     * le setter.
     *
     * @param paramOperationList le setter.
     */
    public void setOperationList(List<Operation> paramOperationList) {
        operationList = paramOperationList;
    }

    /**
     * le getter.
     *
     * @return le getter.
     */
    public User getUser() {
        return user;
    }

    /**
     * le setter.
     *
     * @param paramUser le setter.
     */
    public void setUser(User paramUser) {
        user = paramUser;
    }
}
