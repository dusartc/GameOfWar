package gameOfWar.jeux;

import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.config.Factory;
import gameOfWar.config.Mine;
import gameOfWar.robot.Robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Permet de gerer une Equipe (joueur ou ordinateur)
 * 
 * @author Clement
 */
public class Equipe {

  private String nom;
  private List<Robot> robots;
  private List<Mine> mines;
  private List<Factory> factories;
  private Vue vue;
  private int equipe;
  private Coordonnees coordBase;
  private boolean estIa = false;

  /**
   * Construit une equipe d'apres son nom, le plateau dans lequel le jeu est joué, son numero
   * d'equipe et les coordonnees de sa base
   * 
   * @param nom le nom de l'equipe
   * @param plateau le plateau qui servira a creer la vue de l'equipe
   * @param equipe le numero de l'equipe
   * @param coordBase les coordonnees de la base de l'equipe
   */
  public Equipe(String nom, Plateau plateau, int equipe, Coordonnees coordBase) {
    this.nom = nom;
    this.equipe = equipe;
    this.coordBase = coordBase;
    this.robots = new ArrayList<Robot>();
    this.mines = new ArrayList<Mine>();
    this.factories = new ArrayList<Factory>();
    this.vue = new Vue(plateau, equipe);
  }

  public void addMines(Mine mine) {
    this.mines.add(mine);
  }

  /**
   * Ajoute un robot pour l'equipe et le pose sur sa base
   * 
   * @param robot le robot a ajouter
   */
  public void addRobot(Robot robot) {
    this.robots.add(robot);
    this.vue.poserRobot(robot, getCoordBase());
  }

  /**
   * Demande a l'utilisateur de choisir un robot parmis ceux de son equipe
   * 
   * @return Robot le robot choisit
   */
  public Robot choisitRobot() {
    List<Robot> indisponibles = new ArrayList<Robot>();
    List<Robot> disponibles = new ArrayList<Robot>();
    for (Robot robot : robots) {
      if (robot.initDep().isEmpty()) {
        indisponibles.add(robot);
      } else {
        disponibles.add(robot);
      }
    }
    for (Robot r : indisponibles) {
      System.out.println(r.toString() + " ne peut pas se deplacer :(");
    }
    int i = 1;
    for (Robot robot : disponibles) {
      System.out.println("\t" + i + " : " + robot.toString());
      i += 1;
    }
    i = secureInput(1, i - 1);
    if (disponibles.isEmpty()) {
      return null;
    }
    return disponibles.get(i - 1);
  }

  public Coordonnees getCoordBase() {
    return this.coordBase;
  }

  /**
   * Retourne le numero de l'equipe.
   * 
   * @return int
   */
  public int getEquipe() {
    return this.equipe;
  }

  public String getNom() {
    return this.nom;
  }

  public List<Robot> getRobots() {
    return this.robots;
  }

  public Vue getVue() {
    return this.vue;
  }

  /**
   * Retourne vrai si le joueur a perdu (ie n'a plus de robots)
   * 
   * @return boolean
   */
  public boolean perdu() {
    return this.robots.isEmpty();
  }

  public void removeMines(Mine mine) {
    this.mines.remove(mine);
  }

  public void removeRobot(Robot robot) {
    this.robots.remove(robot);
  }

  /**
   * Affiche le nom de l'equipe, les noms des robots et les coordonnees de la base.
   * 
   * @see Robot
   */
  @Override
  public String toString() {
    String ans = this.nom + "\n" + this.coordBase.toString() + " \n Robots : \n";
    for (Robot ro : this.robots) {
      ans += ro.toString() + "\n";
    }
    return ans;
  }

  public boolean estIa() {
    return this.estIa;
  }

  public void setIa(boolean estIa) {
    this.estIa = estIa;
  }

  /**
   * Demande a l'utilisateur d'entre un nombre entre min et max ou renvoie un random entre min et
   * max si l'equipe est une IA
   * 
   * @param min la borne minimale
   * @param max la borne maximale
   * @return int un nombre entre min et max
   */
  public int secureInput(int min, int max) {
    if (estIa) {
      if (max - min <= 0) {
        return min;
      }
      return new Random().nextInt(max - min) + min;
    }
    return Constante.secureInput(min, max);
  }

  public void addFactory(Factory factory) {
    this.factories.add(factory);
  }

  public List<Factory> getFactories() {
    return this.factories;
  }

  /**
   * Renvoie le nombre de factory que possede l'equipe
   * 
   * @return int
   */
  public int getNbFacto() {
    return this.factories.size();
  }

  /**
   * Fait perdre 5 energies a un robot aleatoire
   */
  public void perdEnergieRandom() {
    Random rd = new Random();
    robots.get(rd.nextInt(robots.size() - 1)).perdEnergie(5);
  }

  public int getNbRobot() {
    return this.robots.size();
  }

  public void sleep() {
    if (estIa) {
      try {
        Thread.sleep(1500);
      } catch (Exception e) {
        // TODO: handle exception
      }
    }
  }
}
