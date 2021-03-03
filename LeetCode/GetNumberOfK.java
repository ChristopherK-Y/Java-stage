package NowCoder;

//https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&tqId=11190&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class GetNumberOfK {
    /**
     * 因为都是整数，所以，我们可以查找，k+—0.5的值，就是他俩的插入位置。
     * @param array 给定数组
     * @param k 给定目标值
     * @return 返回目标值的个数
     */
    public int getNumberOfK(int[] array, int k) {
        int start = getInertIndex(array, k - 0.5);
        int end = getInertIndex(array, k + 0.5);
        return end - start;
    }

    private int getInertIndex(int[] array, double k) {
        int start = 0, end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (array[mid] > k) {
                end = mid - 1;
            } else if (array[mid] < k) {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(new GetNumberOfK().getNumberOfK(array, 3));
    }
}
