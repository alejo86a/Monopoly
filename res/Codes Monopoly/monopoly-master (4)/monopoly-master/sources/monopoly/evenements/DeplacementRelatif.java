package monopoly.evenements;

import java.util.*;

import monopoly.jeu.*;

public class DeplacementRelatif extends AbstractEvent
{
	private int changement;
	private List<Case> lesCases;
	
	/**
	 * Créé un évènement de déplacement relatif
	 * @param nom
	 * @param changement
	 * @param lesCases
	 * @param g
	 */
	public DeplacementRelatif(String nom, int changement, List<Case> lesCases, Game g)
	{
		super(nom);
		this.lesCases = g.lesCases();
		this.changement = changement;
	}
	
	/**
	 * Créé un évènement de déplacement relatif
	 * @param nom
	 * @param cible
	 * @param changement
	 * @param lesCases
	 * @param g
	 */
	public DeplacementRelatif(String nom, Joueur cible, int changement, List<Case> lesCases, Game g)
	{
		super(nom, cible);
		this.lesCases = g.lesCases();
		this.changement = changement;
	}

	/**
	 * Execute l'évènement sur le joueur cible. Si il passe par la case départ, on push l'évènement de cette case dans la stack d'évènement du joueur cible
	 */
	public void executer()
	{
		int indexActuel = this.cible.position().numero();
	    int dep = this.changement;
	    int indexCible = 0;
	    int taille = this.lesCases.size();
	    boolean depart = false;
	    if (indexActuel + dep < 1)
	    {
	    	for (int i = indexActuel ; i > 0 ; i--)
	    	{
	    		dep++;
	    	}
	    	indexCible = taille + dep;
	    }
	    else if (indexActuel + dep > taille)
	    {
	    	for (int i = indexActuel ; i < taille ; i++)
	    	{
	    		dep--;
	    	}
	    	Game.DEPART.evenement().setCible(this.cible);
	    	depart = true;
	    	indexCible = dep;
	    }
	    else
	    {
	    	indexCible = indexActuel + dep;
	    }
	    this.cible.chosesAFaire().push(new Deplacement(this.nom, this.cible, this.lesCases.get(indexCible - 1)));
	    if (depart)
	    {
	    	this.cible.chosesAFaire().push(Game.DEPART.evenement());
	    }
	}
	
	/** Met le joueur en paramètre en tant que cible de l'évènement
     */
	public void setCible(Joueur j)
	{
		this.cible = j;
	}
	
	/** Retourne le nom du joueur
	 * @return Le nom du joueur cible
	 */
	public String toString()
	{
		return this.nom;
	}
}