package gameOfWar.robot;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.jeux.Vue;

import java.util.ArrayList;
import java.util.List;


public class Char extends Robot{
  
  private final int DEGATS_TIRS = 4;
  private final int DEGATS_MINES = 0;
  
  private List<Coordonnees> coordonnees;
  
  public Char(Vue vue, int equipe) {
    super(vue, equipe);
    this.coordonnees = new ArrayList<Coordonnees>();
    this.coordonnees = Constante.DEP_TIREUR;
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
    return this.DEGATS_MINES;
  }

  @Override
  public int getDegatTir() {
    return this.DEGATS_TIRS;
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
    return false;
  }

  @Override
  public void subitMine() {
    // TODO Auto-generated method stub

  }

  @Override
  public void subitTirDe(Robot robot) {
    // TODO Auto-generated method stub

  }
  
  @Override
  public String toString() {
    return this.getClass().getName() + "\n" + super.toString();
  }
}
