package day11;

import java.util.Arrays;

//https://leetcode-cn.com/problems/string-compression/
public class Compress {
    public int compress(char[] chars) {
        char temp = chars[0];
        int count = 0;
        int insert = 0;
        int length = 0;
        String countString = null;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == temp) {
                count++;
            } else {
                if (count > 1) {
                    countString = Integer.toString(count);
                    chars[insert++] = temp;
                    length++;
                    for (int j = 0; j < countString.length(); j++) {
                        chars[insert++] = countString.charAt(j);
                        length++;
                    }
                    count = 1;
                } else {
                    chars[insert++] = temp;
                    length++;
                }
                temp = chars[i];
            }
        }
        if (count > 1) {
            countString = Integer.toString(count);
            chars[insert++] = temp;
            length++;
            for (int j = 0; j < countString.length(); j++) {
                chars[insert++] = countString.charAt(j);
                length++;
            }
        }
        else {
            chars[++insert] = temp;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        Compress compress = new Compress();
        //char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress.compress(chars));
        System.out.println(Arrays.toString(chars));
    }
}
