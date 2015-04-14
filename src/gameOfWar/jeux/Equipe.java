package gameOfWar.jeux;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.config.Mine;
import gameOfWar.robot.Robot;

import java.util.ArrayList;
import java.util.List;


/**
 * La classe Equipe construit une Equipe
 * @author Clement.
 *
 */
public class Equipe {

  /** Correspond au nom de l'equipe */
  private String nom;
  /** Correspond a la liste des robots de l'equipe */
  private List<Robot> robots;
  /** Correspond a la liste de mine de l'equipe */
  private List<Mine> mines;
  /** Correspond a la vue de l'equipe */
  private Vue vue;
  /** Correspond au numero de l'equipe */
  private int equipe;
  /** Correspond au coordonnees de base de l'equipe */
  private Coordonnees coordBase;

  /**
   * Le constructeur construit une equipe entiere avec le nom de l'equipe, la vue, le numero de l'equipe, et les coordonnes.
   * @param nom
   * @param plateau
   * @param equipe
   * @param coord
   */
  public Equipe(String nom, Plateau plateau, int equipe, Coordonnees coord) {
    this.nom = nom;
    this.equipe = equipe;
    this.coordBase = coord;
    this.robots = new ArrayList<Robot>();
    this.mines = new ArrayList<Mine>();
    this.vue = new Vue(plateau, equipe);
  }

  /**
   * retourne le nom de l'equipe.
   * @return
   */
  public String getNom() {
    return this.nom;
  }

  /**
   * Retourne la vue de l'equipe.
   * @return
   */
  public Vue getVue() {
    return this.vue;
  }

  /**
   * Retour les coordonnees.
   * @return
   */
  public Coordonnees getCoordBase() {
    return this.coordBase;
  }

  /** ajouter un robot le pose egalement sur le plateau */
  public void addRobot(Robot robot) {
    this.robots.add(robot);
    this.vue.poserRobot(robot, getCoordBase());
  }

  /**
   * Enleve le robot passer en parametre.
   * @param robot
   */
  public void removeRobot(Robot robot) {
    this.robots.remove(robot);
  }

  /**
   * Ajout une Mines passer en parametre.
   * @param mine
   */
  public void addMines(Mine mine) {
    this.mines.add(mine);
  }

  /**
   * Enleve les Mines passer en parametre.
   * @param mine
   */
  public void removeMines(Mine mine) {
    this.mines.remove(mine);
  }

  /**
   * Retourne le numero d'equipe.
   * @return
   */
  public int getEquipe() {
    return this.equipe;
  }

  /**
   * Affiche le nom de l'equipe et les noms des robots et les coordonnees de la base.
   */
  @Override
  public String toString() {
    String ans = this.nom + "\n" + this.coordBase.toString() + " \n Robots : \n";
    for (Robot ro : this.robots) {
      ans += ro.toString()+"\n";
    }return ans;
  }

  /**
   * Perd la partie si perdu est a vrai.
   * @return
   */
  public boolean perdu() {
    return this.robots.isEmpty();
  }

  /** Parcourt des robots, on le decris et lui fixe un numero et on renvoie celui correspondant au num */
  public Robot choisitRobot() {
    int i = 1;
    for (Robot robot : robots) {
      System.out.println("choix : " + i + "\n\t" + robot.toString());
      i += 1;
    }
    i = Constante.secureInput(1, i-1);
    return this.robots.get(i-1);
  }
  
  public List<Robot> getRobots(){
    return this.robots;
  }
}
