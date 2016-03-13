package fr.afcepf.atod26.projet1.groupe2.wsgestionpaiement.exception;

/**
 * classe exception.
 */
public class BanqueException extends Exception {

    /**
     * version pour la sérialisation.
     * car la classe {@link Exception} implement.
     * {@link java.io.Serializable}.
     */
    private static final long serialVersionUID = 1L;

    /**
     * code de l'exception.
     */
    private ErrorCode codeErreur = ErrorCode.CA_MARCHE_PAS;

    /**
     * Constructeur d'erreur avec juste le message.
     * @param paramCodeErreur le {@link ErrorCode} de l'{@link Exception}
     */
    public BanqueException(ErrorCode paramCodeErreur) {
        codeErreur = paramCodeErreur;
    }

    /**
     * Constructeur d'erreur avec le code et le message.
     * @param message le message.
     * @param paramCodeErreur le {@link ErrorCode} de l'{@link Exception}
     */
    public BanqueException(String message, ErrorCode paramCodeErreur) {
        super(message);
        codeErreur = paramCodeErreur;
    }

    /**
     * Liste des codes d'erreurs de l'application.
     */
    public enum ErrorCode {

        /**
         * erreur generique.
         */
        CA_MARCHE_PAS,
        /**
         * Erreur lors de la connexion a echoué.
         */
        CONNEXION_FAILED,
        /**
         * debit trop eleve.
         */
        DEBIT_TROP_ELEVE,

        /**
         * mauvais code securite
         */
        MAUVAIS_CODE
    }
}
