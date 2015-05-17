package gameOfWar.robot;

import gameOfWar.action.Action;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.config.Factory;
import gameOfWar.jeux.Equipe;
import gameOfWar.jeux.Vue;

import java.util.ArrayList;
import java.util.List;

public class Worker extends Robot {

  public Worker(Vue vue, Equipe equipe) {
    super(vue, equipe);
    this.setEnergie(Constante.ENERGIE_WORKER);
  }

  @Override
  public Action choisitAction() {
    List<Coordonnees> dep = initDep();
    List<Coordonnees> nearBy = nearBy();
    List<Coordonnees> facto = initFacto();
    int nbFacto = this.getEquipe().getNbFacto();
    int chabada = nearBy.isEmpty() ? 2 : 3;
    System.out.println("Vous pouvez :\n\t1 - deplacer");
    if (!facto.isEmpty() && nbFacto < Constante.NB_FACTO_MAX) {
      System.out.println("\t" + (nearBy.isEmpty() ? 2 : 3) + " - poser une factory");
    }
    if (!nearBy.isEmpty()) {
      System.out.println("\t2 - reparer");
    }
    int i = this.getEquipe().secureInput(1, (!facto.isEmpty() ? 3 : (!nearBy.isEmpty() ? 2 : 1)));
    switch (i) {
      case 1:
        return choisitDep(dep);
      case 2:
        if (chabada == 3) {
          int h = 0;
          System.out.println("Vous pouvez reparer :");
          for (Coordonnees c : nearBy) {
            System.out.println(h + " : " + c + " " + direction(c));
            h += 1;
          }
          this.getVue().getPlateau()
              .getCelluleByCoordonnees(nearBy.get(this.getEquipe().secureInput(0, h - 1)))
              .getRobot().estSoigne();
          return null;
        }
      case 3:
        if (nbFacto < Constante.NB_FACTO_MAX) {
          int j = 0;
          System.out.println("Vous pouvez placer une factory sur :");
          for (Coordonnees c : facto) {
            System.out.println(j + " : " + c + " " + direction(c));
            j += 1;
          }
          this.setObjectif(facto.get(this.getEquipe().secureInput(0, j - 1)));
          new Factory(this);
          return null;
        }
      default:
        return null;
    }
  }

  private List<Coordonnees> initFacto() {
    List<Coordonnees> toto = initDep();
    List<Coordonnees> tmp = new ArrayList<Coordonnees>();
    tmp.addAll(toto);
    int px = getVue().getPlateau().getLargeur();
    int py = getVue().getPlateau().getLongueur();
    for (Coordonnees coordonnees : toto) {
      if (coordonnees.equals(new Coordonnees(0, 1))) {
        tmp.remove(coordonnees);
      } else if (coordonnees.equals(new Coordonnees(1, 0))) {
        tmp.remove(coordonnees);
      } else if (coordonnees.equals(new Coordonnees(1, 1))) {
        tmp.remove(coordonnees);
      } else if (coordonnees.equals(new Coordonnees(px - 1, py - 2))) {
        tmp.remove(coordonnees);
      } else if (coordonnees.equals(new Coordonnees(px - 2, py - 1))) {
        tmp.remove(coordonnees);
      } else if (coordonnees.equals(new Coordonnees(px - 2, py - 2))) {
        tmp.remove(coordonnees);
      } else if (coordonnees.equals(new Coordonnees(px - 1, py - 1))) {
        tmp.remove(coordonnees);
      } else if (coordonnees.equals(new Coordonnees(0, 0))) {
        tmp.remove(coordonnees);
      }
    }
    return tmp;
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
    return 0; // impossible de tirer
  }

  @Override
  public List<Coordonnees> getDeplacements() {
    return null;
  }

  @Override
  public String getType() {
    return this.getClass().getName().substring(getClass().getName().lastIndexOf(".") + 1);
  }

  @Override
  public void subitMine() {
    setEnergie(getEnergie() - getDegatMine());
  }

  @Override
  public void subitTirDe(Robot robot) {
    setEnergie(getEnergie() - robot.getDegatTir());
  }

  public List<Coordonnees> initDep() {
    List<Coordonnees> dep = new ArrayList<Coordonnees>();
    List<Coordonnees> caillou = new ArrayList<Coordonnees>();
    for (Coordonnees coordonnees : Constante.DEP_WORKER) {
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
        // System.err.println("null pointer"); // normal car hors map
      }
    }
    return dep;
  }

  private List<Coordonnees> nearBy() {
    List<Coordonnees> ans = new ArrayList<Coordonnees>();
    List<Coordonnees> notAns = new ArrayList<Coordonnees>();
    for (Coordonnees coordonnees : Constante.DEP_WORKER) {
      notAns.add(this.getCoordonnees().ajout(coordonnees));
    }
    for (Coordonnees coordonnees : notAns) {
      try {
        if (this.getVue().getPlateau().getCelluleByCoordonnees(coordonnees).estRobot() != 0) {
          ans.add(coordonnees);
        }
      } catch (Exception e) {
        // sortie de map
      }
    }
    return ans;
  }

  @Override
  public String toString() {
    return this.getType() + ", " + super.toString();
  }

}
