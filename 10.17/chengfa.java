// 输出乘法口诀表 
public class chengfa{
	public static void main(String[] args){
		for(int i = 1;i <= 9;i++){
			int j = 1;
			for(j = 1;j <= i;j++){
				System.out.print(i + "*" + j + " = " + i*j + "   ");
			}
			System.out.println();
		}
	}
}