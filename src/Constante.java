import java.util.ArrayList;
import java.util.List;


public class Constante {

  /// robot ///
  public static final int ENERGIE_PIEGEUR = 30;
  public static final int ENERGIE_TIREUR  = 20;
  public static final int ENERGIE_CHAR    = 50;
  public static final int NB_MAX_ROBOTS_PAR_EQUIPE = 5;
  public final static int soin = 2;
  
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
  public static List<Coordonnees> depTireurPiegeur;
  
  static{
	  depTireurPiegeur = new ArrayList<Coordonnees>(8);
	  depTireurPiegeur.add(HAUT);
	  depTireurPiegeur.add(HAUTDROITE);
	  depTireurPiegeur.add(HAUTGAUCHE);
	  depTireurPiegeur.add(BAS);
	  depTireurPiegeur.add(BASDROITE);
	  depTireurPiegeur.add(BASGAUCHE);
	  depTireurPiegeur.add(GAUCHE);
	  depTireurPiegeur.add(DROITE);
  }
}
