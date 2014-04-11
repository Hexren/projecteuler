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
		p = new Primes(1000000);
		List<Integer> pl = p.asList();
        
		pl = getPrimesWithXDigits(pl, 6);
        //System.out.println(pl.get(0));
        //System.out.println(getReplacementCands(toDigits(56003)));
        for(Integer prime: pl){
            for(List<Integer> replacement: getReplacementCands(toDigits(prime))){
                //System.out.println("Testing:" + prime + " with replacement:" + replacement);       
                List<Integer> primes = new ArrayList<Integer>(8);
                for(int i = 0; i <= 9; i++){
                    int newNumber = replaceDigits(replacement, prime, i);
                    if(isPrime(newNumber)){
                        primes.add(newNumber);
                    }
                }
                if(primes.size()>=8){
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
        int result = listToInt(origDig);
        //check there is no leading 0, that seems to be an assumption in problem 51
        if(toDigits(original).size() != toDigits(result).size())
            return 4; 
        return result;
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
    public static Set<List<Integer>> getReplacementCands(List<Integer> digits){
        Set<List<Integer>> candidates = new HashSet<List<Integer>>(); 
        for(int i=0; i<digits.size()-1; i++){
            List<Integer> persisCand = new ArrayList<Integer>();
            persisCand.add(i);
            for(int j=i+1; j <digits.size();j++)
                if(digits.get(i) == digits.get(j)){
                    persisCand.add(j);
                    candidates.add(new ArrayList<Integer>(persisCand));
                }
        }
        return candidates;
        
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

}
