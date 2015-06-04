package gameOfWar.affichage;

import gameOfWar.config.Constante;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class ParametreEquipe extends JPanel {
	
  
  private static final long serialVersionUID = 1L;
  private String[] pays = Constante.PAYS;
  private String paysChoisitUne;
  private int numeroPays = 0;
  private JLabel sousTitre;
  private JLabel equipeUne;
  private JLabel equipeDeux;
  private JSeparator horizontal;
  private JSeparator vertical;
  private JButton decrementeUne;
  private JLabel paysUne;
  private JButton incrementeUne;
  private JButton decrementeDeux;
  private JLabel paysDeux;
  private JButton incrementeDeux;
  private JToggleButton joueurUn;
  private JToggleButton IAUn;
  private JToggleButton joueurDeux;
  private JToggleButton IADeux;
  private JLabel choisirUne;
  private JLabel choisitUne;
  private JLabel choisirDeux;
  private JLabel choisitDeux;
  private JList choisirListUne;
  private JLabel flecheDroitUne;
  private JLabel flecheGaucheUne;
  private JList choisitListUne;
  private JList choisirListDeux;
  private JLabel flecheDroitDeux;
  private JLabel flecheGaucheDeux;
  private JList choisitListDeux;
  private JButton jouerButton;
  private JButton retour;
  protected Fenetre fenetre;

  public ParametreEquipe(){
      this.setLayout(null);
      this.setPreferredSize(new Dimension(900, 600));
      this.setOpaque(false);
      this.setLocation(60, 77);
      this.initComponent();
	}
  
  public ParametreEquipe(Fenetre fenetre){
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
    equipeUne = new JLabel("<html><center><b>Equipe Une</b></center></html>");
    equipeUne.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 20));
    equipeUne.setBorder(BorderFactory.createLineBorder(Color.white, 1, true));
    equipeUne.setForeground(Color.white);
    equipeUne.setBounds(110, 115, 180, 40);
    equipeDeux = new JLabel("<html><center><b>Equipe Deux</b></center></html>");
    equipeDeux.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 20));
    equipeDeux.setBorder(BorderFactory.createLineBorder(Color.white, 1, true));
    equipeDeux.setForeground(Color.white);
    equipeDeux.setBounds(650, 115, 180, 40);
    horizontal = new JSeparator(JSeparator.HORIZONTAL);
    horizontal.setBackground(Color.white);
    horizontal.setBounds(120, 180, 700, 2);
    vertical = new JSeparator(JSeparator.VERTICAL);
    vertical.setBackground(Color.white);
    vertical.setBounds(475, 180, 2, 380);
    decrementeUne = new JButton("<");
    decrementeUne.setBounds(140, 200, 50, 50);
    decrementeUne.setActionCommand("-");
    decrementeUne.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent arg0) {
        System.out.println(paysChoisitUne);
        paysUne(arg0);
      }
    });
    paysUne = new JLabel(this.getPaysChoisitPays());
    paysUne.setBounds(250, 215, 100, 20);
    paysUne.setFont(new Font("Deja Vu", Font.ROMAN_BASELINE, 20));
    paysUne.setForeground(Color.white);
    incrementeUne = new JButton(">");
    incrementeUne.setBounds(380, 200, 50, 50);
    incrementeUne.setActionCommand("+");
    incrementeUne.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent arg0) {
        System.out.println(paysChoisitUne);
        paysUne(arg0);
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
      if (numeroPays == 0) {
        numeroPays = pays.length;
      }
      else{
        --numeroPays;
        paysChoisitUne = pays[numeroPays];
        setPaysChoisitPays(paysChoisitUne);
      }
    }
    else if (event.getActionCommand().equals("+")) {
      if (numeroPays == pays.length) {
        numeroPays = 0;
      }
      else{
        ++numeroPays;
        paysChoisitUne = pays[numeroPays];
        setPaysChoisitPays(paysChoisitUne);
      }
    }
  }
  /*this.setTitle("Parametre");
  this.setSize(new Dimension(1024,800));
  
//  ImageIcon exit = new ImageIcon("gameOfWar.affichage.img/exit.jpeg");
  JPanel barreHaut= new JPanel();
  JPanel selectParam1= new JPanel();
  JPanel selectParam2= new JPanel();
  JPanel mainParam= new JPanel();
  JLabel lab2= new JLabel("Parametres");
  JLabel lab1= new JLabel("Game of War");
  

  JButton equipe1= new JButton("Equipe 1");
  JButton equipe2= new JButton("Equipe 2");
  JButton ordi1= new JButton("ordinateur");
  JButton ordi2= new JButton("ordinateur");
  JButton joueur1= new JButton("joueur");
  JButton joueur2= new JButton("joueur");

  selectParam1.setSize(new Dimension(350,400));
  selectParam2.setSize(new Dimension(350,400));
  mainParam.setSize(new Dimension(710,100));
  barreHaut.setSize(new Dimension(1024,100));
  
  Font font = new Font("Arial",Font.BOLD,30);
  Font font2 = new Font("Arial",Font.BOLD,20);
  Font font3 = new Font("Arial",Font.BOLD,15);
  
  lab1.setFont(font);
  lab2.setFont(font);
  equipe1.setFont(font3);
  equipe2.setFont(font3);
  joueur1.setFont(font3);
  joueur2.setFont(font3);
  
  selectParam1.setBackground(Color.GRAY);
  mainParam.setBackground(Color.GRAY);
  selectParam2.setBackground(Color.GRAY);
  barreHaut.setBackground(Color.GRAY);
  
  JButton quitter= new JButton();
  quitter.setBounds(950,650,48,48);
  try {
        File fond = new File("src/gameOfWar/jeux/Images/quitter.png");
        Image img = ImageIO.read(fond);
        quitter.setIcon(new ImageIcon(img));
  } 
  catch (IOException exception) {
        exception.printStackTrace();
  }
  
  barreHaut.add(lab1);
  mainParam.add(lab2);
  
  
  this.setLayout(new GridBagLayout());
  GridBagConstraints gbc= new GridBagConstraints();
  
  gbc.gridx=0;
  gbc.gridy=0;
  gbc.gridheight=0;
  gbc.gridwidth= 0;
  gbc.fill= GridBagConstraints.HORIZONTAL;
  this.add(barreHaut,gbc);
  gbc.gridx=1;
  gbc.gridy=3;
  gbc.gridheight=4;
  gbc.gridwidth= 3;
  this.add(selectParam1,gbc);
  gbc.gridx=3;
  gbc.gridy=3;
  gbc.gridheight=4;
  gbc.gridwidth= 3;
  this.add(selectParam2,gbc);
  this.add(quitter);
  this.setVisible(true);
  this.setLocationRelativeTo(null);
  this.getContentPane().setLayout(null);
  this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);*/ 
}
