package NowCoder;

public class StrToInt {
    public int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int symbol = 1;//符号处理，如果存在正负号，那么符号弄好之后，把该字符删除
        if (str.charAt(0) == '-') {
            symbol = -symbol;
            str = str.substring(1);
        } else if (str.charAt(0) == '+') {
            str = str.substring(1);
        }
        int length = str.length();
        int ans = 0;
        for (int i = 0; i < length; i++) {//依次遍历，然后计算数值，如果遇到不是数字的数，就直接返回0
            char oneNumber = str.charAt(i);
            if (!Character.isDigit(oneNumber)) {
                return 0;
            } else {
                ans = ans * 10 + (oneNumber - '0');
            }
        }
        return ans * symbol;
    }

    public static void main(String[] args) {
        System.out.println(new StrToInt().strToInt("1a123"));
    }
}
