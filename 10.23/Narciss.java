public class Narciss {
    public static void main(String[] args) {
        //求位数
        for(int i = 100;i <= 1000;i++) {
            int count = 0;
            int tmp = i;
            while(tmp!=0){
                count++;
                tmp /= 10;
            }
            tmp = i;//求每一位上的数
            int sum = 0;//次方和
            while (tmp!=0) {
                sum += Math.pow(tmp%10,count);
                tmp /= 10;
            }
            if(sum == i) {
                System.out.println(i);
            }
        }
    }
}
