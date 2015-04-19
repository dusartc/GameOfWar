package gameOfWar.jeux;

import gameOfWar.config.Coordonnees;

/**
 * Permet de gerer une IA
 * 
 * @author clement
 */
public class IA extends Equipe {

  /**
   * @see Equipe
   */
  public IA(String nom, Plateau plateau, int equipe, Coordonnees coord) {
    super(nom, plateau, equipe, coord);
    setIa(true);
  }
}
