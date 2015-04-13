
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
//Touche moi cette belle ArrayList(I).
import java.util.Scanner;

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

  public int getNbMines(){
    return this.nbMines;
  }
  
  public void setNbMines(int nbMines){
    this.nbMines = nbMines;
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
    return Constante.COUP_ACTION_PIEGEUR;
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
    if (this.getNbMines() <= 0) {
      return false;
    }if (getVue().getPlateau().getCelluleByCoordonnees(getObjectif()).estVide()) {
      new Mine(this);
      //getVue().getPlateau().getCelluleByCoordonnees(getCoordonnees()).poseMine(this.getNumEquipe());
      return true;
    }return false;
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
    return this.getType() + ", " + super.toString();
  }
  
  public void perdUneMine() {
    this.setNbMines(this.getNbMines()-1);
  }

  @Override
  public Action choisitAction() {
    System.out.println("Vous pouvez :\n\t1 - deplacer\n\t2 - mine");
    List<Coordonnees> dep = new ArrayList<Coordonnees>();
    for (Coordonnees coordonnees : Constante.DEP_PIEGEUR) {
      dep.add(this.getCoordonnees().ajout(coordonnees));
    }
    for (Coordonnees c : dep) {
      if (c.getHauteur() < 0 || c.getLargeur() < 0
          || c.getHauteur() >= this.getVue().getPlateau().getLongueur()
          || c.getLargeur() >= this.getVue().getPlateau().getLargeur()) {
        dep.remove(c);
      }if (this.getVue().getPlateau().getCelluleByCoordonnees(c).estMur()) {
        dep.remove(c);
      }
    }
    Scanner sc = new Scanner(System.in);
    int i = sc.nextInt();
    switch (i) {
      case 1:
        int j = 0;
        System.out.println("vous pouvez aller en :");
        for (Coordonnees c : dep) {
          System.out.println(j+": "+c);
          j += 1;
        }
        this.setObjectif(dep.get(sc.nextInt() - 1));
        return new Deplacement(this);
      case 2:
        int h = 0;
        System.out.println("vous pouvez poser une mine en :");
        for (Coordonnees c : dep) {
          System.out.println(h+": "+c);
          h += 1;
        }
        this.setObjectif(dep.get(sc.nextInt() - 1));
        new Mine(this);
        return null;
      default:
        return null;
    }
  }

}