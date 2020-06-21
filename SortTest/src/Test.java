import java.util.Arrays;

public class Test {
    //冒泡排序
    /*
    * 时间复杂度：
    *  最好 O(n)
    *  最坏 O(n*n)
    *  空间复杂度： O(1)
    *  稳定性： 稳定
    *  */
    public static void bubbleSort(int[] array){
        for (int i = 0;i < array.length;i++){
            boolean flag = true;
            for (int j = 0;j < array.length-i-1;j++){
                if (array[j] > array[j+1]){
                    int t = array[j+1];
                    array[j+1] = array[j];
                    array[j] = t;
                }
                flag = false;
            }
            if (flag){
                break;
            }
        }
    }

    //选择排序
    /*
     * 时间复杂度：
     *  O(n*n)
     *  空间复杂度： O(1)
     *  稳定性： 不稳定
     *  */
    public static void chooseSort(int[] array){
        for (int i = 0;i < array.length;i++){
            int max = 0;
            for (int j = 1;j < array.length-i;j++){
                if (array[max] < array[j]){
                    max = j;
                }
            }
            int t = array[array.length-1-i];
            array[array.length-1-i] = array[max];
            array[max] = t;
        }
    }

    //插入排序
    /*
     * 时间复杂度：
     *  最好 O(n)
     *  最坏 O(n*n)
     *  空间复杂度： O(1)
     *  稳定性： 稳定
     *  数组越接近有序，时间效率越高
     *  */
    public static void insertSort(int[] array){
        for (int i = 1;i < array.length;i++){
            int v = array[i];
            int j = i-1;
            for (;j >= 0 && array[j] > v;j--){
                array[j+1] = array[j];
            }
            array[j+1] = v;
        }
    }

    //希尔排序
    /*
     * 时间复杂度：
     *  最好 O(n)
     *  最坏 O(n*n)
     *  空间复杂度： O(1)
     *  稳定性： 不稳定
     *  */
    public static void shellSort(int[] array){
        int gap = array.length;
        while (gap > 1){
            gap = (gap/3)+1;
            for (int i = 1;i < array.length;i++){
                int v = array[i];
                int j = i - gap;
                for (;j >= 0 && array[j] > v;j -=gap){
                    array[j+gap] = array[j];
                }
                array[j+gap] = v;
            }
        }
    }

    //快速排序
    /*
     * 时间复杂度：
     *  最好 O(n * log(n))
     *  最坏 O(n*n)
     *  空间复杂度：
     *  最好： O(log(n))
     *  最坏： O(n)
     *  稳定性： 不稳定
     *  */
    public static void quickSort(int[] array){
        quickSortInternal(array,0,array.length-1);
    }
    public static void quickSortInternal(int[] array,int left,int right){
        if (right == left){
            return;
        }
        if (left > right){
            return;
        }
        int index = partition(array,left,right);
        quickSortInternal(array,left,index-1);
        quickSortInternal(array,index+1,right);
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int index = array[left];
        while (i < j){
            while (array[i] < index){
                i++;
            }
            while (array[j] > index){
                j--;
            }
            swap(array,i,j);
        }
        swap(array,left,i);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        if (array[i] > array[j]){
            int t = array[i];
            array[i] = array[j];
            array[j] = t;
        }
    }

    //归并排序
    /*
     * 时间复杂度：
     *  最好 O(n * log(n))
     *  空间复杂度： O(n)
     *  稳定性： 稳定
     *  */
    public static void mergeSort(int[] array){
        mergeSortInternal(array,0,array.length);
    }

    private static void mergeSortInternal(int[] array, int low, int high) {
        if (low >= high-1){
            return;
        }
        int mid = (low + high) / 2;
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid,high);

        merge(array,low,mid,high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int i = low;
        int j = mid;
        int len = high-low;
        int[] tmp = new int[len];
        int k = 0;

        while (i < mid && j < high){
            if (array[i] < array[j]){
                tmp[k++] = array[i++];
            }else {
                tmp[k++] = array[j++];
            }
        }
        while (i < mid){
            tmp[k++] = array[i++];
        }
        while (j < high){
            tmp[k++] = array[j++];
        }

        for (int t = 0;t < len;t++){
            array[low+t] = tmp[t];
        }
    }

    public static void main(String[] args) {
        int[] array = {3,0,1,8,7,2,5,4,9,6};
        //bubbleSort(array);
        //chooseSort(array);
        //insertSort(array);
        //shellSort(array);
        //quickSort(array);
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
