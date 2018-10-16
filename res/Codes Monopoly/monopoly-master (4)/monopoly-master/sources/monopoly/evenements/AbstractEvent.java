package monopoly.evenements ;

import monopoly.jeu.* ;
import monopoly.jeu.* ;

/** Cette Classes abstraite implémente les fonctionnalités associées aux
 * événements du jeu */
public abstract class AbstractEvent implements Evenement
{
    /** Intitulé de l'événement (i.e. en principe de la case associée
     * ou de la carte) */
    protected String nom;
    /** Le joueur auquel l'évènement sera appliqué **/
    protected Joueur cible;
    
    /** Le constructeur d'un évènement abstrait 
     * @param String non Le nom de l'évènement
     * @param Joueur cible Le joueur concerné
     * **/
    public AbstractEvent(String nom, Joueur cible)
    {
	this.nom=nom;
	this.cible=cible;
    }
    
    /** Le constructeur d'un évènement abstrait 
     * @param String non Le nom de l'évènement
     * **/
    public AbstractEvent(String nom)
    {
	this.nom=nom;
    }
    
    /** Retourne le nom de l'évènement
     * @return String nom Nom de l'évènement **/
    public String nom()
    {
	return nom;
    }
    
    /** Retourne le Joueur concerné par l'évènement
     * @return cible Le joueur cible
     */
    public Joueur cible()
    {
	return cible;
    }
    
    /** Définit la cible de l'évènement
     * @param Joueur j Le joueur qui sera la cible de l'évènement
     */
    public void setCible(Joueur j)
    {
    	this.cible = j;
    }
    
    /** Retourne le type d'évènement
     * @return type Le type d'évènement
     */
    public String type()
    {
    	return "";
    }
    
    /** Exécute l'évènement **/
    public abstract void executer();
}
