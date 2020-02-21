public class Test {
    public static void main(String[] args) {
        HashBucket hashBucket = new HashBucket();
        hashBucket.put(1,45);
        hashBucket.put(1,33);
        hashBucket.put(2,89);
        hashBucket.put(4,34);
        hashBucket.put(5,56);
        System.out.println("==========");
        System.out.println(hashBucket.getValue(1));
    }
}
