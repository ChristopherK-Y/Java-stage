package 方法的使用_作业;

//3.4.求1！+2！+3！+4！+........+n!的和/n!
public class Factorial {
    public static long oneFactorial(long n) {
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }

    public static long factorial(long n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += oneFactorial(i);
        }
        return result;
    }

    public static void main(String[] args) {
        //System.out.println(factorial(3));
        System.out.println(oneFactorial(3));
    }
}
