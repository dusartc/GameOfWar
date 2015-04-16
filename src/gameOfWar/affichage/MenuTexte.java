package gameOfWar.affichage;

import gameOfWar.config.Constante;
import gameOfWar.jeux.Plateau;

public class MenuTexte {

  public static Plateau initialisationPlateau() {
    int x =
        Constante.secureInput(Constante.X_MIN, Constante.X_MAX,
            "Entrez la largeur du plateau entre " + Constante.X_MIN + " et " + Constante.X_MAX);
    int y =
        Constante.secureInput(Constante.Y_MIN, Constante.Y_MAX,
            "Entrez la longueur du plateau entre " + Constante.Y_MIN + " et " + Constante.Y_MAX);
    int nb =
        Constante.secureInput(Constante.OBSTACLES_MIN, Constante.OBSTACLES_MAX,
            "Entrez le % d'obstacles du plateau entre " + Constante.OBSTACLES_MIN + " et "
                + Constante.OBSTACLES_MAX);
    return new Plateau(x, y, nb);
  }

}
