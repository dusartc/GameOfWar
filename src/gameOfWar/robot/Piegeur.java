package gameOfWar.robot;

import gameOfWar.action.Action;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.config.Mine;
import gameOfWar.jeux.Equipe;
import gameOfWar.jeux.Vue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mariam, Mathieu
 * @author Clement
 */
public class Piegeur extends Robot {

  private int nbMines = Constante.NB_MINES_MAX;

  private List<Coordonnees> coordonnees;

  /**
   * Construit un Piegeur
   * 
   * @param vue la vue du piegeur
   * @param equipe l'equipe du piegeur
   * @see Robot
   */
  public Piegeur(Vue vue, Equipe equipe) {
    super(vue, equipe);
    this.setEnergie(Constante.ENERGIE_PIEGEUR);
  }

  /**
   * @see Robot
   */
  @Override
  public Action choisitAction() {
    List<Coordonnees> dep = initDep();
    List<Coordonnees> mines = initMines();
    if (!mines.isEmpty() && this.getNbMines() > 0) {
      System.out.println("Vous pouvez :\n\t1 - deplacer\n\t2 - mine");
      int i = this.getEquipe().secureInput(1, 2);
      switch (i) {
        case 1:
          return choisitDep(dep);
        case 2:
          int h = 0;
          System.out.println("vous pouvez poser une mine en :");
          for (Coordonnees c : dep) {
            System.out.println(h + ": " + c);
            h += 1;
          }
          this.setObjectif(dep.get(this.getEquipe().secureInput(0, h - 1)));
          new Mine(this);
          return null;
        default:
          return null;
      }
    } else {
      System.out.println("Vous ne pouvez pas poser de mines\nVous ne pouvez que vous deplacez");
      return choisitDep(dep);
    }
  }

  /**
   * @see Robot
   */
  @Override
  public void estSoigne() {
    int prevE = getEnergie();
    int prevM = getNbMines();
    this.setEnergie(Math.min(Constante.ENERGIE_PIEGEUR, getEnergie() + Constante.SOIN));
    this.setNbMines(Constante.NB_MINES_MAX);
    if (prevE != getEnergie()) {
      if (prevM != getNbMines()) {
        System.out.println(getType() + " a ete soigne de " + Constante.SOIN + " et a recupere "
            + Constante.NB_MINES_MAX + " mines");
      } else {
        System.out.println(getType() + " a ete soigne de " + Constante.SOIN);
      }
    } else if (prevM != getNbMines()) {
      System.out.println(getType() + " a recupere " + Constante.NB_MINES_MAX + "mines");
    }
  }

  /**
   * @see Robot
   */
  @Override
  public int getCoupDep() {
    return Constante.COUP_DEPLACEMENTS_PIEGEUR;
  }

  /**
   * @see Robot
   */
  @Override
  public int getCoutAction() {
    return Constante.COUP_ACTION_PIEGEUR;
  }

  /**
   * @see Robot
   */
  @Override
  public int getDegatMine() {
    return Constante.DEGATS_PIEGEUR;
  }

  /**
   * @see Robot
   */
  @Override
  public int getDegatTir() {
    return Constante.DEGATS_TIRS_PIEGEUR; // Vaut 0
  }

  @Override
  public List<Coordonnees> getDeplacements() {
    return this.coordonnees;
  }

  /**
   * Renvoie le nombre de mines que le pigeur possede
   * 
   * @return int
   */
  public int getNbMines() {
    return this.nbMines;
  }

  /**
   * @see Robot
   */
  @Override
  public String getType() {
    return this.getClass().getName().substring(getClass().getName().lastIndexOf(".") + 1);
  }

  public void perdUneMine() {
    this.setNbMines(this.getNbMines() - 1);
  }

  /**
   * retourne vrai si le Robot a reussis a poser une mine
   * 
   * @return boolean
   */
  public boolean poseMine() {
    if (this.getNbMines() <= 0) {
      return false;
    }
    if (getVue().getPlateau().getCelluleByCoordonnees(getObjectif()).estVide()) {
      new Mine(this);
      return true;
    }
    return false;
  }

  public void setNbMines(int nbMines) {
    this.nbMines = nbMines;
  }

  /**
   * @see Robot
   */
  @Override
  public void subitMine() {
    setEnergie(getEnergie() - getDegatMine());
  }

  /**
   * @see Robot
   */
  @Override
  public void subitTirDe(Robot robot) {
    this.setEnergie(this.getEnergie() - robot.getDegatTir());
  }

  @Override
  public String toString() {
    return this.getType() + ", " + super.toString() + ", mines :" + getNbMines();
  }

  private List<Coordonnees> initDep() {
    List<Coordonnees> dep = new ArrayList<Coordonnees>();
    List<Coordonnees> caillou = new ArrayList<Coordonnees>();
    for (Coordonnees coordonnees : Constante.DEP_PIEGEUR) {
      dep.add(this.getCoordonnees().ajout(coordonnees));
    }
    caillou.addAll(dep);
    for (Coordonnees c : caillou) {
      if (c.getHauteur() < 0 || c.getLargeur() < 0
          || c.getHauteur() >= this.getVue().getPlateau().getLongueur()
          || c.getLargeur() >= this.getVue().getPlateau().getLargeur()) {
        dep.remove(c);
      }
      try {
        if (this.getVue().getPlateau().getCelluleByCoordonnees(c).estImpassable()) {
          dep.remove(c);
        }
      } catch (Exception e) {
        // System.err.print("null pointer ");
      }
    }
    return dep;
  }

  private List<Coordonnees> initMines() {
    List<Coordonnees> mines = new ArrayList<Coordonnees>();
    List<Coordonnees> mines2 = new ArrayList<Coordonnees>();
    for (Coordonnees coordonnees : Constante.DEP_PIEGEUR) {
      mines.add(this.getCoordonnees().ajout(coordonnees));
    }
    mines2.addAll(mines);
    for (Coordonnees coordonnees : mines2) {
      try {
        if (!this.getVue().getPlateau().getCelluleByCoordonnees(coordonnees).estVide()) {
          mines.remove(coordonnees);
        }
      } catch (Exception e) {
        // System.err.println("null pointer");
      }
    }
    return mines;
  }

}
