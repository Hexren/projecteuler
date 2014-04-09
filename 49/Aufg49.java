import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class Aufg49{
    public static void main(String[] args){
        Primes p = new Primes(10000);


        for(int i=999; i<=9999-6660;i = i+2){
            if(p.isPrime(i) && p.isPrime(i+3330) && p.isPrime(i+6660) && isPermutation(toDigits(i),toDigits(i+3330),toDigits(i+6660)))
                System.out.println(i + " " + (i+3330) + " " + (i+6660));
        }

    }

    //checks that all the lists in digitLists are permutations of digits
    public static boolean isPermutation(List<Integer> digits, List<Integer>... digitList){
        for(int i: digits){
            for(List<Integer> otherDig: digitList){
                if(!otherDig.remove((Integer)i))
                    return false;
            }
        }   

        return true;
    }

    public static List<Integer> toDigits(int n){
		int len = String.valueOf(n).length();		
		Integer[] numbers = new Integer[len];
		
		for(int i = len-1; i >=0; i--){
			numbers[i] = n%10;
			n = n/10;
		}
		return new LinkedList(Arrays.asList(numbers));
	}    


    public static class Primes {
        
        protected int limit;    
        protected boolean[] primes;

        public Primes(int limit){
            this.limit = limit;
            primes = eSieve(limit);
        }        
        
        public boolean isPrime(int n){
            return primes[n];
        }

        protected boolean[] eSieve(int limit){
		    boolean[] primes = new boolean[limit];
		    Arrays.fill(primes, true);
            
            for(int i = 2; i<primes.length;i++){
               if(primes[i]){
                  for(int j = i+1; j < primes.length; j = j+1){
                    if(j%i==0)
                        primes[j] = false;
                  }
               }
            }

            for(int i = 2; i<50;i++){
                if(primes[i])
                    System.out.println(i + " is Prime");
            }
            
            
		    return primes;
	    }


    }

}
