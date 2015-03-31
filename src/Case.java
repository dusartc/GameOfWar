
public class Case extends Cellule {
  
  private boolean mur;
  
  public Case(int largeur, int hauteur){
	    super(largeur, hauteur);
  }
  
  public Case(int largeur, int hauteur, boolean mur){
    this(largeur, hauteur);
    this.setMur(mur);
  }
  
  public void setMur(boolean mur) {
    this.mur = mur;
  }

  @Override
  void deplaceSur(Robot robot) {
    // TODO Auto-generated method stub

  }

  @Override
  void ajoute(int equipe) {
    // TODO Auto-generated method stub

  }

  @Override
  void videCase() {
    this.mur = false;
  }
  
  public boolean estPassable(){
    return this.mur;
  }

  @Override
  boolean estVide() {
    // TODO Auto-generated method stub
    return this.mur;
  }

}
