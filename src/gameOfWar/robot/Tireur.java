package gameOfWar.robot;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.jeux.Vue;

import java.util.List;
// Touche moi cette belle ArrayList(I).


public class Tireur extends Robot {
  
  private List<Coordonnees> coordonnees; //A mediter (voir : direction et objectif) CLEMENT !
  
  public Tireur(Vue vue, int equipe) {
    super(vue, equipe);
    this.setEnergie(Constante.ENERGIE_TIREUR);
    // TODO Auto-generated constructor stub
  }

  @Override
  public int getCoupDep() {
    return Constante.COUP_DEPLACEMENTS_TIREUR;
  }

  @Override
  public int getCoutAction() {
    return Constante.COUP_ACTION_TIREUR;
  }

  @Override
  public int getDegatMine() {
    return Constante.DEGATS_MINES_TIREUR;
  }

  @Override
  public int getDegatTir() {
    return Constante.DEGATS_TIREUR;
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
      if(robot.getEquipe != this.getEquipe()){
        setEnergie(getEnergie()-(Piegeur)robot.getDegatMine());
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
    if(robot instanceof Tirreur){
      if(robot.getEquipe() != this.getEquipe()){
        this.setEnergie(this.getEnergie()-(Tirreur)robot.getDegatTir());
      }
      else{
        setEnergie(getEnergie());
      }
    }
    else if (robot instanceof Char){
      if(robot.getEquipe() != this.getEquipe()){
        this.setEnergie(this.getEnergie()-(Char)robot.getDegatTir());
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
