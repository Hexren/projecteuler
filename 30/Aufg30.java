import java.util.Arrays;


public class Aufg30{

	public static void main(String[] args){
		int res = 0;
		//loop over numbers smaller 413348
		for(int i = 2; i <= 1111111; i++){
			int[] digits = toDigits(i);
			int added = addPowerOf(digits, 5);
			if(added == i)
				res += added;

		}
		System.out.println(res);
		//getNumberDigits
		//add digists exp 5
		//compare

	}

	public static int addPowerOf(int[] digits, int exp){
		int res = 0;		
		for(int i = 0; i < digits.length; i++){
			res += Math.pow(digits[i], exp);
		}
		return res;

	}

	public static int[] toDigits(int n){
		int len = String.valueOf(n).length();		
		int[] numbers = new int[len];
		
		for(int i = len-1; i >=0; i--){
			numbers[i] = n%10;
			n = n/10;
		}
		return numbers;
	}

}
