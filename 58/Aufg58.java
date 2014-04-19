import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;


public class Aufg58{

	public static void main(String[] args){
		Primes p = new Primes(600000000);
		List<Integer> res = new ArrayList<Integer>();
		        
		int length = 5;
		int i = 1;        
		do{
			i = i + 2;
			res.addAll(get4Corners(i));
			
			System.out.println("i:" + i + " Percent:" + percentPrimes(res, p));
		}while(percentPrimes(res, p) > 10);

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

    public static List<Integer> get4Corners(int len){
		List<Integer> res = new ArrayList<Integer>();
		
        if(len == 1){
            //res.add(1);        
        }else{
		    int start = len * len;
		    
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


    public static class Primes implements Iterable<Integer>{
        
        protected int limit;    
        protected boolean[] primes;
        protected ArrayList<Integer> pl = new ArrayList<Integer>(1000);

        public Primes(int limit){
            this.limit = limit;
            primes = eSieve(limit);
        }   

        public List<Integer> asList(){
            return pl;
        } 
        
        
        public Iterator<Integer> iterator(){
            LinkedList<Integer> pList = new LinkedList<Integer>();
            for(int i = 2; i<primes.length;i++){
                if(primes[i]){
                    pList.add(i);
                }
            }
            return pList.iterator();
        }    
        
        public boolean isPrime(int n){
            return primes[n];
        }

        protected boolean[] eSieve(int limit){
		    boolean[] primes = new boolean[limit];
		    Arrays.fill(primes, true);
            
            for(int i = 2; i<primes.length;i++){
               if(primes[i]){
                  pl.add(i);
                  for(int j = 2*i; j < primes.length; j = j+i){
                    if(j%i==0)
                        primes[j] = false;
                  }
               }
            }
            
		    return primes;
	    }


    }
 







}
