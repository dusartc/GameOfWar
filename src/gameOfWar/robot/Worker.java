package gameOfWar.robot;

import gameOfWar.action.Action;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.jeux.Equipe;
import gameOfWar.jeux.Vue;

import java.util.List;

public class Worker extends Robot {

  public Worker(Vue vue, Equipe equipe) {
    super(vue, equipe);
    this.setEnergie(Constante.ENERGIE_WORKER);
  }

  @Override
  public Action choisitAction() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void estSoigne() {
    // inutile car OS

  }

  @Override
  public int getCoupDep() {
    return Constante.COUP_DEPLACEMENTS_WORKER;
  }

  @Override
  public int getCoutAction() {
    return Constante.COUP_ACTION_WORKER;
  }

  @Override
  public int getDegatMine() {
    return Constante.DEGATS_MINES_WORKER;
  }

  @Override
  public int getDegatTir() {
    return 0;
  }

  @Override
  public List<Coordonnees> getDeplacements() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getType() {
    return this.getClass().getName().substring(getClass().getName().lastIndexOf(".") + 1);
  }

  @Override
  public void subitMine() {
    // TODO Auto-generated method stub

  }

  @Override
  public void subitTirDe(Robot robot) {
    // TODO Auto-generated method stub

  }

}
