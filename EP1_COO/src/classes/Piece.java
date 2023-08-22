package classes;
/**
 * Classe que contém informações das peças de jogo
 */
public class Piece {
	
	private Color color;
	private boolean isMaster;

    public Piece(Color color, boolean isMaster) {
    	this.color = color;
    	this.isMaster = isMaster;
    }

    public Color getColor() {
        return color;
    }

    public boolean isMaster() {
        return isMaster;
    }
}