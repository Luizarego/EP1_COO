package classes;

/**
 * Classe que contém informações e ações básicas relacionadas aos jogadores
 */
public class Player {
	
	private String name;
	private Color pieceColor;
	private Card[] cards;
	private Card card1;
	private Card card2;
 
    public Player(String name, Color pieceColor, Card[] cards) {
    	this.name = name;
    	this.pieceColor = pieceColor;
    	this.cards = cards;
    }

    public Player(String name, Color pieceColor, Card card1, Card card2) {
    	this.name = name;
    	this.pieceColor = pieceColor;
    	this.card1 = card1;
    	this.card2 = card2;
    }

    public String getName() {
        return name;
    }

    public Color getPieceColor() {
        return pieceColor;
    }

    public Card[] getCards() {
        return cards;
    }
    
    public Card getCard1() {
    	return card1;
    }
    
    public Card getCard2() {
    	return card2;
    }

    protected void swapCard(Card oldCard, Card newCard) throws InvalidCardException {
    	if(oldCard != cards[0]) {
    		if(oldCard != cards[1]) {
    			throw new InvalidCardException("ERROR: oldCard is not on player's hand");
    		}
    		else {
    			Card aux = cards[1];
    			cards[1] = newCard;
    	        newCard = aux;
    		}
    	} else {
    		Card aux = cards[0];
			cards[0] = newCard;
	        newCard = aux;
    	}
    }
}