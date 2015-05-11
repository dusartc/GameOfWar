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
  protected JPanel jPanel;
  public JTextField jTextField;
  
  public void ecrireJFrame(String nom){
	  	this.setTitle(nom);
	  	this.setPreferredSize(new Dimension(1024,720));
		this.pack();
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(new Fond());
		
		jPanel = new JPanel(new GridBagLayout());
		jPanel.setPreferredSize(new Dimension(1024,600));
		jPanel.setLocation(0, 120);
		//this.setLayout(new GridBagLayout());
	    GridBagConstraints constraints = new GridBagConstraints();
	    
	    getBoutonJeu(constraints, "Jeu", 250,100,90,0,0);
	    getBoutonJeu(constraints, "Parametre", 250,100,10,0,1);
	    getBoutonJeu(constraints, "Option", 250,100,0,0,2);
	    
	    /*jButton = new Bouton("Parametre");
	    jButton.setPreferredSize(new Dimension(250,100));
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.weighty =0.2;
	    constraints.insets = new Insets(10, 0, 0, 15);
	    constraints.gridx = 0;
	    constraints.gridy = 1;
	    this.getContentPane().add(jButton, constraints);
	    
	    jButton = new Bouton("");
	    
	    jButton = new Bouton("Option");
	    jButton.setPreferredSize(new Dimension(250,100));
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.weighty =0.2;
	    constraints.gridx = 0;
	    constraints.gridy = 2;
	    this.getContentPane().add(jButton, constraints);*/
	    jButton.addActionListener(this);
	    this.setVisible(true);
  }

private void getBoutonJeu(GridBagConstraints constraints, String nom, int x, int y, int insetsTop,int gridx, int gridy) {
	jButton = new Bouton(nom);
	jButton.setPreferredSize(new Dimension(x,y));
	constraints.fill = GridBagConstraints.HORIZONTAL;
	constraints.weighty = 0.2;
	if (insetsTop > 0) {
		constraints.insets = new Insets(insetsTop, 0, 0, 15);
	}
	constraints.gridx = gridx;
	constraints.gridy = gridy;
	this.getContentPane().add(jButton, constraints);
}
  
  public Menu(String nom) {
    this.x = 10;
    this.y = 10;
	
	this.ecrireJFrame(nom);
  }
  
  public void actionPerformed(ActionEvent e) {
    this.getContentPane().removeAll();
    this.setContentPane(new Option());
    jTextField = new JTextField(4);
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
    GridBagConstraints constraints2 = new GridBagConstraints();
    getBoutonJeu(constraints2, "Retour", 50, 50, 0, 1, 3);
    jButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ecrireJFrame("Game of War");
		}
	});
    this.revalidate();
    this.repaint();
    this.setVisible(true);
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

