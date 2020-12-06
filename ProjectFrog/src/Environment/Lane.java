package Environment;

import java.util.ArrayList;

import util.Case;
import gameCommons.Game;
import java.util.Random;


public class Lane {
	private Game game;
	private int ord;
	private int speed;
	private ArrayList<Car> cars;
	private boolean leftToRight;
	private double density;
    private int randomInt;
    
	// TODO : Constructeur(s)
	public Lane(Game g, int ord, int vit, boolean gaucheADroite, double densité) {
		this.game = g;
		this.ord = ord;
		this.speed = vit;
		this.leftToRight = gaucheADroite;
		this.density = densité;
		this.cars = new ArrayList<Car>();
		Random random = new Random();
		this.randomInt = 2 + random.nextInt(this.game.minSpeedInTimerLoops - 1);
	}
    /**
	public void update() {
		// Toutes les voitures se déplacent d'une case au bout d'un nombre "tic
		// d'horloge" égal à leur vitesse
		// Notez que cette méthode est appelée à chaque tic d'horloge

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas

		// A chaque tic d'horloge, une voiture peut être ajoutée
		
		//Case cas = new Case(0,this.ord);
		//Car tuture = new Car(this.game,cas,this.leftToRight);
		//this.cars.add(tuture);

		this.speed = this.speed + 1;

		//this.mayAddCar();
		
	//	this.cars.get(cars.size()).ajoutGraphVoit();
		
		if(this.speed == (this.game.minSpeedInTimerLoops*10)) {	
			this.mayAddCar();
		} // Si je supprime le if ça affiche tout en même temps
		
		for(Car voiture : this.cars) {
	/**		if(leftToRight) {
			    voiture.getCarCase().absc = voiture.getCarCase().absc + 1;
			}
			else {
				voiture.getCarCase().absc = voiture.getCarCase().absc - 1 ;
			} **/

/**		//	voiture.ajoutGraphVoit();
			if(this.speed == (this.game.minSpeedInTimerLoops*10)) {	
			   voiture.sensCirculation();
			 //  voiture.ajoutGraphVoit();
			   this.speed = 0;
			}
			
			if((leftToRight)  && (voiture.getCarCase().absc == game.width)) {
               cars.remove(voiture);
		    }	
			
			if((!leftToRight)  && (voiture.getCarCase().absc == 0)) {
	               cars.remove(voiture);
			}
			
		//	if(voiture.equalCars(cars.get(cars.size()-1))) {
		//	this.speed = 0;
		//	}

	    }
	//	this.speed = 0;
	//}

	}
	**/
	public void update() {
		
	   this.speed = this.speed + 1;
	   
	   for(Car voiture : this.cars) {
		   voiture.addToGraphics();
	   }
	   
//	   if(this.speed == (this.game.minSpeedInTimerLoops*10/3)) {	<- même vitesse partout
	   if(this.speed == (this.randomInt)) {
		   this.mayAddCar();
	       for(Car voiture : this.cars) {
			   voiture.sensCirculation();
			}
		   this.speed = 0;
	   }
	}


	// TODO : ajout de methodes
    public ArrayList<Car> getListCar() {
    	return this.cars;
    }
    
    public int getOrdLane() {
    	return this.ord;
    }
    
    public Case getAfterFirstCase() {
		if (leftToRight) {
			return new Case(1, ord);
		} 
		else {
			return new Case(game.width - 2, ord);
		}
    }
    
// A FAIRE !!! (changer les choses pour la classe Lane parce que j'ai copié sur la classe environment)
// Fait !
	public boolean isSafe(Case c) {
			for(Car voit : this.cars) {
				if((voit.getCarCase().absc == c.absc) && (voit.getCarCase().ord == c.ord)) {
					return false;
				}
			}

		return true;
    }
	
	public boolean firstCaseSafe() {
		if(leftToRight) {
			if(isSafe(new Case(1,ord))) {
				return true;
			}
			else {
				return false;
			}
		}else {
			if(isSafe(new Case(game.width-2,ord))) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	
	/*
	 * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase() 
	 */

	/**
	 * Ajoute une voiture au début de la voie avec probabilité égale à la
	 * densité, si la première case de la voie est vide
	 */
	public void mayAddCar() {
		if ((isSafe(getFirstCase())) && (isSafe(getBeforeFirstCase()))) {
			double random = game.randomGen.nextDouble();
			if (random < density) {
				Car c = new Car(game, getBeforeFirstCase(), leftToRight);
				cars.add(c);
			}
		}
	}

	private Case getFirstCase() {
		if (leftToRight) {
			return new Case(0, ord);
		} else
			return new Case(game.width - 1, ord);
	}

	private Case getBeforeFirstCase() {
		if (leftToRight) {
			return new Case(-1, ord);
		} else
			return new Case(game.width, ord);
	}
	
	public void decalDe1ord() {
		ord = ord - 1;
	}
	
	public void decalDe1ordInv() {
		ord = ord + 1;
	}
	
	public void decalageCar() {
		for(Car voiture : this.cars) {
			voiture.decalUneVoit();
		}
	}
	
	public void decalageCarInv() {
		for(Car voiture : this.cars) {
			voiture.decalUneVoitInv();
		}
	}

}
