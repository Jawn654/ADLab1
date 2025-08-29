import java.util.*;

/*
    Reproduction Rate = 1.2
    Initial infected = 7
    tuition = 9972
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialInfected = 7;
        double R = 1.2;
        int population = 39740;

        while (true) {
            System.out.print("Enter number of days (or -1 to exit): ");
            int D = scanner.nextInt();

            if (D == -1) {
                break;
            }
            int[] infections = new int[D + 1];
            infections[0] = initialInfected;
            int total = initialInfected;
            int withdrawCount = 7;
            for (int day = 1; day <= D; day++) {
            //each days new cases = yesterdays cases × reproduction rate.
                infections[day] = (int)(R * infections[day - 1]);
                total += infections[day];
                if(day <= 14){
                    withdrawCount += infections[day];
                }
            }
            int percentage = (int)((total * 100.0) / population);
            System.out.println("Total infections after " + D + " days: " + total);
            System.out.println("Percentage of student population infected: " + percentage + "%");
            System.out.println("Total Student Withdrawal: " + withdrawCount + " Students");
            System.out.println("Total refund amount: $" + withdrawCount * 9972);
        }
        }
    }
