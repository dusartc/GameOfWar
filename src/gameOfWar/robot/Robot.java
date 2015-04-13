package gameOfWar.robot;
import gameOfWar.action.Action;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.jeux.Equipe;
import gameOfWar.jeux.Vue;

import java.util.List;


/**
 * 
 * @author Alexandre, Clement
 *
 */
public abstract class Robot {

  private Coordonnees coordonnees;
  private int energie;
  private Equipe equipe;
  private Vue vue;
  private Coordonnees objectif;


  public Robot(Vue vue, Equipe equipe) {
    /** calcul des coordonnees de la base en fonction de son num d'equipe */
    this.coordonnees = new Coordonnees((equipe.getEquipe() == Constante.EQUIPE_UN) ? 0 : vue.getPlateau().getLargeur()-1,
        (equipe.getEquipe() == Constante.EQUIPE_UN) ? 0 : vue.getPlateau().getLongueur()-1);
    this.equipe = equipe;
    this.vue = vue;
  }

  public boolean estSurBase() {
    /** calcul des coordonnees de la base */
    return this.coordonnees.equals(new Coordonnees((equipe.getEquipe() == Constante.EQUIPE_UN) ? 0 : vue.getPlateau().getLargeur()-1, 
        (equipe.getEquipe() == Constante.EQUIPE_UN) ? 0 : vue.getPlateau().getLongueur()-1));
  }

  public Coordonnees getCoordonnees() {
    return this.coordonnees;
  }

  abstract public int getCoupDep();

  abstract public int getCoutAction();

  abstract public int getDegatMine();

  abstract public int getDegatTir();

  abstract public List<Coordonnees> getDeplacements();
  
  public Coordonnees getObjectif() {
    return this.objectif;
  }
  
  public void setObjectif(Coordonnees objectif) {
    this.objectif = objectif;
  }

  public int getEnergie() {
    return this.energie;
  }

  public int getNumEquipe() {
    return this.equipe.getEquipe();
  }
  
  public Equipe getEquipe() {
    return this.equipe;
  }

  abstract public String getType();

  public Vue getVue() {
    return this.vue;
  }

  abstract public boolean peutTirer();

  public void setCoordonnees(Coordonnees coordonnees) {
    this.coordonnees = coordonnees;
  }

  public void setEnergie(int energie) {
    this.energie = energie;
  }

  abstract public void subitMine();
  abstract public void subitTirDe(Robot robot);

  public void estSoigne(){
    this.setEnergie(this.getEnergie() + Constante.SOIN);
  }

  @Override
  public String toString() {
    return "energie : " + this.energie + ", " + this.coordonnees.toString();
  }

  abstract public Action choisitAction();
  
  public boolean estMort() {
    return this.energie <= 0;
  }
  
  public void disparait() {
    this.equipe.removeRobot(this);
  }
}
