package gameOfWar.affichage;

import gameOfWar.config.Constante;
import gameOfWar.jeux.Equipe;
import gameOfWar.robot.Char;
import gameOfWar.robot.Piegeur;
import gameOfWar.robot.Robot;
import gameOfWar.robot.Tireur;
import gameOfWar.robot.Worker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;

public class ParametreEquipe extends JPanel {
	
  
  private static final long serialVersionUID = 1L;
  private String[] pays = Constante.PAYS;
  private String paysChoisitUne;
  private int numeroPaysUne = pays.length * 50, numeroPaysDeux = pays.length * 50;
  private JLabel sousTitre, equipeUne, equipeDeux, paysUne, paysDeux, choisirUne,
  choisitUne, choisirDeux, choisitDeux;
  private JSeparator horizontal, vertical;
  private JButton decrementeUne, incrementeUne, decrementeDeux, incrementeDeux, jouerButton, retour;
  private JToggleButton joueurUn, IAUn, joueurDeux, IADeux;
  private JList choisirListUne, choisitListUne, choisirListDeux, choisitListDeux;
  private DefaultListModel defaultListModelUne = new DefaultListModel();
  private DefaultListModel defaultListModelDeux = new DefaultListModel();
  private DefaultListModel defaultListModel1 = new DefaultListModel();
  private JScrollPane jScrollPane1, jScrollPane2, jScrollPaneUne, jScrollPaneDeux;
  private DefaultListModel defaultListModel2 = new DefaultListModel();
  private Map<String, List<Robot>> robot;
  private int equipeNumero;
  private String nom;
  private boolean ia;
  private Equipe[] equipe = new Equipe[2];
  protected Fenetre fenetre;

  public ParametreEquipe(){
      robot = new HashMap<String, List<Robot>>();
  }
  
  public ParametreEquipe(Fenetre fenetre){
	this();
    this.fenetre = fenetre;
    this.setLayout(null);
    this.setPreferredSize(new Dimension(900, 600));
    this.setOpaque(false);
    this.setLocation(60, 77);
    this.initComponent();
  }
  
  public void initComponent(){
    sousTitre = new JLabel("Equipes");
    sousTitre.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 45));
    sousTitre.setBounds(380, 45, 350, 50);
    equipeUne = new JLabel("Equipe Une");
    equipeUne.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 20));
    equipeUne.setBorder(BorderFactory.createLineBorder(Color.white, 1, true));
    equipeUne.setForeground(Color.white);
    equipeUne.setBounds(110, 115, 180, 40);
    equipeDeux = new JLabel("Equipe Deux");
    equipeDeux.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 20));
    equipeDeux.setBorder(BorderFactory.createLineBorder(Color.white, 1, true));
    equipeDeux.setForeground(Color.white);
    equipeDeux.setBounds(650, 115, 180, 40);
    horizontal = new JSeparator(JSeparator.HORIZONTAL);
    horizontal.setBackground(Color.white);
    horizontal.setBounds(120, 180, 700, 2);
    vertical = new JSeparator(JSeparator.VERTICAL);
    vertical.setBackground(Color.white);
    vertical.setBounds(475, 180, 2, 320);
    decrementeUne = new JButton("<");
    decrementeUne.setBounds(140, 200, 50, 50);
    decrementeUne.setActionCommand("-");
    decrementeUne.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent arg0) {
        paysUne(arg0);
      }
    });
    paysUne = new JLabel(this.pays[0]);
    paysUne.setBounds(200, 215, 190, 30);
    paysUne.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 20));
    paysUne.setForeground(Color.white);
    incrementeUne = new JButton(">");
    incrementeUne.setBounds(380, 200, 50, 50);
    incrementeUne.setActionCommand("+");
    incrementeUne.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent arg0) {
        paysUne(arg0);
      }
    });
    decrementeDeux = new JButton("<");
    decrementeDeux.setBounds(505, 200, 50, 50);
    decrementeDeux.setActionCommand("-");
    decrementeDeux.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent arg0) {
        paysDeux(arg0);
      }
    });
    paysDeux = new JLabel(this.pays[0]);
    paysDeux.setBounds(565, 215, 190, 30);
    paysDeux.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 20));
    paysDeux.setForeground(Color.white);
    incrementeDeux = new JButton(">");
    incrementeDeux.setBounds(745, 200, 50, 50);
    incrementeDeux.setActionCommand("+");
    incrementeDeux.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent arg0) {
        paysDeux(arg0);
      }
    });
    joueurUn = new JToggleButton("Joueur");
    joueurUn.setSelected(true);
    joueurUn.setBounds(140, 300, 150, 50);
    joueurUn.setFont(new Font("Deja vu", Font.ROMAN_BASELINE, 20));
    joueurUn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (IAUn.isSelected()) {
		          IAUn.setSelected(false);
		        }
		}
	});
    IAUn = new JToggleButton("Ordinateur");
    IAUn.setBounds(310, 300, 150, 50);
    IAUn.setFont(new Font("Deja vu", Font.ROMAN_BASELINE, 20));
    IAUn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (joueurUn.isSelected()) {
		          joueurUn.setSelected(false);
		        }
		}
	});
    joueurDeux = new JToggleButton("Joueur");
    joueurDeux.setSelected(true);
    joueurDeux.setBounds(505, 300, 150, 50);
    joueurDeux.setFont(new Font("Deja vu", Font.ROMAN_BASELINE, 20));
    joueurDeux.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (IADeux.isSelected()) {
		          IADeux.setSelected(false);
		        }
		}
	});
    IADeux = new JToggleButton("Ordinateur");
    IADeux.setBounds(675, 300, 150, 50);
    IADeux.setFont(new Font("Deja vu", Font.ROMAN_BASELINE, 20));
    IADeux.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (joueurDeux.isSelected()) {
		          joueurDeux.setSelected(false);
		        }
		}
	});
    choisirUne = new JLabel("<html><u>Choisit robot :</u></html>");
    choisirUne.setBounds(140, 380, 150, 20);
    choisirUne.setForeground(Color.white);
    choisirUne.setFont(new Font("Deja vu", Font.ROMAN_BASELINE, 14));
    choisitUne = new JLabel("<html><u>Robot choisit :</u></html>");
    choisitUne.setBounds(310, 380, 150, 20);
    choisitUne.setForeground(Color.white);
    choisitUne.setFont(new Font("Deja vu", Font.ROMAN_BASELINE, 14));
    choisirDeux = new JLabel("<html><u>Choisit robot :</u></html>");
    choisirDeux.setBounds(505, 380, 150, 20);
    choisirDeux.setForeground(Color.white);
    choisirDeux.setFont(new Font("Deja vu", Font.ROMAN_BASELINE, 14));
    choisitDeux = new JLabel("<html><u>Robot choisit :</u></html>");
    choisitDeux.setBounds(675, 380, 150, 20);
    choisitDeux.setForeground(Color.white);
    choisitDeux.setFont(new Font("Deja vu", Font.ROMAN_BASELINE, 14));
    choisirListUne = new JList();
    choisirListUne.setModel(defaultListModelUne);
    choisirListUne.setBounds(140, 400, 125, 90);
    choisirListUne.setBorder(BorderFactory.createLineBorder(Color.white, 2));
    jScrollPaneUne = new JScrollPane();
    jScrollPaneUne.getViewport().add(choisirListUne);
    jScrollPaneUne.setBounds(140, 400, 125, 90);
    jScrollPaneUne.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
    defaultListModelUne.add(0, "Piegeur");
    defaultListModelUne.add(1, "Tireur");
    defaultListModelUne.add(2, "Char");
    defaultListModelUne.add(3, "Worker");
    choisirListUne.addMouseListener(new MouseListener() {
		@Override
		public void mouseReleased(MouseEvent e) {}
		
		@Override
		public void mousePressed(MouseEvent e) {}
		
		@Override
		public void mouseExited(MouseEvent e) {}
		
		@Override
		public void mouseEntered(MouseEvent e) {}
		
		@Override
		public void mouseClicked(MouseEvent e) {
	        if (e.getClickCount() == 2) {
	            int index = choisirListUne.locationToIndex(e.getPoint());
	            System.out.println(index);
	            if (defaultListModel1.getSize() < fenetre.getOptionMap().get("robot")) {
	            	defaultListModel1.addElement(defaultListModelUne.getElementAt(index));
				}

					/*switch (index) {
					case 1:
						if (defaultListModelUne.getElementAt(index).equals("Piegeur")) {
							robot.put("Equipe1", new ArrayList<Robot>());
							robot.get("Equipe1").add(new Piegeur(equipe[1].getVue(), equipe[1]));
						}
						break;
					case 2:
						if (defaultListModelUne.getElementAt(index).equals("Tireur")) {
							robot.put("Equipe1", new ArrayList<Robot>());
							robot.get("Equipe1").add(new Tireur(equipe[1].getVue(), equipe[1]));
						}
						break;
					case 3:
						if (defaultListModelUne.getElementAt(index).equals("Char")) {
							robot.put("Equipe1", new ArrayList<Robot>());
							robot.get("Equipe1").add(new Char(equipe[1].getVue(), equipe[1]));
						}
						break;
					case 4:
						if (defaultListModelUne.getElementAt(index).equals("Worker")) {
							robot.put("Equipe1", new ArrayList<Robot>());
							robot.get("Equipe1").add(new Worker(equipe[1].getVue(), equipe[1]));
						}
						break;
					default:
						break;
					}*/
				//}
	            
	        }
		}
	});
    choisirListDeux = new JList();
    choisirListDeux.setModel(defaultListModelUne);
    choisirListDeux.setBounds(505, 400, 125, 90);
    choisirListDeux.setBorder(BorderFactory.createLineBorder(Color.white, 2));
    jScrollPaneDeux = new JScrollPane();
    jScrollPaneDeux.getViewport().add(choisirListDeux);
    jScrollPaneDeux.setBounds(505, 400, 125, 90);
    jScrollPaneDeux.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
    choisirListDeux.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent arg0) {}
		
		@Override
		public void mousePressed(MouseEvent arg0) {}
		
		@Override
		public void mouseExited(MouseEvent arg0) {}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {}
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
	        if (arg0.getClickCount() == 2) {
	            int index = choisirListUne.locationToIndex(arg0.getPoint());
	            if (defaultListModel2.getSize() < fenetre.getOptionMap().get("robot")) {
					defaultListModel2.addElement(defaultListModelUne.getElementAt(index));
				}
	        }
		}
	});
    choisitListUne = new JList();
    choisitListUne.setModel(defaultListModel1);
    choisitListUne .setBounds(310, 400, 125, 90);
    choisitListUne .setBorder(BorderFactory.createLineBorder(Color.white, 2));
    choisitListUne.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent arg0) {}
		
		@Override
		public void mousePressed(MouseEvent arg0) {}
		
		@Override
		public void mouseExited(MouseEvent arg0) {}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {}
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
	        if (arg0.getClickCount() == 2) {
	            int index = choisitListUne.locationToIndex(arg0.getPoint());
	            if (defaultListModel1.getSize() > 0) {
					defaultListModel1.removeElementAt(index);
				}
	        }
		}
	});
    jScrollPane1 = new JScrollPane();
    jScrollPane1.getViewport().add(choisitListUne);
    jScrollPane1.setBounds(310, 400, 125, 90);
    jScrollPane1.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
    choisitListDeux = new JList();
    choisitListDeux.setModel(defaultListModel2);
    choisitListDeux .setBounds(675, 400, 125, 90);
    choisitListDeux .setBorder(BorderFactory.createLineBorder(Color.white, 2));
    choisitListDeux.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent arg0) {}
		
		@Override
		public void mousePressed(MouseEvent arg0) {}
		
		@Override
		public void mouseExited(MouseEvent arg0) {}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {}
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
	        if (arg0.getClickCount() == 2) {
	            int index = choisitListDeux.locationToIndex(arg0.getPoint());
	            System.out.println(index);
	            if (defaultListModel2.getSize() > 0) {
					defaultListModel2.removeElementAt(index);
				}
	        }
		}
	});
    jScrollPane2 = new JScrollPane();
    jScrollPane2.getViewport().add(choisitListDeux);
    jScrollPane2.setBounds(675, 400, 125, 90);
    jScrollPane2.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
    jouerButton = new JButton("Jouer");
    jouerButton.setBounds(400, 510, 150, 50);
    jouerButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	});
    retour = new Retour(fenetre);
    retour.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        fenetre.showMenu();
      }
    });
    this.add(sousTitre);
    this.add(equipeUne);
    this.add(equipeDeux);
    this.add(horizontal);
    this.add(vertical);
    this.add(decrementeUne);
    this.add(paysUne);
    this.add(incrementeUne);
    this.add(decrementeDeux);
    this.add(paysDeux);
    this.add(incrementeDeux);
    this.add(joueurUn);
    this.add(IAUn);
    this.add(joueurDeux);
    this.add(IADeux);
    this.add(choisirUne);
    this.add(choisitUne);
    this.add(choisirDeux);
    this.add(choisitDeux);
    this.add(jScrollPaneUne);
    this.add(jScrollPaneDeux);
    this.add(jScrollPane1);
    this.add(jScrollPane2);
    this.add(jouerButton);
    this.add(retour);
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D graphics2d = (Graphics2D) g;
    GradientPaint gradientPaint =
        new GradientPaint(0, -(180), new Color(80, 80, 80), 0, 90, new Color(40, 40, 40), true);
    graphics2d.setPaint(gradientPaint);
    graphics2d.fillRoundRect(100, 30, 740, 550, 20, 20);
    GradientPaint gradientPaint2 =
        new GradientPaint(0, 0, new Color(0xFF, 0xFF, 0xFF), 0, 90, new Color(110, 110, 110), true);
    graphics2d.setPaint(gradientPaint2);
    graphics2d.fillRoundRect(100, 30, 740, 80, 20, 20);
  }
  
  public Fenetre getF() {
    return fenetre;
  }

  public void setF(Fenetre f) {
    this.fenetre = f;
  }
  
  public String getPaysChoisitPays(){
    return this.paysChoisitUne;
  }
  
  public void setPaysChoisitPays(String choisit){
    this.paysChoisitUne = choisit;
  }

  public void paysUne(ActionEvent event){
    if (event.getActionCommand().equals("-")) {
      numeroPaysUne--;
    }else{
        numeroPaysUne++;
    }
    paysUne.setText(pays[numeroPaysUne%pays.length]);
  }
  
  public void paysDeux(ActionEvent event){
	    if (event.getActionCommand().equals("-")) {
	      numeroPaysDeux--;
	    }else{
	        numeroPaysDeux++;
	    }
	    paysDeux.setText(pays[numeroPaysDeux%pays.length]);
	  }
  
  public String getNom(){
	  return this.nom;
  }
  
  public boolean getIA(){
	  return this.ia;
  }
  
  public Map<String, List<Robot>> getRobot(){
	  return this.robot;
  }

}
