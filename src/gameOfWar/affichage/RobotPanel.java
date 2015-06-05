package gameOfWar.affichage;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class RobotPanel extends JPanel {

  private static final long serialVersionUID = 1L;

  private JLabel vie;
  private JLabel degats;
  private JLabel coupDep;
  private JLabel coupAct;
  private JLabel portee;
  private JLabel mineSubis;
  private Slider svie;
  private Slider sdegats;
  private Slider scoupDep;
  private Slider scoupAct;
  private Slider sportee;
  private Slider smineSubis;
  private Map<String, Integer> data;
  private Slider[] titi;

  public RobotPanel() {
    data = new HashMap<String, Integer>();
    setBackground(Color.black);
    setLayout(null);
    initComponent();
  }

  private void initComponent() {
    vie = new JLabel("Vie :");
    degats = new JLabel("Degats :");
    coupDep = new JLabel("Coup Deplacement :");
    coupAct = new JLabel("Coup Action :");
    portee = new JLabel("Portee :");
    mineSubis = new JLabel("Degats mine subis :");
    svie = new Slider("vie",10, 100, 500, 10, 100, 50);
    sdegats = new Slider("degats", 1, 10, 500, 60, 100, 50);
    scoupDep = new Slider("coupDep", 1, 6, 500, 110, 100, 50);
    scoupAct = new Slider("coupAct", 1, 6, 500, 160, 100, 50);
    sportee = new Slider("portee", 1, 10, 500, 210, 100, 50);
    smineSubis = new Slider("mineSubis", 10, 100, 500, 260, 100, 50);
    JLabel[] toto = new JLabel[] {vie, degats, coupDep, coupAct, portee, mineSubis};
    titi = new Slider[] {svie, sdegats, scoupDep, scoupAct, sportee, smineSubis};
    int y = 10;
    for (int i = 0; i < toto.length; i++) {
      toto[i].setForeground(Color.WHITE);
      toto[i].setFont(new Font("Deja vu", Font.BOLD, 24));
      toto[i].setBounds(10, y, 280, 50);
      // titi[i].addChangeListener(new ChangeListener() {
      //
      // @Override
      // public void stateChanged(ChangeEvent e) {
      // data.put(titi[i].getName(), titi[i].getValue());
      //
      // }
      // });
      add(toto[i]);
      add(titi[i]);
      y += 50;
    }

  }

  public Map<String, Integer> getDataMap() {
    for (Slider slider : titi) {
      data.put(slider.getNom(), slider.getValue());
    }
    return data;
  }


}
