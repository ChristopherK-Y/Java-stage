public class Demo {
    public static void main(String[] args) {
        String theString = new String("Hello world!");

        //contains(包含)
        System.out.println(theString.contains("world"));
        System.out.println(theString.contains("false"));

        //startsWith/endsWith
        System.out.println(theString.startsWith("Hello"));
        System.out.println(theString.startsWith("hello"));
        System.out.println(theString.endsWith("world"));
        System.out.println(theString.endsWith("world!"));

        //concat/+
        System.out.println(theString + "+++++");
        System.out.println(theString.concat("+++++"));

        //isEmpty() <==> length() == 0
        System.out.println(theString.isEmpty());
        System.out.println(theString.length() == 0);

        //trim(修剪)
        System.out.println("/n/t/r test");
        System.out.println("/n/t/r test".trim());
    }
}
