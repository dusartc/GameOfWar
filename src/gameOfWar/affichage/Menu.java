package gameOfWar.affichage;

import gameOfWar.config.Constante;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu extends JFrame implements ActionListener{

  // <
  // >
  private static final long serialVersionUID = 1L;
  
  private int x;
  private int y;
  
  CardLayout cl = new CardLayout();
  protected JLabel jLabel;
  protected Bouton jButton;
  protected JFrame content;
  public JTextField jTextField;
  
  public Menu(String nom) {
    this.x = 10;
    this.y = 10;
    this.setPreferredSize(new Dimension(1024,720));
    this.pack();
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setContentPane(new Fond());
    this.setLayout(new GridBagLayout());
    this.setVisible(true);
    
    GridBagConstraints constraints = new GridBagConstraints();
    
    jButton = new Bouton("Jeu");
    jButton.setPreferredSize(new Dimension(250,100));
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.weighty = 0.2;
    constraints.insets = new Insets(90, 0, 0, 15);
    constraints.gridx = 0;
    constraints.gridy = 0;
    this.getContentPane().add(jButton, constraints);
    
    jButton = new Bouton("Parametre");
    jButton.setPreferredSize(new Dimension(250,100));
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.weighty =0.2;
    constraints.insets = new Insets(10, 0, 0, 15);
    constraints.gridx = 0;
    constraints.gridy = 1;
    this.getContentPane().add(jButton, constraints);
    
    jButton = new Bouton("Option");
    jButton.setPreferredSize(new Dimension(250,100));
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.weighty =0.2;
    constraints.gridx = 0;
    constraints.gridy = 2;
    this.getContentPane().add(jButton, constraints);
    jButton.addActionListener(this);
    jLabel = new JLabel();
  }
  
  public void actionPerformed(ActionEvent e) {
    this.setTitle("OPTIONS");
    this.setPreferredSize(new Dimension(1024,720));
    this.pack();
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(new Option());
    this.setLayout(new GridBagLayout());
    this.setVisible(true);
    //JButton pd = new JButton("Retour");
    jTextField = new JTextField(1);
    jTextField.setText(""+x);
    jTextField.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        int valueX = Integer.parseInt(jTextField.getText());
        if (valueX >= Constante.X_MIN && valueX <= Constante.X_MAX ) {
          jTextField.setText(""+valueX);
          setX(valueX);
        }
      }
    });
    this.getContentPane().add(jTextField);
    jTextField = new JTextField(1);
    jTextField.setText(""+y);
    jTextField.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        int valueY = Integer.parseInt(jTextField.getText());
        if (valueY >= Constante.X_MIN && valueY <= Constante.X_MAX ) {
          jTextField.setText(""+valueY);
          setX(valueY);
        }
      }
    });
    jTextField.setLocation(500, 0);
    jTextField.setPreferredSize(new Dimension(100,50));
    this.getContentPane().add(jTextField);
    
  }

  public int getX(){
    return this.x;
  }
  public int getY(){
    return this.y;
  }

  public void setX(int x){
    this.x = x;
  }
  
  public void setY(int y){
    this.y = y;
  }
}

