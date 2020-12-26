public class GetNine {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            int t = i;
            while (t != 0) {
                int d = t % 10;
                if (d == 9) {
                    //System.out.println("i = " + i);
                    count++;
                }
                t /= 10;
            }
        }
        System.out.println("The 9 in [1,100] has " + count);
    }
}
