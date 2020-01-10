import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


/**
 * @author jinjiantan
 * @version 0.1
 * Lottery is lottery. Life is life.
 */
public class PowerBall {
    public static void main(String[] args) {
        System.out.println("Welcome to the PowerBall numbers generator system!");
        System.out.println("Lottery is just lottery, it is not gambling, don't mess it up with your life!");
        System.out.println("How many plays do you want to get?");
        Scanner sysIn = new Scanner(System.in);
        int plays = sysIn.nextInt();
        //playResult is the multi-dimension arrays to hold the results.
        int[][] playsResult = new int[plays][6];
        int playsCounter = plays;
        while (playsCounter > 0) {
            playGenerator(playsResult[playsCounter - 1]);
            playsCounter--;
        }
        System.out.println("These are what we get for you.The last one is the PowerBall:");
        resultFormatter(playsResult, plays);
        //System.out.println(Arrays.deepToString(playsResult));
    }

    public static void playGenerator(int[] plays) {
        Random generator = new Random();
        int whiteBallCounter = 0;
        // Generate one set of white ball, put them in the place with the index from 0 to 4
        while (whiteBallCounter < 5) {
            int whiteBall = generator.nextInt(69) + 1;
            if (!conatains(plays, whiteBall)) {
                plays[whiteBallCounter] = whiteBall;
                whiteBallCounter++;
            }
        }
        //generate the power ball, and put it into the place with index 5
        plays[whiteBallCounter] = generator.nextInt(26) + 1;
        //sort the white balls.
        Arrays.sort(plays,0,5);
    }

    public static boolean conatains(int[] array, int element) {
        boolean result = false;
        for (int i : array) {
            if (i == element) {
                result = true;
            }
        }
        return result;
    }

    public static void resultFormatter(int[][] playsResult, int plays){
        for ( int playsCounter = 0; playsCounter < plays; playsCounter++ ){
            System.out.print("whiter balls [ ");
            for( int counter = 0; counter < 5; counter ++ ){
                System.out.print(playsResult[playsCounter][ counter ] + (counter == 4 ? "":", "));
            }
            System.out.println(" ] power ball: [ " + playsResult[playsCounter][5] + " ].");
        }
        System.out.println("Good Luck! :)");
    }
    public void versionControlCheck(){

    }
}