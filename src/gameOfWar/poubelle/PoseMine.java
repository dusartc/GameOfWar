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

public Piegeur p;

  public PoseMine(Robot robot, Coordonnees direction) {
    super(robot, direction);
  }

  public boolean estPosable(Cellule c){
    return(this.getRobot() instanceof Piegeur && !c.estMur() && c.estBase()==0);
  }
  
  public void agit(Cellule c){
    if(this.getRobot() instanceof Piegeur){
    	if(this.estPosable(c)){
    		this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutAction());
    		if(c.contientMine()>0){
    			c.retirerMine();
    		}else if(c.estRobot()>0){
    			c.getRobot().subitMine();
    		}
    		c.retirerMine();
    		p.setNbMines(p.getNbMines()-1);
    	}
    }
  }
  
  
   
}
