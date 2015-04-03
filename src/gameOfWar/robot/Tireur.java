package gameOfWar.robot;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.jeux.Vue;

import java.util.List;
// Touche moi cette belle ArrayList(I).


public class Tireur extends Robot {

  private final int DEGATS_TIRS = 4;
  private final int DEGATS_MINES = 0;
  
  private List<Coordonnees> coordonnees; //A méditer (voir : direction et objectif) CLEMENT !
  
  public Tireur(Vue vue, int equipe) {
    super(vue, equipe);
    this.setEnergie(Constante.ENERGIE_TIREUR);
    // TODO Auto-generated constructor stub
  }

  @Override
  public int getCoupDep() {
    return 1;
  }

  @Override
  public int getCoutAction() {
    return 0;
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
public void subitTir() {
	// TODO Auto-generated method stub
	
}

}
