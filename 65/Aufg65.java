import java.math.BigInteger;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class Aufg65{

    public static int x = 1;
        

	public static void main(String[] args){
		BigInteger a;
        BigInteger h1 = BigInteger.valueOf(1);
        BigInteger h2 = BigInteger.valueOf(0);
        BigInteger k1 = BigInteger.valueOf(0);
        BigInteger k2 = BigInteger.valueOf(1);
        BigInteger h = null;
        BigInteger k = null;

        int counter = 0;
        //see infinite continued fractions on wikipedia
        for(int i=1; i<=100 ;i++){
            //System.out.println(contFracE(i));          
            a = BigInteger.valueOf(contFracE(i));

            h = a.multiply(h1).add(h2); 
            k = a.multiply(k1).add(k2); 
            
            //System.out.println(h + "/" + k);
            
            h2 = h1;
            h1 = h;
            k2 = k1;
            k1 = k;

        }
        
        int res = 0;
        for(Integer i: toDigits(h)){
            res += i;
        }

        System.out.println("Result: " + res);

    }

    //see http://oeis.org/A003417
    public static int contFracE(int n){
        if(n==1)
            return 2;        
        if(n%3==0)
            return (n/3)*2;
        else
            return 1;
    }

    public static List<Integer> toDigits(BigInteger n){
		List<Integer> digits = new ArrayList<Integer>();

		while(n.compareTo(BigInteger.ZERO) > 0){
			digits.add(n.mod(BigInteger.TEN).intValue());
			n = n.divide(BigInteger.TEN);
		}
		Collections.reverse(digits);
		return digits;
	}

}
