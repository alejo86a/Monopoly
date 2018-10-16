package monopoly.evenements ;

import monopoly.jeu.Joueur ;
import monopoly.jeu.Case ;
import monopoly.proprietes.Groupe;

public class Carte extends AbstractEvent
{
	private Evenement e;
	private int num;
	private String type;
	private String action;
	
	/** Constructeur d'une Carte constituée notamment d'un évènement
	 * @param int num Le numéro de la carte
	 * @param String type Le type de carte
	 * @param nom Le nom de la carte
	 * @param Joueur cible Le joueur qui pioche/utilise la carte
	 * @param Evenement e l'évènement qui sera déclenché
	 * @param String action La description
	 * **/
    public Carte(int  num, String type, String nom, Joueur cible, Evenement e, String action)
    {
		super(nom, cible);
		this.e = e;
		this.num = num;
		this.type = type;
		this.action = action;
	}
    
    /** Constructeur d'une Carte constituée notamment d'un évènement
	 * @param int num Le numéro de la carte
	 * @param String type Le type de carte
	 * @param nom Le nom de la carte
	 * @param Evenement e l'évènement qui sera déclenché
	 * @param String action La description
	 * **/
    public Carte(int  num, String type, String nom, Evenement e, String action)
    {
		super(nom);
		this.e = e;
		this.num = num;
		this.type = type;
		this.action = action;
	}
    
    /** Constructeur d'une Carte constituée notamment d'un évènement
	 * @param int num Le numéro de la carte
	 * @param String type Le type de carte
	 * @param nom Le nom de la carte
	 * @param String action La description
	 * **/
    public Carte(int  num, String type, String nom, String action)
    {
		super(nom);
		this.num = num;
		this.type = type;
		this.action = action;
	}

    /** Le joueur pioche ou utilise la carte : l'évènement associé à cette carte est ajouté à la pile de choses à faire du joueur cible.
     */
	public void executer()
	{
		e.setCible(this.cible);
		e.executer();
	}
	
	/** Définit la cible de l'évènement
     * @param Joueur j Le joueur qui sera la cible de l'évènement
     */
	public void setCible(Joueur j)
	{
		this.cible = j;
	}
	
	/** Définit l'évènement associé à la carte 
     * @param Evenement e L'évènement associé à la carte 
     */
	public void setEvenement(Evenement e)
	{
		this.e = e;
	}
	
	/** Retourne le type d'évènement. Soit CC (caisse de communauté), soit chance
     * @return type Le type d'évènement
     */
	public String type()
	{
		return this.type;
	}
	
	/** Retourne le numéro de la carte
     * @return int num Le numéro de la carte
     */
	public int num()
	{
		return this.num;
	}
	
	/** Retourne la description de l'évènement associé
     * @return String toString La description de la carte et de l'évènement associé
     */
	public String toString()
	{
		return this.nom;
	}
}