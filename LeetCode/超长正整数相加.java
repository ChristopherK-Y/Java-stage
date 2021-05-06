package NowCoder;

import java.util.*;

public class 超长正整数相加 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String one = sc.nextLine();
            String another = sc.nextLine();
            System.out.println(AddLongInteger(one, another));
        }
    }

    private static String AddLongInteger(String one, String another) {
        char[] oneArray = one.toCharArray();
        char[] anotherArray = another.toCharArray();
        StringBuffer sb = new StringBuffer();
        /*
         * 这个if-else 会进行判断，第一个for循环执行的是，较短的那个数字，类似于合并两个有序数组的方法。
         * over 在局部是全局的概念，不断的加，就是一个一位的加法器，然后进行了级联。
         */
        if (oneArray.length >= anotherArray.length) {
            int endOfOne = oneArray.length - 1;
            int over = 0;
            for (int i = anotherArray.length - 1; i >= 0; i--, endOfOne--) {
                int x = anotherArray[i] - '0';
                int y = oneArray[endOfOne] - '0';
                int z = x + y + over;
                sb.append(z % 10);
                over = z / 10;
            }
            for (int i = oneArray.length - 1 - anotherArray.length; i >= 0; i--) {
                int x = oneArray[i] - '0';
                int z = x + over;
                sb.append(z % 10);
                over = z / 10;
            }
            if (over != 0) {
                sb.append(over);
            }
        } else {
            int endOfAnother = anotherArray.length - 1;
            int over = 0;
            for (int i = oneArray.length - 1; i >= 0; i--, endOfAnother--) {
                int x = oneArray[i] - '0';
                int y = anotherArray[endOfAnother] - '0';
                int z = x + y + over;
                sb.append(z % 10);
                over = z / 10;
            }
            for (int i = anotherArray.length - 1 - oneArray.length; i >= 0; i--) {
                int x = anotherArray[i] - '0';
                int z = x + over;
                sb.append(z % 10);
                over = z / 10;
            }
            if (over != 0) {
                sb.append(over);
            }
        }
        return sb.reverse().toString();
    }
}
