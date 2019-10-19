//求两个正整数的最大公约数 
import java.util.Scanner;
public class divisor{
	public static int fun1(int a,int b){
		int tmp = 0;
		while(a%b != 0){
			tmp = a%b;
			a = b;
			b = tmp;
		}
		return tmp;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入第一个数：");
		int a = sc.nextInt();
		System.out.println("请输入第二个数：");
		int b = sc.nextInt();
		/*if(a >= b){
			for(int i = b;i >= 1;i--){
				if((a%i==0) && (b%i==0)){
					System.out.println("最大公约数为： " + i);
					break;
				}
			}
		}
		else{
			for(int i = a;i >= 1;i--){
				if((a%i==0) && (b%i==0)){
					System.out.println("最大公约数为： " + i);
					break;
				}
			}
		}*/
		int ret = fun1(a,b);
		System.out.println("最大公约数为： " + ret);
		sc.close();
	}
}