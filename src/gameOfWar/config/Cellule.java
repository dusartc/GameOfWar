package gameOfWar.config;

import gameOfWar.robot.Robot;

/**
 * <p>
 * Represente une cellule d'un tableau
 * <p>
 * 
 * @author Mathieu
 */
public class Cellule {

  private int mine = 0;
  private int base = 0;
  private boolean mur;
  private Robot robot = null;
  private Coordonnees coordonnees;
  private Factory factory = null;
  private String image = " ";

  /**
   * Le constructeur Cellule qui construit une Cellule avec des coordonnees donnees.
   * 
   * @param largeur x
   * @param hauteur y
   */
  public Cellule(int largeur, int hauteur) {
    this.coordonnees = new Coordonnees(largeur, hauteur);
  }

  /**
   * @return int le numero d'equipe auquel appartient la mine
   */
  public int contientMine() {
    return this.mine;
  }

  public void poseMine(int equipe) {
    this.mine = equipe;
  }

  public void retirerMine() {
    this.mine = 0;
  }

  public boolean estMur() {
    return this.mur;
  }

  public void setMur(boolean mur) {
    this.mur = mur;
    if (!mur) {
      this.setImage(" ");
    }
  }

  /**
   * Retourne le numéro de la base par rapport a l'équipe, 0 si il n'y a pas de base.
   * 
   * @return int la valeur de l'equipe.
   */
  public int estBase() {
    return this.base;
  }

  /**
   * Pose une Base par rapport a une numéro de l'equipe
   * 
   * @param equipe numero de l'equipe
   */
  public void poseBase(int equipe) {
    this.base = equipe;
  }

  public Robot getRobot() {
    return this.robot;
  }

  /**
   * Pose une robot sur la Cellule courante
   * 
   * @param robot le Robot a poser
   */
  public void poserRobot(Robot robot) {
    this.robot = robot;
  }

  public void retirerRobot() {
    this.robot = null;
  }

  /**
   * Renvoie si la Cellule a un robot.
   * 
   * @return 0 si il n'y a pas de robot sinon retourne le numéro de l'equipe.
   */
  public int estRobot() {
    if (this.robot == null) {
      return 0;
    }
    return this.robot.getEquipe().getEquipe();
  }

  public Coordonnees getCoordonnees() {
    return this.coordonnees;
  }

  public void setCoordonnees(Coordonnees coord) {
    this.coordonnees = coord;
  }

  public Factory getFactory() {
    return factory;
  }

  /**
   * Renvoie 0 s'il n'y a pas de factory dans la cellule, sinon renvoie le numero de l'equipe
   * possedant la factory
   * 
   * @return int
   */
  public int getNumFacto() {
    if (this.factory == null) {
      return 0;
    }
    return this.factory.getEquipe().getEquipe();
  }

  public void setFactory(Factory factory) {
    this.factory = factory;
  }

  /**
   * Affiche ce que possede la Cellule.
   */
  @Override
  public String toString() {
    return "Cellule [mine=" + this.mine + ", base=" + this.base + ", robot=" + this.robot
        + ", coordonnees=" + this.coordonnees + "]";
  }

  public boolean estVide() {
    return !(this.estMur() || this.estBase() > 0 || this.estRobot() != 0 || contientMine() > 0);
  }

  public boolean estImpassable() {
    return this.mur || this.robot != null;
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

  public void setImage(String image) {
    this.image = image;
  }

  public String getImage() {
    return this.image;
  }

}
