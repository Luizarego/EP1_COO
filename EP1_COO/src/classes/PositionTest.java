package classes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class PositionTest {
	@Test
	public void testConstructor() {
		Position p = new Position(0, 0);
		assertEquals(0, p.getRow());
		assertEquals(0, p.getCol());
	}

	@Test
	public void testRow() {
		Position p = new Position(0, 0);
		assertEquals(0, p.getRow());
	}
	
	@Test
	public void testCol() {
		Position p = new Position(0, 0);
		assertEquals(0, p.getCol());
	}
	
	@Test
	public void testValidatePositionInvalid() {
		Position pos1 = new Position(-1,0);
		Position pos2 =  new Position(0,-1);
		Position pos3 = new Position(6,4);
		Position pos4 = new Position(4,6);
		assertThrows(IllegalMovementException.class, () -> {
             Position.validatePosition(pos1);
		});
		
		assertThrows(IllegalMovementException.class, () -> {
            Position.validatePosition(pos2);
		});
		
		assertThrows(IllegalMovementException.class, () -> {
            Position.validatePosition(pos3);
		});
		
		assertThrows(IllegalMovementException.class, () -> {
            Position.validatePosition(pos4);
		});
	}

	@Test
	public void testValidatePositionValid() {
		Position pos5 = new Position(3,3);
        Position.validatePosition(pos5);
	}
}