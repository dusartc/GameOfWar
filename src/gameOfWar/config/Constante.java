package gameOfWar.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * Regroupe toute les constantes du projet.
 * 
 * @author Mathieu
 * @author Aurelia
 * @author Samantha
 * @author Mariam
 * @author Alexandre
 * @author Clement
 */
public class Constante {

  private static final Properties PROPERTIES = new Properties();

  static {
    // chargement de properties
    try {
      PROPERTIES.load(new FileReader("gameOfWar.properties"));
    } catch (IOException e) {
      System.err.println("Fichier gameOfWar.properties introuvable, verifier son orthographe");
      e.printStackTrace();
      System.exit(1);
    }
  }

  // les données des robots.
  /** Correspond a l'énergie du Piegeur. */
  public static final int ENERGIE_PIEGEUR = Integer.parseInt((String) PROPERTIES.get("p_energie"));
  /** Correspond a l'énergie du Tireur. */
  public static final int ENERGIE_TIREUR = Integer.parseInt((String) PROPERTIES.get("t_energie"));
  /** Correspond a l'énergie du Char. */
  public static final int ENERGIE_CHAR = Integer.parseInt((String) PROPERTIES.get("c_energie"));
  /** Correspond a l'�nergie du Worker. */
  public static final int ENERGIE_WORKER = Integer.parseInt((String) PROPERTIES.get("w_energie"));
  /** Correspond au nombre de robot maximun par equipe. */
  public static final int NB_MAX_ROBOTS_PAR_EQUIPE = Integer.parseInt((String) PROPERTIES
      .get("max_robot"));
  /** Correspond au soin donnees aux bases */
  public static final int SOIN = Integer.parseInt((String) PROPERTIES.get("soin"));
  /** Correspond a l'equipe une */
  public static final int EQUIPE_UN = 1;
  /** Correspond a l'equipe deux */
  public static final int EQUIPE_DEUX = 2;
  /** Correspond au degat produit par le Tireur. */
  public static final int DEGATS_TIREUR = Integer.parseInt((String) PROPERTIES.get("t_degats"));
  /** Correspond au degat produit par le Piegeur. */
  public static final int DEGATS_PIEGEUR = Integer.parseInt((String) PROPERTIES.get("p_degats"));
  /** Correspond au degat produit par le Char. */
  public static final int DEGATS_CHAR = Integer.parseInt((String) PROPERTIES.get("c_degats"));
  /** Correspond au coup de deplacement du Tireur. */
  public static final int COUP_DEPLACEMENTS_TIREUR = Integer.parseInt((String) PROPERTIES
      .get("t_coup_dep"));
  /** Correspond au coup de deplacement du Piegeur. */
  public static final int COUP_DEPLACEMENTS_PIEGEUR = Integer.parseInt((String) PROPERTIES
      .get("p_coup_dep"));
  /** Correspond au coup de deplacement du Char. */
  public static final int COUP_DEPLACEMENTS_CHAR = Integer.parseInt((String) PROPERTIES
      .get("c_coup_dep"));
  /** Correspond au coup de deplacement du Worker. */
  public static final int COUP_DEPLACEMENTS_WORKER = Integer.parseInt((String) PROPERTIES
      .get("w_coup_dep"));
  /** Correspond au coup d'une action du Tireur. */
  public static final int COUP_ACTION_TIREUR = Integer.parseInt((String) PROPERTIES
      .get("t_coup_act"));
  /** Correspond au coup d'une action du Piegeur. */
  public static final int COUP_ACTION_PIEGEUR = Integer.parseInt((String) PROPERTIES
      .get("p_coup_act"));
  /** Correspond au coup d'une action du Char. */
  public static final int COUP_ACTION_CHAR = Integer
      .parseInt((String) PROPERTIES.get("c_coup_act"));
  /** Correspond au coup d'une action du Worker. */
  public static final int COUP_ACTION_WORKER = Integer.parseInt((String) PROPERTIES
      .get("w_coup_act"));
  /** Correspond au degat que subit un tireur s'il marche sur une mine */
  public static final int DEGATS_MINES_TIREUR = Integer.parseInt((String) PROPERTIES
      .get("t_degats_mines_subis"));
  /** Correspond au degat que subit un char s'il marche sur une mine */
  public static final int DEGATS_MINES_CHAR = Integer.parseInt((String) PROPERTIES
      .get("c_degats_mines_subis"));
  /** Correspond au degat que subit un piegeur s'il marche sur une mine */
  public static final int DEGATS_TIRS_PIEGEUR = Integer.parseInt((String) PROPERTIES
      .get("p_degats_mines_subis"));
  /** Correspond au degat que subit un worker s'il marche sur une mine */
  public static final int DEGATS_MINES_WORKER = Integer.parseInt((String) PROPERTIES
      .get("w_degats_mines_subis"));
  /** Correspond à la portée d'un tir pour un Tireur . */
  public static final int PORTEE_TIREUR = Integer.parseInt((String) PROPERTIES.get("t_portee"));
  /** Correspond à la portée d'une mine pour un Piegeur . */
  public static final int PORTEE_PIEGEUR = Integer.parseInt((String) PROPERTIES.get("p_portee"));
  /** Correspond à la portée d'un tir pour un Char . */
  public static final int PORTEE_CHAR = Integer.parseInt((String) PROPERTIES.get("c_portee"));
  /** Correspond a la portee du worker */
  public static final int PORTEE_WORKER = Integer.parseInt((String) PROPERTIES.get("w_portee"));
  /** Correspond au nombre de mines que le piegeur peut porter */
  public static final int NB_MINES_MAX = Integer.parseInt((String) PROPERTIES.get("p_mines"));


  // / les données du plateau ///
  /** Taille minimun en largeur du plateau. */
  public static final int X_MIN = 5;
  /** Taille maximun en largeur du plateau. */
  public static final int X_MAX = Integer.parseInt((String) PROPERTIES.get("x_max"));
  /** Taille minimun en longueur du plateau. */
  public static final int Y_MIN = 10;
  /** Taille maximune en longueur du plateau. */
  public static final int Y_MAX = Integer.parseInt((String) PROPERTIES.get("y_max"));
  /** Obstacles minimun sur le plateau. */
  public static final int OBSTACLES_MIN = 0;
  /** Obstacles maximun sur le plateau. */
  public static final int OBSTACLES_MAX = 50;
  /** Obstacles sur le plateau */
  public static final int OBSTACLES_CHOICE = 25;
  /** Taille en largeur du plateau */
  public static final int X_CHOICE = 10;
  /** Taille en longueur du plateau */
  public static final int Y_CHOICE = 10;


  // / Déplacement pour Tireur et Piegeur et char///
  /** Deplacement en haut pour Tireur et Piegeur. */
  public static final Coordonnees HAUT = new Coordonnees(0, -1);
  /** Deplacement diagonale en haut a droite pour Tireur et Piegeur. */
  public static final Coordonnees HAUT_DROITE = new Coordonnees(1, -1);
  /** Deplacement diagonale en haut a gauche pour Tireur et Piegeur. */
  public static final Coordonnees HAUT_GAUCHE = new Coordonnees(-1, -1);
  /** Deplacement en bas pour Tireur et Piegeur. */
  public static final Coordonnees BAS = new Coordonnees(0, 1);
  /** Deplacement diagonale en base a droite pour Tireur et Piegeur. */
  public static final Coordonnees BAS_DROITE = new Coordonnees(1, 1);
  /** Deplacement diagonale en base a gauche pour Tireur et Piegeur. */
  public static final Coordonnees BAS_GAUCHE = new Coordonnees(-1, 1);
  /** Deplacement a gauche pour Tireur et Piegeur. */
  public static final Coordonnees GAUCHE = new Coordonnees(-1, 0);
  /** Deplacement a droite pour Tireur et Piegeur. */
  public static final Coordonnees DROITE = new Coordonnees(1, 0);
  /** Deplacement a gauche pour char. */
  public static final Coordonnees GAUCHE_CHAR = new Coordonnees(-2, 0);
  /** Deplacement a droite pour char. */
  public static final Coordonnees DROITE_CHAR = new Coordonnees(2, 0);
  /** Deplacement en bas pour char. */
  public static final Coordonnees BAS_CHAR = new Coordonnees(0, 2);
  /** Deplacement en haut pour char. */
  public static final Coordonnees HAUT_CHAR = new Coordonnees(0, -2);


  /** List des deplacement pour Tireur. */
  public static List<Coordonnees> DEP_TIREUR;
  /** List des deplacement pour Piegeur. */
  public static List<Coordonnees> DEP_PIEGEUR;
  /** List des deplacement pour Char. */
  public static List<Coordonnees> DEP_CHAR;
  /** List des deplacement pour Worker. */
  public static List<Coordonnees> DEP_WORKER;

  /** List des coordonnees pouvant etre cible par char */
  public static List<Coordonnees> L_PORTEE_CHAR;
  /** List des coordonnees pouvant etre cible par tireur */
  public static List<Coordonnees> L_PORTEE_TIREUR;
  /** Tableau des pays que le joueur peut selectionner */
  public static String[] PAYS = new String[] {"France", "Russie", "Allemagne", "Angleterre",
      "Etats-Unis", "Bresil", "Canada", "Chine", "Japon"};

  /** Temps que doit mettre un robot avant d'apparaitre*/
  public static int SPAWNING_TIME = Integer.parseInt((String) PROPERTIES
      .getProperty("spawning_time"));
  /** Nombre de factory maximum par equipe*/
  public static int NB_FACTO_MAX = 2;

  /**
   * Ajout des deplacement a leurs listes.
   */
  static {
    DEP_TIREUR = new ArrayList<Coordonnees>();
    DEP_PIEGEUR = new ArrayList<Coordonnees>();
    DEP_WORKER = new ArrayList<Coordonnees>();
    DEP_TIREUR.add(HAUT);
    DEP_WORKER.add(HAUT);
    DEP_TIREUR.add(HAUT_DROITE);
    DEP_TIREUR.add(HAUT_GAUCHE);
    DEP_TIREUR.add(BAS);
    DEP_WORKER.add(BAS);
    DEP_TIREUR.add(BAS_DROITE);
    DEP_TIREUR.add(BAS_GAUCHE);
    DEP_TIREUR.add(DROITE);
    DEP_WORKER.add(DROITE);
    DEP_TIREUR.add(GAUCHE);
    DEP_WORKER.add(GAUCHE);

    DEP_PIEGEUR.addAll(DEP_TIREUR);

    DEP_CHAR = new ArrayList<Coordonnees>();
    DEP_CHAR.add(HAUT_CHAR);
    DEP_CHAR.add(BAS_CHAR);
    DEP_CHAR.add(DROITE_CHAR);
    DEP_CHAR.add(GAUCHE_CHAR);

    L_PORTEE_CHAR = new ArrayList<Coordonnees>();
    L_PORTEE_TIREUR = new ArrayList<Coordonnees>();
    for (int i = 0; i < PORTEE_CHAR; i++) {
      L_PORTEE_CHAR.add(new Coordonnees(0, i));
    }
    for (int i = 0; i < PORTEE_CHAR; i++) {
      L_PORTEE_CHAR.add(new Coordonnees(i, 0));
    }
    for (int i = 0; i < PORTEE_CHAR; i++) {
      L_PORTEE_CHAR.add(new Coordonnees(0, 0 - i));
    }
    for (int i = 0; i < PORTEE_CHAR; i++) {
      L_PORTEE_CHAR.add(new Coordonnees(0 - i, 0));
    }

    for (int i = 0; i < PORTEE_TIREUR; i++) {
      L_PORTEE_TIREUR.add(new Coordonnees(0, i));
    }
    for (int i = 0; i < PORTEE_TIREUR; i++) {
      L_PORTEE_TIREUR.add(new Coordonnees(i, 0));
    }
    for (int i = 0; i < PORTEE_TIREUR; i++) {
      L_PORTEE_TIREUR.add(new Coordonnees(0, 0 - i));
    }
    for (int i = 0; i < PORTEE_TIREUR; i++) {
      L_PORTEE_TIREUR.add(new Coordonnees(0 - i, 0));
    }
  }

  /**
   * Demande a l'utilisateur un nombre entre min et max
   * 
   * @param min la borne minimale
   * @param max la borne maximale
   * @return int
   */
  @SuppressWarnings("resource")
  public static int secureInput(int min, int max) {
    if (max < min) {
      System.out.println("Un seul choix possible");
      return min;
    }
    Scanner sc = new Scanner(System.in); // impossible de fermer car re appeler plus tard
    int ans;
    do {
      System.out.println("\nentrez un nombre compris entre " + min + " inclus et " + max
          + " inclus");
      while (!sc.hasNextInt()) {
        sc.next();
        System.err.println("bad input");
      }
      ans = sc.nextInt();
    } while (ans < min || ans > max);
    return ans;
  }

  /**
   * Demande a l'utilisateur un nombre entre min et max avec la String passée en parametre
   * 
   * @param min la borne minimale
   * @param max la borne maximale
   * @param string ce qui va etre demander a l'utilisateur
   * @return int
   */
  @SuppressWarnings("resource")
  public static int secureInput(int min, int max, String string) {
    Scanner sc = new Scanner(System.in); // impossible de fermer car re appeler plus tard
    int ans;
    do {
      System.out.println(string);
      while (!sc.hasNextInt()) {
        sc.next();
        System.err.println("bad input");
      }
      ans = sc.nextInt();
    } while (ans < min || ans > max);
    return ans;
  }
}
