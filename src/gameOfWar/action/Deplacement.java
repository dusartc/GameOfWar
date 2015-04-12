package gameOfWar.action;

import gameOfWar.config.Cellule;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.robot.Char;
import gameOfWar.robot.Piegeur;
import gameOfWar.robot.Robot;
import gameOfWar.robot.Tireur;


/**
 * 
 * @author Aurelia
 *
 */
public class Deplacement extends Action {


  public Deplacement(Robot robot, Coordonnees direction) {
    super(robot, direction);
    // TODO Auto-generated constructor stub
  }

  public boolean deplacementPossible(Cellule c){
    if(this.getRobot() instanceof Tireur || this.getRobot() instanceof Piegeur){
      Cellule inter = new Cellule(this.getRobot().getCoordonnees().getLargeur(),this.getRobot().getCoordonnees().getHauteur());
      Coordonnees coord = inter.getCoordonnees().calculCoordonnees(c.getCoordonnees());
      for(int i=0;i<Constante.DEP_TIREUR.size();i++){
        if(coord.equals(Constante.DEP_TIREUR.get(i))) {
          if(c.estRobot() == 0 || c.contientMine() >= 0 ||
              c.estBase() == this.getRobot().getEquipe() || !c.estMur()){
            return true;
          }
        }
      }
    }
    if(this.getRobot() instanceof Char){
      Cellule inter = new Cellule(this.getRobot().getCoordonnees().getLargeur(), this.getRobot().getCoordonnees().getHauteur());
      //cree une cellule avec les coordonnes du robot courant
      Coordonnees coord = inter.getCoordonnees().calculCoordonnees(c.getCoordonnees());
      //renvoit a la fonction dans la classe cellule qui calule la distance entre les coordonnes du robot et celles de la cellule passee en parametre
      for(int i=0;i<Constante.DEP_CHAR.size();i++){
        //parcourt le tableau des deplacements du char
        if(coord.equals(Constante.DEP_CHAR.get(i))) {
          //si les coordonnees calculees sont egales a une des coordonnees de la constante DEP_CHAR
          if(c.estVide()){
            //et si la cellule est vide alors le deplacement est possible
            return true;
          }
        }
      }
    }
    return false;
  }


  @Override
  public void agit(Cellule c) {
    if (this.getRobot() instanceof Tireur || this.getRobot() instanceof Piegeur || this.getRobot() instanceof Char) {
      if(this.deplacementPossible(c)){
        //si le deplacmeent est possible
        this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoupDep());
        //le robot perd de l'energie en se deplacant (energie du robot - cout de deplacement)
        this.moveTo(c.getCoordonnees());
        //les coordonnees du robot deviennent les coordonnees de la cellule sur laquelle il se deplace
        if (c.contientMine() != this.getRobot().getEquipe()) {
          this.getRobot().subitMine();
        }
      }
    }
  }

  public void moveTo(Coordonnees c){
    this.getRobot().getVue().retirerRobot(this.getRobot().getCoordonnees());  
    this.getRobot().setCoordonnees(c);
    this.getRobot().getVue().poserRobot(getRobot(), c);
  }
}

