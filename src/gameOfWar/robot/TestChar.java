package gameOfWar.robot;
import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(JUnit4.class)
public class TestChar {
  
  //final int EQUIPE = 1;
  //final int DEGATS_MINES_CHAR = 0;
  //final int COUP_DEPLACEMENTS_CHAR = 5;
  //final int DEGATS_CHAR = 6;
  //final int ENERGIE_CHAR    = 50;
  Robot tank;
  
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
}
