/*
内部类
* */
class OuterClass {
    public int data1 = 1;
    private int data2 = 2;
    int data3 = 3;
    public static int size = 10;
    public OuterClass(){
        System.out.println("OuterClass()");
    }
    class InnerClass{
        public int data4 = 4;
        public int data1 = 11;
        public InnerClass(){
            System.out.println("InnerClass");
        }
        public void test(){
            System.out.println("data1:" + data1);
            System.out.println("data1:" + this.data1);
            System.out.println("out::data1:" + OuterClass.this.data1);
        }
    }
}
class OuterClass2 {
    public int data1 = 1;
    private int data2 = 2;
    int data3 = 3;
    public static int data5 = 10;

    public OuterClass2() {
        System.out.println("OuterClass2()");
    }
    static class InnerClass2 {
        public int data1 = 4;
        public static int data5 = 5;
        OuterClass2 outerClass2;
        public InnerClass2(){
            System.out.println("static::InnerClass2()");
        }
        public InnerClass2(OuterClass2 o){
            this.outerClass2 = o;
            System.out.println("static::InnerClass2(OuterClass o)");
        }
        public void test(){
            System.out.println("data1:" + this.outerClass2.data1);
            System.out.println(data1);
            System.out.println("data5:" + OuterClass2.data5 );
            System.out.println("data5:" + data5);
            System.out.println("InnerClass::test()");
        }
    }
}
class OuterClass3 {
    public int data1 = 10;
    public void test(){
        System.out.println("OuterClass3::test()");
    }
}
public class Test {
    public static <T extends Comparable<T>> TestLink.Node<T> mergeList(TestLink.Node<T> headA,TestLink.Node<T> headB){
        TestLink.Node<T> newHead = new TestLink.Node<>();
        TestLink.Node tmp = newHead;
        while (headA != null && headB != null){
            if (headA.data.compareTo(headB.data) < 0){
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            }else{
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if (headA != null){
            tmp.next = headA;
        }
        return newHead.next;
    }
    public static void main(String[] args) {
        TestLink<Integer> testLink = new TestLink<>();

        testLink.insertTail(1);
        testLink.insertTail(3);
        testLink.insertTail(5);
        testLink.insertTail(7);
        testLink.show();
        TestLink<Integer> testLink2 = new TestLink<>();
        testLink2.insertTail(2);
        testLink2.insertTail(4);
        testLink2.insertTail(6);
        testLink2.insertTail(8);
        testLink2.show();
        TestLink.Node<Integer> newHead = mergeList(testLink.head,testLink2.head);
        testLink.show2(newHead);
    }
    public static void main2(String[] args) {
        OuterClass2 outerClass2 = new OuterClass2();
        OuterClass2.InnerClass2 innerClass2 = new OuterClass2.InnerClass2(outerClass2);
        innerClass2.test();
    }
    public static void main1(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.test();
    }
}
