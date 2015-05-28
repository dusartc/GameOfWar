package gameOfWar.affichage;

import gameOfWar.config.Constante;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Option extends JPanel{
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
 //Fenetre test;
  
  private JPanel jPanel = new Forme(new GridBagLayout());
  private JPanel toutLesPanel;
  private int nombreSousTitre = 0;
  JTextField tx = new JTextField(Constante.X_CHOICE + "");
  JTextField ty = new JTextField(Constante.Y_CHOICE + "");
  JTextField ob = new JTextField(Constante.OBSTACLES_CHOICE + "");
  
  JButton b = new Bouton("Musique");
  JButton b2 = new Bouton("Son");
  JButton b3 = new Bouton("Retour");
  
  public Option() {
	  
    super(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    this.getJpanel(constraints, 400, 100, GridBagConstraints.VERTICAL, 50, 0, 1);
    this.getJpanel(constraints, 400, 100, GridBagConstraints.VERTICAL, 0, 0, 2);
    this.getJpanel(constraints, 400, 100, GridBagConstraints.VERTICAL, 0, 0, 3);
    this.getJpanel(constraints, 800, 100, GridBagConstraints.VERTICAL, 0, 0, 4);
    /*this.getBoutonJeu(constraints, "Jeu", 250, 100, GridBagConstraints.VERTICAL, 50, 0, 1);
    this.getBoutonJeu(constraints, "Parametre", 250, 100, GridBagConstraints.VERTICAL, 0, 0, 2);
    this.getBoutonJeu(constraints, "Option", 250, 100, GridBagConstraints.VERTICAL, 0, 0, 3);
    this.getBoutonJeu(constraints, "X", 50, 50, GridBagConstraints.EAST, 0, 0, 4);*/
    this.add(jPanel);
   /* try {
      test = new Fenetre("Game of War.");
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception) {
      // TODO Auto-generated catch block
      exception.printStackTrace();
    }*/
    /*test.removeAll();
    test.add(this);
    test.validate();*/
  }
  
  public JPanel panel(JPanel toutLesPanel2, GridBagConstraints constraints) {
	  
    jPanel.add(toutLesPanel2, constraints);
    jPanel.setLocation(0, 0);
    jPanel.setMinimumSize(new Dimension(500, 500));
    jPanel.setPreferredSize(new Dimension(1024, 720));
    jPanel.setMaximumSize(new Dimension(1000, 650));
    if (nombreSousTitre == 0) {
      JLabel sousTitre = new JLabel("Option");
      sousTitre.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 45));
      sousTitre.setLocation(150, 0);
      jPanel.add(sousTitre);
      nombreSousTitre++;
    }
    return jPanel;
  }


  private void getJpanel(GridBagConstraints constraints, int x, int y, int fill,
      int insetsTop, int gridx, int gridy) {
    toutLesPanel = new JPanel();
    toutLesPanel.setPreferredSize(new Dimension(x, y));
    constraints.fill = fill;
    constraints.weightx = 1;
    if (insetsTop > 0) {
      constraints.insets = new Insets(insetsTop, 40, 0, 20);
    }
    constraints.gridx = gridx;
    constraints.gridy = gridy;
    toutLesPanel.setOpaque(false);
    
    if(gridy == 1){
    	JLabel l = new JLabel("Taille du Plateau");
    	l.setForeground(Color.white);
    	l.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 20));
    	toutLesPanel.add(l);
    	
    	tx.setPreferredSize(new Dimension(40 , 40));
    	tx.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 20));
    	tx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                txActionPerformed(e);
            }
        });
    	toutLesPanel.add(tx);
    	
    	JLabel l2 = new JLabel("X");
    	l2.setForeground(Color.white);
    	l2.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 20));
    	toutLesPanel.add(l2);
    	
    	ty.setPreferredSize(new Dimension(40 , 40));
    	ty.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 20));
    	ty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                tyActionPerformed(e);
            }
        });
    	toutLesPanel.add(ty);
    	
    } else if(gridy == 2){
    	JLabel l = new JLabel("Pourcentage d'obstacle");
    	l.setForeground(Color.white);
    	l.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 20));
    	toutLesPanel.add(l);
    	
    	ob.setPreferredSize(new Dimension(40, 40));
    	ob.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 20));
    	ob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                obActionPerformed(e);
            }
        });
    	toutLesPanel.add(ob);
    } else if(gridy == 3){
    	
    	b.setPreferredSize(new Dimension(120,100));
    	toutLesPanel.add(b);
    	b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActionPerformed(evt);
            }
        });
    	
    	b2.setPreferredSize(new Dimension(120,100));
    	toutLesPanel.add(b2);
    	b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
    	
    	b3.setPreferredSize(new Dimension(120,100));
    	toutLesPanel.add(b3);
    	b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	b3ActionPerformed(evt);
            }
        });
    	
    }
    this.panel(toutLesPanel, constraints);
  }
  private void bActionPerformed(ActionEvent evt) {                                         
	  JOptionPane.showMessageDialog(null, "HUMMMMMM BILLY !");
  }
  private void b2ActionPerformed(ActionEvent evt) {                                         
	  JOptionPane.showMessageDialog(null, "HUMMMMMM TIMMY !");
  }
  private void b3ActionPerformed(ActionEvent evt) {                                         
	  JOptionPane.showMessageDialog(null, "HUMMMMMM CHEVRE !");
	  Fenetre test = null;
	  test.testFenetre("Game of War.", new Menu());
	  /*try {
      new Fenetre("Game of War.");
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception) {
      // TODO Auto-generated catch block
      exception.printStackTrace();
    }*/
  }
  private void txActionPerformed(ActionEvent evt) {                                         
	  
  }
  private void tyActionPerformed(ActionEvent evt) {                                         
	  
  }
  private void obActionPerformed(ActionEvent evt) {                                         
	  
  }
}
