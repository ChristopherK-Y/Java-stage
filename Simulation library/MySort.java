package data_structure.sort;

import java.util.Arrays;

public class MySort {
    /**
     * 冒泡排序
     * 总共有n个数,那么需要进行的比较次数就是n-1次
     * (每一趟可以排好一个数,最终剩下一个的时候,就不需要在进行比较了)
     * <p>
     * 复杂度:
     * 时间: 最优:O(n)在已经有序的情况下,只需要扫描一遍
     * 最差/平均:O(n^2)
     * 空间:最优/最差:O(1)
     *
     * @param array 要进行排序的数组
     */
    public static void bubbleSort(long[] array) {
        int length = array.length;
        //进行n-1趟冒泡
        for (int i = 0; i < length - 1; i++) {
            //该flag标志是否在一趟冒泡排序中是否进入过交换两个数
            boolean flag = true;
            for (int j = 0; j < length - i - 1; j++) {
                //如果逆序则交换,此处交换的时候,相等的时候,是不会发生交换的,所以冒泡排序是稳定的
                if (array[j] > array[j + 1]) {
                    long temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //如果没有进入过,说明数组已经有序了
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    /**
     * 插入排序
     * 总共有n个数,那么需要进行的比较次数就是n-1次
     * (每一趟可以排好一个数,最终剩下一个的时候,就不需要在进行比较了)
     * <p>
     * 思路就是:
     * 假设第0个数已经是有序的数列,那么每次从后面取出一个数,然后插入到有序数列里面
     * 每次从有序数列的最后一个开始,不断的往前走:即区间为[0,i-1]
     * ①如果当前遍历到的元素大于待插入的数字,那么就把当前的元素往后搬移一下(由于已经把待插入的数字进行保存,所以从一开始就已经空下一个位置了)
     * ②如果当前遍历到的元素小于等于待插入的数字,那么退出循环,应当插入的位置就是,当前元素下标+1(此处由于后面是顺序取的,插入的时候,也保证了他们的相对顺序,所以也保证了排序的稳定性)
     * <p>
     * 复杂度:
     * 时间: 最优: O(n)当数组全部有序,那么内层for循环都不会进入,直接就把待插入的元素插到了他自己原来的位置,相当于遍历了一遍数组
     * 最差/平均:O(n^2)
     * 空间: 最优/最差:O(1)
     *
     * @param array 要进行排序的数组
     */
    public static void insertSort(long[] array) {
        int length = array.length;
        //此处要遍历的元素是[1,length-1],不断的向前插入
        for (int i = 1; i < length; i++) {
            long toInsert = array[i];//暂存待插入的元素,从此就一直会留下一个空位置(坑)
            int j;
            for (j = i - 1; j >= 0 && array[j] > toInsert; j--) {//倒序进行查找应该插入的位置
                array[j + 1] = array[j];
            }
            array[j + 1] = toInsert;//最后把插入元素
        }
    }

    /**
     * 希尔排序
     * 希尔排序其实就是分组进行插入排序
     * ①group = length/2; ②group = length/2/2; ……不断进行/2向下取整
     * <p>
     * 复杂度:
     * 时间: O(n^(1.3~2))计算有些麻烦,这里不进行解释
     * 空间: O(1)
     *
     * 希尔排序由于进行了分组,所以交换过程中,元素的顺序完全被打乱,所以不具有稳点性
     *
     * @param array 待排序的数组
     */
    public static void shellSort(long[] array) {
        int group = array.length / 2;
        while (true) {
            //下面的for循环,思路和插入排序完全一致,只是新增了分组进行插入排序
            for (int i = group; i < array.length; i++) {
                long toInsert = array[i];
                int j;
                //在有序数组中,查找要插入的元素合适位置
                for (j = i - group; j >= 0 && array[j] > toInsert; j -= group) {
                    array[j + group] = array[j];
                }
                array[j + group] = toInsert;
            }
            if (group == 1) {//在组数等于1的情况下,已经进行插入排序,排完就已经有序了,所以直接return
                return;
            }
            group /= 2;
        }
    }

    /**
     * 选择排序
     * 选择排序和冒泡排序十分的相似,也是需要进行n-1趟的排序(最少)
     * 每次从无序子数组中找到最大的一个值,和本无序子数组的最后一个元素进行交换,然后无序子数组的长度-1
     * <p>
     * 复杂度:
     * 时间: 最优/最差/平均: O(n^2) 因为每次都要把无序数组走一遍,所以没有最优和最差之分
     * 空间: 最优/最差: O(1)
     * <p>
     * 因为,每次都会把无序数组的最后一个元素交换出去,所以整个数组的顺序也就乱了,所以选择排序不具有稳定性
     *
     * @param array 要进行排序的数组
     */
    public static void selectSort(long[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int maxIndex = -1;
            for (int j = 0; j < length - i; j++) {//从无序子数组中找到最大的值
                if (maxIndex == -1 || array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            //找到最大的之后,和无序子数组的最后一个元素进行交换,然后无序子数组的长度-1
            long temp = array[maxIndex];
            array[maxIndex] = array[length - 1 - i];
            array[length - 1 - i] = temp;
        }
    }

    /**
     * 堆排序
     * 整体过程和选择排序有点像,每次从无序数组中,找到一个最大的数,然后放在最后(但是此次找最大的数,变成了O(log(n)))
     * ①对传入数组进行建堆操作(O(n * log(n)))
     * ②然后每次从堆顶取出一个最大的,思路和选择排序一样
     * ③由于是头元素更换,所以,把堆顶拿走之后,再次进行向下调整
     * ④直到有序区间的元素<=1个就可以退出了
     *
     * 复杂度:
     * 时间: 最好/最差/平均: O(n * log(n))
     * 空间: 最好/最差: O(1)/O(log(n))
     *
     * @param array 要进行排序的数组
     */
    public static void heapSort(long[] array) {
        int size = array.length;
        //普通的建堆的过程
        for (int i = (size - 2) / 2; i >= 0; i--) {
            shiftDown(array, size, i);
        }
        //while循环,每次从中取出一个数,和无序序列的最后一个元素进行交换,然后无序序列的长度--,调整完之后,对0进行向下调整
        while (size > 1) {
            long temp = array[0];
            array[0] = array[size - 1];
            array[size - 1] = temp;
            size--;
            shiftDown(array, size, 0);
        }
    }

    private static void shiftDown(long[] array, int size, int index) {
        while (true) {
            int leftIndex = 2 * index + 1;
            if (leftIndex >= size) {
                return;
            }

            int rightIndex = leftIndex + 1;
            int maxIndex = leftIndex;
            if (rightIndex < size && array[rightIndex] > array[leftIndex]) {
                maxIndex = rightIndex;
            }

            if (array[index] >= array[maxIndex]) {
                return;
            }

            long temp = array[index];
            array[index] = array[maxIndex];
            array[maxIndex] = temp;
            index = maxIndex;
        }
    }

    public static void main(String[] args) {
        long[] array = {9, 7, 8, 0, 4, 3, 1, 2, 5, 6};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }

}
