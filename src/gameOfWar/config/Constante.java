package gameOfWar.config;
import java.util.ArrayList;
import java.util.List;


public class Constante {

  /// robot ///
  public static final int ENERGIE_PIEGEUR = 30;
  public static final int ENERGIE_TIREUR  = 20;
  public static final int ENERGIE_CHAR    = 50;
  public static final int NB_MAX_ROBOTS_PAR_EQUIPE = 5;
  public static final int SOIN = 2;
  public static final int EQUIPE_UN = 1;
  public static final int EQUIPE_DEUX = 2;
  public static final int DEGATS_TIREUR = 3;
  public static final int DEGATS_PIEGEUR = 2;
  public static final int DEGATS_CHAR = 6;
  public static final int COUP_DEPLACEMENTS_TIREUR = 1;
  public static final int COUP_DEPLACEMENTS_PIEGEUR = 2;
  public static final int COUP_DEPLACEMENTS_CHAR = 5;
  public static final int COUP_ACTION_TIREUR = 2;
  public static final int COUP_ACTION_PIEGEUR = 2;
  public static final int COUP_ACTION_CHAR = 1;
  public static final int DEGATS_MINES_TIREUR = 0;
  public static final int DEGATS_MINES_CHAR = 0;
  public static final int DEGATS_TIRS_PIEGEUR = 0;
  
  /// plateau ///
  public static final int X_MIN = 5;
  public static final int X_MAX = 25;
  public static final int Y_MIN = 10;
  public static final int Y_MAX = 25;
  public static final int OBSTACLES_MIN = 20;
  public static final int OBSTACLES_MAX = 50;
  
  
  /// Déplacement pour Tireur et Piegeur ///
  public static final Coordonnees HAUT = new Coordonnees(0, -1);
  public static final Coordonnees HAUT_DROITE = new Coordonnees(1, -1);
  public static final Coordonnees HAUT_GAUCHE = new Coordonnees(-1, -1);
  public static final Coordonnees BAS = new Coordonnees(0, 1);
  public static final Coordonnees BAS_DROITE = new Coordonnees(1, 1);
  public static final Coordonnees BAS_GAUCHE = new Coordonnees(-1, 1);
  public static final Coordonnees GAUCHE = new Coordonnees(-1, 0);
  public static final Coordonnees DROITE = new Coordonnees(1, 0);
  public static final Coordonnees GAUCHE_CHAR = new Coordonnees(-2, 0);
  public static final Coordonnees DROITE_CHAR = new Coordonnees(2, 0);
  public static final Coordonnees BAS_CHAR = new Coordonnees(0, 2);
  public static final Coordonnees HAUT_CHAR = new Coordonnees(0, -2);
  public static List<Coordonnees> DEP_TIREUR;
  public static List<Coordonnees> DEP_PIEGEUR;
  public static List<Coordonnees> DEP_CHAR;
  
  static{
	  DEP_TIREUR = new ArrayList<Coordonnees>();
	  DEP_PIEGEUR = new ArrayList<Coordonnees>();
	  DEP_TIREUR.add(HAUT);
	  DEP_TIREUR.add(HAUT_DROITE);
	  DEP_TIREUR.add(HAUT_GAUCHE);
	  DEP_TIREUR.add(BAS);
	  DEP_TIREUR.add(BAS_DROITE);
	  DEP_TIREUR.add(BAS_GAUCHE);
	  DEP_TIREUR.add(DROITE);
	  DEP_TIREUR.add(GAUCHE);
	  
	  DEP_PIEGEUR.addAll(DEP_TIREUR);
	  
	  DEP_CHAR = new ArrayList<Coordonnees>();
	  DEP_CHAR.add(HAUT_CHAR);
	  DEP_CHAR.add(BAS_CHAR);
	  DEP_CHAR.add(DROITE_CHAR);
	  DEP_CHAR.add(GAUCHE_CHAR);
  }
}
