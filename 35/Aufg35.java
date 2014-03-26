import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Aufg35{

    public static Map<Long, Boolean> cache = new HashMap<Long, Boolean>();

    public static void main(String[] args){
        //start with 1 because 2 is prime and iteration starts with 3        
        int numPrim = 1;        
        for(int i = 3; i<1000000; i= i+2 ){
            if(Integer.toString(i).indexOf("0") != -1)
                continue;

            boolean isPrime = true;
            for(int rotation: rotations(i)){
                if(!isPrime(rotation)){
                    isPrime = false;   
                } 
            }
            if(isPrime){
                System.out.println(i);
                numPrim++;
            }
        }    
        System.out.println(numPrim);    
    }

    public static List<Integer> rotations(int i){
        int rotated = i;
        List<Integer> rotations = new ArrayList<Integer>();
        int j = 0;
        do{
            //System.out.println(rotated);
            rotations.add(rotated);
            rotated = rotate(rotated);
        }while(rotated != i );
        return rotations;
    }

    public static int rotate(int i){
        String rotation = Integer.toString(i);        
        rotation = rotation.substring(1) + rotation.substring(0,1);
        return Integer.parseInt(rotation);
    }
    
	public static boolean isPrime(long n){
		n = Math.abs(n);
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
