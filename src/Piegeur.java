import java.util.List;


public class Piegeur extends Robot {

  private final int DEGATS_TIRS = 0;
  private final int DEGATS_MINES = 10;
  private int nbMines = 0;
  
  public Piegeur(Vue vue, int l, int h, int equipe) {
    super(vue, l, h, equipe);
    // TODO Auto-generated constructor stub
  }

  @Override
  public int getCoupDep() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getCoutAction() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getDegatMine() {
    return this.DEGATS_MINES;
  }

  @Override
  public int getDegatTir() {
    return this.DEGATS_TIRS;
  }

  @Override
  public List<Coordonnees> getDeplacements() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getType() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean peutTirer() {
    // TODO Auto-generated method stub
    return false;
  }
  
  /*public boolean poseMine() {
    if (this.nbMines <= 0) {
      return false;
    }if (getVue().getPlateau().getCelluleByCoordonnees(getCoordonnees()).estVide()) {
      getVue().getPlateau().getCelluleByCoordonnees(getCoordonnees()).poseMine();
      return true;
    }return false;
  }*/

}