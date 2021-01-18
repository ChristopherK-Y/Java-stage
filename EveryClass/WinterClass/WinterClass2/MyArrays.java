public class MyArrays {
    public static String toString(long[] array) {
        if (array.length == 0) {
            return "[]";
        }
        StringBuilder theString = new StringBuilder("[");
        for (int i = 0; i < array.length - 1; i++) {
            theString.append(array[i]).append(", ");
        }
        theString.append(array[array.length - 1]).append("]");
        return theString.toString();
    }

    public static long[] copyOf(long[] original, int newLength) {
        if (newLength < 0) {
            throw new RuntimeException("给定的新长度错误");
        }
        long[] ans = new long[newLength];
        int length = Integer.min(newLength, original.length);
        for (int i = 0; i < length; i++) {
            ans[i] = original[i];
        }
        //如果 original.length < newLength,那么新的数组的剩余元素就以及是0了，即long类型的默认值
        return ans;
    }

    public static long[] copyOfRange(long[] original, int from, int to) {
        if (from < 0 || from > to || from > original.length) {
            throw new RuntimeException("From OR To input error");
        }
        int newLength = to - from;
        long[] ans = new long[newLength];
        int length = Integer.min(original.length - from, newLength);
        for (int i = 0; i < length; i++) {
            ans[i] = original[i + from];
        }
        return ans;
    }

    public static long[] bubbleSort(long[] original) {
        for (int i = 0; i < original.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < original.length - i - 1; j++) {
                if (original[j] > original[j + 1]) {
                    original[j] ^= original[j + 1];
                    original[j + 1] ^= original[j];
                    original[j] ^= original[j + 1];
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return original;
    }

    public static int binarySearch(long[] original, long target) {
        int lowIndex = 0;
        int highIndex = original.length - 1;
        while (highIndex >= lowIndex) {//左闭右闭的情况
            int midIndex = (highIndex + lowIndex) / 2;
            if (original[midIndex] == target) {
                return midIndex;
            } else if (original[midIndex] > target) {
                highIndex = midIndex - 1;
            } else {
                lowIndex = midIndex + 1;
            }
        }
        return -1;
    }
}
