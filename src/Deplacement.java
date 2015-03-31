
public class Deplacement extends Action {

  
  
  public Deplacement(Robot robot, Coordonnees direction) {
    super(robot, direction);
    // TODO Auto-generated constructor stub
  }


  @Override
  void agit() {
	if (this.getRobot() instanceof Tireur || this.getRobot() instanceof Piegeur) {
		
	}

  }

}
