package gameOfWar.robot;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.jeux.Vue;


//import java.util.ArrayList;
import java.util.List;
//Touche moi cette belle ArrayList(I).


public class Char extends Robot{
  
  private List<Coordonnees> coordonnees; //A mediter (voir : direction et objectif) CLEMENT !
  
  public Char(Vue vue, int equipe) {
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
  public void subitMine(Robot robot) {
    if(robot instanceof Piegeur){
      if(robot.getEquipe() != this.getEquipe()){
        setEnergie(getEnergie()-robot.getDegatMine());
      }
      else{
        setEnergie(getEnergie());
      }
    }
    else {
      System.err.println("Impossible de subir une Mine");
    }
  }

  @Override
  public void subitTirDe(Robot robot) {
    if(robot instanceof Tireur || robot instanceof Char){
      if(robot.getEquipe() != this.getEquipe()){
        this.setEnergie(this.getEnergie()-robot.getDegatTir());
      }
      else{
        setEnergie(getEnergie());
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
