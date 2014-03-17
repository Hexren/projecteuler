

public class Aufg26{

	public static void main(String[] args){
		int maxLen = 0;		
		
		//leave out multiples of 2 and 5, those never have reccuringcycles
		for(int i = 2; i < 1000; i++){
			if(i % 2 == 0 || i % 5 == 0)
				continue;
			
			if(maxLen < reccurCycle(i)){
				maxLen = reccurCycle(i);
				System.out.println(maxLen + " is length at: " + i);	
			}
				
		}
	}

	public static int reccurCycle(int n){
		int residual = 10 % n;
		int len = 1;		

		while(residual != 1){
			
			len++;
			residual = (10 * residual % n);
		}
		return len;
	}	

}
