import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;

public class Parser {

    public ArrayList<ArrayList> parse(String problem) {
        String [] problemElements = extractElements(problem);
        ArrayList<String> operators = extractOperators(problemElements);
        ArrayList<Float> numbers = extractNumbers(problemElements);

        return new ArrayList<>(Arrays.asList(operators, numbers));
    }
    public String[] extractElements(String problem) {
        return problem.split(" ");
    }

    public ArrayList<Float> extractNumbers(String [] problemElements) {
        ArrayList<Float> numbers = new ArrayList<>();

        for (int i = 0; i < problemElements.length; i += 2) {
            String element = problemElements[i];
            try {
                float number = Float.parseFloat(element);
                numbers.add(number);
            }
            catch (NumberFormatException e) {
                numbers = new ArrayList<>();
                System.out.printf("%s не является числом", element);
                break;
            }
        }
        return numbers;
    }

    public ArrayList<String> extractOperators(String [] problemElements) {
        ArrayList<String> operators = new ArrayList<>();
        ArrayList<String> operatorList = new ArrayList(Arrays.asList("+", "-", "*", "/"));

        for (int i = 1; i < problemElements.length; i += 2) {
            String element = problemElements[i];
            if (operatorList.contains(element)) {
                operators.add(element);
            }
            else {
                operators = new ArrayList<>();
                System.out.printf("\"%s\" не является оператором\n", element);
                break;
            }
        }
        return operators;
    }


}

