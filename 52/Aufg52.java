import java.util.Set;
import java.util.HashSet;

public class Aufg52{
    
    public static void main(String[] args){

        long n = 1;
        while(!condition(n)){
            n++;    
            if(n%100000L == 0)
                System.out.println(n);                
        }
        
        System.out.println(n*1);
        System.out.println(n*2);
        System.out.println(n*3);
        System.out.println(n*4);
        System.out.println(n*5);
        System.out.println(n*6);

    }

    public static boolean condition(long n){
        Set<Integer> origDigits = toDigits(n);
        for(int i=2; i <= 6; i++){
            Set<Integer> multDigits = toDigits(i*n);
            if(!origDigits.equals(multDigits))
                return false;
        }
        return true;
    }

	public static Set<Integer> toDigits(long n){	
		Set<Integer> numbers = new HashSet<Integer>();
		
		while(n>0){
			numbers.add((int)(n%10L));
			n = n/10L;
		}
		return numbers;
	}

}
