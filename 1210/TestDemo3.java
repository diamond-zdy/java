import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-12-08
 * Time: 14:32
 */
class Person2 implements Comparable<Person2>{
    public String name;
    public int age;
    public Person2(String name,int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person2 o) {
        if(this.age > o.age) {
            return 1;
        }else if(this.age < o.age) {
            return -1;
        }else {
            return 0;
        }
        //return this.age-o.age;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student {
    public String name;
    public String classes;
    public double score;

    public Student(String name, String classes, double score) {
        this.name = name;
        this.classes = classes;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", score=" + score +
                '}';
    }
}

public class TestDemo3 {

    public static void main(String[] args) {
        CardDemo cardDemo = new CardDemo();
        List<Card> list = cardDemo.buyPuke();
        System.out.println(list);
        cardDemo.shuffle(list);
        System.out.println("洗牌：");
        System.out.println(list);
        System.out.println("发牌：");

        List<List<Card>> hands = new ArrayList<>();

        List<Card> human1 = new ArrayList<>();
        List<Card> human2 = new ArrayList<>();
        List<Card> human3 = new ArrayList<>();

        hands.add(human1);
        hands.add(human2);
        hands.add(human3);
        //3个人抓5张牌
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                Card catchCard = list.remove(0);
                hands.get(i).add(catchCard);
            }
        }
        System.out.println("第一个人的牌：");
        System.out.println(human1);
        System.out.println("第二个人的牌：");
        System.out.println(human2);
        System.out.println("第三个人的牌：");
        System.out.println(human3);
        System.out.println("剩下的牌：");
        System.out.println(list);
    }





    //numRows：你的行数
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();

        if(numRows == 0) {
            return triangle;
        }
        triangle.add(new ArrayList<>());//0
        triangle.get(0).add(1);
        //行数
        for (int i = 1; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);
            //上一行
            List<Integer> prevRow = triangle.get(i-1);
            //第i行的第j列
            for (int j = 1; j < i; j++) {
                int tmp = prevRow.get(j-1)+prevRow.get(j);
                curRow.add(tmp);
            }
            curRow.add(1);
            triangle.add(curRow);
        }
        return triangle;
    }

    public static void main5(String[] args) {
        List<List<Integer>> ret = generate(5);

        for (List<Integer> list  : ret) {
            System.out.println(list);
        }
    }


    public static List<Character> func(String str1,String str2) {
        List<Character> ret = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if(!str2.contains(ch+"")){
                ret.add(ch);
            }
        }
        return ret;
    }

    public static void main4(String[] args) {
        List<Character> list = func("welcome to bit","come");
        Object[] obj = list.toArray();
        System.out.println();
    }

    public static void main3(String[] args) {
        List<Student> list = new ArrayList<>();
        Student student1 = new Student("孙芮","Java20",99.99);
        Student student2 = new Student("高博","Java20",19.9);
        Student student3 = new Student("曹操","Java20",78.67);
        list.add(student1);
        list.add(student2);
        list.add(student3);

        System.out.println(list);
        System.out.println("===========");
        for (Student student  : list) {
            System.out.println(student);
        }
    }

    public static void main2(String[] args) {
        List<Person2> list = new ArrayList<>();
        list.add(new Person2("zhangfei",18));
        list.add(new Person2("caocao",38));
        list.add(new Person2("guanyu",28));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }


    public static void main1(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(4);
        list.add(7);
        list.add(6);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
