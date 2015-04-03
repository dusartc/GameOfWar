package gameOfWar.jeux;


public class Main {

  public static void main(String[] args) {
    Plateau test = new Plateau(5, 10, 20);
    //Vue test2 = new Vue(test);
    //Tireur test3 = new Tireur(test2, 3, 5, 1);
    //test2.poserRobot(robot, coordonnees);
    System.out.println(test);
    
    test.poserUneMine(3, 0, 1);
    System.out.println(test);
    
    
    test.poserUneMine(0, 3, 2);
    System.out.println(test);
  }

}
