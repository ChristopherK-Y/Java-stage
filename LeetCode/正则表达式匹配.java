package NowCoder;

/*
**********************************此题和字符串通配符不一样，完全不一样***********************************************
https://www.nowcoder.com/practice/28970c15befb4ff3a264189087b99ad4
 */
public class 正则表达式匹配 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str string字符串
     * @param pattern string字符串
     * @return bool布尔型
     */
    public boolean match (String str, String pattern) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }
        // 一对一匹配 或 .
        boolean match = (str.length() > 0 && (str.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.'));
        // 有*
        if (pattern.length() > 1 && pattern.charAt(1) == '*') {
            // 0个 || 多个
            return match(str, pattern.substring(2)) || (match && match(str.substring(1), pattern));
        }
        // 无*
        else {
            return match && match(str.substring(1), pattern.substring(1));
        }

    }
}
