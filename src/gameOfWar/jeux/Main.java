package gameOfWar.jeux;

import gameOfWar.action.Action;
import gameOfWar.affichage.Menu;
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
    //Menu test = new Menu("Game of War.");
    
    /*javax.swing.SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run(){
        // TODO Auto-generated method stub
        new Menu("Game Of War");
      }
    });*/
    
    int x = Constante.secureInput(Constante.X_MIN, Constante.X_MAX, "Entrez la largeur du plateau entre "
        +Constante.X_MIN
        +" et "
        +Constante.X_MAX);
    int y = Constante.secureInput(Constante.Y_MIN, Constante.Y_MAX, "Entrez la longueur du plateau entre "
        +Constante.Y_MIN
        +" et "
        +Constante.Y_MAX);
    int nb = Constante.secureInput(Constante.OBSTACLES_MIN, Constante.OBSTACLES_MAX
        ,"Entrez le % d'obstacles du plateau entre "
        +Constante.OBSTACLES_MIN
        +" et "
        +Constante.OBSTACLES_MAX);
    
    Plateau plateau = new Plateau(/*test.getX()*/x, y/*test.getY()*/, nb);
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
      System.out.println(equipes[i%2].getNom()+", a vous de jouer");
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
