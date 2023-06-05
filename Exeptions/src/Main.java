public class Main {
    public static void main(String[] args) {
//        parseString();
//        outofbound();
//        nullpointerEx();
        int[] small = {1,2,3,4,5};
        int[]big = {1,3,4,5,6,7,8};
        thirdTaskMethod(big,small);

    }

    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
        return sum;
    }



    public static void outofbound(){
        String s = "Something";
        System.out.println(s.charAt(16));
        //StringIndexOutOfBoundsException
    }

    public static void nullpointerEx(){
        String s = null;
        s.length();
        //NullPointerException

    }

    public static void parseString(){
        String[] str = {"1","2","3","wrongData"};
        int sum = 0;
        for (int i = 0; i < str.length; i++) {
            sum += Integer.parseInt(str[i]);
        }
        //NumberFormatException

    }

    public static int[] thirdTaskMethod(int[] first , int[]second){
        int[] result = new int[first.length];
            try {
                for (int i = 0; i < first.length; i++) {
                    result[i] = first[i] - second[i];
                }
                return result;
            } catch (RuntimeException e) {
                System.out.println("second array length must be bigger than first array");;
            }
            finally {
                return result;
            }
    }
}