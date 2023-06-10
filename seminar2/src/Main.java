import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        returnFloat();
//        notEmptystring();
                    /*
                    Задание 2
                  */
            int[] intArray = new int[10]; // программа готова к ситуации деления на ноль , но массив не был инициализирован
            try {
               int d = 0; // можно эту переменную сделать float и тогда результат не вызовет экс. а будет nan (как вариант)
               float catchedRes1 = intArray[8] / d;
               System.out.println("catchedRes1 = " + catchedRes1);
            } catch (ArithmeticException e) {
               System.out.println("Catching exception: " + e);
            }



    }

    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }



    public static boolean checkForFloat(String num){
        boolean flag;
        try {
            float fl = Float.parseFloat(num);
            return true;
        }
        catch (Exception e){
            System.out.println("It is not a Float number");
            return false;
        }
    }

    public static float returnFloat(){
        while (true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Vvedite chislo");
            String str = scan.next();
            if(checkForFloat(str)){
                float res = Float.parseFloat(str);
                return res;
            }
        }
    }

    public static void notEmptystring(){
        while (true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a string");
            String str = scan.nextLine();
            if (str.isEmpty()) {
                try {
                    throw new Exception("String is empty");
                } catch (Exception e) {
                    System.out.println("Try again , it is empty string");
                }
            } else {
                break;
            }
        }

    }




}

