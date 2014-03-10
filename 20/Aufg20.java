import java.math.BigInteger;

public class Aufg20{

	public static void main(String[] args){
		String fac =  fac(100).toString();
		for(int i = 0; i < fac.length(); i++){
			System.out.println(new Integer(fac.substring(i,i+1)));
		}

	}


	public static BigInteger fac(int n){
		BigInteger fac = BigInteger.valueOf(1);		
		for(int i=1; i<=n; i++){
			fac = fac.multiply(BigInteger.valueOf(i));
			System.out.println(fac);
		}
		return fac;
	}


}
