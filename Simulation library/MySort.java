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
     * <p>
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
     * <p>
     * 复杂度:
     * 时间: 最好/最差/平均: O(n * log(n))
     * 空间: 最好/最差: O(1)
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

    /**
     * 快速排序
     * <p>
     * 过程为：
     * ①首先选定基准值，这里一般选择待排序区间的下界(array(left))
     * ②进行一次划分(partition)(partition有三种方法,下面会进行详述),结果应该为 : {[ <= pivot ] [ pivot ] [ >= pivot ]} 将一个无序的数组,分为三部分
     * ③对[ <= pivot ] 和 [ >= pivot ]的这两个小区间分别进行相同的操作
     * ④就这样,不停的进行递归操作,最终整个数组就会变的有序
     * <p>
     * 复杂度:
     * 时间: 最好/平均: O(n * log(n))(递归执行的时候,整颗树的高度为log(n),每一次partition都需要对数组进行一遍遍历,那么,在树的每一层都相当于对整个数组进行依次遍历,所以时间复杂度为O(n),最终就是O(n * log(n)))
     * 最差: O(n^2) (如果数组已经有序,那么每次partition都把数组走了一遍(是个等差数列),此时就会退化为冒泡排序即O(n^2))
     * 空间: 最好: O(log(n)) (递归过程化成树就是一颗二叉树,所以最优的情况就是树的高度)
     * 最差: O(n) (数组已经有序,递归过程可以看出单支树,此时树的高度为n)
     *
     * @param array 待排序的数组
     */
    public static void quickSort(long[] array) {
        //quickSort1(array, 0, array.length - 1);
        //quickSort2(array, 0, array.length - 1);
        quickSort3(array, 0, array.length - 1);
    }

    /**
     * 快速排序第一种
     * <p>
     * partition1:
     * 划分过程中,区间情况为{[ pivot ] [ <= pivot ] [ 无序区间 ] [ >= pivot ]}
     * 思路为:
     * ①从右往左找到第一个 < pivot的值(为什么一开始是从右往左,不是从左往右,可以思考一下,待会儿下面会进行详讲)
     * ②从左往右找到第一个 > pivot的值
     * ③将这两个值进行交换
     * ④继续不断重复上述①②③过程,直到左指针和右指针相遇
     * ⑤然后将整个数组最左边的pivot和现在的左(或右(因为左指针和右指针现在重合,所以选择谁都一样))指针所指向的数组元素进行交换
     * (可以保证当前左/右指针指向的元素一定是小于pivot的,下面会进行说明)
     * ⑥此次partition过程结束
     *
     * @param array 待排序的数组
     * @param left  待排序数组区间下界
     * @param right 待排序数组区间下界
     */
    public static void quickSort1(long[] array, int left, int right) {
        if (left < right) {//左右指针需要合法
            int l = left;//待会需要用到边界,所以此处用另外一个
            int r = right;//待会需要用到边界,所以此处用另外一个
            long pivot = array[l];
            while (l < r) {
                while (l < r && array[r] >= pivot) {
                    r--;
                }
                while (l < r && array[l] <= pivot) {
                    l++;
                }
                swap(array, l, r);
            }
            swap(array, left, l);
            quickSort1(array, left, l - 1);
            quickSort1(array, l + 1, right);
        }
    }

    /**
     * 对一个数组中的两个数,进行交换
     *
     * @param array 被操作数组
     * @param x     第一个数的下标
     * @param y     第二个数的下标
     */
    private static void swap(long[] array, int x, int y) {
        long temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    /**
     * 快速排序第二种
     * <p>
     * partition2:
     * 划分过程中,区间情况为{[ <= pivot ] [ 无序区间 ] [ >= pivot ]}
     * 思路为:
     * ①首先把pivot(即最左边的元素存起来),因此,此时的array[left]位置是可被覆盖的
     * ②从右往左找到一个 < pivot的值,然后将这个数,填入左指针指向的数组单元中(①中已经说了,当前左指针位置可被覆盖),而此时array[right]变的可被覆盖了
     * ③从左往右找到一个 > pivot的值,然后将这个数,填入右指针指向的数组单元中,此时左指针指向的数组单元又可被覆盖了
     * ④依次重复上述②③过程,最终,左右指针相遇,循环结束
     * ⑤将pivot的值,直接填入left/right所指向的数组单元
     * ⑥此次partition结束
     *
     * @param array 待排序的数组
     * @param left  待排序数组区间下界
     * @param right 待排序数组区间下界
     */
    public static void quickSort2(long[] array, int left, int right) {
        if (left < right) {
            int l = left;
            int r = right;
            long pivot = array[l];
            while (l < r) {
                while (l < r && array[r] >= pivot) {
                    r--;
                }
                array[l] = array[r];
                while (l < r && array[l] <= pivot) {
                    l++;
                }
                array[r] = array[l];
            }
            array[l] = pivot;
            quickSort2(array, left, l - 1);
            quickSort2(array, l + 1, right);
        }
    }

    /**
     * 快速排序第三种
     * <p>
     * partition3:
     * 划分过程中,区间情况为{[ pivot ] [ < pivot ] [ >= pivot ] [ 无序区间 ]}
     * low         high now
     * 思路为:
     * ①首先设定三个指针(其实其中的high没用,为了好理解,暂时先使用三个)
     * low指针指向  [ < pivot ] 区间的最后一个元素
     * high指针指向 [ >= pivot ]区间的最后一个元素
     * now指针指向  [ 无序区间 ] 的第一个元素(now会不断的进行++)
     * ②初始化,三个指针,low和high由于没有元素,所以此时都指向当前区间的头即传入的left,now指针执行当前区间的第二个元素即left+1
     * ③如果array[now] <  pivot,那么他应该和[ >= pivot ]区间的第一个元素(low+1)进行交换,然后low区间扩大,即low++,由于此时的high区间改变,所以high++(这一步没有必要,方便理解,暂时不管)
     * ④如果array[now] >= pivot,那么直接让high++即可,相当于high区间把属于他的元素吃进了肚子(由于high区间的最后一个元素时刻再now-1的位置)
     * ⑤不断重复上述③④过程,直到,now指针,走到了整个数组的区间的最右边(now <= right),循环结束
     * ⑥最后,将pivot(即array[left])和[ < pivot ]区间的最后一个元素交换
     * ⑦此次partition结束
     *
     * @param array 待排序的数组
     * @param left  待排序数组区间下界
     * @param right 待排序数组区间下界
     */
    public static void quickSort3(long[] array, int left, int right) {
        if (left < right) {
            int low = left;
            //int high = left;//方便理解,最终理解的话,直接去掉
            int now = left + 1;
            long pivot = array[left];
            while (now <= right) {
                if (array[now] < pivot) {
                    swap(array, now, low + 1);
                    low++;
                }
                //high++;//方便理解,最终理解的话,直接去掉
                now++;
            }
            swap(array, left, low);
            quickSort3(array, left, low - 1);
            quickSort3(array, low + 1, right);
        }
    }

    /**
     * 归并排序
     *
     * @param array 待排序的数组
     */
    public static void mergeSort(long[] array) {
        mergeSortOfRange(array, 0, array.length);
    }

    /**
     * 归并排序
     * 过程为：（采用递归思路）
     * ①首先将数组分为两部分，从中间切开
     * ②然后左边和右边分别再次进行递归的归并排序
     * ③等左右两边都有序了，那么把这两部分进行一次合并就好了（合并两个有序数组，合并完成后，依然保持数组为有序的）
     * ④排序完成
     *
     * 对于步骤①：如果待排序的区间内的元素 <=1 个了，那么待排序的区间已经有序，直接返回就好了
     * 这唯一的一个递归出口
     *
     * 复杂度：
     * 时间： 最好/平均/最坏: O(n * log(n)) (对于归并排序,没有最好和最坏的情况,无论怎样,都是同样的分开递归)
     * 归并排序的过程如果拿图像来表示,可以近似看成完全二叉树,所以数的高度是log(n),每一层都可以看成是对整个数组的一次O(n)复制,那么最终就是O(n * log(n))
     * 空间: 最好/最坏: O(n) 仅仅定义一个全局的数组,一直反复使用就好
     * @param array 待排序的数组
     * @param start 待排序数组下界
     * @param end 待排序数组上界
     */
    public static void mergeSortOfRange(long[] array, int start, int end) {
        int size = end - start;
        if (size <= 1) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSortOfRange(array, start, mid);
        mergeSortOfRange(array, mid, end);
        merge(array, start, mid, end);
    }

    /**
     * 对两个有序数组,进行合并
     *
     * @param array 存储两个有序数组的数组
     * @param start 有序数组1下界
     * @param mid 有序数组2下界
     * @param end 数组区间上界
     */
    private static void merge(long[] array, int start, int mid, int end) {
        long[] copyArray = new long[end - start];
        int left = start;
        int right = mid;
        int now = 0;
        while (left < mid && right < end) {
            if (array[left] <= array[right]) {
                copyArray[now++] = array[left++];
            } else {
                copyArray[now++] = array[right++];
            }
        }
        if (left == mid) {
            while (right < end) {
                copyArray[now++] = array[right++];
            }
        } else {
            while (left < mid) {
                copyArray[now++] = array[left++];
            }
        }
        //将合并完成的数组,写回原数组
        System.arraycopy(copyArray, 0, array, start, end - start);
    }

    public static void main(String[] args) {
        long[] array = {9, 7, 8, 0, 4, 3, 1, 2, 5, 6};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

}
