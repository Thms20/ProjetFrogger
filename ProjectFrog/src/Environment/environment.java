package Environment;

import java.util.ArrayList;

import util.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;


public class environment implements IEnvironment {
	private ArrayList<Lane> ligne;
	private Game game;
	
	public environment() {
		this.ligne = new ArrayList<Lane>();
	}
    
	public environment(Game g) {
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
		   // Pas utile ici mais je garde pour un exemple : Case casa = new Case(this.game.getFrog().getPosition().absc,this.game.getFrog().getPosition().ord);
           int ordLane = this.ligne.get(ligne.size()-1).getOrdLane();
         /**  for(int i = 0; i < this.ligne.size(); i++) {
        	   if(ordLane > this.ligne.get(i).getOrdLane()) {
        		   ordLane = this.ligne.get(i).getOrdLane();    		   
        	   }
      	   } **/
    	   if(c.ord >= ordLane + 1) {
    		   return true;
           }
    	   return false;
	}


	public void update() {
/**		boolean bool;
		for(int i = 0; i < this.game.height; i++) {
			if(i%2 != 0) {
				bool = false;
			}
			else {
				bool = true;
			}
		      Lane lan = new Lane(this.game,i,0,bool,game.defaultDensity);
		      this.ligne.add(lan);
		} **/
		for(Lane lg : this.ligne) {
			lg.update();
		}
		
	}
		
	//TODO
    public Game getGame() {
    	return this.game;
    }
}
