package gameOfWar.config;
import gameOfWar.robot.Robot;

/**
 * <p>Cellule est une classe abstraite representer une cellule d'un tableau.<p>
 * 
 * @author Game of war
 */
public class Cellule {
	
	/** 0 si aucune mine, numero de l'equipe qui la possede sinon */
	private int mine = 0;
	/** 0 si aucune base, numero de l'equipe qui la sinon */
	private int base = 0;
	
	private boolean mur;
	/**
	 * Correspond au robot sur la cellule. 
	 * @see Robot
	 */
	private Robot robot;
	/**
	 * @see Coordonnees et les coordonnees d'une cellule.
	 */
	private Coordonnees coordonnees;
	String image;

	/**
	 * Le constructeur cellule qui construit ça cellule avec son coordonnees.
	 * 
	 * @param largeur
	 *    Pour donner une coordonnees a la cellule, ici la largeur.
	 * @param hauteur
	 *    Pour donner une coordonnees a la cellule, ici la Hauteur.
	 */  
	public Cellule(int largeur, int hauteur) {
		this.coordonnees = new Coordonnees(largeur, hauteur);
	}

	/**
	 * 
	 * @return si la cellule est une mine ou non.
	 */
	public int contientMine(){
		return this.mine;
	}

	public void poseMine(int equipe) {
		this.mine = equipe;
	}

	public void retirerMine(){
		this.mine = 0;
	}

	public boolean estMur(){
		return this.mur;
	}
	public void setMur(boolean mur){
		this.mur = mur;
	}
	/**
	 * 
	 * @return si la cellulle est une base ou non.
	 */
	public int estBase(){ 
		return this.base;
	}

	public void poseBase(int equipe){
		this.base = equipe;
	}
	/**
	 * 
	 * @return retourne l'attribut robot.
	 */
	public Robot getRobot() {
		return this.robot;
	}

	public void poserRobot(Robot robot){
		this.robot = robot;
	}

	public int estRobot(){
		if (this.robot == null) {
			return 0;
		}
		return this.robot.getEquipe();
	}
	/**
	 * 
	 * @return retourne l'attribut coordonnees.
	 */
	public Coordonnees getCoordonnees() {
		return this.coordonnees;
	}

	public void setCoordonnees(Coordonnees coord) {
		this.coordonnees = coord;
	}
	//
	//  @Override
	//  public String toString() {
	//    return "Cellule [mine=" + this.mine + ", base=" + this.base + ", robot=" + this.robot + ", coordonnees="
	//        + this.coordonnees + ", image=" + this.image + "]";
	//  }
	//  
	/**
	 * 
	 * @param robot
	 *    qui correspond du déplacement d'un robot sur une case.
	 */
	//abstract void deplaceSur(Robot robot);

	/**
	 * 
	 * @param equipe
	 */
	//abstract void ajoute(int equipe);

	/**
	 * 
	 * Vide la case.
	 */
	public boolean estVide(){
		if (this.estMur() || this.estBase() > 0 || this.estRobot() != 0 || contientMine() > 0) {
			return false;
		}
		return true;
	}
	public void videCase(){
		this.base = 0;
		this.mine = 0;
		this.mur = false;
		this.robot = null;
	}

  
}
