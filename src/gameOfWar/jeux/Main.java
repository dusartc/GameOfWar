package gameOfWar.jeux;

import gameOfWar.action.Action;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.robot.Char;
import gameOfWar.robot.Piegeur;
import gameOfWar.robot.Robot;
import gameOfWar.robot.Tireur;


/**
 * La ou le coeur de la maison chez schmit ce joue.
 * @author Clement, Mathieu.
 *
 */
public class Main {

  public static void main(String[] args) {

    Plateau plateau = new Plateau(15, 15, 20);
    System.out.println(plateau);
    
    Equipe[] equipes = new Equipe[] {
        new Equipe("joueur1", plateau, Constante.EQUIPE_UN, new Coordonnees(0, 0)),
        new Equipe("joueur2", plateau, Constante.EQUIPE_DEUX, new Coordonnees(plateau.getLargeur()-1, 
                                                                              plateau.getLongueur()-1))
    };
    for (Equipe joueur : equipes) {
      joueur.addRobot(new Tireur(joueur.getVue(), joueur));
      joueur.addRobot(new Piegeur(joueur.getVue(), joueur));
      joueur.addRobot(new Char(joueur.getVue(), joueur));
    }
    
    boolean finis = false;
    Robot neo;
    Action action;
    int i = 0;
    while (!finis) {
      neo = equipes[i%2].choisitRobot();
      System.out.println(neo.getVue().toString());
      action = neo.choisitAction();
      if (action != null) {
        action.agit();
      }      
      i += 1;
      for (Equipe joueur : equipes) {
        if (joueur.perdu()) {
          finis = true;
        }for (Robot r : joueur.getRobots()) {
          if (r.estMort()) {
            r.disparait();
          }
          if (r.estSurBase()) {
            r.estSoigne();
          }
        }
      }
    }
  }
}
