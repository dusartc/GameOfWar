
public abstract class Cellule {

	protected int mine = 0;
	protected int base = 0;
	private Robot robot;
	private Coordonnees coordonnees;
	String image;
	
	public Cellule(int largeur, int hauteur) {
		
	}
	
	public int contientMine() {
		return this.mine;
	}
	
	public int estBase() {
		return this.base;
	}
	
	public Robot getRobot() {
		return this.robot;
	}
	
	public Coordonnees getCoordonnees() {
		return this.coordonnees;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	abstract void deplaceSur(Robot robot);
	
	abstract void ajoute(int equipe);
	
	abstract void videCase();
	
}
