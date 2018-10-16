package monopoly.proprietes ;

import java.util.*;

import monopoly.jeu.Case;
import monopoly.jeu.Game;

public class UnGroupe implements Groupe
{
    private String nom;
    private int coutImmo;
    private Game g;
    private List<Propriete> lesProp = new ArrayList<Propriete>();
    
    /**
     * Crée un groupe
     * @param nom
     * @param cout
     */
    public UnGroupe(String nom, int cout)
    {
	this.nom = nom;
	this.coutImmo = cout;
    }
    
    /**
     * Crée un groupe
     * @param nom
     * @param cout
     * @param g
     */
    public UnGroupe(String nom, int cout, Game g)
    {
	this.nom = nom;
	this.coutImmo = cout;
	this.g = g;
    }
    
    /** L'intitulé du groupe */
    public String nom()
    {
	return this.nom;
    }
    
    /** Le prix des constructions pour ce groupe */
    public int coutImmo()
    {
	return this.coutImmo;
    }
    
    /** La liste des propriétés qui le composent */
    public List<Propriete> composition()
    {
	return this.lesProp;
    }
    
    /** Retourne le groupe dont le nom est spécifié */
    public Groupe get(String nom)
    {
    	Groupe dest = null;
    	for (Groupe g : this.g.lesGroupes())
    	{
    		if (g.nom().equals(nom))
    			dest = g;
    	}
    	return dest;
    }
    
    /** Indique si le groupe appartient entièrement à un seul joueur */
    public boolean proprietaireUnique()
    {
		boolean prop = true;
		for (int i = 1 ; i < lesProp.size() ; i++)
		{
			if (lesProp.get(i).proprietaire() != null && lesProp.get(i - 1).proprietaire() != null )
			{
				if (!lesProp.get(i).proprietaire().nom().equals(lesProp.get(i - 1).proprietaire().nom()))
				{
					prop = false;
				}
			}
			else
			{
				prop = false;
			}
		}
		
		return prop;
    }
    
    /** Retourne la description du groupe. Liste les propriétés du groupe **/
    public String toString()
    {
    	String caracs = "Nom du groupe : "+this.nom+"\nCout immobilier : "+this.coutImmo+"\nPropriétés de ce groupe : \n"; 
		for (Propriete p : this.lesProp)
		{
			caracs += p.nom()+" | ";
		}
		caracs += "\n";
		return caracs;
    }
}