
public abstract class Action {

	private Coordonnees direction;
	private Coordonnees objectif;
	private Robot robot;
	
	public Action(Robot robot, Coordonnees direction) {
		this.robot = robot;
		this.direction = direction;
	}
	
	public Robot getRobot() {
		return this.robot;
	}
	
	public Coordonnees getDirection() {
		return this.direction;
	}
	
	public Coordonnees getObjectif() {
		return this.objectif;
	}
	
	abstract void agit();
	
}
