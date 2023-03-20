import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception{

        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = scn.nextLine();

        int actionIndex=-1;
        int colActions=0;
        for (int i = 0; i < exp.length();i++) {
            if(exp.contains(actions[i])){
                actionIndex = i;
                colActions++;}
            if (colActions > 2) throw new Exception("Количество знаков действия не может быть больше 1");

        }

        if(actionIndex==-1){
            throw new Exception("Некорректное выражение");
            //return;
        }

        String[] data = exp.split(regexActions[actionIndex]);

        if(converter.isRoman(data[0]) == converter.isRoman(data[1])) {
            int a, b;

            boolean isRoman = converter.isRoman(data[0]);
            if (isRoman) {

                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);

            } else {

                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }

            if (a > 10 || b > 10) throw new Exception("Число больше 10, введите другое");
            else {
                int result;
                switch (actions[actionIndex]) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    default:
                        result = a / b;
                        break;
                }

                if (isRoman) {
                    if (result > 0) {
                        System.out.println(converter.intToRoman(result));
                    } else throw new Exception("В римской системе нет отрицательных чисел");
                } else {
                    System.out.println(result);
                }
            }
        }else{
            throw new Exception("Числа должны быть в одном формате");
        }


    }
}
