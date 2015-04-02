import java.util.List;


public abstract class Robot {

  private Coordonnees coordonnees;
  private int energie;
  private int equipe;
  private Vue vue;
  
  
  public Robot(Vue vue, int l, int h, int equipe) {
	  this.coordonnees = new Coordonnees(l, h);
	  this.equipe = equipe;
	  this.vue = vue;
  }

  public boolean estSurBase(int x, int y) {
	 if (this.getEquipe() == this.vue.getPlateau().getCellule(x, y).estBase()) {
		return true;
	}
	 return false;
  }

  public Coordonnees getCoordonnees() {
    return this.coordonnees;
  }

  abstract public int getCoupDep();

  abstract public int getCoutAction();

  abstract public int getDegatMine();

  abstract public int getDegatTir();

  abstract public List<Coordonnees> getDeplacements();

  public int getEnergie() {
    return this.energie;
  }

  public int getEquipe() {
    return this.equipe;
  }

  abstract public String getType();

  public Vue getVue() {
    return this.vue;
  }

  abstract public boolean peutTirer();

  public void setCoordonnees(Coordonnees coordonnees) {
    this.coordonnees = coordonnees;
  }

  public void setEnergie(int energie) {
    this.energie = energie;
  }

  abstract public void subitMine();
  abstract public void subitTir();
  
  public void estSoigne(){
    if (this.estSurBase(this.coordonnees.getLargeur(), this.coordonnees.getHauteur())) {
		this.energie += Constante.SOIN;
	}
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return super.toString();
  }
}
