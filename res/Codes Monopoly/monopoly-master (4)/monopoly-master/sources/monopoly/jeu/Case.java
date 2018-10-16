package monopoly.jeu ;
import monopoly.proprietes.Propriete ;
import monopoly.evenements.Evenement ;

/** Cette interface décrit une case du plateau de jeu du Monopoly */
public interface Case {
    /** Numéro de la case */
    int numero() ;
    /** Donne la case associée au numéro spécifié */
    Case get(int numero) ;
    /** Intitulé de la case */
    String nom() ;
    /** Titre de propriété associé à la case (éventuellement
     * <code>null</code>)*/
    Propriete propriete() ;
    /** Événément susceptible de se déclencher à l'arrivée sur cette
     * case (éventuellement <code>null</code>) */
    Evenement evenement() ;
    /**
     * Place une propriété sur la Case
     * @param p La nouvelle propriete
     */
    void setProp(Propriete p);
    /**
     * Place un évènement sur la Case
     * @param e Le nouvel evenement
     */
    void setEvent(Evenement e);
}