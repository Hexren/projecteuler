import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;


public class Aufg13{
	
	public static void main(String[] args) throws Exception{
		BigInteger[] numbers = getNumbers();
		BigInteger foo = BigInteger.ZERO;		
		for(BigInteger number: numbers){
			foo = foo.add(number);
			System.out.println(number);
		}
		System.out.println(foo.toString().substring(0,10));
	}


	public static BigInteger[] getNumbers() throws Exception{
		BigInteger[] numbers = new BigInteger[100];
		BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"));
		String line = null;
		int i = 0;
		while ((line = reader.readLine()) != null) {
    		numbers[i] = new BigInteger(line);
			i++;
		}
		return numbers;
	}

}
