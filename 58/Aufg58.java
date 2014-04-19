import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;


public class Aufg58{

	public static void main(String[] args){
		Primes p = new Primes(650000000);
		List<Integer> res = new ArrayList<Integer>();
		        
		int length = 2000;
		int i = 1;
        double perc;        
		do{
			i = i + 2;
			res.addAll(get4Corners(i));
            perc = percentPrimes(res, p);
			System.out.println("i:" + i + " Percent:" + perc);
		}while(perc > 10);

        System.out.println(i);		
		

	}

	public static double percentPrimes(List<Integer> numbers, Primes p){
		int primes = 0;		
		for(Integer number: numbers){
			if(p.isPrime(number)){
				primes++;
			}
		}
		double res = ((double)primes/numbers.size())*100;
		return res;
	}

    public static List<Integer> get4Corners(Integer len){
		List<Integer> res = new ArrayList<Integer>();
		
        if(len == 1){
            //res.add(1);        
        }else{
		    int start = len * len;
		    //System.out.println(start);
		    res.add(start);
			//System.out.println(start);
		    res.add(start - (len-1));
			//System.out.println(start - (len-1));
		    res.add(start - (2*(len-1)));
			//System.out.println(start - (2*(len-1)));
		    res.add(start - (3*(len-1)));
			//System.out.println(start - (3*(len-1)));       
		}
        return res;
       
    }


    public static class Primes{
        
        protected long limit;    
        protected boolean[] primes;
      
        public Primes(int limit){
            this.limit = limit;
            primes = eSieve(limit);
        }   

        
        public boolean isPrime(int n){
            if(n <= limit)
                return primes[n];
            else
                return isPrimeL(n);
        }

        protected boolean[] eSieve(int limit){
		    boolean[] primes = new boolean[limit];
		    Arrays.fill(primes, true);
            
            for(int i = 2; i<primes.length;i++){
               if(primes[i]){
                  for(int j = 2*i; j < primes.length; j = j+i){
                    if(j%i==0)
                        primes[j] = false;
                  }
               }
            }
            
		    return primes;
	    }

        public static boolean isPrimeL(long n){
		    n = Math.abs(n);
		    
            if(n == 2)
                return true;
		    if(n <= 1) 
			    return false;
		    if(n % 2== 0)
			    return false;
		
		    for(int i = 3; i <= Math.sqrt(n)+1; i = i + 2){
			    if(n % i == 0){
				    return false;
		
			    }
		    }
		    return true;
	    }


    }
 







}
