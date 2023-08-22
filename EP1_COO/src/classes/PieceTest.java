package classes;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PieceTest {

    @Test
    public void testConstructor() {
        Piece piece = new Piece(Color.valueOf("RED"), false);
        assertEquals(Color.valueOf("RED"), piece.getColor());
        assertFalse(piece.isMaster());
    }

    @Test
    public void testColor() {
        Piece redPiece = new Piece(Color.valueOf("RED"), true);
        assertEquals(Color.valueOf("RED"), redPiece.getColor());

        Piece bluePiece = new Piece(Color.valueOf("BLUE"), false);
        assertEquals(Color.valueOf("BLUE"), bluePiece.getColor());
    }
    
    @Test
    public void testIsMaster() {
        Piece masterPiece = new Piece(Color.valueOf("BLUE"), true);
        assertEquals(true, masterPiece.isMaster());

        // Test case for checking if the Piece is not a master
        Piece regularPiece = new Piece(Color.valueOf("RED"), false);
        assertEquals(false, regularPiece.isMaster());
    }
}