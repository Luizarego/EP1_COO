package classes;
//Exce��o para quando se tenta jogar uma carta que n�o est� na m�o do jogador

@SuppressWarnings("serial")
public class InvalidCardException extends OnitamaGameException {

    public InvalidCardException(String message) {
        super(message);
    }
}
