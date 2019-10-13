public class test {
	public static void main(String[] args) {
		
		int ret = 1;
		int sum = 0;
		for(int i = 1;i <= 5;i++){
			ret *= i;
			sum += ret;
		}
		System.out.println(sum);
	/*public static void main1(String[] args) {
		int sumOdd = 0;
		int sumEve = 0;
		for(int i = 1;i <= 100;i++){
			if(i % 2 == 0){
				sumOdd += i;
			}
			else{
				sumEve += i;
			}
		
		}
		System.out.println(sumOdd);
		System.out.println(sumEve);*/
	}
}