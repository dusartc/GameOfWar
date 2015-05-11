package gameOfWar.config;

import gameOfWar.jeux.Equipe;
import gameOfWar.robot.Robot;
import gameOfWar.robot.Worker;


public class Factory {

  private Equipe equipe;
  private int timeSpawn = 0;
  private Robot toSpawn = null;
  private int spawningTime;

  public Factory(Worker worker) {
    this.equipe = worker.getEquipe();
    worker.getVue().getPlateau().getCelluleByCoordonnees(worker.getObjectif()).setFactory(this);
    this.spawningTime = Constante.SPAWNING_TIME;
  }

  public Equipe getEquipe() {
    return equipe;
  }

  public boolean spawningRobot() {
    return toSpawn != null;
  }

  public void spawn(Robot robot) {
    toSpawn = robot;
  }

  public void spawn() {
    timeSpawn += 1;
    if (timeSpawn == spawningTime) {
      timeSpawn = 0;
      spawningTime += 1;
      equipe.addRobot(toSpawn);
      System.out.println(toSpawn.toString() + " est apparu sur le champ de bataille");
      toSpawn = null;
    }
  }

}
