package classes;
//Exce��o para quando se tenta mover uma pe�a que n�o est� em jogo

@SuppressWarnings("serial")
public class InvalidPieceException extends OnitamaGameException {
 
    public InvalidPieceException(String message) {
        super(message);
    }
}