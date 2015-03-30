
public class Deplacement extends Action {

  
  
  public Deplacement(Robot robot, Coordonnees direction) {
    super(robot, direction);
    // TODO Auto-generated constructor stub
  }


  @Override
  void agit() {
		this.getRobot().setCoordonnees(this.getRobot().getCoordonnees().ajout(getDirection()));

  }

}
