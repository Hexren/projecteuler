import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aufg43{
    
    public static void main(String[] args){
		int[] start = {0,1,2,3,4,5,6,7,8,9};

		long i = 0;
		while(hasNext(start)){
			incr(start);
            if(checkCondition(start)){
                System.out.println(Arrays.toString(start));
                i = i + makeNumMath(start, 1,10);
            }                
		}
        System.out.println(i);
    }

    public static boolean checkCondition(int[] digits){
        if(makeNumMath(digits, 2,4) % 2L != 0)
            return false;
        if(makeNumMath(digits, 3,5) % 3L != 0)
            return false;
        if(makeNumMath(digits, 4,6) % 5L != 0)
            return false;
        if(makeNumMath(digits, 5,7) % 7L != 0)
            return false;
        if(makeNumMath(digits, 6,8) % 11L != 0)
            return false;
        if(makeNumMath(digits, 7,9) % 13L != 0)
            return false;
        if(makeNumMath(digits, 8,10) % 17L != 0)
            return false;
        
        return true;        
    }

    //indices start at one, as in the problem description
    public static long makeNum(int[] digits, int start, int end){
        String n = "";
        for(int i=start-1; i<end ;i++){
            n += digits[i];
        }        
        return Long.valueOf(n);
    }

    //indices start at one, as in the problem description, this is the fast version
    public static long makeNumMath(int[] digits, int start, int end){
        long n = 0L;
        long mult = 1;
        for(int i=end-1; i>=start-1 ;i--){
            n = n + (mult * digits[i]);
            mult *= 10L;
        } 
        return n;
    }

    /*
	increments to the next lexicographic ordering for start, modifies start inplace
	returns true if there is a next increment or false otherwise
	*/
	public static void incr(int[] start){
		int k = findK(start);
		int i = findI(k, start);
		int tmp = start[k];
		start[k] = start[i];
		start[i] = tmp;
		reverse(k+1, start);		
	}

	public static int findK(int[] start){
				
		for(int k = start.length - 2; k >= 0; k--){
			if(start[k] < start[k+1])
				return k;
		}
		throw new RuntimeException("WAhhhhahhahaha");
	}

	public static int findI(int k, int[] start){
		for(int i = start.length-1; i >= k+1; i--){
			if(start[k] < start[i]){
				return i;
			}
		}
		throw new RuntimeException("WAGA WAGA");
	}

	public static void reverse(int startPos, int[] start){
		int left = startPos;
    	int right = start.length - 1;

    	while( left < right ) {
        	// swap the values at the left and right indices
        	int temp = start[left];
        	start[left] = start[right];
        	start[right] = temp;

        	// move the left and right index pointers in toward the center
       	 	left++;
        	right--;
    	}
	}

	public static boolean hasNext(int[] start){
	//test if there is a next
		//iterate through through there is a next there is a bigger n+1
		boolean hasNext = false;
		for(int i = 0; i < start.length-1; i++ ){
			if(start[i] < start[i+1]){
				hasNext = true;
			}
		}
		return hasNext;
		
	}
}
