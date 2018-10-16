package monopoly.proprietes;

import monopoly.jeu.Joueur;
import monopoly.jeu.Case;

public class Gare extends Monopole
{
	/** Le loyer de base **/
	public static int LOYER_BASE = 2500;
	
	/**
	 * Crée une nouvelle gare
	 * @param nom
	 * @param pos
	 * @param prix
	 * @param groupe
	 * @param loyer
	 */
    public Gare(String nom, Case pos, int prix, Groupe groupe, int[] loyer)
    {
		super(nom, pos, prix, groupe, loyer);
	}
    
    /**
     * Crée une nouvelle gare
     * @param nom
     * @param prix
     * @param groupe
     * @param loyer
     */
    public Gare(String nom, int prix, Groupe groupe, int[] loyer)
    {
		super(nom, prix, groupe, loyer);
	}
    
    /**
     * Retourne le loyer de la gare. Il varie en fonction du nombre de gare possédées par le propriétaire
     */
	public int loyer()
	{
		int loyer = Gare.LOYER_BASE;
		Joueur prop = this.proprietaire();
		int nb = 0;
		for (Propriete p : this.groupe().composition())
		{
			if (p.proprietaire() != null)
			{
				if (p.proprietaire().nom().equals(prop.nom()) && !p.hypotheque())
				{
					nb++;
				}
			}
		}
		for (int i = 2 ; i <= nb ; i++)
			loyer *= 2;
		
		return loyer;
    }
}