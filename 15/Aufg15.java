public class Aufg15{

	public static int MAX = 20;

	public static void main(String[] args){
		int[] possMoves = new int{0,1};
		int moves = numNextMoves(0,0,possMoves)
		System.out.println(moves);
	}


	//0 right, 1 down
	public static void numNextMoves(int row, int col, int[] possMoves){
		//break		
		if(row == MAX && col == MAX)
			return 1;
		
		//possible next moves
		int i = 0;		
		if(row != MAX){
			possMoves[i] = 1;
			i++;
		}
		if(col != MAX){
			possMoves[i] = 0;
			i++;
		}

		int childMoves = 0;
		for(int j; j < possMoves.length(); j++){		
			int move = possMoves[j];
			switch(move){
				case 0: childMoves = childMoves + numNextMoves(row, col+1, possMoves);
						break;

				case 1: childMoves = childMoves + numNextMoves(row, col+1, possMoves);
						break;
				
			}
		return childMoves+1;
			
		
		}

	}


}
