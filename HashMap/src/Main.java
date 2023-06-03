public class Main {
    public static void main(String[] args) {
        Mapa<Integer,String> dict = new Mapa<>();
        dict.put(2,"one");
        dict.put(1,"second");
        dict.put(5,"john");
        dict.put(7,"carl");
        System.out.println(dict.remove(7));
//        System.out.println(dict.get(7));
        System.out.println(dict.size());

        System.out.println(dict.containsKey(2));
        System.out.println(dict.containsValue("ssssssr"));










    }
}