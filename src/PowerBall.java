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
        int[][] playsResult = new int[plays][6];
        while (plays > 0) {
            playGenerator(playsResult[plays - 1]);
            plays--;
        }
        System.out.println("These are what we get for you.The last one is the PowerBall. Good Luck!");
        System.out.println(Arrays.deepToString(playsResult));
    }

    public static void playGenerator(int[] plays) {
        Random generator = new Random();
        int whiteBallCounter = 0;
        while (whiteBallCounter < 5) {
            int whiteBall = generator.nextInt(69) + 1;
            if (!conatains(plays, whiteBall)) {
                plays[whiteBallCounter] = whiteBall;
                whiteBallCounter++;
            }
        }
        plays[whiteBallCounter] = generator.nextInt(26) + 1;
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
}