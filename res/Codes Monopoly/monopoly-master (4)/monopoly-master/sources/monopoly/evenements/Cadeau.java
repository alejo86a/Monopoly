package monopoly.evenements;

import monopoly.jeu.Game;
import monopoly.jeu.Joueur;

public class Cadeau extends AbstractEvent
{
	private int somme;
	
	/** Constructeur de la classe Cadeau
	 * 
	 * @param nom Le nom du cadeau
	 * @param cible Le joueur qui se verra offrir un cadeau
	 */
	public Cadeau(String nom, Joueur cible)
    {
		super(nom, cible);
	}
	
	/** Constructeur de la classe Cadeau
	 * 
	 * @param nom Le nom du cadeau
	 * @param somme La somme que le joueur va toucher
	 */
	public Cadeau(String nom, int somme)
    {
		super(nom);
		this.somme = somme;
	}
	
	/** Définit la cible de l'évènement
     * @param Joueur j Le joueur qui sera la cible de l'évènement
     */
	public void setJoueur(Joueur j)
	{
		this.cible = j;
	}

	/** L'éexecution d'un cadeau : Chaque adversaire encore en lice devra verser à la cible la somme associée à l'évènement.*/
	public void executer()
	{
		for (Joueur j : this.cible.adversaires())
		{
			new Depense(this.nom, j, this.somme).executer();
			new Recette(this.nom, this.cible, this.somme).executer();
		}
	}
	
	/** Description de l'évènement
	 * @return nom Le nom de l'évènement**/
	public String toString()
	{
		return this.nom;
	}
}