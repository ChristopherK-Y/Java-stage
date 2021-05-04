package NowCoder;

import java.util.*;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 *
 * https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993
 */
public class 把数组排成最小的数 {
    /**
     * 思路：实质上就是把该数组重新排列组合为一个新的串，使得他们连起来是最小的数
     * 所以我们可以这么做：
     * ①把所有数都转为String，放入一个ArrayList中
     * ②排序：规则为return number1.append(number2) - number2.append(number1);
     * ③把List中的所有元素拼接成一个字符串输出。
     */
    public String PrintMinNumber(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();
        for (int oneNumber : numbers) {
            list.add(String.valueOf(oneNumber));
        }
        list.sort((number1, number2) -> Integer.parseInt(number1 + number2) - Integer.parseInt(number2 + number1));
        /*在OJ中会更快
        list.sort(new Comparator<String>(){
            public int compare(String number1, String number2){
                int one = Integer.parseInt(number1+number2);
                int another = Integer.parseInt(number2+number1);
                if(one > another){
                    return 1;
                }else if(one < another){
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        */
        StringBuilder ans = new StringBuilder();
        for (String oneNumber : list) {
            ans.append(oneNumber);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        int[] array = {3, 32, 321};
        System.out.println(new 把数组排成最小的数().PrintMinNumber(array));
    }
}
