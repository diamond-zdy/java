//输出 1000 - 2000 之间所有的闰年 
public class leapyear{
	 public static void main(String[] args){
		 for(int i = 1000;i <= 2000;i++){
			 if(i%4 == 0&& i%100 != 0){
				 System.out.println(i);
			 }
			 if(i%400 == 0){
				 System.out.println(i);
			 }
				 
		 }
	 }
 }