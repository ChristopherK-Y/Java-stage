package day11;

import java.util.Arrays;

//https://leetcode-cn.com/problems/string-compression/
public class Compress {
    public int compress(char[] chars) {
        char temp = chars[0];//用于存储当前用于比较的char字符
        int count = 0;//当前的字符重复了多少次了
        int insert = 0;//当前应该要进行插入（写入）的位置index
        int length = 0;//当前的字符数组的长度
        String countString = null;//把count转换为字符数组元素时用的中间String
        for (int i = 0; i < chars.length; i++) {//①首先进行一个n的循环，一个一个的遍历
            if (chars[i] == temp) {//1）如果当前的元素和temp的一样，那么就把记录的count++
                count++;
            } else {//2）如果不等了，那么就把（temp）和他的数量写入，并且把temp修改为当前的字符//每往数组写入一次，length++
                if (count > 1) {//数量大于一就要写入数量
                    countString = Integer.toString(count);
                    chars[insert++] = temp;
                    length++;
                    for (int j = 0; j < countString.length(); j++) {
                        chars[insert++] = countString.charAt(j);
                        length++;
                    }
                    count = 1;
                } else {//数量小于1，即1，那么就只把字符写入即可
                    chars[insert++] = temp;
                    length++;
                }
                temp = chars[i];
            }
        }
        //接下来的代码就是复制的，作用为把最后的所有元素都写进去，因为之前的如果出现倒数几个元素都是一样的
        //那么for退出的时候，count和temp都进行了记录，但是还没有往数组里面写，这里就是进行最后的写入
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
        return length;//最后返回新数组的长度即可
    }

    public static void main(String[] args) {//主方法：测试
        Compress compress = new Compress();
        //char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress.compress(chars));
        System.out.println(Arrays.toString(chars));
    }
}
