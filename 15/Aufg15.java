import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.math.BigInteger;

public class Aufg15{

	public static int MAX = 20;

	public static void main(String[] args){
		//BigInteger moves = numNextMoves(0,0);	
		//System.out.println(moves.toString());
		long[][] boundaries = boundaries();
		System.out.println(boundaries[0][0]);
	}


	//0 right, 1 down
	public static BigInteger numNextMoves(int row, int col){
		//System.out.println("row: " + row + " col: " + col);
		//System.out.println(possMoves);		
		//break		
		if(row == MAX && col == MAX)
			return BigInteger.valueOf(1L);
		
		List<Integer> posMoves = new ArrayList<Integer>();
		
		//possible next moves
		if(col < MAX){
			posMoves.add(0);
		}
		if(row < MAX){
			posMoves.add(1);
		}

		
		//System.out.println(possChildMoves);
		BigInteger childMoves = BigInteger.ZERO;
		for(int j = 0; j < posMoves.size() ; j++){		
			int move = posMoves.get(j);
			switch(move){
				case 0: childMoves = childMoves.add(numNextMoves(row, col+1));
						break;

				case 1: childMoves = childMoves.add(numNextMoves(row+1, col));
						break;
			}
		}
		return childMoves;
	}


	public static long[][] boundaries(){
		long[][] grid = new long[MAX+1][MAX+1];
		//Initialise the grid with boundary conditions
		for (int i = 0; i < MAX; i++) {
			grid[i][MAX] = 1;
			grid[MAX][i] = 1;
		}
		for (int i = MAX - 1; i >= 0; i--) {
			for (int j = MAX - 1; j >= 0; j--) {
				grid[i][j] = grid[i+1][j] + grid[i][j+1];
			}
		}
		return grid;

	}


}
