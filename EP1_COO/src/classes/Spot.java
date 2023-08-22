package classes;

//Classe contendo ações e informações sobre cada espaço (quadrado) no tabuleiro
 
public class Spot {
	
	private Piece piece;
	private Position pos;
	private Color color;

    public Spot(Piece piece, Position pos, Color color) {
    	this.piece = piece;
    	this.pos = pos;
    	this.color = color;
    }

    public Spot(Piece piece, Position pos) {
    	this.piece = piece;
    	this.pos = pos;
    }

    public Spot(Position pos) {
    	this.pos = pos;
    }

    public Position getPosition() {
        return pos;
    }

    public Piece getPiece() {
        return piece;
    }

    public Color getColor() {
        return color;
    }

    protected void occupySpot(Piece piece) throws IllegalMovementException {
    	if(this.piece != null) {
    		if((this.piece).getColor() == piece.getColor()) {
    			throw new IllegalMovementException("ERROR: The spot is already occupied by a piece of the same color");
    		}
    	}
        this.piece = piece;
        this.pos = getPosition();
        this.color = getColor();
    }

    protected void releaseSpot() {
        if(piece == null) {
        	return;
        }
        else {
        	piece = null;
        }
    }
}