package NowCoder;

//https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=13&tqId=11165&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class Power {
    /**
     * 思路：
     * ①如果指数是正数，那么正常连续乘就好了
     * ②如果指数是负数，那么将底数改为底数分之1，把指数改为-指数就好（2^-3 ==> 1/2 ^ 3）
     * @param base 底数
     * @param exponent 指数
     * @return 计算（底数^指数 即：base的exponent次幂）的值
     */
    public double power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        double ans = 1;
        for (int i = 0; i < exponent; i++) {
            ans *= base;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Power().power(2, -3));
    }
}
