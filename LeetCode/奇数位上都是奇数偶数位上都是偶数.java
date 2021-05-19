package NowCoder;

public class 奇数位上都是奇数偶数位上都是偶数 {
    /**
     *	奇数位上都是奇数或者偶数位上都是偶数
     *	输入：数组arr，长度大于2
     *	将arr调整成奇数位上都是奇数或者偶数位上都是偶数
     *
     * https://www.nowcoder.com/questionTerminal/b89b14a3b5a94e438b518311c5156366
     */
    public void oddInOddEvenInEven(int[] arr) {
        int i = 0;
        int j = 1;
        int len = arr.length;
        int end = len - 1;
        while(i < len && j < len)
        {
            if(arr[end] % 2 == 0)
            {
                swap(i,end,arr);
                i += 2;
            }
            else
            {
                swap(j,end,arr);
                j += 2;
            }
        }
    }
    private static void swap(int a, int b,int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
