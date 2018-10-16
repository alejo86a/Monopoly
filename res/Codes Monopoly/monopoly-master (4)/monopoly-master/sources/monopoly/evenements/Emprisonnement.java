package monopoly.evenements ;

import monopoly.jeu.*;
import java.util.*;

public class Emprisonnement extends AbstractEvent
{
	/**
	 * Cette HashMap associe un Integer qui représente un nombre de tour à un joueur en prison.
	 */
	public static HashMap<Joueur, Integer> TAB_PRISON = new HashMap<Joueur, Integer>();
	
	/**
	 * Crée l'évènement qui mettra un joueur cible en prison
	 * @param nom
	 * @param cible
	 */
	public Emprisonnement(String nom, Joueur cible)
    {
		super(nom, cible);
	}
	
	/**
	 * Crée l'évènement qui mettra un joueur cible en prison
	 * @param nom
	 * @param cible
	 */
	public Emprisonnement(String nom)
    {
		super(nom);
	}
	
	/** Met le joueur en paramètre en tant que cible de l'évènement
     */
	public void setJoueur(Joueur j)
	{
		this.cible = j;
	}

	/**
	 * Emprisonne la cible
	 */
	public void executer()
	{
		this.cible.emprisonner();
		this.cible.placerSur(Game.PRISON);
		this.cible.chosesAFaire().clear();
	}
	
	/**
	 * @return Le nom de la cible
	 */
	public String toString()
	{
		return this.nom;
	}
}