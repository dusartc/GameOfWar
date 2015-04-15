package gameOfWar.robot;
import gameOfWar.action.Action;
import gameOfWar.action.Attaque;
import gameOfWar.action.Deplacement;
import gameOfWar.config.Constante;
import gameOfWar.config.Coordonnees;
import gameOfWar.jeux.Equipe;
import gameOfWar.jeux.Vue;

import java.util.ArrayList;
import java.util.List;
// Touche moi cette belle ArrayList(I).


/**
 * 
 * @author Samantha, Mathieu, Clément
 *
 */
public class Tireur extends Robot {

  private List<Coordonnees> coordonnees; //A mediter (voir : direction et objectif) CLEMENT !

  public Tireur(Vue vue, Equipe equipe) {
    super(vue, equipe);
    this.setEnergie(Constante.ENERGIE_TIREUR);
  }

  @Override
  public Action choisitAction() {
    List<Coordonnees> dep = initDep();
    List<Coordonnees> cible = initCible();
    if (!cible.isEmpty()) {
      System.out.println("Vous pouvez :\n\t1 - deplacer\n\t2 - Attaquer");
      int i = Constante.secureInput(1, 2);
      switch (i) {
        case 1:
          int j = 0;
          System.out.println("Vous pouvez aller en :");
          for (Coordonnees c : dep) {
            System.out.println(j + " : " + c);
            j += 1;
          }this.setObjectif(dep.get(Constante.secureInput(0, j-1)));
          return new Deplacement(this);
        case 2:
          int h = 0;
          System.out.println("Vous pouvez attaquer :");
          for (Coordonnees c : cible) {
            System.out.println(h + " : " + c);
          }this.setObjectif(cible.get(Constante.secureInput(0, h-1)));
          return new Attaque(this);
        default:
          System.out.println("mauvais input @choisitAction()");
          break;
      }
    }else {
      System.out.println("Aucune cible disponible\nVous ne pouvez que vous deplacer");
      int j = 0;
      System.out.println("Vous pouvez aller en :");
      for (Coordonnees c : dep) {
        System.out.println(j + " : " + c);
        j += 1;
      }this.setObjectif(dep.get(Constante.secureInput(0, j-1)));
      return new Deplacement(this);
    }
    return null;
  }

  @Override
  public void estSoigne() {
    this.setEnergie(Math.min(Constante.ENERGIE_TIREUR, getEnergie() + Constante.SOIN));
  }

  @Override
  public int getCoupDep() {
    return Constante.COUP_DEPLACEMENTS_TIREUR;
  }

  @Override
  public int getCoutAction() {
    return Constante.COUP_ACTION_TIREUR;
  }

  @Override
  public int getDegatMine() {
    return Constante.DEGATS_MINES_TIREUR;
  }

  @Override
  public int getDegatTir() {
    return Constante.DEGATS_TIREUR;
  }

  @Override
  public List<Coordonnees> getDeplacements() {
    return this.coordonnees;
  }

  @Override
  public String getType() {
    return this.getClass().getName().substring(getClass().getName().lastIndexOf(".")+1);
  }

  @Override
  public void subitMine() {
      setEnergie(getEnergie()-Constante.DEGATS_PIEGEUR);
    }

  @Override
  public void subitTirDe(Robot robot) {
    if(robot instanceof Tireur || robot instanceof Char){
      if(robot.getEquipe() != this.getEquipe()){
        this.setEnergie(this.getEnergie()-robot.getDegatTir());
        
      }else {
        System.err.println("meme equipe ; affrontement impossible entre "+this.toString()+" et "+robot.toString());
      }
    }
    else {
      System.err.println("Impossible de subir un Tir");
    }
  }
  
  @Override
  public String toString() {
    return this.getType() + ", " + super.toString();
  }
  
  private List<Coordonnees> initCible() {
    List<Coordonnees> cible2 = new ArrayList<Coordonnees>();
    List<Coordonnees> cible = new ArrayList<Coordonnees>();
    for (Coordonnees coordonnees : Constante.L_PORTEE_TIREUR) {
      cible.add(this.getCoordonnees().ajout(coordonnees));
    }
    for (int i = 0; i < cible.size(); i++) {
      Coordonnees c = cible.get(i);
      try {
        if (this.getVue().getPlateau().getCelluleByCoordonnees(c).estMur()) {
          i = (((i+Constante.PORTEE_TIREUR)/Constante.PORTEE_TIREUR)*Constante.PORTEE_TIREUR)-1;
          continue;
        }if (this.getVue().getPlateau().getCelluleByCoordonnees(c).estRobot() != this.getEquipe().getEquipe()
            && this.getVue().getPlateau().getCelluleByCoordonnees(c).estRobot() != 0) {
          cible2.add(c);
        }
      } catch (Exception e) {
        //System.err.print("@initCible ");
      }      
    }
    return cible2;
  }
  
  private List<Coordonnees> initDep() {
    List<Coordonnees> dep = new ArrayList<Coordonnees>();
    List<Coordonnees> caillou = new ArrayList<Coordonnees>();
    for (Coordonnees coordonnees : Constante.DEP_TIREUR) {
      dep.add(this.getCoordonnees().ajout(coordonnees));
    }caillou.addAll(dep);
    for (Coordonnees c : caillou) {
      if (c.getHauteur() < 0 || c.getLargeur() < 0
          || c.getHauteur() >= this.getVue().getPlateau().getLongueur()
          || c.getLargeur() >= this.getVue().getPlateau().getLargeur()) {
        dep.remove(c);
      }try {
        if (this.getVue().getPlateau().getCelluleByCoordonnees(c).estMur()) {
          dep.remove(c);
        }
      } catch (Exception e) {
        //System.err.println("null pointer");
      }
    }
    return dep;
  }
}
