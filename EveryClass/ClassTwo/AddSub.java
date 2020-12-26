public class AddSub {
    public static void main(String[] args) {
        int flag = 1;
        double result = 0.0;
        for (int i = 1; i <= 100; i++) {
            result += (1.0 / i) * (flag);
            flag = -flag;
            //System.out.println("The " + i + " result is" + result);
        }
        System.out.println("The result is " + result);
    }
}
