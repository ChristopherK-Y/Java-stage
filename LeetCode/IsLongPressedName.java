package day05;

//https://leetcode-cn.com/problems/long-pressed-name/
public class IsLongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length() || name.charAt(0) != typed.charAt(0) || name.charAt(name.length() - 1) != typed.charAt(typed.length() - 1)) {
            return false;//长度不同-开头不同-结尾不同都是不可以的，直接返回false
        }
        int nPtr = 0;
        int tPtr = 0;
        while (tPtr < typed.length() && nPtr < name.length()) {
            if (name.charAt(nPtr) == typed.charAt(tPtr)) {
                nPtr++;
            } else if (typed.charAt(tPtr) != typed.charAt((tPtr - 1))) {
                return false;
            }
            tPtr++;
        }
        if (nPtr == name.length() && isOk(typed, tPtr - 1)) {
            return true;
        }
        return false;
    }

    private boolean isOk(String typed, int index) {//如果name指针那边走完了，那么typed剩下的字母必须全部都要相等
        char original = typed.charAt(index);
        for (int i = index + 1; i < typed.length(); i++) {
            if (typed.charAt(i) != original) {
                return false;
            }
        }
        return true;
    }
}
