package gameOfWar.robot;

import gameOfWar.action.Action;
import gameOfWar.action.Attaque;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.jeux.Equipe;
import gameOfWar.jeux.Vue;

import java.util.ArrayList;
import java.util.List;


// import java.util.ArrayList;import java.util.List;
// Touche moi cette belle ArrayList(I


/**
 * Modelise un Char
 * 
 * @author Aurelia
 * @author Mathieu
 * @author Clement
 *
 */
public class Char extends Robot {

  private List<Coordonnees> coordonnees;

  /**
   * Construit un char
   * 
   * @param vue la vue du char
   * @param equipe l'equipe du char
   * @see Robot
   */
  public Char(Vue vue, Equipe equipe) {
    super(vue, equipe);
    this.setEnergie(Constante.ENERGIE_CHAR);
  }

  /**
   * @see Robot
   */
  @Override
  public Action choisitAction() {
    List<Coordonnees> dep = initDep();
    List<Coordonnees> cible = initCible();
    if (!cible.isEmpty()) {
      System.out.println("Vous pouvez :\n\t1 - deplacer\n\t2 - Attaquer");
      int i = this.getEquipe().secureInput(1, 2);
      switch (i) {
        case 1:
          return choisitDep(dep);
        case 2:
          int h = 0;
          System.out.println("Vous pouvez attaquer :");
          for (Coordonnees c : cible) {
            System.out.println(h + " : " + c + " " + direction(c));
            h += 1;
          }
          this.setObjectif(cible.get(this.getEquipe().secureInput(0, h - 1)));
          return new Attaque(this);
        default:
          System.out.println("mauvais input @choisitAction()");
          break;
      }
    } else {
      System.out.println("Aucune cible disponible\nVous ne pouvez que vous deplacer");
      return choisitDep(dep);
    }
    return null;
  }

  /**
   * @see Robot
   */
  @Override
  public void estSoigne() {
    int prev = getEnergie();
    this.setEnergie(Math.min(Constante.ENERGIE_CHAR, getEnergie() + Constante.SOIN));
    if (prev != getEnergie()) {
      System.out.println(getType() + " a ete soigne de " + Constante.SOIN);
    }
  }

  /**
   * @see Robot
   */
  @Override
  public int getCoupDep() {
    return Constante.COUP_DEPLACEMENTS_CHAR;
  }

  /**
   * @see Robot
   */
  @Override
  public int getCoutAction() {
    return Constante.COUP_ACTION_CHAR;
  }

  /**
   * @see Robot
   */
  @Override
  public int getDegatMine() {
    return Constante.DEGATS_MINES_CHAR;
  }

  /**
   * @see Robot
   */
  @Override
  public int getDegatTir() {
    return Constante.DEGATS_CHAR;
  }

  @Override
  public List<Coordonnees> getDeplacements() {
    return this.coordonnees;
  }

  /**
   * @see Robot
   */
  @Override
  public String getType() {
    return this.getClass().getName().substring(getClass().getName().lastIndexOf(".") + 1);
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
    return this.getType() + ", " + super.toString();
  }

  private List<Coordonnees> initCible() {
    List<Coordonnees> cible2 = new ArrayList<Coordonnees>();
    List<Coordonnees> cible = new ArrayList<Coordonnees>();
    for (Coordonnees coordonnees : Constante.L_PORTEE_CHAR) {
      cible.add(this.getCoordonnees().ajout(coordonnees));
    }
    for (int i = 0; i < cible.size(); i++) {
      Coordonnees c = cible.get(i);
      try {
        if (this.getVue().getPlateau().getCelluleByCoordonnees(c).estMur()) {
          i = (((i + Constante.PORTEE_CHAR) / Constante.PORTEE_CHAR) * Constante.PORTEE_CHAR) - 1;
          continue;
        }
        if (this.getVue().getPlateau().getCelluleByCoordonnees(c).estRobot() != this.getEquipe()
            .getEquipe() && this.getVue().getPlateau().getCelluleByCoordonnees(c).estRobot() != 0) {
          cible2.add(c);
        }
      } catch (Exception e) {
        // System.err.print("@initCible ");
      }
    }
    return cible2;
  }

  private List<Coordonnees> initDep() {
    List<Coordonnees> dep = new ArrayList<Coordonnees>();
    List<Coordonnees> caillou = new ArrayList<Coordonnees>();
    for (Coordonnees coordonnees : Constante.DEP_CHAR) {
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
        // System.err.println("null pointer");
      }
    }
    return dep;
  }
}
