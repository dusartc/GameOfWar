/**
 * 
 * <p>Cellule est une classe abstraite representer une cellule d'un tableau.<p>
 * 
 * @author Game of war.
 * @version 1.0.
 */
public abstract class Cellule {
  
  protected int mine = 0;
  protected int base = 0;
  /**
   * Correspond au robot sur la cellule.
   * 
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
    if (this.coordonnees.equals(robot.getCoordonnees())) {
      return this.mine;
    }
    return 0;
  }
  
  /**
   * 
   * @return si la cellulle est une base ou non.
   */
  public int estBase(){ 
    if (this.coordonnees.equals(robot.getCoordonnees())) {
      return this.base;
    }
    return 0;
  }
  
  /**
   * 
   * @return retourne l'attribut robot.
   */
  public Robot getRobot() {
    return this.robot;
  }
  
  /**
   * 
   * @return retourne l'attribut coordonnees.
   */
  public Coordonnees getCoordonnees() {
    return this.coordonnees;
  }

  @Override
  public String toString() {
    return "Cellule [mine=" + this.mine + ", base=" + this.base + ", robot=" + this.robot + ", coordonnees="
        + this.coordonnees + ", image=" + this.image + "]";
  }
  
  /**
   * 
   * @param robot
   *    qui correspond du déplacement d'un robot sur une case.
   */
  abstract void deplaceSur(Robot robot);
  
  /**
   * 
   * @param equipe
   */
  abstract void ajoute(int equipe);
  
  /**
   * 
   * Vide la case.
   */
  abstract void videCase();

  abstract void estVide();
  
}
