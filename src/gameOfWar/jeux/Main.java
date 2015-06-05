package gameOfWar.jeux;

import gameOfWar.action.Action;
import gameOfWar.affichage.Fenetre;
import gameOfWar.affichage.MenuTexte;
import gameOfWar.config.Factory;
import gameOfWar.robot.Robot;

import java.util.ArrayList;

import javax.swing.JOptionPane;


/**
 * La ou le coeur de la maison chez schmit ce joue.
 * 
 * @author Mathieu
 * @author Clement
 */

public class Main {


  public static void main(String[] args) {
    boolean graphique = false;
    int retour = JOptionPane.showConfirmDialog(null, "Joueur en mode graphique ?");
    if (retour == JOptionPane.OK_OPTION) {
      JOptionPane.showMessageDialog(null, "Vous allez jouer en mode graphique !");
      graphique = true;
    } else if (retour == JOptionPane.NO_OPTION) {
      JOptionPane.showMessageDialog(null, "Vous allez jouer en mode texte !");
      graphique = false;
    } else {
      /*JOptionPane.showMessageDialog(null, "Par defaut : Vous allez jouer en mode texte !");
      graphique = false;*/
      System.exit(0);
    }

    // ///////////////Partie TEXTE/////////////////////////
    if (!graphique) {
      Plateau plateau = MenuTexte.initialisationPlateau(graphique);
      Equipe[] equipes = MenuTexte.initialisationEquipes(plateau);

      boolean finis = false;
      Robot neo;
      Action action;
      int i = 0;
      ArrayList<Robot> robotATuer = new ArrayList<Robot>();
      while (!finis) {
        MenuTexte.clearScreen();
        System.out.println(equipes[i % 2].getVue().toString() + "\n" + equipes[i % 2].getNom()
            + ", a vous de jouer :\n");
        neo = equipes[i % 2].choisitRobot();
        MenuTexte.clearScreen();
        if (neo != null) {
          System.out.println(neo.getVue().toString());
          action = neo.choisitAction();
          if (action != null) {
            action.agit();
          }
        } else {
          System.out.println("aucun robot disponible, un de vos robots va perdre de l'energie");
          equipes[i % 2].perdEnergieRandom();
        }
        if (!equipes[i % 2].getFactories().isEmpty()) {
          for (Factory f : equipes[i % 2].getFactories()) {
            f.choisitUnRobotASpawn();
          }
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
        MenuTexte.clearScreen();
      }
      MenuTexte.clearScreen();
      if (equipes[0].perdu() && equipes[1].perdu()) {
        System.out.println("Aucun joueur n'a gagner");
      } else if (equipes[0].perdu()) {
        System.out.println(equipes[1].getNom() + " a gagne");
      } else {
        System.out.println(equipes[0].getNom() + " a gagne");
      }
    } else {
      javax.swing.SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
          new Fenetre();

        }
      });
    }
  }
}
