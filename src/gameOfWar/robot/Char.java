package gameOfWar.robot;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.jeux.Equipe;
import gameOfWar.jeux.Vue;

//import java.util.ArrayList;
import java.util.List;
//Touche moi cette belle ArrayList(I).

/**
 * 
 * @author Aurelia, Mathieu, Clement
 *
 */
public class Char extends Robot{

  private List<Coordonnees> coordonnees; //A mediter (voir : direction et objectif) CLEMENT !

  public Char(Vue vue, Equipe equipe) {
    super(vue, equipe);
    this.setEnergie(Constante.ENERGIE_CHAR);
  }

  @Override
  public int getCoupDep() {
    return Constante.COUP_DEPLACEMENTS_CHAR;
  }

  @Override
  public int getCoutAction() {
    return Constante.COUP_ACTION_CHAR;
  }

  @Override
  public int getDegatMine() {
    return Constante.DEGATS_MINES_CHAR;
  }

  @Override
  public int getDegatTir() {
    return Constante.DEGATS_CHAR;
  }

  @Override
  public List<Coordonnees> getDeplacements() {
    return this.coordonnees;
  }

  @Override
  public String getType() {
    return getClass().getName();
  }

  @Override
  public boolean peutTirer() {
    return true;
  }

  @Override
  public void subitMine() {
      setEnergie(getEnergie()-Constante.DEGATS_PIEGEUR);
    }

  @Override
  public void subitTirDe(Robot robot) {
    if(robot instanceof Tireur || robot instanceof Char){
      if(robot.getEquipe() != this.getEquipe()){
        this.setEnergie(this.getEnergie()-robot.getDegatTir());
      }
    }
    else {
      System.err.println("Impossible de subir un Tir");
    }
  }

  @Override
  public String toString() {
    return this.getType() + ", " + super.toString();
  }
}
