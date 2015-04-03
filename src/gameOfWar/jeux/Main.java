package gameOfWar.jeux;

import gameOfWar.action.Action;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.robot.Char;
import gameOfWar.robot.Piegeur;
import gameOfWar.robot.Robot;
import gameOfWar.robot.Tireur;


public class Main {

  public static void main(String[] args) {
    Plateau plateau = new Plateau(Constante.X_MAX, Constante.Y_MAX, Constante.OBSTACLES_MIN);
    Equipe[] equipes = new Equipe[] {
        new Equipe("joueur1", plateau, Constante.EQUIPE_UN, new Coordonnees(0, 0)),
        new Equipe("joueur2", plateau, Constante.EQUIPE_DEUX, new Coordonnees(plateau.getLongueur()-1, 
                                                                              plateau.getLargeur()-1))
    };
    for (Equipe joueur : equipes) {
      joueur.addRobot(new Tireur(joueur.getVue(), joueur.getEquipe()));
      joueur.addRobot(new Piegeur(joueur.getVue(), joueur.getEquipe()));
      joueur.addRobot(new Char(joueur.getVue(), joueur.getEquipe()));
    }
    
    for (Equipe equipe : equipes) {
      System.out.println(equipe.toString());
    }
    
    boolean fini = false;
    int joueur = 0;
    Robot neo;
    Action act;
    Equipe current;
    while (!fini) {
      joueur++;
      current = equipes[joueur%2];
      neo = current.choisitRobot();
      System.out.println(neo);
      act = neo.choisitAction();
      if (equipes[joueur%2].perdu() || equipes[((joueur%2)+1)%2].perdu()) {
        fini = true;
      }
    }
  }

}
