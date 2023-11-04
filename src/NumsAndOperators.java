import java.util.ArrayList;

public class NumsAndOperators {
    private ArrayList<Float> nums;
    private ArrayList<String> operators;

    public NumsAndOperators(ArrayList<Float> nums, ArrayList<String> operators) {
        this.nums = nums;
        this.operators = operators;
    }

    public ArrayList<Float> getNums() {
        return this.nums;
    }

    public ArrayList<String> getOperators() {
        return this.operators;
    }
}
