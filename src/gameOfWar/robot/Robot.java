package gameOfWar.robot;

import gameOfWar.action.Action;
import gameOfWar.action.Deplacement;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.jeux.Equipe;
import gameOfWar.jeux.Vue;

import java.util.List;


/**
 * @author Alexandre
 * @author Clement
 */
public abstract class Robot {

  private Coordonnees coordonnees;
  private int energie;
  private Equipe equipe;
  private Vue vue;
  private Coordonnees objectif;


  public Robot(Vue vue, Equipe equipe) {
    /** calcul des coordonnees de la base en fonction de son num d'equipe */
    this.coordonnees =
        new Coordonnees((equipe.getEquipe() == Constante.EQUIPE_UN) ? 0 : vue.getPlateau()
            .getLargeur() - 1, (equipe.getEquipe() == Constante.EQUIPE_UN) ? 0 : vue.getPlateau()
            .getLongueur() - 1);
    this.equipe = equipe;
    this.vue = vue;
  }

  abstract public Action choisitAction();

  public void disparait() {
    this.vue.getPlateau().getCelluleByCoordonnees(this.coordonnees).videCase();
    this.equipe.removeRobot(this);
  }

  public boolean estMort() {
    return this.energie <= 0;
  }

  abstract public void estSoigne();

  public boolean estSurBase() {
    /** calcul des coordonnees de la base */
    return this.coordonnees.equals(new Coordonnees((equipe.getEquipe() == Constante.EQUIPE_UN) ? 0
        : vue.getPlateau().getLargeur() - 1, (equipe.getEquipe() == Constante.EQUIPE_UN) ? 0 : vue
        .getPlateau().getLongueur() - 1));
  }

  public Coordonnees getCoordonnees() {
    return this.coordonnees;
  }

  abstract public int getCoupDep();

  abstract public int getCoutAction();

  abstract public int getDegatMine();

  abstract public int getDegatTir();

  abstract public List<Coordonnees> getDeplacements();

  public int getEnergie() {
    return this.energie;
  }

  public Equipe getEquipe() {
    return this.equipe;
  }

  public int getNumEquipe() {
    return this.equipe.getEquipe();
  }

  public Coordonnees getObjectif() {
    return this.objectif;
  }

  abstract public String getType();

  public Vue getVue() {
    return this.vue;
  }

  public void perdEnergieApresAction() {
    this.setEnergie(getEnergie() - getCoutAction());
  }

  public void perdEnergieApresDep() {
    this.setEnergie(getEnergie() - getCoupDep());
  }

  public void setCoordonnees(Coordonnees coordonnees) {
    this.coordonnees = coordonnees;
  }

  public void setEnergie(int energie) {
    this.energie = energie;
  }

  public void setObjectif(Coordonnees objectif) {
    this.objectif = objectif;
  }

  abstract public void subitMine();

  abstract public void subitTirDe(Robot robot);

  @Override
  public String toString() {
    return "energie : " + this.energie + ", " + this.coordonnees.toString();
  }

  public String direction(Coordonnees c) {
    Coordonnees arrive = this.getCoordonnees().difference(c);
    if (arrive.equals(Constante.BAS_CHAR)) {
      return "SUD";
    }
    if (arrive.equals(Constante.HAUT_CHAR)) {
      return "NORD";
    }
    if (arrive.equals(Constante.DROITE_CHAR)) {
      return "EST";
    }
    if (arrive.equals(Constante.GAUCHE_CHAR)) {
      return "OUEST";
    }
    if (arrive.equals(Constante.BAS)) {
      return "SUD";
    }
    if (arrive.equals(Constante.HAUT)) {
      return "NORD";
    }
    if (arrive.equals(Constante.DROITE)) {
      return "EST";
    }
    if (arrive.equals(Constante.GAUCHE)) {
      return "OUEST";
    }
    if (arrive.equals(Constante.HAUT_DROITE)) {
      return "NORD EST";
    }
    if (arrive.equals(Constante.HAUT_GAUCHE)) {
      return "NORD OUEST";
    }
    if (arrive.equals(Constante.BAS_DROITE)) {
      return "SUD EST";
    }
    if (arrive.equals(Constante.BAS_GAUCHE)) {
      return "SUD OUEST";
    }
    return "unknown";
  }

  public Action choisitDep(List<Coordonnees> dep) {
    int j = 0;
    System.out.println("vous pouvez aller en :");
    for (Coordonnees c : dep) {
      System.out.println(j + ": " + c + " " + direction(c));
      j += 1;
    }
    this.setObjectif(dep.get(Constante.secureInput(0, j - 1)));
    return new Deplacement(this);
  }
}
