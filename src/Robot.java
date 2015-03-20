import java.util.List;


public abstract class Robot {

	private Coordonnees coordonnees;
	private int energie;
	private int equipe;
	private Vue vue;
	
	public Robot(Vue vue, int l, int h, int equipe) {
		
	}
	
	public boolean estSurBase() {
		return false;
	}
	
	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	abstract public int getCoupDep();

	abstract public int getCoutAction();

	abstract public int getDegatMine();

	abstract public int getDegatTir();

	abstract public List<Coordonnees> getDeplacements();

	public int getEnergie() {
		return energie;
	}

	public int getEquipe() {
		return equipe;
	}
	
	abstract public String getType();
	
	public Vue getVue() {
		return vue;
	}
	
	abstract public boolean peutTirer();
	
	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}
	
	public void setEnergie(int energie) {
		this.energie = energie;
	}
	
	public void setVue(Vue vue) {
		this.vue = vue;
	}
	
	public void subitMine() {
		
	}
	
	public void subitTir() {
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}	
}
