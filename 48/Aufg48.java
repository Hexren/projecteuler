import java.math.BigInteger;

public class Aufg48{
    public static void main(String[] args){
        BigInteger result = BigInteger.ZERO; 
        for(int i = 1; i <= 1000; i++){
            BigInteger bi = BigInteger.valueOf(i);
            result = result.add(bi.pow(i));
        }
        String sr = result.toString();
        System.out.println(sr.substring(sr.length()-10));
    }
}
