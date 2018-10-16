package monopoly.proprietes;

import monopoly.jeu.Joueur;
import monopoly.jeu.Case;

public abstract class Monopole extends UnePropriete
{
	/**
	 * Crée un nouveau monopole tel qu'une gare ou une compagnie
	 * @param nom
	 * @param pos
	 * @param prix
	 * @param groupe
	 * @param loyer
	 */
	public Monopole(String nom, Case pos, int prix, Groupe groupe, int[] loyer)
    {
		super(nom, pos, prix, groupe, loyer);
	}
	
	/**
	 * Crée un nouveau monopole tel qu'une gare ou une compagnie
	 * @param nom
	 * @param prix
	 * @param groupe
	 * @param loyer
	 */
	public Monopole(String nom, int prix, Groupe groupe, int[] loyer)
    {
		super(nom, prix, groupe, loyer);
	}

	/**
	 * Indique si il est possible de construire une maison
	 * @return false
	 */
	public boolean constructible()
	{
	return false;
    }

	/** Construit un bâtiment sur cette propriété si c'est possible
     * (cf. règles de constructibilité et liquidités du joueur).
     * @return true si la construction a pu être réalisée, false
     * sinon */
    public boolean construire()
    {
	return false;
    }
    
    /** Détruit un bâtiment sur cette propriété si c'est possible (et
     * reverse alors au joueur la moitié du prix d'achat des
     * bâtiments) 
     * @return true si un bâtiment a été détruit, false sinon */
    public boolean detruire()
    {
	return false;
    }
    
    /** Retourne le loyer du monopole **/
    public abstract int loyer();
}