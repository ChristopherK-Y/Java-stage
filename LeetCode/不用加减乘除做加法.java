package NowCoder;

public class 不用加减乘除做加法 {
    public int Add(int num1, int num2) {
        int sum = num1 ^ num2;
        int carry = num1 & num2;
        while (carry != 0) {
            carry <<= 1;
            int temp = sum;
            sum ^= carry;
            carry &= temp;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new 不用加减乘除做加法().Add(100, 99));
    }
}
