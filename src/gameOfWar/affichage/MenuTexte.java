package gameOfWar.affichage;

import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.jeux.Equipe;
import gameOfWar.jeux.Plateau;

public class MenuTexte {

  public static Plateau initialisationPlateau() {
    clearScreen();
    System.out.println(quadrillage("INITIALISATION DU PLATEAU"));
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

  public static Equipe[] initialisationEquipes(Plateau p) {
    clearScreen();
    System.out.println(quadrillage("INITIALISATION DES EQUIPES"));
    System.out.println("Veuillez choisir votre pays parmis ceux-ci :");
    Equipe[] ans = new Equipe[2];
    for (int i = 0; i < Constante.PAYS.length; i++) {
      System.out.println("\t" + i + " - " + Constante.PAYS[i]);
    }
    String nom = Constante.PAYS[Constante.secureInput(0, Constante.PAYS.length - 1)];
    ans[0] = new Equipe(nom, p, Constante.EQUIPE_UN, new Coordonnees(0, 0));
    //TODO 2eme equipe soit joueur ou IA
    return ans;
  }

  private static String quadrillage(String message) {
    message = "\t| " + message + " |\n";
    String ans = "";
    for (int i = 0; i < message.length() - 2; i++) {
      ans += "*";
    }
    ans += "\n" + message + "\t";
    for (int i = 0; i < message.length() - 2; i++) {
      ans += "*";
    }
    return "\t" + ans + "\n";
  }

  public static void clearScreen() {
    System.out.print("\u001b[2J");
  }

}
