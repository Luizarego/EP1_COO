package classes;
//Exce��o para quando se tenta fazer um movimento inv�lido

@SuppressWarnings("serial")
public class IllegalMovementException extends OnitamaGameException {

    public IllegalMovementException(String message) {
        super(message);
    }
}
