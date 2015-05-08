package gameOfWar.affichage;

import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.jeux.Equipe;
import gameOfWar.jeux.IA;
import gameOfWar.jeux.Plateau;

/**
 * Affiche des menus en mode texte
 * 
 * @author clement
 */
public class MenuTexte {

  /**
   * Efface l'écran si la console associé prend en charge les codes ANSI
   */
  public static void clearScreen() {
    System.out.print("\u001b[2J");
  }

  /**
   * Demande a l'utilisateur l'Equipe qu'il souhaite et l'adversaire qu'il souhaite
   * 
   * @param p le plateau qui servira a creer la vue de l'equipe
   * @return Equipe[] les equipes qui s'affronteront sur le plateau
   */
  public static Equipe[] initialisationEquipes(Plateau p) {
    Equipe[] ans = new Equipe[2];
    clearScreen();
    System.out.println(quadrillage("INITIALISATION DES EQUIPES"));
    ans[0] = new Equipe(choisitPays(), p, Constante.EQUIPE_UN, new Coordonnees(0, 0));
    // TODO 2eme equipe soit joueur ou IA
    clearScreen();
    System.out
        .println("Voulez-vous affronter l'ordinateur ou un autre joueur ?\n\t1 - Ordinateur\n\t2 - Joueur");
    int i = Constante.secureInput(1, 2);
    switch (i) {
      case 1:
        System.out.println("Vous allez affronter un ordinateur facile");
        ans[1] =
            new IA("IA", p, Constante.EQUIPE_DEUX, new Coordonnees(p.getLargeur() - 1,
                p.getLongueur() - 1));
        return ans;
      case 2:
        ans[1] =
            new Equipe(choisitPays(), p, Constante.EQUIPE_DEUX, new Coordonnees(p.getLargeur() - 1,
                p.getLongueur() - 1));
        return ans;
      default:
        return ans;
    }
  }

  /**
   * Demande a l'utilisateur la taille du plateau qu'il souhaite
   * 
   * @return Plateau le plateau voulu
   */
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

  private static String choisitPays() {
    System.out.println("Veuillez choisir votre pays parmis ceux-ci :");
    for (int i = 0; i < Constante.PAYS.length; i++) {
      System.out.println("\t" + i + " - " + Constante.PAYS[i]);
    }
    return Constante.PAYS[Constante.secureInput(0, Constante.PAYS.length - 1)];
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

}
