import java.math.BigInteger;

public class Aufg65{

	public static void main(String[] args){
		BigInteger a = BigInteger.valueOf(2);
        BigInteger h1 = BigInteger.valueOf(1);
        BigInteger h2 = BigInteger.valueOf(1);
        BigInteger k1 = BigInteger.valueOf(1);
        BigInteger k2 = BigInteger.valueOf(0);
        
        int counter = 0;

        //see infinite continued fractions on wikipedia
        for(int i=0; i<10 ;i++){
            BigInteger h = a.multiply(h1).add(h2); 
            BigInteger k = a.multiply(k1).add(k2); 
            
            System.out.println(h + "/" + k);

            
            h2 = h1;
            h1 = h;
            k2 = k1;
            k1 = k;
        }
        System.out.println("Result: " + counter);

    }


}
