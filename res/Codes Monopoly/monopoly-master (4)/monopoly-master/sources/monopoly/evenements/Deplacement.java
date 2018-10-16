package monopoly.evenements ;

import java.util.*;
import javax.swing.*;

import monopoly.jeu.*;

public class Deplacement extends AbstractEvent
{
	private Case caseCible;
	
	/** Construit le déplacement d'un joueur indépendemment du fait que ce soit un déplacement relatif ou absolu
	 * @param nom
	 * @param cible
	 * @param caseCible
	 */
    public Deplacement(String nom, Joueur cible, Case caseCible)
    {
		super(nom, cible);
		this.caseCible = caseCible;
	}
    
    /** Construit le déplacement d'un joueur indépendemment du fait que ce soit un déplacement relatif ou absolu
     * 
     * @param nom
     * @param caseCible
     */
    public Deplacement(String nom, Case caseCible)
    {
		super(nom);
		this.caseCible = caseCible;
	}
    
    /** Met le joueur en paramètre en tant que cible de l'évènement
     */
    public void setCible(Joueur j)
    {
    	this.cible = j;
    }
    
    /**
     * Execute le déplacement, et push un nouvel évènement en fonction de la nouvelle case.
     */
	public void executer()
	{
		this.cible.placerSur(this.caseCible);
		JOptionPane.showMessageDialog(new JFrame(), this.cible.nom()+" est maintenant sur "+this.cible.position().nom());
	    if (this.cible.position().propriete() != null)
	    {
	    	if (this.cible.position().propriete().proprietaire() == null)
	    	{
	    		int achat = JOptionPane.showConfirmDialog(null, "Voulez-vous acheter "+this.cible.position().propriete().nom()+" pour "+this.cible.position().propriete().prixAchat()+" ? (Liquidités disponibles : "+this.cible.especes()+" euros)", this.cible.nom()+" achète "+this.caseCible.propriete().nom(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    		if (achat == JOptionPane.YES_OPTION)
				{
					this.cible.chosesAFaire().push(new AchatProp(this.cible.position().propriete(), "acheter", this.cible));
				}
	    		else
	    		{
	    			JOptionPane.showMessageDialog(null, this.cible.nom()+" n'achète pas "+this.caseCible.propriete().nom());
	    		}
	    	}
	    	else if (!this.cible.position().propriete().proprietaire().nom().equals(this.cible.nom()))
			{
	    		if (this.cible.position().propriete().hypotheque())
	    		{
	    			JOptionPane.showMessageDialog(new JFrame(), this.cible.position().propriete().nom()+" est hypothéqué ! Pas de loyer à payer");
	    		}
	    		else
	    		{
	    			PayerLoyer pl = new PayerLoyer(this.cible.position().propriete(), "Raquer", this.cible);
	    			this.cible.chosesAFaire().push(pl);
	    		}
			}
			else
			{
				if (this.cible.position().propriete().constructible())
				{
					int maison = JOptionPane.showConfirmDialog(null, "Voulez-vous construire une maison ? (Nombre de maisons sur ce terrain : "+this.cible.position().propriete().niveauImmobilier()+")", this.cible.nom()+" achète "+this.caseCible.propriete().nom(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (maison == JOptionPane.YES_OPTION)
					{
						int ancienLoyer = this.cible.position().propriete().loyer();
						if (this.cible.position().propriete().construire())
						{
							JOptionPane.showMessageDialog(null, "Bravo vous avez une maison\nAncien loyer : "+ancienLoyer+"\nNouveau loyer : "+this.cible.position().propriete().loyer());
						}
						else if (this.cible.position().propriete().niveauImmobilier() != 5)
						{
							JOptionPane.showMessageDialog(null, this.cible.nom()+" n'a pas assez d'argent, impossible de construire une maison");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Il y a déjà un hôtel ici : pas possible de construire quoi que ce soit !");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, this.cible.nom()+" n'achète pas de maison pour "+this.caseCible.propriete().nom());
					}
				}
			}
	    }
	    else
	    {
			if (this.cible.position().evenement() != null)
			{
				if (this.cible.position().evenement().getClass().toString().equals("class monopoly.evenements.Carte"))
				{
					Carte c = (Carte)this.cible.position().evenement();
					if (c.type().equals("chance"))
					{
						Collections.shuffle(Game.lesCartesChances);
						c = Game.lesCartesChances.get(0);
					}
					else
					{
						Collections.shuffle(Game.lesCartesCC);
						c = Game.lesCartesCC.get(0);
					}
					this.cible.position().setEvent(c);
				}
				this.cible.position().evenement().setCible(this.cible);
				JOptionPane.showMessageDialog(null, this.cible.position().evenement());
				this.cible.chosesAFaire().push(this.cible.position().evenement());
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Bienvenue à la visite de "+this.cible.position().nom());
			}
	    }
	}
	
	/**
	 * Descrit le déplacement du joueur
	 * @return String le déplacement du joueur cible
	 */
	public String toString()
	{
		return "Déplacement à la case numéro "+this.caseCible.numero()+" : "+this.caseCible.nom();
	}
}