import java.math.BigInteger;

public class Aufg20{

	public static void main(String[] args){
		String fac =  fac(100).toString();
		long res = 0L;
		for(int i = 0; i < fac.length(); i++){
			res = res + new Integer(fac.substring(i,i+1));
		}
		System.out.println(res);
	}


	public static BigInteger fac(int n){
		BigInteger fac = BigInteger.valueOf(1);		
		for(int i=1; i<=n; i++){
			fac = fac.multiply(BigInteger.valueOf(i));
		}
		return fac;
	}


}
