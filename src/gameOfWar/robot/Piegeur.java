
package gameOfWar.robot;
import gameOfWar.action.Action;
import gameOfWar.action.Deplacement;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.config.Mine;
import gameOfWar.jeux.Equipe;
import gameOfWar.jeux.Vue;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Mariam, Mathieu, Clement
 *
 */
public class Piegeur extends Robot {

  private int nbMines = 10;

  private List<Coordonnees> coordonnees; //A mediter (voir : direction et objectif) CLEMENT !

  
  public Piegeur(Vue vue, Equipe equipe) {
    super(vue, equipe);
    this.setEnergie(Constante.ENERGIE_PIEGEUR);
  }

  @Override
  public Action choisitAction() {
    System.out.println("Vous pouvez :\n\t1 - deplacer\n\t2 - mine");
    List<Coordonnees> dep = initDep();
    int i = Constante.secureInput(1, 2);
    switch (i) {
      case 1:
        int j = 0;
        System.out.println("vous pouvez aller en :");
        for (Coordonnees c : dep) {
          System.out.println(j+": "+c);
          j += 1;
        }
        this.setObjectif(dep.get(Constante.secureInput(0, j-1)));
        return new Deplacement(this);
      case 2:
        int h = 0;
        System.out.println("vous pouvez poser une mine en :");
        for (Coordonnees c : dep) {
          System.out.println(h+": "+c);
          h += 1;
        }
        this.setObjectif(dep.get(Constante.secureInput(0, h-1)));
        new Mine(this);
        return null;
      default:
        return null;
    }
  }
  
  @Override
  public void estSoigne() {
    this.setEnergie(Math.min(Constante.ENERGIE_PIEGEUR, getEnergie() + Constante.SOIN));
  }
  @Override
  public int getCoupDep() {
    return Constante.COUP_DEPLACEMENTS_PIEGEUR;
  }

  @Override
  public int getCoutAction() {
    return Constante.COUP_ACTION_PIEGEUR;
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
  public List<Coordonnees> getDeplacements() {
    return this.coordonnees;
  }

  public int getNbMines(){
    return this.nbMines;
  }

  @Override
  public String getType() {
    return this.getClass().getName().substring(getClass().getName().lastIndexOf(".")+1);
  }

  public void perdUneMine() {
    this.setNbMines(this.getNbMines()-1);
  }

  public boolean poseMine() {
    if (this.getNbMines() <= 0) {
      return false;
    }if (getVue().getPlateau().getCelluleByCoordonnees(getObjectif()).estVide()) {
      new Mine(this);
      return true;
    }return false;
  }

  public void setNbMines(int nbMines){
    this.nbMines = nbMines;
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
    return this.getType() + ", " + super.toString() + ", mines :"+getNbMines();
  }
  
  private List<Coordonnees> initDep() {
    List<Coordonnees> dep = new ArrayList<Coordonnees>();
    List<Coordonnees> caillou = new ArrayList<Coordonnees>();
    for (Coordonnees coordonnees : Constante.DEP_CHAR) {
      dep.add(this.getCoordonnees().ajout(coordonnees));
    }caillou.addAll(dep);
    for (Coordonnees c : caillou) {
      if (c.getHauteur() < 0 || c.getLargeur() < 0
          || c.getHauteur() >= this.getVue().getPlateau().getLongueur()
          || c.getLargeur() >= this.getVue().getPlateau().getLargeur()) {
        dep.remove(c);
      }try {
        if (this.getVue().getPlateau().getCelluleByCoordonnees(c).estMur()) {
          dep.remove(c);
        }
      } catch (Exception e) {
        //System.err.print("null pointer ");
      }
    }
    return dep;
  }

}
