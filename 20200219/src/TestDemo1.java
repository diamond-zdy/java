import java.sql.Connection;
import java.util.*;

public class TestDemo1 {
    public static void main1(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        System.out.println(set);
        //迭代器-》只要实现了iterator接口
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"asd");
        map.put(2,"kjl");
        map.put(null,"sdd");
        String s = map.get(2);
        s = map.getOrDefault(40,"ddddd");
        System.out.println(map);
        System.out.println(s);

        String s1 = map.remove(2);
        System.out.println(s1);
        System.out.println(map);

        Set<Integer> set = map.keySet();
        System.out.println(set);

        Collection<String> collection = map.values();
        System.out.println(collection);
        for (Map.Entry<Integer,String> entrySet : map.entrySet()) {
            System.out.println(entrySet.getKey() + " " + entrySet.getValue());
        }
    }
}
