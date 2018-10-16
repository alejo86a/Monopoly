package monopoly.evenements ;

import monopoly.jeu.Joueur ;
import monopoly.jeu.Case ;
import monopoly.proprietes.Propriete;

public class PayerLoyer extends AbstractEvent
{
    private Propriete prop;
    
    /**
     * Evènement créé lorsqu'un joueur cible doit payer un loyer.
     * @param prop
     * @param nom
     * @param cible
     */
    public PayerLoyer(Propriete prop, String nom, Joueur cible)
    {
	super(nom, cible);
	this.prop = prop;
    }
    
    /**
     * Si la cible n'est pas le propriétaire de la case sur laquelle il est (et qu'il y a un propriétaire), alors un évènement Dépense est créé et ajouté à la pile d'évènement de la cible
     */
    public void executer()
    {
    	if (!this.cible.nom().equals(this.prop.proprietaire().nom()))
    	{
    		new Depense("Verser loyer", this.cible, this.prop.loyer()).executer();
    		if (!this.cible.elimine())
    		{
    			new Recette("Percevoir loyer", this.prop.proprietaire(), this.prop.loyer()).executer();
    		}
    	}
    }
}