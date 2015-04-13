package gameOfWar.config;

import gameOfWar.robot.Piegeur;

/**
 * La classe Mine correspond au placement d'une mine.
 * @author Mathieu
 *
 */
public class Mine {

  /**
   * Le constructeur construit une Mine par rapport aux coordonnees donnees et a l'equipe
   * @param largeur
   * @param hauteur
   * @param equipe, l'equipe de la Mine.
   */
//  public Mine(int largeur, int hauteur, int equipe) {
//    super(largeur, hauteur);
//    this.poseMine(equipe);
//  }
//  
//  public Mine(Coordonnees coordonnees, int equipes) {
//    super(coordonnees.getLargeur(), coordonnees.getHauteur());
//    this.poseMine(equipes);
//  }
  
  public Mine(Piegeur piegeur) {
    piegeur.getVue().getPlateau().getCelluleByCoordonnees(piegeur.getObjectif()).poseMine(piegeur.getNumEquipe());
    //this.poseMine(piegeur.getNumEquipe());
    piegeur.perdUneMine();
  }
}
