package monopoly.jeu;

import monopoly.proprietes.Propriete ;
import monopoly.evenements.Evenement ;

public class MonoCase implements Case
{
    private int num;
    private String nom;
    private Propriete prop;
    private Evenement event;
    private Game g;
    
    /**
     * Crée une case
     * @param num
     * @param nom
     * @param prop
     * @param event
     * @param g
     */
    public MonoCase(int num, String nom, Propriete prop, Evenement event, Game g)
    {
	this.num = num;
	this.nom = nom;
	this.prop = prop;
	this.event = event;
	this.g = g;
    }
    
    /**
     * Crée une case
     * @param num
     * @param nom
     * @param g
     */
    public MonoCase(int num, String nom, Game g)
    {
	this.num = num;
	this.nom = nom;
	this.prop = null;
	this.event = null;
	this.g = g;
    }
    
    /**
     * Crée une case
     * @param num
     * @param nom
     * @param prop
     * @param g
     */
    public MonoCase(int num, String nom, Propriete prop, Game g)
    {
	this.num = num;
	this.nom = nom;
	this.prop = prop;
	this.event = null;
	this.g = g;
    }
    
    /**
     * Crée une case
     * @param num
     * @param nom
     * @param event
     */
    public MonoCase(int num, String nom, Evenement event)
    {
	this.num = num;
	this.nom = nom;
	this.prop = null;
	this.event = event;
    }
    
    /** Numéro de la case */
    public int numero()
    {
	return this.num;
    }
    
    /** Donne la case associée au numéro spécifié */
    public Case get(int numero)
    {
    	Case dest = null;
    	for (Case c : this.g.lesCases())
    	{
    		if (c.numero() == numero)
    			dest = c;
    	}
    	return dest;
    }
    
    /** Intitulé de la case */
    public String nom()
    {
	return this.nom;
    }
    
    /** Titre de propriété associé à la case (éventuellement
     * <code>null</code>)*/
    public Propriete propriete()
    {
	return this.prop;
    }
    
    /** Événément susceptible de se déclencher à l'arrivée sur cette
     * case (éventuellement <code>null</code>) */
    public Evenement evenement()
    {
	return this.event;
    }
    
    /**
     * Place une nouvelle propriété sur la case
     */
    public void setProp(Propriete p)
    {
	this.prop = p;
    }
    
    /**
     * Place un  nouvel évènement sur la case
     */
    public void setEvent(Evenement e)
    {
	this.event = e;
    }
    
    /**
     * Description de la case
     */
    public String toString()
    {
    	String carac = "Numero de la case : "+this.num+"\nNom de la case : "+this.nom+"\nEvenement : "+this.event+"\n";
    	if (this.prop != null)
    	{
    		carac += "Propriété : "+this.prop.nom()+", groupe : "+this.prop.groupe().nom()+", prix d'achat : "+this.prop.prixAchat()+", appartient à ";
    		if (this.prop.proprietaire() == null)
    		{
    			carac += "aucun joueur";
    		}
    		else
    		{
    			carac += this.prop.proprietaire().nom();
    		}
    		carac += "\n";
    	}
    	return carac;
    }
}