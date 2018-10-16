package monopoly.proprietes;

import monopoly.evenements.TirerDes;
import monopoly.jeu.Joueur;
import monopoly.jeu.Case;

public class Compagnie extends Monopole
{
	/**
	 * Crée une nouvelle compagnie
	 * @param nom
	 * @param pos
	 * @param prix
	 * @param groupe
	 * @param loyer
	 */
    public Compagnie(String nom, Case pos, int prix, Groupe groupe, int[] loyer)
    {
		super(nom, pos, prix, groupe, loyer);
	}
    
    /**
     * Crée une nouvelle compagnie
     * @param nom
     * @param prix
     * @param groupe
     * @param loyer
     */
    public Compagnie(String nom, int prix, Groupe groupe, int[] loyer)
    {
		super(nom, prix, groupe, loyer);
	}

    /**
     * Retourne le loyer
     */
	public int loyer()
    {
		int loyer = 400;
		Joueur prop = this.proprietaire();
		int nb = 0;
		for (Propriete p : this.groupe().composition())
		{
			if (p.proprietaire() != null)
			{
				if (p.proprietaire().nom().equals(prop) && !p.hypotheque())
				{
					nb++;
				}
			}
		}
		
		if (nb == 2)
			loyer = 1000;
		
		return loyer * TirerDes.DERNIER_LANCER;
    }
}