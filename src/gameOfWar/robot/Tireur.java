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
  public void subitMine() {
      if(this.getVue().getPlateau().estMine(this.getCoordonnees().getLargeur(), this.getCoordonnees().getHauteur()) 
          != this.getEquipe()){
        setEnergie(getEnergie()-Constante.DEGATS_PIEGEUR);
      }
      else{
        setEnergie(getEnergie());
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
