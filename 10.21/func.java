//编写程序数一下 1到 100 的所有整数中出现多少个数字9。
public class func{
	public static void main(String[] args){
		int i = 1;
		int count = 0;
		for (i = 1; i <= 100; i++)
		{
			if (i % 10 == 9)
				count++;
			if (i / 10 == 9)
				count++;
		}
		System.out.println("1-100出现9的次数为： " + count);
	}
}