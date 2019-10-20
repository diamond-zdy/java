//计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值。
public class sumN{
	public static double sumn(int n){
		double sum = 0.0;
		int flag = 1;
		for(int i = 1;i <= n;i++){
			sum += 1.0/i*flag;
			flag = -flag;
		}
		return sum;
	}
	public static void main(String[] args){
		/*int i = 1;
		int j = 2;
		double add1 = 0.0000;
		double add2 = 0.0000;
		double add;
		for(i=1;i < 100;i += 2){
			add1 += 1.0000/i;
		}
		for(j=2;j <= 100;j += 2){
			add2 += 1.0000/j;
		}
		sum = add1 - add2;*/
		
		double ret = sumn(100);
		System.out.println(ret);
	}
}