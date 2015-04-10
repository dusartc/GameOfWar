
package gameOfWar.robot;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.jeux.Vue;

import java.util.List;


public class Piegeur extends Robot {

  private int nbMines = 10;
  
  private List<Coordonnees> coordonnees;
  
  public Piegeur(Vue vue, int equipe) {
    super(vue, equipe);
    this.setEnergie(Constante.ENERGIE_PIEGEUR);
    this.coordonnees = Constante.DEP_PIEGEUR;
  }
  
  @Override
  public int getDegatMine() {
    return Constante.DEGATS_PIEGEUR;
  }

  @Override
  public int getDegatTir() {
    return Constante.DEGATS_PIEGEUR;
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
  public void subitMine() {
    setEnergie(getEnergie()-Constante.DEGATS_PIEGEUR);
  }

  public void subitTirDe(Robot robot) {
    setEnergie(getEnergie()-Constante.DEGATS_PIEGEUR);
  }
  
  @Override
  public String toString() {
    return this.getType() + " " + super.toString();
  }

}