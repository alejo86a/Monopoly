package monopoly.jeu ;

import java.util.List ;
import java.util.Stack ;

import monopoly.proprietes.Propriete ;
import monopoly.evenements.Evenement ;

/** Cette interface décrit les fonctionnalités que doit présenter une
 * classe représentant un joueur de Monopoly */
public interface Joueur {
    /** Le numéro du joueur */
    int numero() ;
    /** Le nom du joueur */
    String nom() ;
    /** Indique si le joueur est emprisonné */
    boolean enPrison() ;
    /** Emprisonne le joueur */
    void emprisonner() ;
    /** Libere le joueur */
    void liberer();
    /** Indique si le joueur est éliminé */
    boolean elimine() ;
    /** Élimine le joueur */
    void eliminer() ;
    /** Liquidités possédées par le joueur */
    int especes() ;
    /** Impose au joueur le paiement de la somme spécifiée
     * @return true si le joueur a pu payer, false sinon
     */
    boolean payer(int somme) ;
    /** Verse au joueur la somme spécifier */
    void verser(int somme) ;
    /** Donne la case sur laquelle le joueur est placé */
    Case position() ;
    /** Place le joueur sur la case spécifiée */
    void placerSur(Case c) ;
    /** Donne la liste des autres joueurs encore en lice (tous sauf
     * <code>this</code> et les éliminés)*/
    List<Joueur> adversaires() ;
    /** Titres de propriétés possédés par le joueur */
    List<Propriete> titres() ;
    /** Cartes conservées par le joueur */
    List<Evenement> cartes() ;
    /** La pile d'événements que le joueur doit subir pendant son tour
     * de jeu : si la pile est vide, le joueur a terminé son tour ; sinon il doit
     * dépiler un événement pour l'exécuter. Il peut arriver qu'un événement manipule
     * cette pile (par exemple "Aller en prison" termine le tour du joueur même s'il lui
     * restait théoriquement des choses à faire) */
    Stack<Evenement> chosesAFaire() ;
}
