import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.Comparator;
import java.util.TreeSet;


public class Aufg60{
	static int LIMIT = 100000;
	static int TESTLIMIT = 10000;
	static Set<Integer> concatebalePrimes = new HashSet<Integer>();


	public static void main(String[] args){
		Primes p = new Primes(LIMIT);
		List<Set<Integer>> result = new ArrayList<Set<Integer>>();
		long counter = 0;
		
		for(int i=3; i<TESTLIMIT; i=i+2){
			if(!p.isPrime(i))
				continue;
			Set<Integer> is = new HashSet<Integer>();
			is.add(i);
			concatebalePrimes.add(i);
			result.add(is);
		}			
		
		for(int i=0; i<4; i++){
			result = addPrimes(result, p);
			System.out.println(concatebalePrimes.size());			
		}

		Collections.sort(result,
            new Comparator<Set<Integer>>(){
				public int compare(Set<Integer> a, Set<Integer> b){
					Integer ia = sumSet(a);
					Integer ib = sumSet(b);
					return ia.compareTo(ib);
				}
			});
		System.out.println(result);
		System.out.println(result.size());
	
	}

	public static int sumSet(Set<Integer> a){
		int res = 0;
		for(Integer i: a){
			res += i;
		}
		return res;
	}

	public static List<Set<Integer>> addPrimes(List<Set<Integer>> primeSets, Primes p){
		List<Set<Integer>> result = new ArrayList<Set<Integer>>();
		Set<Integer> concatebalePrimesTmp = new HashSet<Integer>();

		for(Set<Integer> primeSet: primeSets){
			for(int i: concatebalePrimes){
				
				if(isConcPrimeSets(primeSet, i, p)){
					Set<Integer> newRes = new HashSet<Integer>();
					newRes.addAll(primeSet);
					newRes.add(i);
					if(!result.contains(newRes)){					
						result.add(newRes);
						concatebalePrimesTmp.addAll(newRes);
					
					}
				}
			}
		}
		concatebalePrimes = concatebalePrimesTmp;
		return result;
	}

	//tests all primes from 2 sets against each other
	public static boolean isConcPrimeSets(Set<Integer> setA, int b, Primes p){
		if(setA.contains(b)){
			return false;
		}
		for(Integer x: setA){
			if(!concPrime(x,b,p)){
					return false;
			}
		}
		return true;
	}


	//tests if the possible concatenations of 2 numbers are prime
	public static boolean concPrime(int x, int y, Primes p){
		int[] lxy = concat(toDigits(x),toDigits(y));
		int xy = arrToInt(lxy);
		if(!p.isPrime(xy))
			return false;				
		int[] lyx = concat(toDigits(y),toDigits(x));
		int yx = arrToInt(lyx);	
		if(!p.isPrime(yx))
			return false;
		return true;
	}

	public static int[] concat(int[] A, int[] B) {
   		int aLen = A.length;
	   	int bLen = B.length;
	   	int[] C= new int[aLen+bLen];
	   	System.arraycopy(A, 0, C, 0, aLen);
	   	System.arraycopy(B, 0, C, aLen, bLen);
	   	return C;
	}


	public static int[] toDigits(int n){
		int len = (int) Math.log10(n) + 1;
		int[] numbers = new int[len];
		
		for(int i = len-1; i >=0; i--){
			numbers[i] = n%10;
			n = n/10;
		}
		return numbers;
	}

    public static int arrToInt(int[] digits){
        int res = 0;
		int mult = 1;
		for(int i=digits.length-1; i>=0; i--){
			res = res + (mult*digits[i]);
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
            primes[1] = false;
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
