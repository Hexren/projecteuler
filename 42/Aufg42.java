import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Aufg42{

	static List<Integer> cache = new ArrayList<Integer>();
	static{
		cache.add(1);
		}
	public static void main(String[] args) throws Exception{
		String[] words = getWords();
		for(int i = 0; i < words.length; i++){
			words[i] = words[i].replace("\"", "");
		}
		
		long res = 0;
		for(int i = 0; i < words.length; i++){
			if(isTriangleNumber(wordCharValue(words[i]))){
				System.out.println(words[i] + " = " + wordCharValue(words[i]));
				res++;			

			}
		}
		System.out.println(res);
	}

	public static boolean isTriangleNumber(int n){
		int i = 1;
		int t = 0;
		if(Collections.max(cache) > n){
			if(cache.contains(n))
				return true;
			else
				return false;
		}
		
		do{
			
			t = (int) (0.5*i*(i+1));
			if(!cache.contains(t))		
				cache.add(t);

			if(t == n)
				return true;
			i++;
		}while(t < n);
		return false;
	}

	public static int wordCharValue(String word) throws Exception{
		int sum = 0;
		for(Character ch: word.toCharArray()){
			//value is asci code - 64 that is the position in the alphabet
			sum = sum + (int)ch - 64;
		}
		
		return sum;
	}


	public static String[] getWords() throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader("words.txt"));
		String words = "";
		String line;
		while ((line = reader.readLine()) != null) {
    		words += line;
		}
		return words.split(",");
	}
}
