import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str = "";
        Scanner scan = new Scanner(System.in);
        while(!Objects.equals(str, "/"))
        {
            System.out.println("Введите пример");
            float a, b;
            String operation;

            str = scan.nextLine();
            String[] words = str.split(" ");
            if (words.length == 3)
            {
                try
                {
                    a = Integer.parseInt(words[0]);
                    b = Integer.parseInt(words[2]);
                    operation = words[1];
                    switch (operation)
                    {
                        case "+":
                            System.out.println(a + b);
                            break;
                        case "-":
                            System.out.println(a - b);
                            break;
                        case "*":
                            System.out.println(a * b);
                            break;
                        case "/":
                            System.out.println(a / b);
                            break;
                        default:
                            System.out.println("Вы ввели некорректную операцию");

                    }
                }
                catch (Exception e)
                {
                    System.out.println("Введите пример в формате число1 операция число2 \n");
                }
            }
            else
            {
                System.out.println("Введите пример в формате число1 операция число2\n");
            }
        }
    }
}