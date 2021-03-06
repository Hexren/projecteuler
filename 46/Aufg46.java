import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class Aufg46{
       
    public static Map<Long, Boolean> cache = new TreeMap<Long, Boolean>();
 
    public static void main(String[] args){
        long steps = 0;
        long n = 1;
        while(true){
            steps++;
            n = n + 2;
            if(isPrime(n))
                continue;
            
            int i = 1;
            long iSq = 2*(i*i);
            for(; iSq < n; i++){
                if(isPrime(n - iSq)){
                    break;
                }
                iSq = 2*(i*i);
            }

            if(steps % 100000 == 0){
                System.out.println(n);
                steps = 0;
            }

            if(!isPrime(n - iSq)){
                System.out.println("Erg = " + n + " Square: " + iSq + " Prim " + (n - iSq));
                //break;
            }
          
        }
}


	public static boolean isPrime(long n){
		//n = Math.abs(n);
		if(cache.containsKey(n))
			return cache.get(n);
    	
        if(n == 2)
            return true;
		if(n <= 1) 
			return false;
		if(n % 2== 0)
			return false;
		
		for(int i = 3; i <= Math.sqrt(n)+1; i = i + 2){
			if(n % i == 0){
				cache.put(n,false);
				return false;
		
			}
		}
		cache.put(n,true);
		return true;
	}

}
