package monopoly.gui;

import monopoly.evenements.*;
import monopoly.jeu.*;
import monopoly.proprietes.*;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.Border;

public class Plateau
{
	private JFrame fen = new JFrame("Monopoly");
	private Game g;
	
	/**
	 * Crée le Plateau
	 */
	public Plateau(Game g)
	{
		this.g = g;
	}
	
	/** Met à jour le plateau **/
	public void actualiser(Game g)
	{
		this.init(g);
	}
	
	/** Affiche le plateau représentant l'avancement en cours du jeu **/
	public void init(Game g)
	{
		int hauteurCase = 30;
		Color board = new Color(165, 238, 155);
		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur = (int)tailleEcran.getHeight();
		int largeur = (int)tailleEcran.getWidth();
	    fen.setSize(largeur, hauteur);
	    fen.setLocationRelativeTo(null);
	    fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    GridBagLayout gb = new GridBagLayout();
	    JPanel pan = new JPanel();
	    pan.setLayout(gb);
	    GridBagConstraints c = new GridBagConstraints();
	    
	    // haut gauche à haut droit
	    int i = 0;
	    for (int cpt = 0 ; cpt <= g.lesCases().size() / 4 ; cpt++)
	    {
	    	
	    	
	    	JPanel lacase = this.placerLigne(cpt, hauteurCase);
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.ipady = 35;
		    c.gridx = i;
		    c.gridy = 0;
		    
		    pan.add(lacase, c);
		    i++;
	    }
	    
	    // haut droit à bas droit
	    int j = 1;
	    for (int cpt = (g.lesCases().size() / 4)  + 1; cpt < g.lesCases().size() / 2 ; cpt++)
	    {
	    	JPanel lacase = this.placerLigne(cpt, hauteurCase);
		    c.fill = GridBagConstraints.BOTH;
		    c.weightx = 0.5;
		    c.ipady = 35;
		    c.gridx = i - 1;
		    c.gridy = j;
		    
		    pan.add(lacase, c);
		    lacase.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
		    j++;
	    }
	    
	    // bas droit à bas gauche
	    int k = i;
	    for (int cpt = g.lesCases().size() / 2 ; cpt <= (g.lesCases().size() / 2 + (g.lesCases().size() / 4)) ; cpt++)
	    {
	    	JPanel lacase = this.placerLigne(cpt, hauteurCase);
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.ipady = 35;
		    c.gridx = k - 1;
		    c.gridy = j;
		    pan.add(lacase, c);
		    lacase.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
		    k--;
	    }
	    
	    // bas gauche à haut gauche
	    int l = j;
	    for (int cpt = (g.lesCases().size() / 2 + (g.lesCases().size() / 4)) + 1; cpt < g.lesCases().size() ; cpt++)
	    {
	    	JPanel lacase = this.placerLigne(cpt, hauteurCase);
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.ipady = 35;
		    c.gridx = k;
		    c.gridy = l - 1;
		    pan.add(lacase, c);
		    lacase.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
		    l--;
	    }
	    int y = 1;
	    for (Joueur j1 : g.lesJoueurs())
	    {
		    JLabel topo = new JLabel("");
		    String legende = "<html><center>";
	    	legende += j1.nom()+" = "+j1.numero()+"<br>";
		    legende += "</html>";
		    topo.setText(legende);
		    GridBagConstraints gbc = new GridBagConstraints();
		    gbc.weightx = 0.5;
		    gbc.fill = GridBagConstraints.HORIZONTAL;
		    gbc.ipady = 40;
		    gbc.ipadx = 40;
		    gbc.gridx = 5;
		    gbc.gridy = y;
		    topo.setMinimumSize(new Dimension(10, 10));
	    	topo.setMaximumSize(new Dimension(10, 10));
		    pan.add(topo, gbc);
		    y++;
	    }
	    fen.setContentPane(pan);
	    
	    pan.setBackground(board);
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    fen.setExtendedState(Frame.MAXIMIZED_BOTH);
	    fen.setVisible(true);
	}
	
	/**  Attribue à la case une couleur en fonction du type **/
	public void setColor(Case lacase, Component c)
	{
		if (lacase.propriete() != null)
    	{
    		if (lacase.propriete().groupe().nom().equals("bleu ciel"))
    		{
    			Color bc = new Color(0, 191, 255);
    			c.setBackground(bc);
    		}
    		else if (lacase.propriete().groupe().nom().equals("bleu roi"))
    		{
    			Color bleu = new Color(0, 0, 139);
    			c.setBackground(bleu);
    		}
    		else if (lacase.propriete().groupe().nom().equals("jaune"))
    		{
    			c.setBackground(Color.YELLOW);
    		}
    		else if (lacase.propriete().groupe().nom().equals("mauve"))
    		{
    			Color mauve = new Color(191, 62, 255);
    			c.setBackground(mauve);
    		}
    		else if (lacase.propriete().groupe().nom().equals("orange"))
    		{
    			Color orange = new Color(255, 127, 36);
    			c.setBackground(orange);
    		}
    		else if (lacase.propriete().groupe().nom().equals("rouge"))
    		{
    			c.setBackground(Color.RED);
    		}
    		else if (lacase.propriete().groupe().nom().equals("vert"))
    		{
    			Color vert = new Color(69, 139, 0);
    			c.setBackground(vert);
    		}
    		else if (lacase.propriete().groupe().nom().equals("violet"))
    		{
    			Color violet = new Color(104, 34, 139);
    			c.setBackground(violet);
    		}
    		else if (lacase.propriete().groupe().nom().equals("gares") || lacase.propriete().groupe().nom().equals("compagnies"))
    		{
    			c.setBackground(Color.BLACK);
    			//new Color(0,true)
    		}
    	}
		else
		{
			c.setBackground(new Color(0,true));
		}
	}
	
	/**
	 * Crée une case en fonction de sa position sur le plateau et de sa hauteur
	 * @param cpt
	 * @param hauteurCase
	 * @return La case dont cpt correspond à sa place sur la ligne
	 */
	public JPanel placerLigne(int cpt, int hauteurCase)
	{
		Color board = new Color(165, 238, 155);
		JPanel lacase = new JPanel();
		lacase.setBackground(board);
		JButton couleur = new JButton("");
		GridLayout gl = new GridLayout(2, 1);
    	this.setColor(g.lesCases().get(cpt), couleur);
    	couleur.setMinimumSize(new Dimension(10, 1));
    	couleur.setMaximumSize(new Dimension(10, 1));
    	String nom = g.lesCases().get(cpt).nom();
    	String[] seq = nom.split(" ");
    	nom = "<html><center>";
    	int taille = 0;
    	for (String s : seq)
    	{
    		taille += s.length();
    		if (taille > 15)
    		{
    			nom += "<br>"+s;
    			taille = s.length();
    		}
    		else
    		{
    			nom += " "+s;
    		}
    	}
    	if (g.lesCases().get(cpt).propriete() != null)
    	{
    		couleur.setText(g.lesCases().get(cpt).propriete().prixAchat()+" F");
    		if (!couleur.getBackground().equals(Color.YELLOW))
    		{
    			couleur.setForeground(Color.WHITE);
    		}
    		if (couleur.getBackground().equals(Color.BLACK))
    		{
    			couleur.setBackground(new Color(0,true));
    			couleur.setForeground(Color.BLACK);
    		}
    	}
    	else if (g.lesCases().get(cpt).evenement() != null)
    	{
    		if (g.lesCases().get(cpt).evenement().type().equals("dépense"))
    		{
    			Depense d = (Depense)g.lesCases().get(cpt).evenement();
    			couleur.setText(String.valueOf(d.somme())+" F");
    		}
    		else if (g.lesCases().get(cpt).evenement().type().equals("recette"))
    		{
    			Recette r = (Recette)g.lesCases().get(cpt).evenement();
    			couleur.setText(String.valueOf(r.somme())+" F");
    		}
    	}
    	nom += "</html>";
    	for (Joueur j3 : g.lesJoueurs())
    	{
    		if (j3.position().numero() == g.lesCases().get(cpt).numero())
    		{
    			couleur.setText(couleur.getText()+" -> "+j3.numero());
    			couleur.setFont(new Font("calibri", 10, 10));
    		}
    	}
    	JLabel test = new JLabel(nom);
    	test.setFont(new Font("calibri", 12, 12));
    	test.setHorizontalAlignment(JLabel.CENTER);
    	test.setVerticalAlignment(JLabel.CENTER);
    	lacase.add(couleur);
    	lacase.add(test);
    	lacase.setMinimumSize(new Dimension(10, hauteurCase));
    	lacase.setMaximumSize(new Dimension(10, hauteurCase));
	    lacase.setLayout(gl);
	    if (this.g.lesCases().get(cpt).propriete() == null || this.g.lesCases().get(cpt).evenement() != null)
	    {
	    	couleur.setBorder(null);
	    }
	    lacase.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
	    return lacase;
	}
	
	public static void main(String[] args)
	{
		Game g = new Game();
		Plateau p = new Plateau(g);
		p.init(g);
		int tour = 1;
		while (JOptionPane.showConfirmDialog(null, "Jouer le tour "+tour+" ?") == JOptionPane.YES_OPTION)
		{
			JOptionPane.showMessageDialog(new JFrame(), "====================================\n========== Début du tour "+tour+"==========\n====================================");
			for (Joueur j : g.lesJoueurs())
			{
				if (j.elimine())
				{
					JOptionPane.showMessageDialog(new JFrame(), j.nom()+" est éliminé !");
				}
				else
				{
					g.jouerTour(j);
				}
				
				p.actualiser(g);
			}
			JOptionPane.showMessageDialog(new JFrame(), "====================================\n========== Fin du tour "+tour+"==========\n====================================");
			tour++;
		}
		JOptionPane.showMessageDialog(null, "Fin du jeu");
	}
}