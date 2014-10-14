import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.Arrays;

public class MinesweeperMaster{
	
	public static String MINE = "x";
	public static String CLICK = "C";
	public static String OPEN = "O"; 
	public static String NUMBER = "N";
	public static String HIDDEN = "H";	 



	public static void main(String[] args) throws Exception{
		Problem[] problems = getProblems();
		for(Problem problem: problems){
			
			//System.out.println(problem);
		}
        System.out.println(problems[3]);
        solveField(problems[3]);
	    //System.out.println(foo.toString().substring(0,10));
	}


    public static void solveField(Problem problem){
        String[][] field = new String[problem.r][problem.c];
        int m = 0;
        for(int i=field.length-1; i>=0; i--){
            for(int j=field[i].length-1; j>=0; j--){
                if(m < problem.m){
                    field[i][j]=MINE;
                    m++;
                }else{
					field[i][j]=".";
				}
            }
        }  
		printField(field);  
		field=markFields(field);
		printField(field);
 
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
		String[] ones = {CLICK, OPEN};
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


	public static boolean isLegal(String[][] field){
		String[][] markedField= markFields(field);
		boolean res = checkFields(markedField);
		return res;
	}

	//marks left bottom as click and reveals according to rules
	public static String[][] markFields(String[][] field){
		String[][] markedField = cloneField(field);		
		markedField[0][0] = CLICK;
 		for(int i=0; i<markedField.length; i++){
            for(int j=0; j<markedField[i].length; j++){
				
				if(markedField[i][j]==CLICK){				
	
                }else if(hasOpenNeig(i,j,markedField) && markedField[i][j]!=MINE){
					
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
		return markedField;
	}

	public static boolean checkFields(String[][] field){
		return true;
	}


	public static String[][] cloneField(String[][] field){
		String [][] myField = new String[field.length][];
		for(int i = 0; i < field.length; i++)
    		myField[i] = field[i].clone();
		return myField;
	}

	public static Problem[] getProblems() throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("C-small-practice.in"));
		    
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
