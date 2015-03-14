
public class Essai {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Plateau test = new Plateau(10, 5);
		test.initObstacle(10);
		System.out.println(test.toString());
	}
}
