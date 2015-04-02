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
  public static final int DEGATSTIREUR = 3;
  public static final int DEGATSPIEGEUR = 2;
  public static final int DEGATSCHAR = 6;
  
  /// plateau ///
  public static final int X_MIN = 5;
  public static final int X_MAX = 25;
  public static final int Y_MIN = 10;
  public static final int Y_MAX = 25;
  public static final int OBSTACLES_MIN = 20;
  public static final int OBSTACLES_MAX = 50;
  
  
  /// Déplacement pour Tireur et Piegeur ///
  public static final Coordonnees HAUT = new Coordonnees(0, -1);
  public static final Coordonnees HAUTDROITE = new Coordonnees(1, -1);
  public static final Coordonnees HAUTGAUCHE = new Coordonnees(-1, -1);
  public static final Coordonnees BAS = new Coordonnees(0, 1);
  public static final Coordonnees BASDROITE = new Coordonnees(1, 1);
  public static final Coordonnees BASGAUCHE = new Coordonnees(-1, 1);
  public static final Coordonnees GAUCHE = new Coordonnees(-1, 0);
  public static final Coordonnees DROITE = new Coordonnees(1, 0);
  public static List<Coordonnees> DEP_TIREUR;
  public static List<Coordonnees> DEP_PIEGEUR;
  public static List<Coordonnees> DEP_CHAR;
  
  static{
	  DEP_TIREUR = new ArrayList<Coordonnees>();
	  DEP_PIEGEUR = new ArrayList<Coordonnees>();
	  DEP_TIREUR.add(HAUT);
	  DEP_TIREUR.add(HAUTDROITE);
	  DEP_TIREUR.add(HAUTGAUCHE);
	  DEP_TIREUR.add(BAS);
	  DEP_TIREUR.add(BASDROITE);
	  DEP_TIREUR.add(BASGAUCHE);
	  DEP_TIREUR.add(DROITE);
	  DEP_TIREUR.add(GAUCHE);
	  
	  DEP_PIEGEUR.addAll(DEP_TIREUR);
	  
	  DEP_CHAR = new ArrayList<Coordonnees>();
	  DEP_CHAR.add(HAUT);
	  DEP_CHAR.add(BAS);
	  DEP_CHAR.add(DROITE);
	  DEP_CHAR.add(GAUCHE);
  }
}
