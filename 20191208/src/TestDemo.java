import java.util.ArrayList;
import java.util.List;

class Student{
    String name;
    String grade;
    double score;

    public Student(String name, String grade, double score) {
        this.name = name;
        this.grade = grade;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", score=" + score +
                '}';
    }
}
public class TestDemo {
    public static List<Character> func(String str1,String str2){
        List<Character> ret = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (!str2.contains(ch + "")){
                ret.add(ch);
            }
        }
        return ret;
    }

    public static void main2(String[] args) {
        List<Character> list = func("welcome to bit","come");
        //Object obj = list.toArray();
        System.out.println(list);
    }
    public static void main1(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("ww","06",77));
        list.add(new Student("yy","06",99));
        list.add(new Student("ll","06",88));
        System.out.println(list);
        System.out.println("================");
        for (Student student:list) {
            System.out.println(student);
        }
    }
}
