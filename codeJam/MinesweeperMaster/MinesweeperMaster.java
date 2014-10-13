import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;


public class MinesweeperMaster{
	
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
        for(int i=0; i<field.length; i++){
            for(int j=0; j<field[i].length; j++){
                if(m < problem.m){
                    System.out.print("x");
                    m++;
                }else{  
                    System.out.print(".");                  
                }
            }
            System.out.println("");
        }     
    }

    public static void solveField2(Problem problem){

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
