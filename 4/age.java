//1. 根据年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
import java.util.Scanner;
public class age{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in); 
		System.out.println("请输入年龄：");
		int age = sc.nextInt(); 
		if(age <= 18){
			System.out.println("少年");
		}
		else if(age >= 19 && age <= 28){
			System.out.println("青年");
		}
		else if(age >= 29 && age <= 55){
			System.out.println("中年");
		}
		else{
			System.out.println("老年");
		}
		sc.close();	
	}
}