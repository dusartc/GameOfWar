package gameOfWar.action;

import gameOfWar.config.Coordonnees;
import gameOfWar.robot.Robot;;;

/** La Classe Action permet de gérer les actions des robots sur le plateau
 * 
 */
public abstract class Action {

	/** La direction que doit emprunter le robot*/
	private Coordonnees direction;
	/** L'objectif que doit atteindre le robot*/
	private Coordonnees objectif;
	/** Le robot */
	private Robot robot;
	
	/**
	 * Construit un objet Action avec le robot et les coordonnees donnes
	 * @param robot
	 * @param direction
	 */
	public Action(Robot robot, Coordonnees direction) {
		this.robot = robot;
		this.direction = direction;
	}
	
	/**
	 * Retourne le robot
	 * @return le robot
	 */
	public Robot getRobot() {
		return this.robot;
	}
	
	/**
	 * Retourne la direction par laquelle le robot doit passer
	 * @return la direction par laquelle le robot doit passer
	 */
	public Coordonnees getDirection() {
		return this.direction;
	}
	
	/**
	 * Retourne l'objectif que doit atteindre le robot
	 * @return l'objetif
	 */
	public Coordonnees getObjectif() {
		return this.objectif;
	}
	
	/**
	 * agit realise une action d'un robot
	 */
	abstract void agit();
	
}
