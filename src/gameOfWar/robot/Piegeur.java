
package gameOfWar.robot;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.jeux.Vue;
import java.util.ArrayList;
import java.util.List;


public class Piegeur extends Robot {

  private final int DEGATS_TIR = 2; /*degats qu'il se prend après un tir*/
  private final int DEGATS_MINES = 2; /*degats qu'il se prend après une mine*/
  private final int COUP_DEP = 2; /*degats qu'il se prend en se deplaçant*/
  private final int COUP_ACTION = 2; /*degats qu'il se prend en posant une mine*/
  private int nbMines = 10;
  
  private List<Coordonnees> coordonnees;
  
  public Piegeur(Vue vue, int l, int h, int equipe) {
    super(vue, l, h, equipe);
    this.coordonnees = new ArrayList<Coordonnees>();
    this.coordonnees = Constante.DEP_PIEGEUR;
    // TODO Auto-generated constructor stub
  }

  @Override
  public int getCoupDep() {
    // TODO Auto-generated method stub
    return this.COUP_DEP;
  }

  @Override
  public int getCoutAction() {
    // TODO Auto-generated method stub
    return this.COUP_ACTION;
  }

  @Override
  public int getDegatMine() {
    return this.DEGATS_MINES;
  }

  @Override
  public int getDegatTir() {
    return this.DEGATS_TIR;
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
    // TODO Auto-generated method stub
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
	// TODO Auto-generated method stub
	setEnergie(getEnergie()-2);
}

@Override
public void subitTir() {
	// TODO Auto-generated method stub
	setEnergie(getEnergie()-2);
}

}