package gameOfWar.jeux;

import gameOfWar.action.Action;
import gameOfWar.affichage.Menu;
import gameOfWar.affichage.MenuTexte;
import gameOfWar.robot.Char;
import gameOfWar.robot.Piegeur;
import gameOfWar.robot.Robot;
import gameOfWar.robot.Tireur;

import java.util.ArrayList;


/**
 * La ou le coeur de la maison chez schmit ce joue.
 * 
 * @author Mathieu
 * @author Clement
 */

public class Main extends Menu {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public Main(String nom) {
    super(nom);
    // TODO Auto-generated constructor stub
  }


  public static void main(String[] args) {
    // Menu test = new Menu("Game of War.");

    /*
     * javax.swing.SwingUtilities.invokeLater(new Runnable() {
     * 
     * @Override public void run(){ // TODO Auto-generated method stub new Menu("Game Of War"); }
     * });
     */

    Plateau plateau = MenuTexte.initialisationPlateau();

    Equipe[] equipes = MenuTexte.initialisationEquipes(plateau);
//    Equipe[] equipes =
//        new Equipe[] {
//            new IA("ia1", plateau, Constante.EQUIPE_UN, new Coordonnees(0, 0)),
//            new IA("ia2", plateau, Constante.EQUIPE_DEUX, new Coordonnees(plateau.getLargeur() - 1,
//                plateau.getLongueur() - 1))};

    for (Equipe joueur : equipes) {
      joueur.addRobot(new Tireur(joueur.getVue(), joueur));
      joueur.addRobot(new Piegeur(joueur.getVue(), joueur));
      joueur.addRobot(new Char(joueur.getVue(), joueur));
    }

    boolean finis = false;
    Robot neo;
    Action action;
    int i = 0;
    ArrayList<Robot> robotATuer = new ArrayList<Robot>();
    while (!finis) {
      System.out.println(equipes[i % 2].getVue().toString() + "\n" + equipes[i % 2].getNom()
          + ", a vous de jouer :\n");
      neo = equipes[i % 2].choisitRobot();
      System.out.println(neo.getVue().toString());
      action = neo.choisitAction();
      if (action != null) {
        action.agit();
      }
      i += 1;
      for (Equipe joueur : equipes) {
        if (joueur.perdu()) {
          finis = true;
        }
        for (Robot r : joueur.getRobots()) {
          if (r.estMort()) {
            robotATuer.add(r);
          }
        }
      }
      for (Robot r : equipes[i % 2].getRobots()) {
        if (r.estSurBase()) {// on soigne que les robots de l'equipe courante
          r.estSoigne();
        }
      }
      if (!robotATuer.isEmpty()) {
        for (Robot r : robotATuer) {
          r.disparait();
        }
        robotATuer.clear();
      }
    }
    MenuTexte.clearScreen();
    if (equipes[0].perdu() && equipes[1].perdu()) {
      System.out.println("Aucun joueur n'a gagner");
    } else if (equipes[0].perdu()) {
      System.out.println(equipes[1].getNom() + " a gagne");
    } else {
      System.out.println(equipes[0].getNom() + " a gagne");
    }
  }
}
