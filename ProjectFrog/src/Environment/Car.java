package Environment;

import java.awt.Color;

import util.Case;
import gameCommons.Game;
import graphicalElements.Element;


public class Car {
	private Game game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private final Color colorLtR = Color.BLACK;
	private final Color colorRtL = Color.BLUE;

	//TODO Constructeur(s)
	public Car(Game g, Case c, boolean gaucheADroite) {
		this.game = g;
		this.leftPosition = c;
		this.leftToRight = gaucheADroite;
		this.length = 2;
	}
	
	//TODO : ajout de methodes
	public Case getCarCase() {
		return this.leftPosition;
	}
    
	public void ajoutGraphVoit() {
		if((leftPosition.absc == 0) || (leftPosition.absc == this.game.width)) {
			addToGraphics();
	}

	}
		
	public void sensCirculation() {
		//this.ajoutGraphVoit();
		if(leftToRight) {
		    leftPosition.absc = leftPosition.absc + 1;
		  //  addToGraphics();
		    //this.game.getGraphic().repaint();
		}
		else {
			leftPosition.absc = leftPosition.absc - 1;
			//addToGraphics();
		}
	}
		
	public Case caseDevantVoit() {
		Case c = this.leftPosition;
		if(leftToRight) {
		    c.absc = c.absc + 1;
		}
		else {
		    c.absc = c.absc - 1;
		}
		return c;
	}
	
	public boolean equalCars(Car car) {
		if((this.leftPosition.absc == car.leftPosition.absc) && (this.leftPosition.ord == car.leftPosition.ord)) {
			return true;
		}
		return false;
	}
	
	
	/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
	public void addToGraphics() {
		for (int i = 0; i < length; i++) {
			Color color = colorRtL;
			if (this.leftToRight){
				color = colorLtR;
			}
			game.getGraphic()
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

}
