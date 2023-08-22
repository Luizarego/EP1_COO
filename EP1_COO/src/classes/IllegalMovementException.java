package classes;
//Exceção para quando se tenta fazer um movimento inválido

@SuppressWarnings("serial")
public class IllegalMovementException extends OnitamaGameException {

    public IllegalMovementException(String message) {
        super(message);
    }
}
