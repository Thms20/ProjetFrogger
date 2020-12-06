package frog;

import util.Case;
import util.Direction;
import Environment.Lane;
import gameCommons.Game;
import gameCommons.IFrog;


public class FrogInf implements IFrog {
	
	private Game game;
	private Case cas;
	private Direction dir;

	
	public FrogInf(Game ga) {
		this.game = ga;
		this.cas = new Case(game.width/2,0);
	}

	
	public Case getPosition() {
		return this.cas;
	}


	public Direction getDirection() {
		return this.dir;
	}

	public void move(Direction key) {
		switch(key) {
		case up:
		//	this.cas.ord = this.cas.ord + 1;
		    game.getEnv().ajoutLane();
			game.getEnv().decalageLane();
			break;
		case down:
		//	this.cas.ord = this.cas.ord - 1;
			game.getEnv().decalageLaneInv();
			break;
		case right:
			this.cas.absc = this.cas.absc + 1;
			break;
		case left:
			this.cas.absc = this.cas.absc - 1;
			break;
		}
			
		this.game.testLose();
		}
		
}
