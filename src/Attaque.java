
public class Attaque extends Action {

	public Attaque(Robot robot, Coordonnees direction) {
		super(robot, direction);
	}
	
	@Override
	void agit() {
		while (this.getRobot().getCoordonnees() != this.getObjectif()) {
			
		}
	}

}
