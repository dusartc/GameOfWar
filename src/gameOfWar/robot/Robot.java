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

  /**
   * Contruit un Robot
   * 
   * @param vue la vue du robot
   * @param equipe l'equipe du robot
   */
  public Robot(Vue vue, Equipe equipe) {
    /* calcul des coordonnees de la base en fonction de son num d'equipe */
    this.coordonnees =
        new Coordonnees((equipe.getEquipe() == Constante.EQUIPE_UN) ? 0 : vue.getPlateau()
            .getLargeur() - 1, (equipe.getEquipe() == Constante.EQUIPE_UN) ? 0 : vue.getPlateau()
            .getLongueur() - 1);
    this.equipe = equipe;
    this.vue = vue;
  }

  /**
   * Demande a l'utilisateur une action pour son char
   * 
   * @return Action
   */
  abstract public Action choisitAction();

  public void disparait() {
    this.vue.getPlateau().getCelluleByCoordonnees(this.coordonnees).videCase();
    this.equipe.removeRobot(this);
  }

  public boolean estMort() {
    return this.energie <= 0;
  }

  /**
   * Permet de soigner le Robot
   */
  abstract public void estSoigne();

  public boolean estSurBase() {
    /** calcul des coordonnees de la base */
    return this.coordonnees.equals(new Coordonnees((equipe.getEquipe() == Constante.EQUIPE_UN) ? 0
        : vue.getPlateau().getLargeur() - 1, (equipe.getEquipe() == Constante.EQUIPE_UN) ? 0 : vue
        .getPlateau().getLongueur() - 1));
  }

  /**
   * renvoie l'emplacement du Robot
   * 
   * @return Coordonnees
   */
  public Coordonnees getCoordonnees() {
    return this.coordonnees;
  }

  /**
   * renvoie le coup de deplacement du Robot
   * 
   * @return int
   */
  abstract public int getCoupDep();

  /**
   * Renvoie le cout de l'action du Robot
   * 
   * @return int
   */
  abstract public int getCoutAction();

  /**
   * Renvoie les degats que le Robot subira s'il marche sur une mine
   * 
   * @return int
   */
  abstract public int getDegatMine();

  /**
   * Renvoie les degats d'un tir du Robot
   * 
   * @return int
   */
  abstract public int getDegatTir();

  abstract public List<Coordonnees> getDeplacements();

  public int getEnergie() {
    return this.energie;
  }

  public Equipe getEquipe() {
    return this.equipe;
  }

  /**
   * Renvoie le numero de l'equipe du Robot
   * 
   * @return int
   */
  public int getNumEquipe() {
    return this.equipe.getEquipe();
  }

  public Coordonnees getObjectif() {
    return this.objectif;
  }

  /**
   * Renvoie le type de Robot (ie piegeur, char, tireur)
   * 
   * @return String
   */
  abstract public String getType();

  public Vue getVue() {
    return this.vue;
  }

  /**
   * Fait perdre de l'energie au Robot apres avoir effectue une action
   */
  public void perdEnergieApresAction() {
    this.setEnergie(getEnergie() - getCoutAction());
  }

  /**
   * Fait perdre de l'energie au Robot apres avoir effectue un deplacement
   */
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

  /**
   * Fait perdre de l'energie au Robot quand il marche sur une mine
   */
  abstract public void subitMine();

  /**
   * Fait perdre de l'energie au Robot apres avoir prit un tir d'un autre Robot
   * 
   * @param robot le Robot qui a tire
   */
  abstract public void subitTirDe(Robot robot);

  @Override
  public String toString() {
    return "energie : " + this.energie + ", " + this.coordonnees.toString();
  }

  /**
   * Renvoie la direction des coordonnees par rapport aux coordonnees du Robot (ie NORD SUD EST
   * OUEST)
   * 
   * @param c les coordonnees associes
   * @return String
   */
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

  /**
   * Demande a l'utilisateur de choisir un deplacement parmis la liste passee en parametre
   * 
   * @param dep List de coordonnees des deplacements possible
   * @return Action
   */
  public Action choisitDep(List<Coordonnees> dep) {
    int j = 0;
    System.out.println("vous pouvez aller en :");
    for (Coordonnees c : dep) {
      System.out.println(j + ": " + c + " " + direction(c));
      j += 1;
    }
    this.setObjectif(dep.get(this.getEquipe().secureInput(0, j - 1)));
    return new Deplacement(this);
  }
  
  public String getText() {
    if (equipe.getEquipe() == 0) {
      return getType().substring(1,2);
    }
    return getType().substring(1,2).toLowerCase();
  }
}
