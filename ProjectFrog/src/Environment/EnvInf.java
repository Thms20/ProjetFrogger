package Environment;

import java.util.ArrayList;

import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Case;
import util.Direction;

public class EnvInf implements IEnvironment{
	private ArrayList<Lane> ligne;
	private Game game;
	
	public EnvInf() {
		this.ligne = new ArrayList<Lane>();
	}
    
	public EnvInf(Game g) {
		this.game = g;
		this.ligne = new ArrayList<Lane>();
		boolean bool;
		for(int i = 1; i < this.game.height - 1; i++) {
			if(i%2 != 0) {
				bool = false;
			}
			else {
				bool = true;
			}
		      Lane lan = new Lane(this.game,i,/**this.game.tempo**/0,bool,game.defaultDensity);
		      this.ligne.add(lan);
		}
	}
	
	public ArrayList<Lane> getLane() {
		return this.ligne;
	}
	

	public boolean isSafe(Case c) {
		ArrayList<Car> ca = new ArrayList<Car>();
		for(Lane line : this.ligne) {
            ca = line.getListCar();
			for(Car voit : ca) {
				if((voit.getCarCase().absc == c.absc) && (voit.getCarCase().ord == c.ord)) {
					return false;
				}
			}
		}
		return true;
	}


	public boolean isWinningPosition(util.Case c) {
           int ordLane = this.ligne.get(ligne.size()-1).getOrdLane();
    	   if(c.ord >= ordLane + 1) {
    		   return true;
           }
    	   return false;
	}

	public void ajoutLane() {
		boolean sens;
		if(((ligne.size() + 1) % 2) == 0) {
			sens = true;
		}
		else {
			sens = false;
		}
	    ligne.add(new Lane(this.game,ligne.size() + 1,0,sens,game.defaultDensity));
	}
	
	public void decalageLane() {
		for(Lane lg : ligne) {
			lg.decalDe1ord();
			lg.decalageCar();
		}
	}
	
	public void decalageLaneInv() {
		for(Lane lg : ligne) {
			lg.decalDe1ordInv();
			lg.decalageCarInv();
		}
	}

	public void update() {	
		for(Lane lg : this.ligne) {
			lg.update();
		}
		
	}
		
	//TODO
    public Game getGame() {
    	return this.game;
    }
    
    public int score() {
    	return ligne.size() - game.height + 2;
    }
}
