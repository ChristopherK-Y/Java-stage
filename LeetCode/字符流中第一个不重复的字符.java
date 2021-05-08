package NowCoder;

import java.util.*;

/*
https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720
 */
public class 字符流中第一个不重复的字符 {
    HashSet<Character> set = new HashSet<>();//存已经遍历的所有字符，单个的
    ArrayList<Character> ans = new ArrayList<>();//存储现在出现的单个字符

    {
        ans.add('#');//初始化
    }

    public void Insert(char ch) {
        if (set.add(ch)) {//如果可以插入，说明首次出现即为单个,那么插入ans
            ans.add(ch);
        } else {//不可以插入说明已经存在，那么从ans中删除，ans中的每一个字符都是只出现了一次
            ans.remove((Character) ch);
        }
    }

    public char FirstAppearingOnce() {
        return ans.size() == 1 ? ans.get(0) : ans.get(1);//因为初始化了1个#，所以，大于1的时候，取1，等于1的时候取0即#。
    }

    public static void main(String[] args) {
        String x = "google";
        字符流中第一个不重复的字符 fff = new 字符流中第一个不重复的字符();
        for (int i = 0; i < x.length(); i++) {
            fff.Insert(x.charAt(i));
            System.out.print(fff.FirstAppearingOnce());
        }
    }
}