import java.util.List;
import java.util.ArrayList;
import java.math.BigInteger;

public class Aufg57{

    public static List<Integer> a = new ArrayList<Integer>();
    public static List<Integer> h = new ArrayList<Integer>();
    public static List<Integer> k = new ArrayList<Integer>();

    public static void main(String[] args){
        BigInteger a = BigInteger.valueOf(2);
        BigInteger h1 = BigInteger.valueOf(1);
        BigInteger h2 = BigInteger.valueOf(1);
        BigInteger k1 = BigInteger.valueOf(1);
        BigInteger k2 = BigInteger.valueOf(0);
        int counter = 0;

        //see infinite continued fractions on wikipedia
        for(int i=0; i<1000 ;i++){
            BigInteger h = a.multiply(h1).add(h2); 
            BigInteger k = a.multiply(k1).add(k2); 
            
            if(h.toString().length() > k.toString().length()){
                counter++;
                System.out.println(h + "/" + k);

            }

            h2 = h1;
            h1 = h;
            k2 = k1;
            k1 = k;
        }
        System.out.println("Result: " + counter);

    }
}
