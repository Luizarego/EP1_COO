package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Classe que contém informações das cartas

public class Card {
	
	private String name;
	private Color color;
	private Position[] positions;

	private static Position[] tigerPositions = {new Position(-2, 0), new Position(1, 0)};
	private static Position[] rabbitPositions = {new Position(1, -1), new Position(-1, 1), new Position(0, 2)};
	private static Position[] crabPositions = {new Position(0, -2), new Position(0, 2), new Position(-1, 0)};
	private static Position[] goosePositions = {new Position(-1, -1), new Position(0, -1), new Position(0, 1), new Position(1, 1)};
	private static Position[] dragonPositions = {new Position(-1, -2), new Position(1, -1), new Position(1, 1), new Position(-1, 2)};
	private static Position[] frogPositions = {new Position(0, -2), new Position(-1, -1), new Position(1, 1)};
	private static Position[] elephantPositions = {new Position(-1, -1), new Position(0, -1), new Position(0, 1), new Position(-1, 1)};
	private static Position[] roosterPositions = {new Position(1, -1), new Position(0, -1), new Position(0, 1), new Position(-1, 1)};
	
	public Card(String name, Color color, Position[] positions) {
		this.name = name;
		this.color = color;
		this.positions = positions;
	}
   
    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Position[] getPositions() {
        return positions;
    }

    public static Card[] createCards() {
    	Card tigerCard = new Card("tiger", Color.valueOf("BLUE"), tigerPositions);
    	Card rabbitCard = new Card("rabbit", Color.valueOf("BLUE"), rabbitPositions);
    	Card crabCard  = new Card("crab", Color.valueOf("BLUE"), crabPositions);
    	Card gooseCard = new Card("goose", Color.valueOf("BLUE"), goosePositions);
    	Card dragonCard = new Card("dragon", Color.valueOf("RED"), dragonPositions);
    	Card frogCard = new Card("frog", Color.valueOf("RED"), frogPositions);
    	Card elephantCard = new Card("elephant", Color.valueOf("RED"), elephantPositions);
    	Card roosterCard = new Card("rooster", Color.valueOf("RED"), roosterPositions);
    	
    	List <Card> cardsList = new ArrayList<>();
    	cardsList.add(tigerCard);
    	cardsList.add(rabbitCard);
    	cardsList.add(crabCard);
    	cardsList.add(gooseCard);
    	cardsList.add(dragonCard);
    	cardsList.add(frogCard);
    	cardsList.add(elephantCard);
    	cardsList.add(roosterCard);
    	
    	Collections.shuffle(cardsList);
    	
    	Card[] shuffledCards = new Card[8];
    	shuffledCards = cardsList.toArray(shuffledCards);

    	Card[] gameCards = new Card[5];
    	for(int i = 0; i < 5; i++) {
    		gameCards[i] = shuffledCards[i];
    	}
    	
    	return gameCards;
    }

	public static Position[] getCardPosition(Card card) {
		if(card.getName() == "tiger") {
			return tigerPositions;
		}
		if(card.getName() == "rabbit") {
			return rabbitPositions;
		}
		if(card.getName() == "crab") {
			return crabPositions;
		}
		if(card.getName() == "goose") {
			return goosePositions;
		}
		if(card.getName() == "dragon") {
			return dragonPositions;
		}
		if(card.getName() == "frog") {
			return frogPositions;
		}
		if(card.getName() == "elephant") {
			return elephantPositions;
		}
		if(card.getName() == "rooster") {
			return roosterPositions;
		}
		return null;
	}
}