import java.util.ArrayList;
import java.util.List;


public class Tireur extends Robot {

  private final int DEGATS_TIRS = 4;
  private final int DEGATS_MINES = 0;
  
  private List<Coordonnees> coordonnees;
  
  public Tireur(Vue vue, int l, int h, int equipe) {
    super(vue, l, h, equipe);
    this.coordonnees = new ArrayList<Coordonnees>();
    this.coordonnees = Constante.DEP_TIREUR;
    // TODO Auto-generated constructor stub
  }

  @Override
  public int getCoupDep() {
    return 1;
  }

  @Override
  public int getCoutAction() {
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
    return this.coordonnees;
  }

  @Override
  public String getType() {
    return getClass().getName();
  }

  @Override
  public boolean peutTirer() {
    return false;
  }

@Override
public void subitMine() {
	// TODO Auto-generated method stub
	
}

@Override
public void subitTir() {
	// TODO Auto-generated method stub
	
}

}
