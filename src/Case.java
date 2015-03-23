
public class Case extends Cellule {
  
  private int mur = 0;
  
  public Case(int largeur, int hauteur, int mur){
    super(largeur, hauteur);
    this.mur = mur;
  }

  public Case(int largeur, int hauteur) {
    super(largeur, hauteur);
  }
  
  public void setMur(int mur) {
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
    // TODO Auto-generated method stub

  }
  
  public boolean estPassable(){
    return this.mur == 0;
  }

  @Override
  boolean estVide() {
    // TODO Auto-generated method stub
    return true;
  }

}
