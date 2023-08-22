package classes;
//Exceção para quando se tenta mover uma peça que não está em jogo

@SuppressWarnings("serial")
public class InvalidPieceException extends OnitamaGameException {
 
    public InvalidPieceException(String message) {
        super(message);
    }
}