package classes;
//Exceção para quando se tenta jogar fora do seu turno

@SuppressWarnings("serial")
public class IncorrectTurnOrderException extends OnitamaGameException {
   
    public IncorrectTurnOrderException(String message) {
        super(message);
    }
}
