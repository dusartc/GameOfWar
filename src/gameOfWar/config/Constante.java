package gameOfWar.config;
import java.util.ArrayList;
import java.util.List;

/**
 * Regroupe toute les constantes du projet.
 * @author Mathieu,Clement,Aurelia,Samantha,Mariam,Alexandre
 *
 */
public class Constante {

  // les données des robots.
  /** Correspond a l'énergie du Piegeur. */
  public static final int ENERGIE_PIEGEUR = 50;
  /** Correspond a l'énergie du Tireur. */
  public static final int ENERGIE_TIREUR  = 40;
  /** Correspond a l'énergie du Char. */
  public static final int ENERGIE_CHAR    = 60;
  /** Correspond au nombre de robot maximun par equipe. */
  public static final int NB_MAX_ROBOTS_PAR_EQUIPE = 5;
  /** Correspond au soin donnees aux bases*/
  public static final int SOIN = 2;
  /** Correspond a l'equipe une*/
  public static final int EQUIPE_UN = 1;
  /** Correspond a l'equipe deux*/
  public static final int EQUIPE_DEUX = 2;
  /** Correspond au degat produit par le Tireur.*/
  public static final int DEGATS_TIREUR = 3;
  /** Correspond au degat produit par le Piegeur.*/
  public static final int DEGATS_PIEGEUR = 2;
  /** Correspond au degat produit par le Char.*/
  public static final int DEGATS_CHAR = 6;
  /** Correspond au coup de deplacement du Tireur. */
  public static final int COUP_DEPLACEMENTS_TIREUR = 1;
  /** Correspond au coup de deplacement du Piegeur. */
  public static final int COUP_DEPLACEMENTS_PIEGEUR = 2;
  /** Correspond au coup de deplacement du Char. */
  public static final int COUP_DEPLACEMENTS_CHAR = 5;
  /** Correspond au coup d'une action du Tireur. */
  public static final int COUP_ACTION_TIREUR = 2;
  /** Correspond au coup d'une action du Piegeur. */
  public static final int COUP_ACTION_PIEGEUR = 2;
  /** Correspond au coup d'une action du Char. */
  public static final int COUP_ACTION_CHAR = 1;
  /** Correspond au degat d'une mine pour un Tireur. */
  public static final int DEGATS_MINES_TIREUR = 3;
  /** Correspond au degat d'une mine pour un Char. */
  public static final int DEGATS_MINES_CHAR = 6;
  /** Correspond au degat d'un tir pour un Piegeur . */
  public static final int DEGATS_TIRS_PIEGEUR = 0;
   /** Correspond à la portée d'un tir pour un Tireur . */
  public static final int PORTEE_TIREUR = 3;
   /** Correspond à la portée d'une mine pour un Piegeur . */
  public static final int PORTEE_PIEGEUR = 1;
  /** Correspond à la portée d'un tir pour un Char . */
  public static final int PORTEE_CHAR = 10;
  

  /// les données du plateau ///
  /** Taille minimun en largeur du plateau.*/
  public static final int X_MIN = 5;
  /** Taille maximun en largeur du plateau.*/
  public static final int X_MAX = 25;
  /** Taille minimun en longueur du plateau.*/
  public static final int Y_MIN = 10;
  /** Taille maximune en longueur du plateau.*/
  public static final int Y_MAX = 25;
  /** Obstacles minimun sur le plateau.*/
  public static final int OBSTACLES_MIN = 20;
  /** Obstacles maximun sur le plateau.*/
  public static final int OBSTACLES_MAX = 50;


  /// Déplacement pour Tireur et Piegeur et char///
  /** Deplacement en haut pour Tireur et Piegeur.*/
  public static final Coordonnees HAUT = new Coordonnees(0, -1);
  /** Deplacement diagonale en haut a droite pour Tireur et Piegeur.*/
  public static final Coordonnees HAUT_DROITE = new Coordonnees(1, -1);
  /** Deplacement diagonale en haut a gauche pour Tireur et Piegeur.*/
  public static final Coordonnees HAUT_GAUCHE = new Coordonnees(-1, -1);
  /** Deplacement en bas pour Tireur et Piegeur.*/
  public static final Coordonnees BAS = new Coordonnees(0, 1);
  /** Deplacement diagonale en base a droite pour Tireur et Piegeur.*/
  public static final Coordonnees BAS_DROITE = new Coordonnees(1, 1);
  /** Deplacement diagonale en base a gauche pour Tireur et Piegeur.*/
  public static final Coordonnees BAS_GAUCHE = new Coordonnees(-1, 1);
  /** Deplacement a gauche pour Tireur et Piegeur.*/
  public static final Coordonnees GAUCHE = new Coordonnees(-1, 0);
  /** Deplacement a droite pour Tireur et Piegeur.*/
  public static final Coordonnees DROITE = new Coordonnees(1, 0);
  /** Deplacement a gauche pour char.*/
  public static final Coordonnees GAUCHE_CHAR = new Coordonnees(-2, 0);
  /** Deplacement a droite pour char.*/
  public static final Coordonnees DROITE_CHAR = new Coordonnees(2, 0);
  /** Deplacement en bas pour char.*/
  public static final Coordonnees BAS_CHAR = new Coordonnees(0, 2);
  /** Deplacement en haut pour char.*/
  public static final Coordonnees HAUT_CHAR = new Coordonnees(0, -2);
  
  /** List des deplacement pour Tireur.*/
  public static List<Coordonnees> DEP_TIREUR;
  /** List des deplacement pour Piegeur.*/
  public static List<Coordonnees> DEP_PIEGEUR;
  /** List des deplacement pour Char.*/
  public static List<Coordonnees> DEP_CHAR;

  /**
   * Ajout des deplacement a leurs listes.
   */
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
