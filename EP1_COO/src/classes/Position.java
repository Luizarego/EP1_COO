package classes;
//Classe usada para definição de estrutura de posições e movimentos do jogo

public class Position {
	
	private int row;
	private int col;

   public Position(int row, int col) {
	   this.row = row;
	   this.col = col;
   }

   public int getRow() {
       return row;
   }

   public int getCol() {
       return col;
   }
   
   public static void validatePosition(Position position) throws IllegalMovementException {
	   if(position.row < 0 || position.row > 5 || position.col < 0 || position.col > 5) {
		   throw new IllegalMovementException("ERROR: index out of bounds");
	   }  
   }
}