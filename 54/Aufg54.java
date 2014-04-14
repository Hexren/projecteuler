import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.lang.Comparable;

public class Aufg54{

    public static void main(String[] args) throws Exception{
        String[] games = getGames();
        int counter1 = 0;
        int counter2 = 0;   
        int tieCounter = 0;
        for(int i=0; i<games.length; i++){
            String[] cards = games[i].split(" ");
            Card[] cardsA;
            Hand hand1 = null;
            Hand hand2 = null;            
         

            cardsA = new Card[5];
            for(int j=0; j<5; j++){
                cardsA[j] = makeCard(cards[j]);
            }
            hand1 = new Hand(cardsA);

            cardsA = new Card[5];
            for(int j=5; j<10; j++){
                cardsA[j-5] = makeCard(cards[j]);
            }
            hand2 = new Hand(cardsA);


            String winner = "";
            if(hand1.getRankedHand().value > hand2.getRankedHand().value){
                counter1++;
                winner = "1";
            }else if(hand1.getRankedHand().value < hand2.getRankedHand().value){
                counter2++;
                winner = "2";
            }
            else{
                tieCounter++;
                if(hand1.highCards.size()>0){
                    boolean solved  = false;
                    for(int c=0; c<hand1.highCards.size(); c++){
                        if(hand1.highCards.get(c).face.value > hand2.highCards.get(c).face.value){
                            counter1++;
                            solved = true;  
                            winner = "1";
                            break;
                        }else if(hand1.highCards.get(c).face.value < hand2.highCards.get(c).face.value){
                            counter2++; 
                            solved = true;
                            winner = "2";
                            break;
                        }
                    }
                    if(!solved){
                        System.out.println("Winner: " + winner);
                        System.out.println(hand1.getRankedHand());
                        System.out.println(hand1);
                        System.out.println(hand2.getRankedHand());
                        System.out.println(hand2);
                        System.out.println("------------------------------------");
                    }
                }else{
                    System.out.println(hand1.getRankedHand());
                    System.out.println(hand1);
                    System.out.println(hand2.getRankedHand());
                    System.out.println(hand2);
                    System.out.println("------------------------------------");
                }
            }

         /*
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

        */
            
            RankHand interest = RankHand.ROYALFLUSH;

            if(hand1.getRankedHand() == interest || hand2.getRankedHand() == interest){
                System.out.println("Winner: " + winner);
                System.out.println(hand1.getRankedHand());
                System.out.println(hand1);
                System.out.println(hand2.getRankedHand());
                System.out.println(hand2);
                System.out.println("------------------------------------");
            }


        }  
            System.out.println("Counter 1: " + counter1);
            System.out.println("Counter 2: " + counter2); 
            System.out.println("TieCounter 2: " + tieCounter);  
    }

	public static String[] getGames() throws Exception{
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
        public List<Card> highCards = new ArrayList<Card>();

        public Hand(Card[] cards){
            this.cards = new ArrayList<Card>(Arrays.asList(cards));
            Collections.sort(this.cards);
        }
        
        public String toString(){
            String res = "";
            return cards.toString();
        }

        public boolean isFlush(){
            for(int i=1; i<cards.size(); i++){
                if(cards.get(0).suit != cards.get(i).suit)
                    return false;
            }
            return true;
        }
    
        public boolean isRoyalFlush(){
            if(cards.get(0).face != Face.TEN)
                return false;
            if(cards.get(1).face != Face.JACK)
                return false;
            if(cards.get(2).face != Face.QUEEN)
                return false;
            if(cards.get(3).face != Face.KING)
                return false;
            if(cards.get(4).face != Face.ACE)
                return false;

            if(!isFlush())
                return false;
            return true;
        }

        public boolean isStraight(){
            for(int i=1; i<cards.size(); i++){
                if(cards.get(i-1).face.value != cards.get(i).face.value-1)
                    return false;
            }
            return true;
        }

        public boolean isStraightFlush(){
            return isStraight() && isFlush();
        }

        public boolean isFourOfAKind(){
            int counter = 0;
            
            for(int i=0; i<cards.size(); i++){
                int tmpCounter = 0;
                for(int j=i; j<cards.size(); j++){
                    if(cards.get(i).face == cards.get(j).face)
                        tmpCounter++;
                }
                
                counter = Math.max(tmpCounter, counter);
            }
            if(counter == 4)
                return true;
            else
                return false;
        }

        public boolean isThreeOfAKind(){
            int counter = 0;
            
            for(int i=0; i<=cards.size(); i++){
                int tmpCounter = 0;
                for(int j=i; j<cards.size(); j++){
                    if(cards.get(i).face == cards.get(j).face)
                        tmpCounter++;
                }
                counter = Math.max(tmpCounter, counter);
            }
            if(counter == 3)
                return true;
            else
                return false;
        }



        public boolean isFullHouse(){
            boolean three = false;
            boolean pair = false;
            List<Card> tmpCards = new ArrayList<Card>(cards);

            for(int i=0; i<=tmpCards.size(); i++){
                int tmpCounter = 0;
                for(int j=i; j<tmpCards.size(); j++){
                    if(tmpCards.get(i).face == tmpCards.get(j).face)
                        tmpCounter++;
                }
                if(tmpCounter==3){
                    tmpCards.remove(i);
                    tmpCards.remove(i);
                    tmpCards.remove(i);
                    three = true;
                    break;
                }
            }
            if(tmpCards.get(0).face == tmpCards.get(1).face){
                pair = true;

            }
            if(pair && three)
                return true;
            else
                return false;
        }

        public boolean isTwoPairs(){
            int counter = 0;

            for(int i=0; i<cards.size()-1; i++){
                if(cards.get(i).face == cards.get(i+1).face){
                        counter++;
                }
                
            }     
            if(counter == 2)
                return true;
            else
                return false;
        }


        public boolean isPair(){
            int counter = 0;

            for(int i=0; i<cards.size()-1; i++){
                if(cards.get(i).face == cards.get(i+1).face){
                        counter++;
                        highCards.add(cards.get(i));
                }
                
            }   
            Collections.sort(highCards);
            Collections.reverse(highCards);  
            if(counter == 1)
                return true;
            else
                return false;
        }


        public RankHand getRankedHand(){
            if(isRoyalFlush())
                return RankHand.ROYALFLUSH;
            if(isStraightFlush())
                return RankHand.STRAIGHTFLUSH;
            if(isFourOfAKind())
                return RankHand.FOUROFAKIND;
            if(isFullHouse())
                return RankHand.FULLHOUSE;
            if(isStraight())
                return RankHand.STRAIGHT;
            if(isThreeOfAKind())
                return RankHand.THREEOFAKIND;
            if(isTwoPairs())
                return RankHand.TWOPAIR;
            if(isPair())
                return RankHand.ONEPAIR;

            highCards.addAll(cards);
            Collections.sort(highCards);
            Collections.reverse(highCards);
            return RankHand.HIGHCARD;
        }

    }

    public static enum RankHand {
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
        RankHand(int value){
            this.value = value;
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

        public Integer value;
        Face(Integer value){
            this.value = value;
        }    
 
    }

    public static class Card implements Comparable<Card>{
        public Face face;
        public Suit suit;
        public Card(Face face, Suit suit){
            this.face = face;
            this.suit = suit;
        }

 	    public int compareTo(Card o){
            return this.face.value.compareTo(o.face.value);
        }

        public String toString(){
            return face.toString() + " " + suit.toString();
        }

    }

    public static enum Suit {
        CLUB, 
        DIAMOND, 
        HEART, 
        SPADE;

        public String toString(){
            return this.name();//Integer.toString(value);
        }

    }



    public static Card makeCard(String s){
        Face face;
        Suit suit;

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

        switch(s.charAt(1)){
        case 'C': suit = Suit.CLUB; 
                  break;
        case 'D': suit = Suit.DIAMOND; 
                  break;
        case 'H': suit = Suit.HEART; 
                  break;
        case 'S': suit = Suit.SPADE; 
                  break;
        default: 
            throw new RuntimeException("FUUUUU");
        }

        return new Card(face, suit);
    }






}

