public class FindPeople {
    public static void personNames(String[] array) {
        for (String temp : array) {
            if (temp.startsWith("孙") && temp.length() == 2) {
                System.out.println(temp);
            }
        }
    }

    public static void main(String[] args) {
        String[] array = {"孙一", "孙二X", "李三", "王五", "孙六X", "孙七"};
        personNames(array);

    }
}
