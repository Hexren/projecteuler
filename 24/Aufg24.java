import java.util.Arrays;

public class Aufg24{

	public static void main(String[] args){
		int[] start = {0,1,2,3,4,5,6,7,8,9};

		System.out.println("1: " + Arrays.toString(start));
		int i = 1;
		for(i = 1; i < 1000000 && hasNext(start); i++){
			incr(start);
				
		}
		System.out.println(i + ": " + Arrays.toString(start));
			

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
