import java.util.HashMap;
import java.util.Map;
import static java.util.stream.Collectors.*;
import static java.util.stream.IntStream.range;
import java.awt.Point;

public class Aufg66{

    public static void main(String[] args){
        int x = 0;
        for(int d=2; d<=10; d++){
            if(!isSquare(d)){
                x = Math.max(0,findMinX(d));
                System.out.println("D: " + d + " x: " +x);
                //diophantine()
                //System.out.println(diophantine(x,y,13));
            }
        }

        range(2,10).filter(e -> !isSquare(e))
                    .mapToObj(d -> new Point(d, findMinX(d)) ).forEach(e -> System.out.println(e));

    }

//617
    public static int findMinX(int d){
        int y = 1;
        double x = 0;
        while(!isInt(x) || x<1){
            x = getX(y,d);
            
            y++;
            if(x < 0)
                throw new RuntimeException("AHAAHHHAHAHA at: " + d);
   
        }
        return (int)x;
    }

    public static double getX(int y, int d){
        return Math.sqrt(1+d*Math.pow(y,2));
    }


    public static int diophantine(int x, int y, int d){
        return (int) (Math.pow(x,2) - (d * Math.pow(y,2)));
    }

    public static boolean isInt(double d){
        return d == (int)d;
    }

    public static boolean isSquare(double d){
        if(Math.sqrt(d) == (int)Math.sqrt(d)){
            return true;
        }else{
            return false;
        }
    }



}
