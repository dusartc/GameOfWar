package gameOfWar.config;


public class Base extends Cellule {
	
	public Base(int largeur, int hauteur, int equipe) {
      super(largeur, hauteur);
      this.poseBase(equipe);
	}
}
