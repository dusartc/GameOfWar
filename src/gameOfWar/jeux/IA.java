package gameOfWar.jeux;

import gameOfWar.config.Coordonnees;

public class IA extends Equipe {

  public IA(String nom, Plateau plateau, int equipe, Coordonnees coord) {
    super(nom, plateau, equipe, coord);
    setIa(true);
  }

  
  
}
