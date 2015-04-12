package gameOfWar.poubelle;
import gameOfWar.action.Action;
import gameOfWar.config.Cellule;
import gameOfWar.config.Coordonnees;
import gameOfWar.robot.Piegeur;
import gameOfWar.robot.Robot;

/**
 * La classe PoseMine permet de produire une action qui pose une mine.
 * @author Mariam
 *
 */
public class PoseMine extends Action{

  public PoseMine(Robot robot, Coordonnees direction) {
    super(robot, direction);
    //this.agit();
  }

  public boolean estPosable(Cellule cellule){
    if (this.getRobot() instanceof Piegeur) {
      
    }
    return false;
  }
  public void agit(Cellule c){
    
  }
   
}
