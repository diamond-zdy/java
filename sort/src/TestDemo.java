import java.util.Arrays;
import java.util.Stack;

public class TestDemo {
    /*快速排序
    时间复杂度：O（log2n） 最坏情况：
    空间复杂度;O（log2n）
    稳定性：不稳定
    * */
    public static int partion(int[] array,int start,int end){
        int tmp = array[start];
        while (start < end){
            while ((start < end) && array[end] >= tmp){
                end--;
            }
            if (start >= end){
                break;
            }else {
                array[start] = array[end];
            }
            while ((start < end) && array[start] <= tmp){
                start++;
            }
            if (start >= end){
                break;
            }else {
                array[end] = array[start];
            }
        }
        array[start] = tmp;
        return start;
    }
    public static void insertSort2(int[] array,int low,int high){
        for (int i = low+1;i <= high;i++){
            int tmp = array[i];
            int j = 0;
            for (j = i-1;j >=low;j--){
                if (array[j] > tmp){
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
    public static void swap(int[] array,int low,int high){
        int tmp = array[low];
        array[low] = array[high];
        array[high] = tmp;
    }

    public static void ThreeNumOfMiddle(int[] array,int low,int high){
        int mid = (low+high)/2;
        if (array[mid] > array[high]){
            swap(array,mid,high);
        }
        if (array[mid] > array[low]){
            swap(array,mid,low);
        }
        if (array[low]>array[high]){
            swap(array,low,high);
        }
    }
    public static void quick(int[] array,int low,int high){
        if (low >= high){
            return;
        }
        //优化方式1：
        if (high-low+1 < 100){
            insertSort2(array,low,high);
            return;
        }
        ThreeNumOfMiddle(array,low,high);

            //写一个函数将待排序序列分成两部分
            int pivot = partion(array,low,high);
            //开始递归，左，右
            quick(array,low,pivot-1);
            quick(array,pivot+1,high);

    }
    public static void quickSort(int[] array){
        quick2(array,0,array.length-1);
    }
    //冒泡排序
    public static void bubbbleSort(int[] array){
        boolean flg = false;
        for (int i = 0;i < array.length - 1;i++){
            for (int j = 0;j < array.length-1-i;j++){
                if (array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            if (!flg){
                break;
            }
        }
    }
    //非递归
    public static void quick2(int[] array,int low,int high){
        int pivot = partion(array,low,high);
        Stack<Integer> stack = new Stack<>();
        if (pivot > low+1){
            stack.push(low);
            stack.push(pivot-1);
        }
        if (pivot < high-1){
            stack.push(pivot+1);
            stack.push(high);
        }
        while(!stack.empty()){
            high = stack.pop();
            low = stack.pop();
            pivot = partion(array,low,high);
            if (pivot > low+1){
                stack.push(low);
                stack.push(pivot-1);
            }
            if (pivot < high-1){
                stack.push(pivot+1);
                stack.push(high);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,8,4,6,7,44,20};
        System.out.println(Arrays.toString(array));
        quickSort(array);
        //bubbbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
