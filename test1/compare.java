public class compare{
	public static void main(String[] args){
		int a = 1;
		int b = 3;
		int c = 5;
		int max1 = a > b ? a : b; 
		int max2 = max1 > c ? max1 : c;
		int min1 = a < b ? a : b;
		int min2 = min1 < c ? min1 : c;
		System.out.println("max = " + max2);
		System.out.println("min = " + min2);
	}
}