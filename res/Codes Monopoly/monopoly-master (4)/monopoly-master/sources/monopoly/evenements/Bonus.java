package monopoly.evenements;

import monopoly.jeu.Game;
import monopoly.jeu.Joueur;

public class Bonus extends AbstractEvent
{
	public Bonus(String nom, Joueur cible)
    {
		super(nom, cible);
	}
	
	public void setJoueur(Joueur j)
	{
		this.cible = j;
	}

	public void executer()
	{
		
	}
	
	public String toString()
	{
		return this.nom;
	}
}