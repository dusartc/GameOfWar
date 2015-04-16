package gameOfWar.config;

import gameOfWar.robot.Piegeur;

/**
 * La classe Mine correspond au placement d'une mine.
 * 
 * @author Clement
 */
public class Mine {

  public Mine(Piegeur piegeur) {
    piegeur.getVue().getPlateau().getCelluleByCoordonnees(piegeur.getObjectif())
        .poseMine(piegeur.getNumEquipe());
    piegeur.perdUneMine();
    piegeur.perdEnergieApresAction();
  }
}
