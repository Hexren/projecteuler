import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;

public class Aufg51{
        public static Primes p;
	public static void main(String[] args){
		p = new Primes(100000);
		List<Integer> pl = p.asList();
		pl = getPrimesWithXDigits(pl, 5);
        //System.out.println(pl.get(0));
        System.out.println(getReplacementCands(toDigits(56003)));
        for(Integer prime: pl){
            for(Tuple replacement: getReplacementCands(toDigits(prime))){
                //System.out.println("Testing:" + prime + " with replacement:" + replacement);       
                List<Integer> primes = new ArrayList<Integer>(8);
                for(int i = 0; i <= 9; i++){
                    int newNumber = replaceDigits(replacement, prime, i);
                    if(isPrime(newNumber)){
                        primes.add(newNumber);
                    }
                }
                if(primes.size()>=7){
                    Collections.sort(primes);
                    System.out.println(replacement);
                    System.out.println(primes);
                    System.out.println("Found! exiting...");
                    System.exit(0);
                }
       
            }
        }
	}

    public static int replaceDigits(List<Integer> digits, int original, int replacement){
        List<Integer> origDig = toDigits(original);
        for(Integer i: digits){
            origDig.set(i, replacement);
        }
        return listToInt(origDig);
    }
    
	public static List<Integer> getPrimesWithXDigits(List<Integer> primes, int x){
		int i = 0;
		for(i= 0; i<primes.size(); i++){
			if(toDigits(primes.get(i)).size() >= x)
				return primes.subList(i,primes.size());
		}
		return primes;
	}

    public static boolean isPrime(int n){
        return p.isPrime(n);
    }

    //find candidate replacements in a primes
    public static Set<Tuple> getReplacementCands(List<Integer> digits){
        Set<Tuple> candidates = new HashSet<Tuple>(); 
        for(int i=0; i<digits.size()-1; i++){
            for(int j=i+1; j <digits.size();j++)
                if(digits.get(i) == digits.get(j)){
                    candidates.add(new Tuple(i,j));
                }
        }
        return candidates;
        
    } 

    //compares 2 numbers given as digit lists
	public static boolean equal(List<Integer> p1, List<Integer> p2, int ia, int ib){
		for(int i=0; i<p1.size(); i++){
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

    public static int listToInt(List<Integer> digits){
        String n = "";
        for(Integer i: digits){
            n = n + i;
        }
        return Integer.parseInt(n);
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

    public static class Tuple{ 
        public final int x; 
        public final int y; 
        public Tuple(int x, int y) { 
            this.x = x; 
            this.y = y; 
        } 

        public int hashCode() {
        	return (int)(y+x); 
    	}

		public boolean equals(Object other) {
			//System.out.println(this.toString());
			//System.out.println(other.toString());
			if (other.getClass() != getClass()) 
      			return false; 
    		if (x != ((Tuple)other).x) 
       			return false;
			if (y != ((Tuple)other).y) 
       			return false;
			return true;
   		} 

        public String toString(){
            return "{"+x+","+y+"}";
        }

    } 

}
