package gameCommons;

import util.Case;

public interface IEnvironment {

	/**
	 * Teste si une case est sure, c'est � dire que la grenouille peut s'y poser
	 * sans mourir
	 * 
	 * @param c
	 *            la case � tester
	 * @return vrai s'il n'y a pas danger
	 */
	public boolean isSafe(Case c);

	/**
	 * Teste si la case est une case d'arrivee
	 * 
	 * @param c
	 * @return vrai si la case est une case de victoire
	 */
	public boolean isWinningPosition(Case c);

	/**
	 * Effectue une �tape d'actualisation de l'environnement
	 */
	public void update();

	/**
	 * Ajoute une Lane 
	 */
	public void ajoutLane();
	
	/**
	 * D�cale d'une ligne vers le bas toutes les lanes de la liste
	 */
	public void decalageLane();
	
	/**
	 * D�cale d'une ligne vers le haut toutes les lanes de la liste
	 */
	public void decalageLaneInv();
	
	/**
	 * 
	 * @return le score qui est la taille de la liste de lane
	 */
	public int score();
}
