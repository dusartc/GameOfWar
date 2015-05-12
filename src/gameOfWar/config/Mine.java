package gameOfWar.config;

import gameOfWar.robot.Piegeur;

/**
 * Correspond au placement d'une mine.
 * 
 * @author Clement
 */
public class Mine {

  /**
   * place la mine sur le plateau
   * 
   * @param piegeur le piegeur posant la mine
   */
  public Mine(Piegeur piegeur) {
    piegeur.getVue().getPlateau().getCelluleByCoordonnees(piegeur.getObjectif())
        .poseMine(piegeur.getNumEquipe());
    piegeur.perdUneMine();
    piegeur.perdEnergieApresAction();
    piegeur.getVue().getPlateau().getCelluleByCoordonnees(piegeur.getObjectif()).setImage((piegeur.getNumEquipe() == 0 ? "m" : "M"));
  }
}
