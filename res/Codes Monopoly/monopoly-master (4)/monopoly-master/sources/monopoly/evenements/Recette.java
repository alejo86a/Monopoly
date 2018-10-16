package monopoly.evenements ;

import java.util.Iterator;

import javax.swing.JOptionPane;

import monopoly.jeu.Joueur ;
import monopoly.proprietes.Propriete;

public class Recette extends AbstractEvent
{
	private int somme;
	private String type = "";
	
	/**
	 * Crée l'évènement Recette qui va faire gagner une somme à une cible
	 * @param nom
	 * @param cible
	 * @param somme
	 */
    public Recette(String nom, Joueur cible, int somme)
    {
		super(nom, cible);
		this.somme = somme;
	}
    
    /**
     * Crée l'évènement Recette qui va faire gagner une somme à une cible
     * @param nom
     * @param somme
     */
    public Recette(String nom, int somme)
    {
    	super(nom);
    	this.somme = somme;
    }
    
    /**
     * Crée l'évènement Recette qui va faire gagner une somme à une cible
     * @param nom
     * @param somme
     * @param type
     */
    public Recette(String nom, int somme, String type)
    {
    	super(nom);
    	this.somme = somme;
    	this.type = type;
    }
    
    /** Met le joueur en paramètre en tant que cible de l'évènement
     */
    public void setCible(Joueur j)
    {
    	this.cible = j;
    }
    
    /** Indique la somme perçue par la cible
     * 
     * @return la somme associée à l'évènement
     */
    public int somme()
    {
    	return this.somme;
    }
    
    /**
     * @return Le type d'évènement
     */
    public String type()
    {
    	return this.type;
    }
    
    /**
     * Execute l'évènement et verse la somme associée au joueur cible. Si il a assez d'argent, il déshypothèque le plus possible les propriétés qu'il a hypothéqué.
     */
	public void executer()
	{
		JOptionPane.showMessageDialog(null, "Versement de "+this.somme+" à "+this.cible.nom());
		this.cible.verser(this.somme);
		JOptionPane.showMessageDialog(null, this.cible.nom()+" possède "+this.cible.especes()+" euros.");
		Iterator<Propriete> it = this.cible.titres().iterator();
		Propriete p = null;
		if (it.hasNext())
		{
			p = it.next();
			while (p.deshypothequer())
			{
				JOptionPane.showMessageDialog(null, this.cible.nom()+" a récupéré son bien : "+p.nom());
				if (it.hasNext())
				{
					p = it.next();
				}
			}
		}
	}
	
	/**
	 * @return La description de l'évènement
	 */
	public String toString()
	{
		return this.nom+". Somme à empocher : "+this.somme;
	}
}