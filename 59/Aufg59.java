import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Aufg59{

	public static void main(String[] args) throws Exception{

		char[] chars = getChars();
		char[] key = new char[]{(char)107,(char)107,(char)107};
		//97 - 122		
		for(int a=97; a <= 122; a++){
			key[0] = (char)a;
			for(int b=97; b <= 122; b++){
				key[1] = (char)b;
				for(int c=97; c <= 122; c++){
					key[2] = (char)c;
					String text = new String(decrypt(key,chars));
					if(text.contains("the") && text.contains("and") && text.contains("tha")){
						System.out.println(text);
						int sum = 0;
						for(char ch: decrypt(key,chars)){
							sum += ch;
						}
						System.out.println(sum);
					}
				}
			}
		}
		
		
	}

	public static char[] decrypt(char[] key, char[] text){
		char[] decry = new char[text.length];
		for(int i=0; i<text.length; i++){
			decry[i] = (char)(text[i] ^ key[i%key.length]);
		}
		return decry;
	}


	public static char[] getChars() throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader("cipher1.txt"));
		String words = "";
		String line;
		while ((line = reader.readLine()) != null) {
    		words += line;
		}
		int i = 0;
		char[] chars = new char[words.split(",").length];
		for(String chara: words.split(",")){
			int x = Integer.valueOf(chara);
			chars[i] = (char)x;			
			i++;
		}
		return chars;
	}


}
