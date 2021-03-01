package NowCoder;

//https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec?tpId=13&tqId=11196&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class LeftRotateString {
    public String leftRotateString(String str, int n) {
        if (str.length() == 0) {
            return str;
        }
        n %= str.length();
        if (n == 0) {
            return str;
        }
        char[] array = str.toCharArray();
        StringBuilder newString = new StringBuilder();
        for (int i = n; i < str.length(); i++) {
            newString.append(array[i]);
        }
        for (int i = 0; i < n; i++) {
            newString.append(array[i]);
        }
        return new String(newString);
    }

    public static void main(String[] args) {
        System.out.println(new LeftRotateString().leftRotateString("abcXYZdef", 3));
    }
}
