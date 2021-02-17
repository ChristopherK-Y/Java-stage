import com.sun.istack.internal.NotNull;

public class MyCompareTo {
    String theString;

    public int compareTo(@NotNull String anotherString) {
        char[] thisStringArray = theString.toCharArray();
        char[] anotherStringArray = anotherString.toCharArray();
        try {
            for (int i = 0; i < theString.length(); i++) {
                if (thisStringArray[i] != anotherStringArray[i]) {
                    return thisStringArray[i] - anotherStringArray[i];
                    //如果这里throw ArrayIndexOutOfBoundsException 那么就一定时anotherString太短了，直接返回1就好
                }
            }
            if (anotherString.length() > theString.length()) {
                //所有的长度都比完了，还没有任何的返回，那么就是，要么第二个长，要么相等
                return -1;
            } else {
                return 0;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return 1;
        }
    }

    public MyCompareTo(String theString) {
        this.theString = theString;
    }

    public static void main(String[] args) {
        MyCompareTo string = new MyCompareTo("abcdefghi");
        System.out.println(string.compareTo("Abcdefghi"));
        String theString = new String("abcdefghi");
        System.out.println(theString.compareTo("Abcdefghi"));
    }
}
