package gameOfWar.jeux;

import gameOfWar.config.Coordonnees;

/**
 * Permet de gerer une IA
 * 
 * @author clement
 */
public class IA extends Equipe {

  /**
   * Construit une IA basique
   * 
   * @param nom le nom de l'ia
   * @param plateau le plateau de l'ia
   * @param equipe son numero d'equipe
   * @param coord les coordonnees de sa base
   */
  public IA(String nom, Plateau plateau, int equipe, Coordonnees coord) {
    super(nom, plateau, equipe, coord);
    setIa(true);
  }
}
