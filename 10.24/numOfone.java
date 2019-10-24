public class numOfone {
    /*public static int numOfone(int n) {
        int count = 0;
        while (n!=0) {
            int i = n%2;
            n /= 2;
            if(i == 1){
                count++;
            }
        }
        return count;
    }*/
    public static int numOfone1(int n) {
        int count = 0;
        while (n!=0) {
            count++;
            n = n & (n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        int ret = numOfone1(14);
        System.out.println(ret);
    }
}
