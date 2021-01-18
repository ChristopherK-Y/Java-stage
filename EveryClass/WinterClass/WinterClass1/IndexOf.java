public class IndexOf {
    public static int indexOf(long[] src, long target) {
        int result = -1;
        for (int i = 0; i < src.length; i++) {
            if (src[i] == target) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long[] a = new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(indexOf(a, 11));
    }
}
