package NowCoder;

//https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class Fibonacci {
    public int fibonacci(int n) {
        int one = 0;
        int two = 1;
        if (n > 0) {
            for (int i = 0; i < n - 1; i++) {
                int temp = two;
                two = two + one;
                one = temp;
            }
            return two;
        } else {
            return 0;
        }
    }

    //0 1 1 2 3 5 8 13 21
    public static void main(String[] args) {
        System.out.println(new Fibonacci().fibonacci(4));
    }
}
