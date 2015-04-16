package gameOfWar.config;

import gameOfWar.robot.Robot;

/**
 * <p>
 * Cellule est une classe abstraite representer une cellule d'un tableau.
 * <p>
 * 
 * @author Mathieu
 */
public class Cellule {

  /** 0 si la mine appartient a aucune equipe, 1 pour l'equipe une et 2 pour l'equipe deux. */
  private int mine = 0;
  /** 0 si la base appartient a aucune equipe, 1 pour l'equipe une et 2 pour l'equipe deux. */
  private int base = 0;
  /** Mettre un mur a la Cellule ou non. */
  private boolean mur;
  /** Permettre de mettre un robot sur une Cellue. */
  private Robot robot;
  /** Les coordonnees d'une Cellulue. */
  private Coordonnees coordonnees;
  /** Correspond a l'image de la Cellule. */
  String image;

  /**
   * Le constructeur Cellule qui construit une Cellule avec des coordonnees donnees.
   * 
   * @param largeur Pour donner une coordonnees a la cellule, ici la largeur.
   * @param hauteur Pour donner une coordonnees a la cellule, ici la Hauteur.
   */
  public Cellule(int largeur, int hauteur) {
    this.coordonnees = new Coordonnees(largeur, hauteur);
  }

  /**
   * @return la valeur de la Mine, c'est a dire a qu'elle equipe elle appartient.
   */
  public int contientMine() {
    return this.mine;
  }

  /**
   * Pose une Mine sur la cellule avec le numero de l'equipe.
   * 
   * @param equipe donne a une Mine ça correspondance a l'equipe.
   */
  public void poseMine(int equipe) {
    this.mine = equipe;
  }

  /**
   * Retire la Mine de la cellule.
   */
  public void retirerMine() {
    this.mine = 0;
  }

  public boolean estMur() {
    return this.mur;
  }

  /**
   * Pose un mur.
   * 
   * @param mur
   */
  public void setMur(boolean mur) {
    this.mur = mur;
  }

  /**
   * Retourne le numéro de la base par rapport a l'équipe, 0 si il n'y a pas de base.
   * 
   * @return la valeur de l'equipe.
   */
  public int estBase() {
    return this.base;
  }

  /**
   * Pose une Base par rapport a une numéro d'equipe
   * 
   * @param equipe
   */
  public void poseBase(int equipe) {
    this.base = equipe;
  }

  /**
   * 
   * @return retourne le robot sur la Cellule.
   */
  public Robot getRobot() {
    return this.robot;
  }

  /**
   * Pose une robot sur la Cellule.
   * 
   * @param robot
   */
  public void poserRobot(Robot robot) {
    this.robot = robot;
  }

  /**
   * Retire un robot de la Cellule.
   */
  public void retirerRobot() {
    this.robot = null;
  }

  /**
   * Regarde si la Cellule a un robot.
   * 
   * @return 0 si il n'y a pas de robot sinon retourne le numéro de l'equipe.
   */
  public int estRobot() {
    if (this.robot == null) {
      return 0;
    }
    return this.robot.getEquipe().getEquipe();
  }

  /**
   * 
   * @return retourne les coordonnées de la Cellule.
   */
  public Coordonnees getCoordonnees() {
    return this.coordonnees;
  }

  /**
   * Modifie les coordonnée de la Cellule.
   * 
   * @param coord
   */
  public void setCoordonnees(Coordonnees coord) {
    this.coordonnees = coord;
  }

  /**
   * Affiche ce que possede la Cellule.
   */
  @Override
  public String toString() {
    return "Cellule [mine=" + this.mine + ", base=" + this.base + ", robot=" + this.robot
        + ", coordonnees=" + this.coordonnees + ", image=" + this.image + "]";
  }

  /**
   * Regarde si la Celulle est Vide.
   * 
   * @return
   */
  public boolean estVide() {
    if (this.estMur() || this.estBase() > 0 || this.estRobot() != 0 || contientMine() > 0) {
      return false;
    }
    return true;
  }

  /**
   * Vide la Cellule.
   */
  public void videCase() {
    this.base = 0;
    this.mine = 0;
    this.mur = false;
    this.robot = null;
  }


}
