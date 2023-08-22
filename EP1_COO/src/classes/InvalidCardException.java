package classes;
//Exceção para quando se tenta jogar uma carta que não está na mão do jogador

@SuppressWarnings("serial")
public class InvalidCardException extends OnitamaGameException {

    public InvalidCardException(String message) {
        super(message);
    }
}
