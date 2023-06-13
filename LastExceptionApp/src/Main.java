import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try{
            writetofile(checkInputData(InputData()));
        }
        catch (IOException | ArrayIndexOutOfBoundsException e){
            System.out.println("Please try put correct data");
            e.getStackTrace();
        }
    }

    public static String[] InputData(){      // Вводим данные одновременно ожидая неправильное колличество этих данных
        System.out.println("Please input data : Name,Surname,Patronymic Birthdate phone gender");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] res = str.split(" ");
        try {
            if(res.length!=4){
                throw new WrongInputSizeException();
            }
        }
        catch (WrongInputSizeException e){
            System.out.println("Its wrong size of input data, must be 4 types");
        }
        return res;
    }


    // "\\d{11}" - поиск телефон "\b(m|f){1}\b" - поиск пола
    //   "\b[A-Z][a-z]+\S\b" - FIO    (0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((19|20)\d\d) - дата рождения
    public static String FindNumber(String s){    // Методы найдиФИО и другие "найди" в случае неверного формата все ровно возвращают пустую строку
        String res = "";                               // и на этапе записи в фаил метод записи проверит колличество элементов и запишет только если их 4.
        Pattern p = Pattern.compile("\\d{11}");
        Matcher m = p.matcher(s);
        while(m.find()){
            res = res + s.substring(m.start(), m.end());
        }
        try {
            if(res.length()==0){
                throw new WrongFormatDataExeption();
            }
        }
        catch (WrongFormatDataExeption e){
            System.out.println("Wrong number data format");
        }
        return res;
    }
    public static String findFIO(String s){
        String res = "";
        Pattern p = Pattern.compile("\\b[A-Z][a-z]+\\S\\b");
        Matcher m = p.matcher(s);
        while(m.find()){
            res = res + s.substring(m.start(), m.end());
        }
        try {
            if(res.length()==0){
                throw new WrongFormatDataExeption();
            }
        }
        catch (WrongFormatDataExeption e){
            System.out.println("Wrong FIO data format");
        }
        return res;
    }

    public static String findGender(String s) {
        String res = "";
        Pattern p = Pattern.compile("\\b(m|f){1}\\b");
        Matcher m = p.matcher(s);
        while(m.find()){
            res = res + s.substring(m.start(), m.end());
        }
        try {
            if(res.length()==0){
                throw new WrongFormatDataExeption();
            }
        }
        catch (WrongFormatDataExeption e){
            System.out.println("Wrong gender data format");
        }
        return res;
    }

    public static String findDate(String s){
        String res = "";
        Pattern p = Pattern.compile("(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((19|20)\\d\\d)");
        Matcher m = p.matcher(s);
        while(m.find()){
            res = res + s.substring(m.start(), m.end());
        }
        try {
            if(res.length()==0){
                throw new WrongFormatDataExeption();
            }
        }
        catch (WrongFormatDataExeption e){
            System.out.println("Wrong birthdate data format");
        }
        return res;
    }

    public static String checkInputData(String[] arr){        // формируем правильную строку из данных (порядок)
        String str = String.join(" ",arr);
        String res = findFIO(str) + " " +findDate(str) +" "+ FindNumber(str) + " " + findGender(str);
        return res;
    }


    public static void writetofile(String str) throws IOException,ArrayIndexOutOfBoundsException  {  // запись в фаил
        String[] arr = str.split(" ");   // при ситуации когда
        if(arr.length==4){
            String[] arrLower = arr[0].split(",");
            String name = arrLower[0];
            File file = new File( name + ".txt");
            FileWriter fw = new FileWriter(file, true);
            fw.write(EditingStr(str)+'\n');
            fw.close();
        }

    }

    public static String EditingStr(String str){ // Добавляем скобочки для записи в фаил
        String[] arr = str.split(" ");
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = "<"+arr[i]+">";
        }
        String res = String.join("", arr);
        return res;
    }






}