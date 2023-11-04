import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Objects;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        String str = "";
        Scanner scan = new Scanner(System.in);
        while (!Objects.equals(str, "/")) {
            System.out.println("Введите пример");

            str = scan.nextLine();
            String[] words = str.split(" ");
            int strLen = words.length;
            double amountOfNumbers = Math.ceil((double) strLen / 2);
            int numLen = (int) amountOfNumbers;

            if (strLen % 2 != 0 && strLen >= 3) {
//                ArrayList<Float> nums = new ArrayList<>();
                Hashtable<Integer, Float> nums = new Hashtable<>();
                Hashtable<String, ArrayList<Integer>> operators = new Hashtable<String, ArrayList<Integer>>(4);
                float result = 0;
                boolean flag = true;

                int j = 0;
                for (int i = 0; i < strLen; i += 2) {
                    try {
                        float number = Float.parseFloat(words[i]);
                        nums.put(i, number);
                    } catch (NumberFormatException ex) {
                        System.out.printf("\"%s\" не является числом\n", words[i]);
                        flag = false;
                    }
                }

                ArrayList<Integer> plusList = new ArrayList<>();
                ArrayList<Integer> minusList = new ArrayList<>();
                ArrayList<Integer> multList = new ArrayList<>();
                ArrayList<Integer> divList = new ArrayList<>();

                for (int i = 1; i < strLen; i += 2) {
                    if (words[i].equals("+") || words[i].equals("-") || words[i].equals("*") || words[i].equals("/")) {
                        switch (words[i]) {
                            case ("+"):
                                plusList.add(i);
                                break;
                            case ("-"):
                                minusList.add(i);
                                break;
                            case ("*"):
                                multList.add(i);
                                break;
                            case ("/"):
                                divList.add(i);
                        }
                    }
                    else{
                        System.out.printf("\"%s\" не является оператором\n", words[i]);
                        flag = false;
                    }
                }
//                operators.put("+", plusList);
//                operators.put("-", minusList);
//                operators.put("*", multList);
//                operators.put("/", divList);

                if (!divList.isEmpty()) {
                    for (int index : divList)
                    {
                        // Добавить проверку на деление на ноль
                        float res = nums.get(index - 1) / nums.get(index + 1);
                        nums.remove(index - 1);
                        nums.remove(index + 1);
                        nums.put(index, res);
                    }
                }

                System.out.println(nums.toString());


            }
        }
    }
}