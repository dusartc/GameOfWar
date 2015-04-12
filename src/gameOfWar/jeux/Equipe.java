package gameOfWar.jeux;
import gameOfWar.config.Coordonnees;
import gameOfWar.config.Mine;
import gameOfWar.robot.Robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 
 * @author Clement.
 *
 */
public class Equipe {

  private String nom;
  private List<Robot> robots;
  private List<Mine> mines;
  private Vue vue;
  private int equipe;
  private Coordonnees coordBase;

  public Equipe(String nom, Plateau plateau, int equipe, Coordonnees coord) {
    this.nom = nom;
    this.equipe = equipe;
    this.coordBase = coord;
    this.robots = new ArrayList<Robot>();
    this.mines = new ArrayList<Mine>();
    this.vue = new Vue(plateau, equipe);
  }

  public String getNom() {
    return this.nom;
  }

  public Vue getVue() {
    return this.vue;
  }

  public Coordonnees getCoordBase() {
    return this.coordBase;
  }

  public void addRobot(Robot robot) {
    /** ajouter un robot le pose egalement sur le plateau */
    this.robots.add(robot);
    this.vue.poserRobot(robot, getCoordBase());
  }

  public void removeRobot(Robot robot) {
    this.robots.remove(robot);
  }

  public Robot getRobotByCoordonnees(Coordonnees coordonnees) {
    /** parcourt de tous les robots et on renvoie celui avec les memes coordonnees */
    for (Robot robot : robots) {
      if (robot.getCoordonnees().equals(coordonnees)) {
        return robot;
      }
    }return null;
  }

  public Robot getRobotByIndex(int i) {
    return this.robots.get(i);
  }

  public void addMines(Mine mine) {
    this.mines.add(mine);
  }

  public void removeMines(Mine mine) {
    this.mines.remove(mine);
  }

  public int getEquipe() {
    return this.equipe;
  }

  @Override
  public String toString() {
    String ans = this.nom + "\n" + this.coordBase.toString() + " \n Robots : \n";
    for (Robot ro : this.robots) {
      ans += ro.toString()+"\n";
    }return ans;
  }

  public boolean perdu() {
    return this.robots.isEmpty();
  }

  public Robot choisitRobot() {
    /** parcourt des robots, on le decris et lui fixe un numero et on renvoie celui correspondant au num */
    int i = 1;
    for (Robot robot : robots) {
      System.out.println("choix : " + i + "\n\t" + robot.toString());
      i += 1;
    }
    Scanner sc = new Scanner(System.in);
    if (sc.hasNextInt()) {
      i = sc.nextInt();
      sc.close();
      return this.robots.get(i-1);
    }
    sc.close();
    return null;
  }
}
