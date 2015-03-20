import java.awt.Robot;


public abstract class Cellule {
  
  protected int mine = 0;
  protected int base = 0;
  private Robot robot;
  private Coordonnees coordonnees;
  String image;
  
  public Cellule(int largeur, int hauteur) {
    this.coordonnees = new Coordonnees(largeur, hauteur);
  }
  
  public int contientMine(){
    if (this.coordonnees.equals(robot.getCoordonnees())) {
      return this.mine;
    }
    return 0;
  }
  
  public int estBase(){ 
    if (this.coordonnees.equals(robot.getCoordonnees())) {
      return this.base;
    }
    return 0;
  }
  public Robot getRobot() {
    return this.robot;
  }
  public Coordonnees getCoordonnees() {
    return this.coordonnees;
  }
  
  @Override
  public String toString() {
    return "Cellule [mine=" + this.mine + ", base=" + this.base + ", robot=" + this.robot + ", coordonnees="
        + this.coordonnees + ", image=" + this.image + "]";
  }
  
  abstract void deplaceSur(Robot robot);
  
  abstract void ajoute(int equipe);
  
  abstract void videCase();
}
