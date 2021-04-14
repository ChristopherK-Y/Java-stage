import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

public class StreamDemo {
    // n -> n + 10
    private static class AAA implements IntUnaryOperator {
        @Override
        public int applyAsInt(int n) {
            return n + 10;
        }
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        ArrayList<Integer> list = new ArrayList<>();
        for (int n : array) {
            list.add(n);
        }

        // java stream
        long collect = Arrays.stream(array)
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println(collect);
    }
}
