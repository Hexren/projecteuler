import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;

public class Aufg50{
    public static Primes p;

    public static void main(String[] args){
        int limit = 1000000;
        int counter = 0;
        
        p = new Primes(5000000);
        List<Integer> pl = p.asList();
        int res = 0;
        int k = 0;
        while(res < limit*1.5){
            res += pl.get(k);
            k++;
        }
        pl = pl.subList(0,k);

        List<Integer> max = new ArrayList<Integer>();       

        for(int i = 0; i < 50; i++){
            List<Integer> cand = new ArrayList<Integer>(pl);
            cand = cand.subList(i, cand.size());
            cand = pruneBack(cand,limit);
            if(cand.size() > max.size()){
                System.out.println(sum(cand));
                max = cand;
            }
        }
        System.out.println(sum(max));
        System.out.println(max);

    }

    public static List<Integer> pruneBack(List<Integer> primes, int limit){
       
        int sum = sum(primes);
        while(sum > limit || !isPrime(sum)){
            sum = sum - primes.get(primes.size()-1);
            primes.remove(primes.size()-1);
        }

        return primes;
    }
    
    public static boolean isPrime(int n){
        return p.isPrime(n);
    }

    public static int sum(List<Integer> list) {
        Integer sum= 0; 
        for (Integer i:list)
            sum = sum + i;
        return sum;
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
