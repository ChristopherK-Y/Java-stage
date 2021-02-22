package NowCoder;

//https://www.nowcoder.com/practice/59ac416b4b944300b617d4f7f111b215?tpId=13&tqId=11201&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class Add {
    /**
     * 思路：
     * ①两个数的按位异或是两数每位的和，但是不带进位
     * ②两个数的按位与是两个数的每一位是否产生进位
     * @param num1 被加数
     * @param num2 加数
     * @return 两数之和
     */
    public int add(int num1, int num2) {
        while (num2 != 0) {
            int sum = num1 ^ num2;//不带进位的两数和
            int carry = (num1 & num2) << 1;//每一位的进位
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(new Add().add(5, 5));
    }
}
