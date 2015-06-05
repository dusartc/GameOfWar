package gameOfWar.config;

import gameOfWar.jeux.Equipe;
import gameOfWar.robot.Char;
import gameOfWar.robot.Piegeur;
import gameOfWar.robot.Robot;
import gameOfWar.robot.Tireur;
import gameOfWar.robot.Worker;

/**
 * Place une Factory
 * 
 * @author Clement
 */
public class Factory {

  private Equipe equipe;
  private int timeSpawn = 0;
  private Robot toSpawn = null;
  private int spawningTime;

  /**
   * Place une mine aux coordonnees de l'objectif du worker
   * 
   * @param worker Celui qui pose la mine
   */
  public Factory(Worker worker) {
    this.equipe = worker.getEquipe();
    equipe.addFactory(this);
    worker.getVue().getPlateau().getCelluleByCoordonnees(worker.getObjectif()).setFactory(this);
    this.spawningTime = Constante.SPAWNING_TIME;
    worker.getVue().getPlateau().getCelluleByCoordonnees(worker.getObjectif())
        .setImage(worker.getNumEquipe() == Constante.EQUIPE_UN ? "F" : "f");
    worker.perdEnergie(worker.getEnergieMax() / 2);
  }

  public Equipe getEquipe() {
    return equipe;
  }

  /**
   * Renvoie True si un robot doit apparaitre
   * 
   * @return boolean
   */
  public boolean spawningRobot() {
    return toSpawn != null;
  }

  private void spawn() {
    timeSpawn += 1;
    if (timeSpawn == spawningTime) {
      timeSpawn = 0;
      spawningTime += 1;
      equipe.addRobot(toSpawn);
      System.out.println(toSpawn.toString() + " est apparu sur le champ de bataille");
      toSpawn = null;
    }
  }

  /**
   * Demande a l'utilisateur de choisir un Robot a faire apparaitre sur le plateau
   */
  public void choisitUnRobotASpawn() {
    if (equipe.getNbRobot() < Constante.NB_POP_MAX) {
      if (toSpawn == null) {
        System.out.println("Voulez-vous fabriquer un nouveau robot ?\n\t1 - oui\n\t2 - non");
        if (equipe.secureInput(1, 2) == 1) {
          String[] robots = new String[] {"Tireur", "Piegeur", "Char", "Worker"};
          for (int i = 0; i < robots.length; i++) {
            System.out.println(i + " - " + robots[i]);
          }
          switch (equipe.secureInput(0, robots.length)) {
            case 0:
              toSpawn = new Tireur(equipe.getVue(), equipe);
              break;
            case 1:
              toSpawn = new Piegeur(equipe.getVue(), equipe);
              break;
            case 2:
              toSpawn = new Char(equipe.getVue(), equipe);
              break;
            case 3:
              toSpawn = new Worker(equipe.getVue(), equipe);
            default:
              break;
          }
        }
      } else {
        spawn();
      }
    } else {
      System.out.println("Population max atteinte");
    }
  }

}
