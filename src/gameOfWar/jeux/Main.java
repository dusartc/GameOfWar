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

    Plateau plateau = new Plateau(10, 5, 20);
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
          if (r.estSurBase()) {
            r.estSoigne();
          }
        }
      }
    }
    
    

//    equipeDeux.setMine(new Piegeur(equipeDeux, equipes[1].getEquipe()), new Coordonnees(3, 0));
//
//    equipeUne.setMine(new Piegeur(equipeUne, equipes[0].getEquipe()), new Coordonnees(0, 5));
//    
//    equipeDeux.setMine(new Piegeur(equipeDeux, equipes[1].getEquipe()), new Coordonnees(5, 0));
//
//    equipeDeux.setMine(new Piegeur(equipeDeux, equipes[1].getEquipe()), new Coordonnees(0, 5));
//    
//    System.out.println(equipeUne);
//    System.out.println(equipeDeux);
//    System.out.println(plateau);
//    
//    Piegeur testPiegeur = new Piegeur(equipeUne, equipes[0].getEquipe());
//    equipeUne.poserRobot(testPiegeur, equipes[0].getCoordBase());
//    Action dep = new Deplacement(testPiegeur, new Coordonnees(0,1));
//    System.out.println(plateau);
//    dep.agit(new Cellule(0, 1));
//    System.out.println(plateau);
//    for (Equipe equipe : equipes) {
//      System.out.println(equipe.toString());
//    }
//    
//    boolean fini = false;
//    int joueur = 0;
//    Robot neo;
//    Action act;
//    Equipe current;
//    while (!fini) {
//      joueur++;
//      current = equipes[joueur%2];
//      neo = current.choisitRobot();
//      System.out.println(neo);
//      act = neo.choisitAction();
//      if (equipes[joueur%2].perdu() || equipes[(joueur+1)%2].perdu()) {
//        fini = true;
//      }
//    }
    
    //System.out.println(equipeVue1);
    //System.out.println(equipeVue2);
  }

}
