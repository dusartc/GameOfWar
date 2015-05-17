package gameOfWar.config;

/**
 * Correspond à une base du plateau
 * 
 * @author Mathieu
 */
public class Base extends Cellule {

	/**
	 * Construit une base par rapport aux coordonnees donnees et au numero de
	 * l'equipe
	 * 
	 * @param largeur
	 *            l'indice sur l'axe x
	 * @param hauteur
	 *            l'indice sur l'axe y
	 * @param equipe
	 *            , le numero de l'equipe de la base
	 * @see Cellule
	 */
	public Base(int largeur, int hauteur, int equipe) {
		super(largeur, hauteur);
		this.poseBase(equipe);
		this.setImage(largeur == 0 ? "B" : "b");
	}
}