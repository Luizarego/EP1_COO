package classes;
//Exce��o geral para qualquer regra burlada

@SuppressWarnings("serial")
public class OnitamaGameException extends RuntimeException {

    public OnitamaGameException(String message) {
        super(message);
    }
}
