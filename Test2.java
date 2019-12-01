import java.util.Arrays;

public class Test2 {
    public static int[] add(int[] arr1,int[] arr2){
        int len = arr1.length + arr2.length;
        int[] arr = new int[len];
        int i = 0;
        int j = 0;
        int m = 0;
        while (i < arr1.length && j < arr2.length) {
            if(arr1[i] <= arr2[j]){
                arr[m] = arr1[i];
                i++;
            }else {
                arr[m] = arr2[j];
                j++;
            }
            m++;
        }
        //以下可用while循环
        if (i > arr1.length){
            for (;j < arr2.length;j++){
                arr[m] = arr2[j];
            }
        }else {
            for (;i < arr1.length;i++){
                arr[m] = arr1[i];
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,3,6,9};
        int[] arr2 = {2,4,6,8};
        int[] arr = add(arr1,arr2);
        System.out.println(Arrays.toString(arr));
    }
}
