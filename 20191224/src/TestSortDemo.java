import java.util.Arrays;

public class TestSortDemo {
    public static void adjustDowm(int[] array,int root,int len){

    }
    public static void insertSort(int[] array){

        for (int i = 1;i < array.length;i++){
            int tmp = array[i];
            int j = i-1;
            for (;j >= 0;j--){
                if (tmp < array[j]){
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 不稳定
     * @param array
     */
    public static void selectSort(int[] array){
        for (int i = 0;i<array.length;i++){
            for (int j = i+1;j<array.length;j++){
                if (array[i]>array[j]){
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5,8,6,1};
        //insertSort(array);
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
