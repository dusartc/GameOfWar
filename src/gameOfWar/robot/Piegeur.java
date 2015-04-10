
package gameOfWar.robot;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.jeux.Vue;

import java.util.List;
//Touche moi cette belle ArrayList(I).

public class Piegeur extends Robot {

  private int nbMines = 10;
  
  private List<Coordonnees> coordonnees; //A mediter (voir : direction et objectif) CLEMENT !
  
  public Piegeur(Vue vue, int equipe) {
    super(vue, equipe);
    this.setEnergie(Constante.ENERGIE_PIEGEUR);
  }
  
  @Override
  public int getDegatMine() {
    return Constante.DEGATS_PIEGEUR;
  }

  @Override
  public int getDegatTir() {
    return Constante.DEGATS_TIRS_PIEGEUR; // Vaut 0
  }

  @Override
  public int getCoupDep() {
    return Constante.COUP_DEPLACEMENTS_PIEGEUR;
  }

  @Override
  public int getCoutAction() {
    return Constante.COUP_ACTION_TIREUR;
  }

  @Override
  public List<Coordonnees> getDeplacements() {
	    return this.coordonnees;
  }

  @Override
  public String getType() {
    return this.getClass().getName();
  }

  @Override
  public boolean peutTirer() {
    return false;
  }
  
  public boolean poseMine() {
    if (this.nbMines <= 0) {
      return false;
    }if (getVue().getPlateau().getCelluleByCoordonnees(getCoordonnees()).estVide()) {
      getVue().getPlateau().getCelluleByCoordonnees(getCoordonnees()).poseMine(this.getEquipe());
      return true;
    }return false;
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