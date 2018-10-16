package monopoly.proprietes ;

import monopoly.jeu.Joueur ;
import monopoly.jeu.Case ;

/** Cette interface décrit les fonctionnalités associées à tout titre
 * de propriété */
public interface Propriete {
    /** La case du plateau de jeu associée à ce titre de propriété */
    Case position() ;
    /** Nom de la propriété (le même que la case en principe) */
    String nom() ;
    /** Indique si la propriété est hypothéquée */
    boolean hypotheque() ;
    /** Hypothèque la propriété (en procurant ainsi des liquidités au
     * propriétaire pour une valeur moitié du prix d'achat) */
    void hypothequer() ;
    /** Lève l'hypothèque (si le joueur possède les liquidités
     * suffisantes soit la valeur hypothécaire + 10%)
     * @return true si l'hypothèque est levée, false sinon */
    boolean deshypothequer() ;
    /** Prix d'achat */
    int prixAchat() ;    
    /** Le groupe auquel est rattachée la propriété */
    Groupe groupe() ;
    /** Indique si la propriété est constructible */
    boolean constructible() ;
    /** Construit un bâtiment sur cette propriété si c'est possible
     * (cf. règles de constructibilité et liquidités du joueur).
     * @return true si la construction a pu être réalisée, false
     * sinon */
    boolean construire() ;
    /** Détruit un bâtiment sur cette propriété si c'est possible (et
     * reverse alors au joueur la moitié du prix d'achat des
     * bâtiments) 
     * @return true si un bâtiment a été détruit, false sinon */
    boolean detruire() ;
    /** Propriétaire du titre (éventuellement <code>null</code>) */
    Joueur proprietaire() ;
    /** Montant du loyer à percevoir */
    int loyer() ;
    /** Niveau des constructions (0 = terrain nu, 1 à 4 = nb de
     * maisons, 5 = hôtel)  */
    int niveauImmobilier() ;
    /** Met en tant que propriétaire le Joueur j en paramètre **/
    void setProprietaire(Joueur j);
}
