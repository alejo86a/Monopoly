package monopoly.evenements;

import monopoly.jeu.Game;
import monopoly.jeu.Joueur;
import monopoly.proprietes.Propriete;

public class FraisImmo extends AbstractEvent
{
	private int[] sommes;
	
	/**
	 * Crée l'évènement qui va engendrer les frais immobiliers
	 * @param nom
	 * @param cible
	 */
	public FraisImmo(String nom, Joueur cible)
    {
		super(nom, cible);
	}
	
	/**
	 * Crée l'évènement qui va engendrer les frais immobiliers
	 * @param nom
	 * @param sommes
	 */
	public FraisImmo(String nom, int[] sommes)
    {
		super(nom);
		this.sommes = sommes;
	}
	
	/** Met le joueur en paramètre en tant que cible de l'évènement
     */
	public void setJoueur(Joueur j)
	{
		this.cible = j;
	}

	/**
	 * Ajoute à la pile d'évènements de la cible une somme correspondantes aux maisons qu'il possède.
	 */
	public void executer()
	{
		int sommeADebourser = 0;
		for (Propriete p : this.cible.titres())
		{
			if (p.niveauImmobilier() == 5)
			{
				sommeADebourser += this.sommes[1];
			}
			else
			{
				sommeADebourser += this.sommes[0] * p.niveauImmobilier();
			}
		}
		
		new Depense(this.nom, this.cible, sommeADebourser).executer();
	}
	
	/**
	 * @return le nom du joueur
	 */
	public String toString()
	{
		return this.nom;
	}
}