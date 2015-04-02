
public class PoseMine extends Action{

	public PoseMine(Robot robot, Coordonnees direction) {
		super(robot, direction);
		// TODO Auto-generated constructor stub
	}
	public void agit(){
		if (this.getRobot() instanceof Piegeur) {
			this.getRobot().getVue().setMine(getRobot(), getObjectif());
		}
		else {
			System.err.println("Erreur, placement impossible.");
		}
	}
	 
}
