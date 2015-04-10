package gameOfWar.jeux;
import gameOfWar.config.Coordonnees;
import gameOfWar.robot.Robot;


public class Vue {

  private Plateau plateau;

  public Vue(Plateau plateau) {
    this.plateau = plateau;
    //TODO ne vois qu'une partie du plateau en fonction de son equipe; osef a faire dans le toString
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

  public void setMine(Robot robot, Coordonnees coordonnees){
    this.plateau.poserUneMine(coordonnees.getLargeur(), coordonnees.getHauteur(), robot.getEquipe());
  }
  public Plateau getPlateau(){
    return this.plateau;
  }

}