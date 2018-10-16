package monopoly.evenements ;

import monopoly.jeu.*;
import java.util.*;

public class Liberer extends AbstractEvent
{
	/**
	 * Crée l'évènement de libération d'un joueur
	 * @param nom
	 * @param cible
	 */
	public Liberer(String nom, Joueur cible)
    {
		super(nom, cible);
	}
	
	/**
	 * Crée l'évènement de libération d'un joueur
	 * @param nom
	 */
	public Liberer(String nom)
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
	 * Libère le joueur cible
	 */
	public void executer()
	{
		this.cible.liberer();
	}
	
	/**
	 * @return Le nom de la cible
	 */
	public String toString()
	{
		return this.nom;
	}
}