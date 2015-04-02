package gameOfWar.jeux;
import gameOfWar.config.Coordonnees;
import gameOfWar.robot.Robot;


public class Vue {

  private Plateau plateau;
  
  public Vue(Plateau plateau) {
    this.plateau = plateau;
    //TODO ne vois qu'une partie du plateau en fonction de son equipe;
  }

  public void poserRobot(Robot robot, Coordonnees coordonnees){
	  this.plateau.poserRobot(coordonnees.getLargeur(), coordonnees.getHauteur(), robot);
  }
  
  public void setMine(Robot robot, Coordonnees coordonnees){
	  this.plateau.poserUneMine(coordonnees.getLargeur(), coordonnees.getHauteur(), robot.getEquipe());
  }
  public Plateau getPlateau(){
    return this.plateau;
  }
  
}