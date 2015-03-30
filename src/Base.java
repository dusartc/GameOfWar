
public class Base extends Cellule {
	
	public Base(int largeur, int hauteur, int equipe) {
      super(largeur, hauteur);
      this.ajoute(equipe);
	}

    @Override
	void deplaceSur(Robot robot) {
    	
	}

	@Override
	void ajoute(int equipe) {
		this.poseBase(equipe);
	}

	@Override
	void videCase() {
		this.poseBase(0);
	}

	@Override
	boolean estVide() {
	  return this.estBase() > 0;
	}

}
