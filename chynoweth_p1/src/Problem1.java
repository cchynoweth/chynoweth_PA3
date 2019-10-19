import java.security.SecureRandom;
import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int runs = 0;
        int numCorrect = 0;

        // scan in chosen difficulty level
        System.out.println("Enter a level of difficulty: ");
        int difficulty = in.nextInt();

        // scan in chosen arithmetic level
        System.out.println("Enter a type of arithmetic: ");
        int arithmetic = in.nextInt();

        // while loop runs for 10 questions
        while (runs < 10) {
            // generates a question using the chosen difficulty and arithmetic level
            // if answer is correct, adds 1 to numCorrect
            numCorrect += generateQuestion(difficulty, arithmetic);
            runs++;
        }

        // calculate grade percent by dividing numCorrect by 10
        // then give proper response depending on grade
        double grade = numCorrect / 10.0;
        if (grade < .75) {
            System.out.println("Please ask your teacher for extra help.");
        } else {
            System.out.println("Congratulations, you are ready to go on to the next level!");
        }
    }

    private static int generateQuestion(int difficulty, int arithmetic) {
        SecureRandom rand = new SecureRandom();

        int rand_int1;
        int rand_int2;

        // switch case generates larger random numbers depending on difficulty
        switch (difficulty) {
            default: // default to single digit numbers in the case of difficulty < 1 or difficulty > 4
                rand_int1 = rand.nextInt(9) + 1;
                rand_int2 = rand.nextInt(9) + 1;
                break;
            case 2:
                rand_int1 = rand.nextInt(99) + 1;
                rand_int2 = rand.nextInt(99) + 1;
                break;
            case 3:
                rand_int1 = rand.nextInt(999) + 1;
                rand_int2 = rand.nextInt(999) + 1;
                break;
            case 4:
                rand_int1 = rand.nextInt(9999) + 1;
                rand_int2 = rand.nextInt(9999) + 1;
                break;
        }

        double realAns;

        // switch statement generates realAns and asks question depending on chosen arithmetic
        switch (arithmetic) {
            default: // default to addition in case of arithmetic < 1 or arithmetic > 4
                realAns = rand_int1 + rand_int2;
                System.out.printf("How much is %d plus %d?\n", rand_int1, rand_int2);
                break;
            case 2:
                realAns = rand_int1 * rand_int2;
                System.out.printf("How much is %d times %d?\n", rand_int1, rand_int2);
                break;
            case 3:
                realAns = rand_int1 - rand_int2;
                System.out.printf("How much is %d minus %d?\n", rand_int1, rand_int2);
                break;
            case 4:
                realAns = rand_int1 / (double)rand_int2;
                System.out.printf("How much is %d divided by %d?\n", rand_int1, rand_int2);
                break;
        }
        // returns 1 if answer is correct, 0 if incorrect
        return checkAnswer(realAns);
    }
    private static int checkAnswer(double realAns) {
        SecureRandom rand = new SecureRandom();
        Scanner in = new Scanner(System.in);

        // read in student answer
        double studentAns = in.nextDouble();

        // generates an integer to be used in generating a random response
        int rand_response = rand.nextInt(4);

        // compare studentAns to realAns using a ~large margin of error (elementary school)
        if (Math.abs(studentAns - realAns) > .01) {
            // switch statement to generate a randomized response
            switch (rand_response) {
                case 0:
                    System.out.println("No. Please try again.");
                    break;
                case 1:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 2:
                    System.out.println("Don't give up!");
                    break;
                case 3:
                    System.out.println("No. Keep trying.");
                    break;
            }
            return 0;
        }
        else {
            switch (rand_response) {
                case 0:
                    System.out.println("Very good!");
                    break;
                case 1:
                    System.out.println("Excellent!");
                    break;
                case 2:
                    System.out.println("Nice work!");
                    break;
                case 3:
                    System.out.println("Keep up the good work!");
                    break;
            }
            return 1;
        }
    }
}
