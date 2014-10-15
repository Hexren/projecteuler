import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.Arrays;

public class MinesweeperMaster{
	
	public static String MINE = "x";
	public static String CLICK = "c";
	public static String OPEN = "O"; 
	public static String NUMBER = "N";
	public static String HIDDEN = ".";	 



	public static void main(String[] args) throws Exception{
		Problem[] problems = getProblems();
		int i = 1;		
		int solv = 0;
		int impo = 0;
		for(Problem problem: problems){
			System.out.println("Case #" + i + ":");
			String[][] field = solveField(problem);
			
			if(isLegal(field)){
				solv++;
				//System.out.println("Solved:");
				//field=markFields(field);
				//printField(field);
			}else{
				impo++;
				System.out.println("Impossible");
				System.out.println(problem);
				field=markFields(field);
				printField(field);
			}			
			i++;
		}
        System.out.println("Solved: " + solv);
        System.out.println("Impossible: " + impo);
        //solveField(problems[3]);
	    //System.out.println(foo.toString().substring(0,10));
	}


    public static String[][] solveField(Problem problem){
       // problem.m = 10;
      	String[][] field = simpleSolver(problem);
		field = setClick(field);
		return field;
		//printField(field);  
    }

	public static boolean isLegal(String[][] field){
		field = cloneField(field);	
		field = setClick(field);
		if(isLegalIntern(field))
			return true;
		else
			return false;
	}

	public static String[][] setClick(String[][] field){
		field = cloneField(field);	
		for(int i=0; i<field.length; i++){
            for(int j=0; j<field[i].length; j++){
				
				if(field[i][j]!=MINE){				
					field[i][j]=CLICK;
					if(isLegalIntern(field)){
						return field;
					}else{
						field[i][j]=HIDDEN;
					}
                }
			}
        }
		field[0][0] = CLICK;
		return field;
	}

	//solves by filling each row from highest to lowest, no intelligence
	public static String[][] lineSolver(Problem problem){
		String[][] field = new String[problem.r][problem.c];
		int mines = problem.m;	
		int placedMines = 0;        
		
		for(int i=field.length-1; i>=0; i--){
            for(int j=field[i].length-1; j>=0; j--){
                if(placedMines < mines){
                    field[i][j]=MINE;
                    placedMines++;
                }else{
					field[i][j]=HIDDEN;
				}
            }
        }  
		return field;
	}

	//solves by filling each row from highest to lowest, no intelligence
	public static String[][] simpleSolver(Problem problem){
		String[][] field = new String[problem.r][problem.c];
		int mines = problem.m;	
		int placedMines = 0;        
		
		for(int i=field.length-1; i>=0; i--){
            for(int j=field[i].length-1; j>=0; j--){
                if(placedMines < mines){
                    field[i][j]=MINE;
                    placedMines++;
                }else{
					field[i][j]=HIDDEN;
				}
            }
        }  
		return field;
	}

	public static void printField(String[][] field){
        for(int i=0; i<field.length; i++){
            for(int j=0; j<field[i].length; j++){
            	System.out.print(field[i][j]);
            }
            System.out.println("");
        }     
	}


	//returns true if one of the neighbors is CLICKED or OPEN
	public static boolean hasOpenNeig(int x, int y, String[][] field){
		String[] ones = {OPEN};
        if(field[x][y] == CLICK){
            return true;
        }

		if(assertFieldHasOne(x,y,ones, field))
			return true;
		return false;
	}

	//return true if the field borders a mine 
	public static boolean hasMineNeig(int x, int y, String[][] field){
		String[] ones = {MINE};
		if(assertFieldHasOne(x,y,ones, field))
			return true;
		return false;
	}

	//return true if a neighbor of field[x][y] contains something from ones
	public static boolean assertFieldHasOne(int x, int y, String[] ones, String[][] field){
		for(int i=Math.max(x-1,0); i<=Math.min(field.length-1,x+1); i++){
			for(int j=Math.max(y-1,0); j<=Math.min(field[i].length-1,y+1) ;j++){
				if(Arrays.asList(ones).contains(field[i][j]))
					return true;
			}
		}
		return false;
	}


	public static boolean isLegalIntern(String[][] field){
		String[][] markedField= markFields(field);
		boolean res = checkFields(markedField);
		return res;
	}

	//return true if this is a winning field
	public static boolean checkFields(String[][] field){
		for(int i=0; i<field.length; i++){
            for(int j=0; j<field[i].length; j++){
				
				if(field[i][j]==HIDDEN){				
					return false;
                }
			}
        }  
		return true;
	}


    //public static int freeRow()

	//reveals according to rules
	public static String[][] markFields(String[][] field){
		String[][] markedField = cloneField(field);

		/*
		very dumbly loops over and reveals until nothing is changing anymore
		*/
		boolean changed = true;
		while(changed){
			changed=false;
			for(int i=0; i<markedField.length; i++){
		        for(int j=0; j<markedField[i].length; j++){
					if(markedField[i][j]!=HIDDEN && markedField[i][j]!=CLICK )
						continue;				
		
					if(hasOpenNeig(i,j,markedField) && markedField[i][j]!=MINE){
						changed=true;
					    if(!hasMineNeig(i,j,markedField)){
							markedField[i][j]=OPEN;
						}else{
							markedField[i][j]=NUMBER;
						}
		            }else if(markedField[i][j]!=MINE){
						markedField[i][j]=HIDDEN;
					}
		        }
		    }  
		}
		return markedField;
	}




	public static String[][] cloneField(String[][] field){
		String [][] myField = new String[field.length][];
		for(int i = 0; i < field.length; i++)
    		myField[i] = field[i].clone();
		return myField;
	}

	public static Problem[] getProblems() throws Exception{
        //BufferedReader reader = new BufferedReader(new FileReader("C-small-practice.in"));
        BufferedReader reader = new BufferedReader(new FileReader("5.in"));
		    
        //initialise problems array
        int numbProbl = Integer.parseInt(reader.readLine());
        Problem[] problems = new Problem[numbProbl];
        
		String line = null;
		int i = 0;
		while ((line = reader.readLine()) != null) {
    		String[] args = line.split("\\s+");
			
            Problem problem = new Problem();
		    problem.r = Integer.parseInt(args[0]);
            problem.c = Integer.parseInt(args[1]);
            problem.m = Integer.parseInt(args[2]); 
            problems[i] = problem;
            i++;
        }
		return problems;
	}


    private static class Problem{
        public int m;
        public int r;
        public int c;

        public String toString(){
            return "m:" + m + " r:"+ r + " c:" +c;
        }

    }

}
