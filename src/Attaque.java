
public class Attaque extends Action {
	
	private int degats;
	
	public Attaque(Robot robot, Coordonnees direction, int degats) {
		super(robot, direction);
		this.degats = degats;
	}
	
	public int getDegats() {
		return this.degats;
	}
	
	@Override
	void agit() {
		
	}

}
