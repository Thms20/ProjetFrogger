package frog;

import givenEnvironment.*;
import util.Case;
import util.Direction;
import gameCommons.Game;
import gameCommons.IFrog;


public class Frog implements IFrog {
	
	private Game game;
	private Case cas;
	private Direction dir;
	
	public Frog(Game g, Case c, Direction d) {
		this.game = g;
		//this.cas = new Case(0,0);
		this.cas = c;
		this.dir = d;
	}
	
	public Frog(Game ga) {
		this.game = ga;
		this.cas = new Case(game.width/2,0);
	}

	@Override
	public Case getPosition() {
		return this.cas;
	}

	@Override
	public Direction getDirection() {
		return this.dir;
	}

	
	public void move(Direction key) {
		switch(key) {
		case up:
			this.cas.ord = this.cas.ord + 1;
			break;
		case down:
			this.cas.ord = this.cas.ord - 1;
			break;
		case right:
			this.cas.absc = this.cas.absc + 1;
			break;
		case left:
			this.cas.absc = this.cas.absc - 1;
			break;
		}
		
		this.game.testWin();
		this.game.testLose();
	}
	
	


}
