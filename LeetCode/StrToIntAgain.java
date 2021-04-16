package NowCoder;

public class StrToIntAgain {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] array = str.toCharArray();
        int symbol = 1;
        long ans = 0;
        int i = 0;
        if (array[0] == '-') {
            symbol = -1;
            i++;
        } else if (array[0] == '+') {
            //symbol = 1;
            i++;
        }
        for (; i < array.length; i++) {
            if (Character.isDigit(array[i])) {
                ans = ans * 10 + (array[i] - '0');
            } else {
                return 0;
            }
        }
        ans = symbol * ans;
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new StrToIntAgain().StrToInt("21474"));

    }
}
