package gameOfWar.action;

import gameOfWar.config.*;
import gameOfWar.robot.*;

/**
 *  La classe Attaque permet de produire une action de tir.
 * @author Samantha
 *
 */
public class Attaque extends Action {
  //Encapsulation de la classe Robot en tant que cible
  Robot cible;
  //Déclaration des constantes de portee de robot
  private final int PORTEE_TIREUR = 3;
  private final int PORTEE_PIEGEUR = 1;
  private final int PORTEE_CHAR = 10;
  public Attaque(Robot robot, Coordonnees direction ) {
    super(robot, direction);
  }
  public int getPORTEE_TIREUR() {
    return PORTEE_TIREUR;
  }
  public int getPORTEE_PIEGEUR() {
    return PORTEE_PIEGEUR;
  }
  public int getPORTEE_CHAR() {
    return PORTEE_CHAR;
  }
  @Override
  public void agit(Cellule caseCible) {
    // TODO Stub de la méthode généré automatiquement
    // Calcul de la portée de l'attaque : On prend la portée définie dans
    // l'attaque, selon le type de personnage.
    int porteeAtt ;
    while (this.getObjectif().equals(true)) {
      if(this.getRobot() instanceof Piegeur && cible instanceof Piegeur || cible instanceof Tireur || cible instanceof Char){
        porteeAtt = PORTEE_PIEGEUR;
        this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutAction());
        //le robot perd de l'energie en posant des Mines (energie du robot - cout de son action)
        if(caseCible.contientMine() > 0 && caseCible.equals(porteeAtt)){
          //si la cible marche sur une mine
          cible.setEnergie(cible.getEnergie()-cible.getDegatMine());
          //le robot cible perd de l'energie (energie du robot cible - degat de la mine)
        }
      }
      else if (this.getRobot() instanceof Tireur && cible instanceof Piegeur || cible instanceof Tireur || cible instanceof Char){
        porteeAtt = PORTEE_TIREUR;
        this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutAction());
        //le robot perd de l'energie en tirant (energie du robot - cout de son action)
        if(caseCible.equals(porteeAtt)){
          //si la portee de l'attaque du robot atteint la caseCible
          cible.setEnergie(cible.getEnergie()-cible.getDegatTir());
          //le robot cible perd de l'energie (energie du robot cible - degat du tir)
        }
      }
      else if (this.getRobot() instanceof Char && cible instanceof Piegeur || cible instanceof Tireur || cible instanceof Char){
        porteeAtt = PORTEE_CHAR;
        this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutAction());
        //le robot perd de l'energie en tirant (energie du robot - cout de son action)
        if(caseCible.equals(porteeAtt)){
          //si la portee de l'attaque du robot atteint la caseCible
          cible.setEnergie(cible.getEnergie()-cible.getDegatTir());
          //le robot cible perd de l'energie (energie du robot cible - degat du tir)
        }
      }
    }
  }
}