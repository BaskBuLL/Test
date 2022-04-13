package top.baskbull.leet;

/**
 * @author liuzhuo
 * @date 2022/4/1 11:33 上午
 */
public class 排序 {

    public static void swap(int[] arr, int i, int j) {
//        arr[i] = arr[i] ^ arr[j];
//        // arr[i] ^ arr[j] ^ arr[j] = arr[i]
//        arr[j] = arr[i] ^ arr[j];
//        // arr[i] ^ arr[j] ^ arr[i]
//        arr[i] = arr[i] ^ arr[j];
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * arr[L ...... R] 荷兰国旗划分问题 以arr[right]为划分值
     * <arr[R] ==arr[R] >arr[R]
     * 空间复杂度O(1) 时间复杂度O(n)
     */
    public static int[] netherlandsFlag(int[] arr, int left, int right) {
        if (left > right) {
            return new int[]{-1, -1};
        }
        if (left == right) {
            return new int[]{left, right};
        }
        // <区 有边界
        int less = left - 1;
        //因为我们以arr[right]为界限 所以暂时不动
        // >区 左边界
        int more = right;
        int index = left;
        while (index < more) {
            if (arr[index] == arr[right]) {
                index++;
            } else if (arr[index] < arr[right]) {
                swap(arr, index++, ++less);
            } else if (arr[index] > arr[right]) {
                swap(arr, index, --more);
            }
        }
        //L......Less Less+1......more-1 more......R-1 R
        swap(arr, more, right);
        return new int[]{less + 1, more};
    }

    public static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr, 0, arr.length - 1);
    }

    public static void process3(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(arr, (int) (left + (Math.random() * (right - left + 1))), right);
        int[] equalArea = netherlandsFlag(arr, left, right);
        process3(arr, left, equalArea[0] - 1);
        process3(arr, equalArea[1] + 1, right);
    }

    ////////////快排
    public void quickSort(int[] nums, int left, int right) {
        //O(nlog2n) 最坏O(n2)
        if (left < right) {
            int base = nums[left];
            int l = left;
            int r = right;
            while (l < r) {
                while (nums[l] < base && l < right) {
                    l++;
                }
                while (nums[r] > base && r > left) {
                    r--;
                }
                if (l <= r) {
                    int temp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = temp;
                    l++;
                    r--;
                }
            }
            if (left < r) {
                quickSort(nums, left, r);
            }
            if (right > l) {
                quickSort(nums, l, right);
            }
        }
    }

    //归并排序
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    /**
     * arr在[L......R]上变有序
     */
    public static void process(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[left + j] = help[j];
        }
    }


    /////////堆排序
    public static void heapInsert(int[] arr, int index) {
        //(index-1)/2是父节点
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 从index往下沉
     * 结束条件：我的孩子都不比我大；没孩子了
     */
    public static void heapIfy(int[] arr, int index, int heapSize){
        int left = 2 * index + 1;
        while (left < heapSize) {
            //左右孩子找大的
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        //O(N*logN)
        while (heapSize > 0) {
            //O(logN)
            heapIfy(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

}
