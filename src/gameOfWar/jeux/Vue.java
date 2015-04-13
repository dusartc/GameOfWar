package gameOfWar.jeux;
import gameOfWar.config.Base;
import gameOfWar.config.Cellule;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.config.Mur;
import gameOfWar.robot.Char;
import gameOfWar.robot.Piegeur;
import gameOfWar.robot.Robot;
import gameOfWar.robot.Tireur;


/**
 * 
 * @author Clement, Mathieu
 *
 */
public class Vue {

  private Plateau plateau;
  private int equipe;
  
  public Vue(Plateau plateau, int equipe) {
    this.plateau = plateau;
    this.equipe = equipe;
  }

  public boolean estOK(Coordonnees coordonnees){
    return coordonnees.getLargeur() > 0
        && coordonnees.getHauteur() > 0
        && coordonnees.getLargeur() < this.plateau.getLargeur() 
        && coordonnees.getLargeur() < this.plateau.getLongueur();
  }

  public void libereCelulle(Coordonnees coordonnees){
    this.plateau.libereCellule(coordonnees.getLargeur(), coordonnees.getHauteur());
  }

  public void poserRobot(Robot robot, Coordonnees coordonnees){
    this.plateau.poserRobot(coordonnees.getLargeur(), coordonnees.getHauteur(), robot);
  }
  
  public void retirerRobot(Coordonnees coordonnees) {
    this.plateau.retirerRobot(coordonnees);
  }

//  public void setMine(Robot robot, Coordonnees coordonnees){
//    this.plateau.poserUneMine(coordonnees.getLargeur(), coordonnees.getHauteur(), robot.getEquipe());
//  }
  
  public void retirerMine(Coordonnees coordonnees) {
    this.plateau.retirerMine(coordonnees);
  }
  
  public Plateau getPlateau(){
    return this.plateau;
  }
  
  public int getEquipe(){
    return this.equipe;
  }
  
  @Override
  public String toString() {
    StringBuilder ans = new StringBuilder();
    ans.insert(ans.length(), quadrillage());
    for (int i = 0; i < this.plateau.getLongueur(); i++) {
      for (int j = 0; j < this.plateau.getLargeur(); j++) {
        if (this.plateau.getCellule(i, j) instanceof Mur) {
          if(this.plateau.getCellule(i, j).estMur()) {
            ans.insert(ans.length(), "| O ");
          }
        }
        else if (this.plateau.getCellule(i, j) instanceof Base) {
          if (this.plateau.estBase(i,j) == 1) {
            ans.insert(ans.length(), "\n| B ");
          }
          else if(this.plateau.estBase(i,j) == 2){
            ans.insert(ans.length(),"| b |\n");
          }
        }
        else if (this.plateau.getCellule(i, j).contientMine() > 0 ) {
         // Mine testMine = (Mine) this.plateau.getCellule(i, j);
          String res ="";
          if (this.equipe == Constante.EQUIPE_UN) {
            res += "| M ";
          }
          else if(this.equipe == Constante.EQUIPE_DEUX){
            res += "| m ";
          }
          ans.insert(ans.length(), (this.plateau.estMine(i, j) == this.getEquipe())?
            res:"|   ");
        }
        else if (this.plateau.getCellule(i, j).getRobot() instanceof Piegeur) {
          if (this.plateau.estRobot(i, j) == 1) {
            ans.insert(ans.length(), "| P ");
          }
          else if (this.plateau.estRobot(i, j) == 2) {
            ans.insert(ans.length(), "| p ");
          }
          else {
            ans.insert(ans.length(),"|   ");
          }
          
        }
        else if (this.plateau.getCellule(i, j).getRobot() instanceof Tireur) {
          if (this.plateau.estRobot(i, j) == 1) {
            ans.insert(ans.length(), "| T ");
          }
          else if (this.plateau.estRobot(i, j) == 2) {
            ans.insert(ans.length(), "| t ");
          }
          else {
            ans.insert(ans.length(),"|   ");
          }
        }
        else if (this.plateau.getCellule(i, j).getRobot() instanceof Char) {
          if (this.plateau.estRobot(i, j) == 1) {
            ans.insert(ans.length(), "| C ");
          }
          else if (this.plateau.estRobot(i, j) == 2) {
            ans.insert(ans.length(), "| c ");
          }
          else {
            ans.insert(ans.length(),"|   ");
          }
        }
        else if (this.plateau.getCellule(i, j) instanceof Cellule){
          ans.insert(ans.length(),"|   ");
          if (j == this.plateau.getLargeur() -1) {
            ans.insert(ans.length(),"|");
          }
        }

      }if(i < this.plateau.getLongueur() - 1) {
        ans.insert(ans.length(),"\n"+quadrillage()+"\n");
      }
    }ans.insert(ans.length(),quadrillage() + "\n\n" + legende());
    return ans.toString();  
  }

  private String legende() {
    String ans = "+";
    for (int i = 0; i < 63; i++) {
      ans += "-";
    } ans += "+\n";
    ans += "|\tMAJUSCULES\t%\tminuscules\t\t\t|\n";
    String[] chabadabada = new String[] {
        "base","tireur","piegeur","char","mine"
    };
    for (int i = 0; i < chabadabada.length; i++) {
      ans += "|\t\t" 
          + chabadabada[i].substring(0, 1).toUpperCase()
          + "\t|\t\t" + chabadabada[i].substring(0, 1) + "\t"
          + chabadabada[i] + "\t\t|\n";
    }ans += "|\t";
    for (int i = 0; i < 47; i++) {
      ans += "-";
    }ans += "\t\t|\n";
    ans += "|\t\to\tobstacles\t\t\t\t|\n+";
    for (int i = 0; i < 63; i++) {
      ans += "-";
    }
    return ans + "+";
  }

  private String quadrillage(){
    String ans = "+";
    for (int i = 0; i < this.plateau.getLargeur() ; i++) {
      ans += "---+";
    }    
    return ans;
  }

}