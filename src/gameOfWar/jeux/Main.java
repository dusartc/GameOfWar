package gameOfWar.jeux;

import gameOfWar.action.Action;
import gameOfWar.action.Deplacement;
import gameOfWar.config.Cellule;
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

    Plateau plateau = new Plateau(10, 10, 20);
    Vue equipeUne = new Vue(plateau, Constante.EQUIPE_UN);
    Vue equipeDeux = new Vue(plateau, Constante.EQUIPE_DEUX);
    
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
    
    equipeUne.setMine(new Piegeur(equipeUne, equipes[0].getEquipe()), new Coordonnees(0, 3));

    equipeDeux.setMine(new Piegeur(equipeDeux, equipes[1].getEquipe()), new Coordonnees(3, 0));

    equipeUne.setMine(new Piegeur(equipeUne, equipes[0].getEquipe()), new Coordonnees(0, 5));
    
    equipeDeux.setMine(new Piegeur(equipeDeux, equipes[1].getEquipe()), new Coordonnees(5, 0));

    equipeDeux.setMine(new Piegeur(equipeDeux, equipes[1].getEquipe()), new Coordonnees(0, 5));
    
    System.out.println(equipeUne);
    System.out.println(equipeDeux);
    System.out.println(plateau);
    
   Piegeur testPiegeur = new Piegeur(equipeUne, equipes[0].getEquipe());
    equipeUne.poserRobot(testPiegeur, equipes[0].getCoordBase());
    Action dep = new Deplacement(testPiegeur, new Coordonnees(0,1));
    System.out.println(plateau);
    dep.agit(new Cellule(0, 1));
    System.out.println(plateau);
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
