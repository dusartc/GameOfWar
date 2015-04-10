

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Mathieu
 *
 */
public class TestChar {
  
  Char tank;
  
  @Before
  public void creerUnRobotChar(){
    tank = new Char(null, 1);
  }
  
  @Test
  public void testCreerUnChar(){
    assertEquals(1, tank.getEquipe());
    assertEquals(50, tank.getEnergie());
    assertEquals("Char", tank.getType());
  }
  
  @Test
  public void testDegatMineEquipeAdverse(){
    int energie = tank.getEnergie();
    Piegeur test = new Piegeur(null, 2);
    tank.subitMine(test);
    assertEquals(energie-2, tank.getEnergie());
  }

}
