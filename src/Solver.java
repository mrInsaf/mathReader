import java.util.ArrayList;

public class Solver {
    ArrayList<Float> nums;
    ArrayList<String> operators;

    float firstNum;
    float secondNum;

    public Solver(ArrayList<Float> nums, ArrayList<String> operators) {
        this.nums = nums;
        this.operators = operators;
    }

    public void solve() {
        int i = operators.size() - 1;

        while (i >= 0) {
            String operator = operators.get(i);
            this.firstNum = nums.get(i);
            this.secondNum = nums.get(i + 1);

            if (operator.equals("/") || operator.equals("*")) {
                primaryCalculation(i, operator);
                i--;
            }
            else {
                break;
            }
        }

        i = operators.size() - 1;
        while (i >= 0) {
            String operator = operators.get(i);
            this.firstNum = nums.get(i);
            this.secondNum = nums.get(i + 1);

            secondaryCalculation(i, operator);
            i--;
        }
    }

    private void removeElements(int i) {
        operators.remove(i);
        nums.remove(i + 1);
    }

    private void division(int i) {
        if (secondNum != 0) {
            nums.set(i, firstNum / secondNum);
            removeElements(i);
        } else {
            System.out.println("Деление на ноль");
            operators.clear();
            nums.clear();
        }
    }

    private void multiplication (int i) {
        nums.set(i, firstNum * secondNum);
        removeElements(i);
    }

    private void primaryCalculation (int i, String operator) {
        switch (operator) {
            case "/":
                division(i);
                break;
            case "*":
                multiplication(i);
                break;
        }
    }

    private void secondaryCalculation (int i, String operator) {
        switch (operator) {
            case("+"):
                addition(i);
                break;
            case("-"):
                substraction(i);
                break;
        }
    }

    private void addition (int i) {
        nums.set(i, firstNum + secondNum);
        removeElements(i);
    }

    private void substraction (int i) {
        nums.set(i, firstNum - secondNum);
        removeElements(i);
    }

}
