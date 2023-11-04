import java.util.ArrayList;

public class Solver {
    public void solve(ArrayList<Float> nums, ArrayList<String> operators) {
        int i = operators.size() - 1;
        while (i >= 0) {
            String operator = operators.get(i);
            float firstNum = nums.get(i);
            float secondNum = nums.get(i + 1);

            if (operator.equals("/") || operator.equals("*")) {
                switch (operator) {
                    case "/":
                        if (secondNum != 0) {
                            nums.set(i, firstNum / secondNum);
                            operators.remove(i);
                            nums.remove(i + 1);
                        } else {
                            System.out.println("Деление на ноль");
                            operators.clear();
                            nums.clear();
                            break;
                        }
                        break;
                    case "*":
                        nums.set(i, firstNum * secondNum);
                        operators.remove(i);
                        nums.remove(i + 1);
                        break;
                }
                i--;
            }
            else {
                break;
            }
        }

        i = operators.size() - 1;
        while (i >= 0) {
            String operator = operators.get(i);
            float firstNum = nums.get(i);
            float secondNum = nums.get(i + 1);

            switch (operator) {
                case("+"):
                    nums.set(i, firstNum + secondNum);
                    operators.remove(i);
                    nums.remove(i + 1);
                    break;
                case("-"):
                    nums.set(i, firstNum - secondNum);
                    operators.remove(i);
                    nums.remove(i + 1);
                    break;
            }
            i--;
        }
    }
}
