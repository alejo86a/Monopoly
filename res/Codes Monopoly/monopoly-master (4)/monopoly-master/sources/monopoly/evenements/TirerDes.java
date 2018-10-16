package monopoly.evenements ;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import monopoly.jeu.* ;

/** Cette Classes abstraite implémente les fonctionnalités associées aux
 * événements du jeu */
public class TirerDes extends AbstractEvent
{
    private int lancer;
    private boolean faitUnDouble = false;
    private int nbLancer = 1;
    private Game g;
    public static int DERNIER_LANCER;
    
    /**
     * Crée l'évènement qui permettra à une cible de tirer les dés.
     * @param nom
     * @param cible
     * @param g
     */
    public TirerDes(String nom, Joueur cible, Game g)
    {
    	super(nom, cible);
    	this.g = g;
    }
    
    /**
     * Execute l'évènement et tire les dés si le joueur n'est pas en prison ou s'il a purgé ses 3 tours de prisons.
     * Le joueur sort de prison s'il fait un double, ou bien il rejoue s'il n'y était pas.
     * Au bout du troisième double il est emprisonné.
     */
    public void executer()
    {
    	String listeAdv = "Liste des adversaires de "+this.cible.nom()+" :\n";
    	for (Joueur j : this.cible.adversaires())
    	{
    		listeAdv += j.nom()+"\n";
    	}
    	JOptionPane.showMessageDialog(null, listeAdv);
    	double lancer1 = Math.random() * 6 + 1;
    	double lancer2 = Math.random() * 6 + 1;
    	if ((int)lancer1 == (int)lancer2)
    	{
    		this.faitUnDouble = true;
    	}
    	this.lancer = (int)lancer1 + (int)lancer2;
    	JOptionPane.showMessageDialog(new JFrame(), this.cible.nom()+" est sur "+this.cible.position().nom()+"\n"+"Dé 1 : "+(int)lancer1+" et dé 2 : "+(int)lancer2+"\n"+this.cible.nom()+" fait "+this.lancer);
    	TirerDes.DERNIER_LANCER = this.lancer;
		if (this.cible.enPrison())
		{
			Emprisonnement.TAB_PRISON.put(this.cible, Emprisonnement.TAB_PRISON.get(this.cible) + 1);
			if (Emprisonnement.TAB_PRISON.get(this.cible) >= 3)
			{
				this.cible.liberer();
				Emprisonnement.TAB_PRISON.put(this.cible, 0);
				JOptionPane.showMessageDialog(new JFrame(), this.cible.nom()+" sort de prison !");
			}
		}
    	if (this.faitUnDouble())
    	{
    		if (this.cible.enPrison())
    		{
    			this.cible.liberer();
    			JOptionPane.showMessageDialog(new JFrame(), this.cible.nom()+" a fait un double, il sort de prison !");
    		}
    		else
    		{
    			this.faitUnDouble = false;
    			this.cible.chosesAFaire().push(this);
    			JOptionPane.showMessageDialog(new JFrame(), this.cible.nom()+" a fait un double, il va donc rejouer !\nNb de lancers : "+this.nbLancer);
	    		this.nbLancer++;
	    		if (this.nbLancer == 3)
	    		{
	    			this.cible.chosesAFaire().clear();
	    			this.cible.chosesAFaire().push(new Emprisonnement("Trop de doubles tue le double", this.cible));
	    		}
    		}
    	}
    	if (!this.cible.enPrison())
    	{
    		this.cible.chosesAFaire().push(new DeplacementRelatif(this.nom, this.cible, this.lancer, Game.LES_CASES, this.g));
    	}
    }
    
    /**
     * Indique si le joueur a fait un double
     * @return true si les dés sont identiques
     */
    public boolean faitUnDouble()
    {
    	return this.faitUnDouble;
    }
    
    /**
     * Indique la valeur du déplacement
     * @return La somme es deux dés
     */
    public int valeur()
    {
	return this.lancer;
    }
    
    /**
     * La description de l'évènement
     */
    public String toString()
    {
    	return this.cible.nom()+" fait "+this.lancer;
    }
}