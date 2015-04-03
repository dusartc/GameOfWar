package gameOfWar.jeux;
import gameOfWar.config.Coordonnees;
import gameOfWar.config.Mine;
import gameOfWar.robot.Robot;

import java.util.ArrayList;
import java.util.List;


public class Equipe {

  private String nom;
  private List<Robot> robots;
  private List<Mine> mines;
  private Vue vue;
  
  public Equipe(String nom, Plateau plateau) {
    this.nom = nom;
    this.robots = new ArrayList<Robot>();
    this.mines = new ArrayList<Mine>();
    this.vue = new Vue(plateau);
  }
  
  public String getNom() {
    return this.nom;
  }
  
  public Vue getVue() {
    return this.vue;
  }
  
  public void addRobot(Robot robot) {
    this.robots.add(robot);
  }
  
  public void removeRobot(Robot robot) {
    this.robots.remove(robot);
  }
  
  public Robot getRobotByCoordonnees(Coordonnees coordonnees) {
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
}
