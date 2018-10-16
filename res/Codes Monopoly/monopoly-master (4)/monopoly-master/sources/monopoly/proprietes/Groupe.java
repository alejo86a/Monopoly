package monopoly.proprietes ;

import java.util.*;

/** Cette interface décrit les fonctionnalités associées à un groupe
 * de propriétés */
public interface Groupe {
    /** L'intitulé du groupe */
    String nom() ;
    /** Le prix des constructions pour ce groupe */
    int coutImmo() ;
    /** La liste des propriétés qui le composent */
    List<Propriete> composition() ;
    /** Retourne le groupe dont le nom est spécifié */
    Groupe get(String nom) ;
    /** Indique si le groupe appartient entièrement à un seul joueur */
    boolean proprietaireUnique() ;
}
