import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.showmeList();
        System.out.println();
        list.reverse(list).showmeList();
    }
}