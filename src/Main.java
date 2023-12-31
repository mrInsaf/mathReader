import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Scanner scan = new Scanner(System.in);
        String problem = "";

        while (!problem.equals("/")) {
            System.out.println("Введите пример:");
            problem = scan.nextLine();
            ArrayList<ArrayList> numsAndOperators = parser.parse(problem);

            ArrayList<Float> nums = numsAndOperators.get(1);
            ArrayList<String> operators = numsAndOperators.get(0);

            Solver solver = new Solver(nums, operators);

            solver.solve();

            System.out.println(nums.toString());
        }

    }
}