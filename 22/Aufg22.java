import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;

public class Aufg22{

	public static void main(String[] args) throws Exception{
		List<String> words = getWords();
		Collections.sort(words);
		long sum = 0L;
		for(int i = 0; i < words.size(); i++){
			
			System.out.println(words.get(i));
			sum += wordCharValues(words.get(i)) * (i+1);
		}
		System.out.println(sum);
	}


	public static List<String> getWords() throws Exception{
		List<String> words = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader("names.txt"));
		String line = null;
		
		StringBuilder sb = new StringBuilder();
		while ((line = reader.readLine()) != null) {	
			for(String word: line.split(",")){
				words.add(words.size(), word.replace("\"",""));
			}
		}
		
		return words;
	}


	public static int wordCharValues(String word) throws Exception{
		int sum = 0;
		for(Character ch: word.toCharArray()){
			//value is asci code - 64 that is the position in the alphabet
			sum = sum + (int)ch - 64;
		}
		
		return sum;
	}


}
