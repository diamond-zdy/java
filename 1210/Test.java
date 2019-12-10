//行注释

/*
块注释
1、public-》公共的。？？
2、class -》 定义类。结构体的高配版本。
   后边-》类名。Test。
   在一个.java文件里面，只能有一个public修饰的类
   类名一定要和文件名一样的。
3、class { 类体(属性 方法) }
4、main函数-》方法  
5、public static ？  面试问题：为什么main方法是
被static修饰？
6、static：静态的。 Java当中static的作用非常多。
7、String[] args ：定义数组-->字符串数组

   C: int arr[10];  Java : int[] arr = .....

   字符串：String 
8、main函数的参数意义是什么？

9、System.out.println("Hello Java20!");

   "Hello Java20!"  ：字符串  
   
   System.out.println --》printf();
   println():输出 并且换行
   print()
   printf("%d\n",10)
10、javac -encoding UTF-8   文件名.java
11、
	数组名.length-->数组的长度
	
	for(int i = 0; i < args.length;i++) {
		System.out.println(args[i]);
	}
12、一个类生成一个.class文件 
    一个类对应一个字节码文件
13、int   4个字节？？？
    跨平台      有符号  没有 无符号
14、Integer是int的包装类  
    int：简单类型-》内置类型
	
15、long   8个字节
    
*/

class Test2 {
	
}

public class Test {
	public static void main(String[] args) {
		/*
		for(int i = 0; i < args.length;i++) {
			System.out.println(args[i]);
		}
		
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		int a = Integer.MAX_VALUE;//溢出
		System.out.println(a+1);
		
		//System.out.print("Hello Java20!");
		//System.out.printf("%d\n",a);
		
		long a = 10L;
		System.out.println(a);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
		
		
		double a = 12.5D;
		System.out.println(a);
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);
		
		
		//double  在底层 组织数据的方式和整形不一样
		double a = 1.1;
		double b = 1.1;
		
		System.out.println(a*b);
		*/
		//4个字节   
		float f = 12.5f;
		System.out.println(f);
		
	}
}



