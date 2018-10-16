package monopoly.jeu;

import java.util.*;

import javax.swing.JOptionPane;

import monopoly.evenements.Emprisonnement;
import monopoly.evenements.Evenement;
import monopoly.evenements.TirerDes;
import monopoly.proprietes.Propriete;

public class PersoJoueur implements Joueur
{
	private int numero;
	private String nom;
	private boolean estEnPrison = false;
	private boolean elimine = false;
	private int especes = 150000;
	private Case position;
    private List<Propriete> titres = new ArrayList<Propriete>();
	private List<Evenement> cartes = new ArrayList<Evenement>();
	private Stack<Evenement> chosesAFaire = new Stack<Evenement>();
	private List<Joueur> adversaires = new ArrayList<Joueur>();
	private Game g;
	
	/**
	 * Crée un joueur
	 * @param numero
	 * @param nom
	 * @param g
	 */
	public PersoJoueur(int numero, String nom, Game g)
	{
		this.numero = numero;
		this.nom = nom;
		this.position = new MonoCase(1, "Case départ", g);
		this.g = g;
		Emprisonnement.TAB_PRISON.put(this, 0);
	}
	
	/**
	 * Crée un joueur
	 * @param numero
	 * @param nom
	 * @param depart
	 * @param g
	 */
	public PersoJoueur(int numero, String nom, Case depart, Game g)
	{
		this.numero = numero;
		this.nom = nom;
		this.position = depart;
		this.g = g;
		Emprisonnement.TAB_PRISON.put(this, 0);
	}
	
	/** Le numéro du joueur */
	public int numero()
	{
		return this.numero;
	}
	
    /** Le nom du joueur */
    public String nom()
    {
    	return nom;
    }
    
    /** Indique si le joueur est emprisonné */
    public boolean enPrison()
    {
    	return this.estEnPrison;
    }
    
    /** Emprisonne le joueur */
    public void emprisonner()
    {
    	this.estEnPrison = true;
    	Emprisonnement.TAB_PRISON.put(this, 0);
    }
    
    /** Indique si le joueur est éliminé */
    public boolean elimine()
    {
    	return this.elimine;
    }
    
    /** Élimine le joueur */
    public void eliminer()
    {
    	if (!this.elimine)
    	{
	    	this.elimine = true;
	    	this.chosesAFaire.clear();
	    	for (Propriete p : this.titres)
	    	{
	    		p.setProprietaire(null);
	    	}
	    	//System.out.println(this.listerProp());
	    	JOptionPane.showMessageDialog(null, this.listerProp());
    	}
    }
    
    /** Liquidités possédées par le joueur */
    public int especes()
    {
    	return this.especes;
    }
    
    /** Impose au joueur le paiement de la somme spécifiée
     * @return true si le joueur a pu payer, false sinon
     */
    public boolean payer(int somme)
    {
    	boolean paye = false;
    	if (this.especes - somme >= 0)
    	{
    		paye = true;
    		this.especes -= somme;
    	}
    	
    	return paye;
    }
    
    /** Verse au joueur la somme spécifier */
    public void verser(int somme)
    {
    	this.especes += somme;
    }
    
    /** Donne la case sur laquelle le joueur est placé */
    public Case position()
    {
		return this.position;
	}
    
    /** Place le joueur sur la case spécifiée */
    public void placerSur(Case c)
    {
    	this.position = c;
	}
    
    /** Donne la liste des autres joueurs encore en lice (tous sauf
     * <code>this</code> et les éliminés)*/
    public List<Joueur> adversaires()
    {
    	ArrayList<Joueur> adv = new ArrayList<Joueur>();
    	for (Joueur j : this.g.lesJoueurs())
    	{
    		if (j.numero() != this.numero && !j.elimine())
    			adv.add(j);
    	}
    	this.adversaires = adv;
    	
		return this.adversaires;
	}
    
    /** Titres de propriétés possédés par le joueur */
    public List<Propriete> titres()
    {
		return this.titres;
	}
    
    /** Cartes conservées par le joueur */
    public List<Evenement> cartes()
    {
		return this.cartes;
	}
    
    /** La pile d'événements que le joueur doit subir pendant son tour
     * de jeu : si la pile est vide, le joueur a terminé son tour ; sinon il doit
     * dépiler un événement pour l'exécuter. Il peut arriver qu'un événement manipule
     * cette pile (par exemple "Aller en prison" termine le tour du joueur même s'il lui
     * restait théoriquement des choses à faire) */
    public Stack<Evenement> chosesAFaire()
    {
		return this.chosesAFaire;
	}
    
    /**
     * Liste les propriétés possédées par le joueur
     * @return liste des propriétés du joueur
     */
    public String listerProp()
    {
	String liste = "Liste des propriétés : \n";
	for (Propriete p : this.titres)
	{
	    liste += p.nom()+" ";
	    if (p.hypotheque())
	    {
	    	liste += "(hypothéqué) ";
	    }
	    liste += " | ";
	}
	return liste;
    }
    
    /**
     * Libère le joueur de prison
     */
    public void liberer()
    {
    	this.estEnPrison = false;
    }
    
    /**
     * 
     * @return la valeur du dernier lancer de dé du joueur
     */
    public int dernierLancer()
    {
    	TirerDes td = new TirerDes("Lancer", this, this.g);
    	td.executer();
    	return td.valeur();
    }
    
    /** Met les espèces du joueur à la valeur de la somme en paramètre **/
    public void setEspeces(int somme)
    {
    	this.especes = somme;
    }
    
    /** Décrit le joueur
     * @return la description du joueur
     */
    public String toString()
    {
		String j = "Numéro : "+this.numero+"\nNom : "+this.nom+"\nSomme : "+this.especes+"\nPlacé sur : "+this.position.nom()+"\n"+this.listerProp();
		if (this.estEnPrison)
		{
			j += "\n"+this.nom+" est en prison !";
		}
		return j;
    }
}
