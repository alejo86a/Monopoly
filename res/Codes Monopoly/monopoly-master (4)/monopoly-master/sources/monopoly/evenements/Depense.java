package monopoly.evenements ;

import java.util.*;

import javax.swing.JOptionPane;

import monopoly.jeu.Joueur ;
import monopoly.jeu.Case ;
import monopoly.proprietes.Propriete;

public class Depense extends AbstractEvent
{
	private int somme;
	private String type = "";
	
	/** Le constructeur de la classe permettant d'effectuer une dépense
	 * @param nom Le nom de la transaction
	 * @param cible Le joueur qui va dépenser une certaine somme
	 * @param somme La somme à dépenser
	 */
    public Depense(String nom, Joueur cible, int somme)
    {
		super(nom, cible);
		this.somme = somme;
	}
    
    /** Le constructeur de la classe permettant d'effectuer une dépense
	 * @param nom Le nom de la transaction
	 * @param somme La somme à dépenser
	 */
    public Depense(String nom, int somme)
    {
		super(nom);
		this.somme = somme;
	}
    
    /** Le constructeur de la classe permettant d'effectuer une dépense
	 * @param nom Le nom de la transaction
	 * @param somme La somme à dépenser
	 * @param type Le type de dépense
	 */
    public Depense(String nom, int somme, String type)
    {
		super(nom);
		this.somme = somme;
		this.type = type;
	}
    
    /** Définit la cible de l'évènement
     * @param Joueur j Le joueur qui sera la cible de l'évènement
     */
    public void setCible(Joueur j)
    {
    	this.cible = j;
    }
    
    /** Retourne la somme à dépenser
	 * @return somme La somme à dépenser
	 */
    public int somme()
    {
    	return this.somme;
    }

    /** Execute l'évènement et débite la somme s'il a assez de liquidités disponibles. Sinon il hypothèque jusqu'à avoir assez d'argent. Si il n'a toujours pas assez après avoir hypothéqué, il est eliminé
     */
	public void executer()
	{
		if (this.cible.payer(this.somme))
		{
			JOptionPane.showMessageDialog(null, this.cible.nom()+" a payé "+somme+" euros");
		}
		else
		{
			int diff = this.somme - this.cible.especes();
			JOptionPane.showMessageDialog(null, "Il manque "+diff+" euros à "+this.cible.nom());
			if (this.cible.titres().size() == 0)
			{
				this.cible.eliminer();
				JOptionPane.showMessageDialog(null, this.cible.nom()+" n'a pas les fonds suffisants, il est éliminé car il ne possède pas de propriété à hypothéquer !");
			}
			else
			{
				Iterator<Propriete> it = this.cible.titres().iterator();
				Propriete p = it.next();
				while (this.cible.especes() <= this.somme && !this.cible.elimine())
				{
					if (it.hasNext())
					{
						p = it.next();
						while (p.niveauImmobilier() > 0 && this.cible.especes() <= this.somme && !p.hypotheque())
						{
							if (p.detruire())
							{
								JOptionPane.showMessageDialog(null, p.proprietaire().nom()+" vend une maison. Nb Maisons : "+p.niveauImmobilier());
							}
						}
						if (this.cible.especes() <= this.somme && !p.hypotheque())
						{
							p.hypothequer();
							JOptionPane.showMessageDialog(null, this.cible.nom()+" hypothèque "+p.nom()+" et récupère "+p.prixAchat() / 2+" euros.");
						}
					}
					else
					{
						this.cible.eliminer();
						JOptionPane.showMessageDialog(null, this.cible.nom()+" n'a pas les fonds suffisants, il est éliminé car plus il n'a plus rien à hypothéquer !");
					}
				}
				if (this.cible.payer(this.somme))
				{
					JOptionPane.showMessageDialog(null, this.cible.nom()+" a payé "+somme+" euros");
				}
				else
				{
					diff = this.somme - this.cible.especes();
					JOptionPane.showMessageDialog(null, "Il manque "+diff+" euros à "+this.cible.nom());
					if (!this.cible.elimine())
					{
						this.cible.eliminer();
						JOptionPane.showMessageDialog(null, this.cible.nom()+" n'a pas les fonds suffisants, il est éliminé car il n'a plus d'argent !");
					}
				}
			}
		}
	}
	
	/** Retourne le type de dépense
     * @return type Le type d'évènement
     */
	public String type()
	{
		return this.type;
	}
	
	/** Description de l'évènement
	 * @return toString Description de la dépense**/
	public String toString()
	{
		return this.nom+". Somme à débourser : "+this.somme;
	}
}