
public class Vue {

  private Plateau plateau;
  
  public Vue(Plateau plateau) {
    this.plateau = plateau;
    //TODO ne vois qu'une partie du plateau en fonction de son equipe;
  }

  public void poserRobot(Robot robot, Coordonnees coordonnees){
	  robot.setCoordonnees(coordonnees);
  }
  public Plateau getPlateau(){
    return this.plateau;
  }
  
}
