//实现方法 replace, 能够替换字符串中的某个部分
public class MyReplace {
    String theString;

    public String myReplace(char oldChar, char newChar) {
        if (oldChar == newChar) {//如果新老字符是一样的，那么就不需要，进行任何的修改，那么就直接返回当前的字符串即可
            return this.theString;
        }
        char[] charArray = theString.toCharArray();
        for (int i = 0; i < charArray.length; i++) {//遍历，如果找到了一个oldChar，那么直接返回就好了
            if (charArray[i] == oldChar) {
                charArray[i] = newChar;
            }
        }
        return new String(charArray);//将replace过的字符数组转为字符串返回就好了
    }

    public MyReplace(String theString) {
        this.theString = theString;
    }

    public static void main(String[] args) {
        MyReplace string = new MyReplace("111222333444");
        System.out.println(string.myReplace('1', 'R'));
    }
}
