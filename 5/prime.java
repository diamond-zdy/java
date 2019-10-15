 //判定一个数字是否是素数 
//import java.util.Scanner;
/*public class prime{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in); 
		System.out.println("请输入一个数字： ");
		int x = in.nextInt(); 
		boolean isPrime = true;
		if ( x == 1)
		{
			isPrime = false;
		}
		int i = 2;
		for (; i < x; i++){
			if(x%i == 0){
				isPrime = false;
				break;
			}
		}
		if(isPrime){
			System.out.println("是素数");
		}
		else{
			System.out.println("不是素数");
		}
		in.close();
	}
}*/
//打印 1 - 100 之间所有的素数
public class prime{
	public static void main(String[] args){
		for(int i = 1;i <= 100;i++){
			int j = 2;
			for( j = 2;j < i;j++){
				if(i % j == 0){
					break;
				}
			}
			if(j == i){
				System.out.println(i);
			}
		}
	}
}
