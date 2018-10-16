package monopoly.evenements ;

import monopoly.jeu.Joueur ;
import monopoly.jeu.Case ;

/** Cette interface décrit les fonctionnalités associées aux
 * événements du jeu */
public interface Evenement {
    /** Intitulé de l'événement (i.e. en principe de la case associée
     * ou de la carte) */
    String nom() ;
    /** Le joueur qui subit l'événement */
    Joueur cible() ;    
    /** Action à effectuer **/
    void executer();
    /** Définit le joueur qui est concerné par l'évènement **/
    void setCible(Joueur j);
    /** Retourne le type d'évènement **/
    String type();
}
