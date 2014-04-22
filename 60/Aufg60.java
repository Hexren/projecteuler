import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.Comparator;


public class Aufg60{
	static int LIMIT = 100000000;
	public static void main(String[] args){
		Primes p = new Primes(LIMIT);
		List<Set<Integer>> result = new ArrayList<Set<Integer>>();
		long counter = 0;
		Set<Integer> primes = new HashSet<Integer>();
		//find legal tuples;
		for(int i=2; i<=2000; i=i+1){
			if(!p.isPrime(i))
				continue;
			primes.add(i);
			for(int j=i+1; j<=2000; j++){
				if(!p.isPrime(j))
					continue;			
				if(concPrime(i,j,p)){
					Set<Integer> set = new HashSet<Integer>();
					set.add(i);
					set.add(j);
					result.add(set);
				}
			}
		}
			
		System.out.println(result);
		List<Set<Integer>> foo = concatPrimeSets(result, p);
		System.out.println(foo);
		Collections.sort(foo,
            new Comparator<Set<Integer>>(){
				public int compare(Set<Integer> a, Set<Integer> b){
					Integer ia = sumSet(a);
					Integer ib = sumSet(b);
					return ia.compareTo(ib);
				}
			});
		System.out.println(foo);
		
	
	}

	public static int sumSet(Set<Integer> a){
		int res = 0;
		for(Integer i: a){
			res += i;
		}
		return res;
	}

	public static List<Set<Integer>> concatPrimeSets(List<Set<Integer>> primes, Primes p){
		List<Set<Integer>> result = new ArrayList<Set<Integer>>();
		for(int i=0; i<primes.size()-1 ;i++){
			for(int j=i+1; j<primes.size(); j++){
				if(isConcPrimeSets(primes.get(i), primes.get(j), p)){
					Set<Integer> combSet = new HashSet<Integer>();
					combSet.addAll(primes.get(i));
					combSet.addAll(primes.get(j));
					if(!result.contains(combSet))					
						result.add(combSet);
				}
			}
		}
		return result;
	}

	//tests all primes from 2 sets against each other
	public static boolean isConcPrimeSets(Set<Integer> setA, Set<Integer> setB, Primes p){
		if(!Collections.disjoint(setA,setB)){
			return false;
		}
		for(Integer x: setA){
			for(Integer y: setB){
				if(!concPrime(x,y,p)){
					return false;
				}
			}
		}
		return true;
	}


	//tests if the possible concatenations of 2 numbers are prime
	public static boolean concPrime(int x, int y, Primes p){
		List<Integer> lxy = toDigits(x);
		lxy.addAll(toDigits(y));
		List<Integer> lyx = toDigits(y);
		lyx.addAll(toDigits(x));
		Integer xy = listToInt(lxy);
		Integer yx = listToInt(lyx);
				
		if(p.isPrime(xy) && p.isPrime(yx))
			return true;
		return false;
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
        /*String n = "";
        for(Integer i: digits){
            n = n + i;
        }
        return Integer.parseInt(n);*/
		int res = 0;
		int mult = 1;
		for(int i=digits.size()-1; i>=0; i--){
			res = res + (mult*digits.get(i));

			mult *= 10;
		}
		return res;
    }

    public static class Primes implements Iterable<Integer>{
        
        protected long limit;    
        protected boolean[] primes;
      
        public Primes(int limit){
            this.limit = limit;
            primes = eSieve(limit);
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
            if(n < limit)
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
