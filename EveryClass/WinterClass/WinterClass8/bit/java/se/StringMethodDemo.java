package bit.java.se;

import java.util.Arrays;

public class StringMethodDemo {
    public static void main1(String[] args) {
        String s;

        // 最常见
        s = "Hello";
        s = "Hello" + " " + "World";
        // <=> s = "Hello World"

        s = new String();
        // 构造了一个空的字符串 s = "";
        // 空字符串 != null
        // s = ""  完全两个概念 s = null

        char[] a;
        a = new char[]{'我', '是', '中', '国', '人'};
        s = new String(a);
        // s = "我是中国人"
        System.out.println(s);

        s = new String(a, 1, 2);
        // s = "是中";
        System.out.println(s);

        s = new String("Hello");
        System.out.println(s);

        String t = new String(s);
        System.out.println(t);
    }

    public static void main2(String[] args) {
        String theString = new String("This is Christopher!");
        System.out.println(theString.length());
        for (int i = 0; i < theString.length(); i++) {
            System.out.println(theString.charAt(i));
        }
        System.out.println(Arrays.toString(theString.toCharArray()));
    }

    public static void main3(String[] args) {
        String theString = "我是中国人，我爱中国，我爱中国，我爱中国";
        int index = -1;
        do {
            index = theString.indexOf("我爱", index + 1);
            System.out.println(index);
        } while (index != -1);
    }

    public static void main4(String[] args) {
        String theString = new String("我是中国人，我爱中国，我爱中国，我爱中国");
        System.out.println(theString.substring(theString.indexOf("我"), theString.lastIndexOf("我")));
    }

    public static void main5(String[] args) {
        String theString = new String("我是中国人，我爱中国，我爱中国，我爱中国");
        System.out.println(theString.replace("我", "you"));
        System.out.println(theString.replace('我', '你'));
    }

    public static void main6(String[] args) {
        String theString = new String("我是中国人，我爱中国，我爱中国，我爱中国");
        System.out.println(Arrays.toString(theString.split("我")));

        String ip = new String("192.169.0.1");
        System.out.println(Arrays.toString(ip.split("\\.")));
    }

    public static void main(String[] args) {
        String[] stringArray = {"1", "2", "3", "4"};
        char[] charArray = new char[]{'1','2','3','4'};
        System.out.println(String.join(".",stringArray));
        //System.out.println(String.join(".",charArray));
    }

}
