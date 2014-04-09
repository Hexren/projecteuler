import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;

public class Aufg51{

	public static void main(String[] args){
		Primes p = new Primes(100);
		List<Integer> pl = p.asList();
		

	}

	public static List<Integer> getPrimesWithXDigits(List<Integer> primes, int x){
		
		int i = 0;
		for(i= 0; i<primes.size(); i++){
			if(toDigits(primes.get(i)).size() >= x)
				return primes.subList(x-1,primes.size());
		}
		return primes;
	}

	public static boolean equal(List<Integer> p1, List<Integer> p2, int ia, int ib){
		for(int i=0; i<=p1.size(); i++){
			if(i == ia || i == ib)
				continue;
			if(p1.get(i) != p2.get(i)){
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
		return new ArrayList<Integer>(Arrays.asList(numbers));
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
