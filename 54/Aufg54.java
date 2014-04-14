import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Aufg54{

    public static void main(String[] args) throws Exception{
        String[] games = getWords();
        for(int i=0; i<1; i++){
            String[] cards = games[i].split(" ");            
            for(int j=0; j<cards.length; j++){
                System.out.println(cards[j]);                
                Card card = makeCard(cards[j]);
                System.out.println(card.toString());
            }
        }  
    }

	public static String[] getWords() throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader("poker.txt"));
		String[] games = new String[1000];
		String line;
        int i = 0;
		while ((line = reader.readLine()) != null) {
    		games[i] = line;
            i++;
       }
		return games;
	}

    public static class Hand{
        public List<Card> cards;

        public Hand(Card[] cards){
            this.cards = new ArrayList<Card>(Arrays.asList(cards));
        }
    }

    public static enum RANKHAND {
        ROYALFLUSH(10), 
        STRAIGHTFLUSH(9), 
        FOUROFAKIND(8), 
        FULLHOUSE(7),
        FLUSH(6),
        STRAIGHT(5),
        THREEOFAKIND(4),
        TWOPAIR(3),
        ONEPAIR(2),
        HIGHCARD(1);

        public String toString(){
            return this.name();//Integer.toString(value);
        }

        public int value;
        Face(int value){
            this.value = value;
        }    
 
    }

    public static Card makeCard(String s){
        Face face;
        switch(s.charAt(0)){
        case 'A': face = Face.ACE; 
                  break;
        case 'K': face = Face.KING; 
                  break;
        case 'Q': face = Face.QUEEN; 
                  break;
        case 'J': face = Face.JACK; 
                  break;
        case 'T': face = Face.TEN; 
                  break;
        case '9': face = Face.NINE; 
                  break;
        case '8': face = Face.EIGTH; 
                  break;
        case '7': face = Face.SEVEN; 
                  break;
        case '6': face = Face.SIX; 
                  break;
        case '5': face = Face.FIVE; 
                  break;
        case '4': face = Face.FOUR; 
                  break;
        case '3': face = Face.THREE; 
                  break;
        case '2': face = Face.TWO; 
                  break;
        default: 
            throw new RuntimeException("FUUUUU");
        }
        return new Card(face);
    }

    public static class Card{
        public Face face;
        public Card(Face face){
            this.face = face;
        }

        public String toString(){
            return face.toString();
        }

    }



    public static enum Face {
        ACE(14), 
        KING(13), 
        QUEEN(12), 
        JACK(11),
        TEN(10),
        NINE(9),
        EIGTH(8),
        SEVEN(7),
        SIX(6),
        FIVE(5),
        FOUR(4),
        THREE(3),    
        TWO(2);

        public String toString(){
            return this.name();//Integer.toString(value);
        }

        public int value;
        Face(int value){
            this.value = value;
        }    
 
    }

}

