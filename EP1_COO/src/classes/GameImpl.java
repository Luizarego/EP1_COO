package classes;

import java.util.ArrayList;
import java.util.List;

public class GameImpl implements Game{
	
	private Player redPlayer;
	private Player bluePlayer;
	
	private Card[] cards;
	private Card[] redPlayerCards;
	private Card[] bluePlayerCards;
	private Card tableCard;
	
	private Color firstToPlay;
	private int turnControl;
	private Color playerTurn;
	
	private Piece redMaster;
	private Piece blueMaster;
	
	private List <Piece> pieces = new ArrayList<>();
	
	private Spot board[][] = new Spot[5][5];
	
	private void initializeBoard() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(i == 0) { //Azul
					if(j == 2) { //Mestre
						board[i][j] = new Spot(new Piece(Color.valueOf("BLUE"), true), new Position(i, j), Color.valueOf("BLUE"));
						blueMaster = board[i][j].getPiece();
						if(!pieces.contains(board[i][j].getPiece())){
							pieces.add(board[i][j].getPiece());
						}
					}
					if(j != 2) {
						board[i][j] = new Spot(new Piece(Color.valueOf("BLUE"), false), new Position(i, j), Color.valueOf("NONE"));
						if(!pieces.contains(board[i][j].getPiece())){
							pieces.add(board[i][j].getPiece());
						}
					}
				}
				if(i == 4) { //Vermelho
					if(j == 2) { //Mestre
						board[i][j] = new Spot(new Piece(Color.valueOf("RED"), true), new Position(i, j), Color.valueOf("RED"));
						redMaster = board[i][j].getPiece();
						if(!pieces.contains(board[i][j].getPiece())){
							pieces.add(board[i][j].getPiece());
						}
					}
					if(j != 2) {
						board[i][j] = new Spot(new Piece(Color.valueOf("RED"), false), new Position(i, j), Color.valueOf("NONE"));
						if(!pieces.contains(board[i][j].getPiece())){
							pieces.add(board[i][j].getPiece());
						}
					}
				}
				if(i != 0 && i != 4) {
					board[i][j] = new Spot(null, new Position(i, j), Color.valueOf("NONE"));
				}
			}
		}
	}
	
	protected Card[] getCards() {
		return cards;
	}
	
	protected Piece getRedMaster() {
		return redMaster;
	}
	
	protected Piece getBlueMaster() {
		return blueMaster;
	}
	
	protected Spot[][] getBoard(){
		return board;
	}
	
	protected Color getFirstToPlay() {
		return firstToPlay;
	}
	
	protected void setFirstToPlay(Color color) {
		firstToPlay = color;
	}
	
	protected int getTurnControl() {
		return turnControl;
	}

	public GameImpl() {
		redPlayerCards = new Card[2];
		bluePlayerCards = new Card[2];
		cards = Card.createCards();
		
		redPlayerCards[0] = cards[0];
		redPlayerCards[1] = cards[1];
		bluePlayerCards[0] = cards[2];
		bluePlayerCards[1] = cards[3];
		tableCard = cards[4];
		firstToPlay = tableCard.getColor();
		turnControl = 1;
		
		redPlayer = new Player ("RedPlayer", Color.valueOf("RED"), redPlayerCards);
		bluePlayer = new Player("BluePlayer", Color.valueOf("BLUE"), bluePlayerCards);
		
		initializeBoard();
	}
	
	public GameImpl(String redPlayerName, String bluePlayerName) {
		redPlayerCards = new Card[2];
		bluePlayerCards = new Card[2];
		cards = Card.createCards();
		
		redPlayerCards[0] = cards[0];
		redPlayerCards[1] = cards[1];
		bluePlayerCards[0] = cards[2];
		bluePlayerCards[1] = cards[3];
		tableCard = cards[4];
		firstToPlay = tableCard.getColor();
		turnControl = 1;
		
		redPlayer = new Player(redPlayerName, Color.valueOf("RED"), redPlayerCards);
		bluePlayer = new Player(bluePlayerName, Color.valueOf("BLUE"), bluePlayerCards);
		
		initializeBoard();
	}
	
	public GameImpl(String redPlayerName, String bluePlayerName, Card[] cards) {
		redPlayerCards = new Card[2];
		bluePlayerCards = new Card[2];
		
		if(cards.length < 5) {
			System.out.println("Número insuficiente de cartas; o mínimo é 5.");
		}
		
		redPlayerCards[0] = cards[0];
		redPlayerCards[1] = cards[1];
		bluePlayerCards[0] = cards[2];
		bluePlayerCards[1] = cards[3];
		tableCard = cards[4];
		firstToPlay = tableCard.getColor();
		turnControl = 1;
		
		redPlayer = new Player(redPlayerName, Color.valueOf("RED"), redPlayerCards);
		bluePlayer = new Player(bluePlayerName, Color.valueOf("BLUE"), bluePlayerCards);
		
		initializeBoard();
	}

	@Override
	public Color getSpotColor(Position position) {
		Position.validatePosition(position);
		int i = position.getRow();
		int j = position.getCol();
		return board[i][j].getColor();
	}

	@Override
	public Piece getPiece(Position position) {
		Position.validatePosition(position);
		int i = position.getRow();
		int j = position.getCol();
		if(board[i][j].getPiece() == null) {
			return null;
		}
		else {
			return board[i][j].getPiece();
		}
	}

	@Override
	public Card getTableCard() {
		return tableCard;
	}

	@Override
	public Player getRedPlayer() {
		return redPlayer;
	}

	@Override
	public Player getBluePlayer() {
		return bluePlayer;
	}
	
	public static boolean validMove(Spot s1, Spot s2) {
        if(s1.getPiece().getColor() == s2.getPiece().getColor()) 
            return false;
        return true;
    }

	@Override
	public void makeMove(Card card, Position cardMove, Position currentPos) throws IncorrectTurnOrderException, IllegalMovementException, InvalidCardException, InvalidPieceException{
		if(getPiece(currentPos) == null) {
			throw new InvalidPieceException("ERROR: there's no piece at the current position");
		}
		
		if(getPiece(currentPos) != null) {
			if(!pieces.contains(getPiece(currentPos))) {
				throw new InvalidPieceException("ERROR: this piece does not belong to the game");
			}
		}
		
		if(turnControl % 2 == 0) { //Par -> cor oposta ao firstToPlay
			if(firstToPlay == Color.valueOf("BLUE")){
				playerTurn = Color.valueOf("RED");
			}
			if(firstToPlay == Color.valueOf("RED")) {
				playerTurn = Color.valueOf("BLUE");
			}
		}
		if(turnControl % 2 != 0) { //Impar -> cor do firstToPlay
			playerTurn = firstToPlay;
		}
		
		if(getPiece(currentPos).getColor() != playerTurn) {
			throw new IncorrectTurnOrderException("ERROR: incorrect turn order");
		}
		
		Position newPos = new Position(currentPos.getRow() + cardMove.getRow(), currentPos.getCol() + cardMove.getCol());
        
        if(newPos.getRow() > 4 ||newPos.getCol() > 4 || newPos.getRow() < 0 || newPos.getCol() < 0){
            throw new IllegalMovementException("ERROR: index out of bounds");
        }
        
        if(getPiece(newPos) != null){
        	if(getPiece(newPos).getColor() == getPiece(currentPos).getColor()) {
        		throw new IllegalMovementException("ERROR: invalid move, position already occupied by ally");
        	}
        } 

        if(currentPos.getRow() > 4 || currentPos.getCol() > 4 || currentPos.getRow() < 0 ||currentPos.getCol() < 0){
            throw new InvalidPieceException("ERROR: piece out of bounds");
        }

        boolean belongs = false;            
                
        if(playerTurn == Color.valueOf("RED")) {
        	if(card == redPlayerCards[0]){
        		belongs = true;
        		Card aux = redPlayerCards[0];
        		redPlayerCards[0] = tableCard;
        		tableCard = aux;
        	} 
                   
        	if(card == redPlayerCards[1]){
        		belongs = true;
        		Card aux = redPlayerCards[1];
        		redPlayerCards[1] = tableCard;
        		tableCard = aux;
        	}   
        }
        
        if(playerTurn == Color.valueOf("BLUE")) {        	  
        	if(card == bluePlayerCards[0]){
        		belongs = true;
        		Card aux = bluePlayerCards[0];
        		bluePlayerCards[0] = tableCard;
        		tableCard = aux;
        	} 
                
        	if(card == bluePlayerCards[1]){
        		belongs = true;
        		Card aux = bluePlayerCards[1];
        		bluePlayerCards[1] = tableCard;
        		tableCard = aux;
        	} 
        }
                
        if(!belongs) throw new InvalidCardException("ERROR: card not on player's hand");
     
        Spot newSpot;
       
        int k = newPos.getRow();
        int m = newPos.getCol();
        Color posColor = Color.valueOf("NONE");
        	
        //se é o templo, não quero mudar a cor do spot sem querer
        if(board[k][m].getColor() != Color.valueOf("NONE")) {
        	posColor = board[k][m].getColor();
        }
        	
        newSpot = new Spot(getPiece(currentPos), newPos, posColor);
        int i = newSpot.getPosition().getRow();
        int j = newSpot.getPosition().getCol();
        
        int a = currentPos.getRow();
        int b = currentPos.getCol();
        Color posColor2 = board[a][b].getColor();
        Spot oldSpot = new Spot(null, currentPos, posColor2);
            
        board[i][j] = newSpot;
        board[a][b] = oldSpot;

        turnControl++;
    }
	
	@Override
	public boolean checkVictory(Color color) {
		boolean checkRedMaster = false;
		boolean checkBlueMaster = false;
		
		//se o mestre ocupa o templo inimigo
		if(board[0][2].getPiece() != null && board[0][2].getPiece() == redMaster && color == Color.valueOf("RED")) {
			return true;
		}
		if(board[4][2].getPiece() != null && board[4][2].getPiece() == blueMaster && color == Color.valueOf("BLUE")) {
			return true;
		}
		
		//se o mestre foi capturado
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(board[i][j].getPiece() != null) {
					if(board[i][j].getPiece().getColor() == Color.valueOf("RED")){
						if(board[i][j].getPiece().isMaster()) {
							checkRedMaster = true;
						}
					}
					if(board[i][j].getPiece().getColor() == Color.valueOf("BLUE")){
						if(board[i][j].getPiece().isMaster()) {
							checkBlueMaster = true;
						}
					}
				}
			}
		}
		
		if(!checkRedMaster && color == Color.valueOf("BLUE")) {
			return true;
		}
		if(!checkBlueMaster && color == Color.valueOf("RED")) {
			return true;
		}
		
		return false;
	}

	@Override
	public void printBoard() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(board[i][j].getPiece() != null) {
					if(board[i][j].getPiece().getColor() == Color.valueOf("BLUE")) {
						System.out.print(" B ");
					}
					if(board[i][j].getPiece().getColor() == Color.valueOf("RED")) {
						System.out.print(" R ");
					}
				}
				else {
					System.out.print(" - ");
				}
			}
			System.out.println();
		}
	}
}