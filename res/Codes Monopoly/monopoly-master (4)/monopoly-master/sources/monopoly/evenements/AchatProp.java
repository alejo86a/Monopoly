package monopoly.evenements;

import javax.swing.*;
import monopoly.jeu.*;
import monopoly.proprietes.*;

public class AchatProp extends AbstractEvent
{
    private Propriete prop;
    
    /** Le constructeur pour l'achat d'une propriété
     *  @param Propriete prop La propriété vendue
     *  @String nom Le nom de la transaction
     *  @Joueur cible Le joueur qui achète
     *  **/
    public AchatProp(Propriete prop, String nom, Joueur cible)
    {
	super(nom, cible);
	this.prop = prop;
    }
    
    /** Méthode qui éxecute l'évènement. Le joueur cible achète la propriété s'il a assez de liquidités
     * **/
    public void executer()
    {
		if (this.cible.payer(this.prop.prixAchat()))
		{
			JOptionPane.showMessageDialog(new JFrame(), this.cible.nom()+" achète "+this.prop.nom()+" pour "+this.prop.prixAchat());
		    this.cible.titres().add(prop);
		    this.prop.setProprietaire(this.cible);
		}
    }
    
    /** Retourne la propriété liée à la transaction
     * @return Propriete prop La propriété à vendre
     */
    public Propriete propriete()
    {
	return this.prop;
    }
    
    /** Retourne le résumé de la transaction
     * return String toString Description de la transaction à effectuer
     */
    public String toString()
    {
	return "Propriété concernée : \n"+this.prop+"\nJoueur concerné : "+this.cible+"\nNom de l'achat : "+this.nom;
    }
}