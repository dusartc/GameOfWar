import java.util.Random;


public class Plateau {

	char[][] plateau;
	
	Plateau(int x,int y){
		this.plateau = new char[y][x];
	}
	
	public void initObstacle(int nb) {
		Random rd = new Random();
		for (int i = 0; i < nb; i++) {
			int x = rd.nextInt(this.plateau[0].length-1);
			int y = rd.nextInt(this.plateau.length-1);
			this.plateau[y][x]='x';
		}
		this.plateau[0][0]='B';
		this.plateau[this.plateau.length-1][this.plateau[0].length-1] = 'b';
	}
	
	@Override
	public String toString() {
		String ans="";
		for (int i = 0; i < this.plateau[0].length; i++) {
			for (int j = 0; j < this.plateau.length; j++) {
				if (this.plateau[j][i]=='\u0000') {
					ans+=" . ";
				} else if (this.plateau[j][i]=='b') {
					ans+= " b ";
				} else if (this.plateau[j][i]=='B') {
					ans+= " B ";
				} else ans+=" x ";
			}
			ans+="\n";
		}
		return ans;
	}
	
	
	
}
