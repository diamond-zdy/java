import java.util.*;

public class Test {
    //找出前k个最大的数
    public static Integer[] findKNum(int[] array,int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);//小堆
                //return o2.compareTo(o1);//大堆
            }
        });
        for (int i = 0;i < array.length;i++){
            if (minHeap.size() < k){
                minHeap.add(array[i]);
            }else {
                Integer top = minHeap.peek();
                if (top != null && top < array[i]){
                    minHeap.poll();
                    minHeap.add(array[i]);
                }
            }
        }
        Integer[] integers = new Integer[k];
        for (int i = 0;i < k;i++){
            Integer top = minHeap.peek();
            integers[i] = top;
            minHeap.poll();
        }
        return integers;
    }
    public static List<String> topKFrequent(String[] words,int k){
        //遍历words数组，将单词和每个单词出现的次数一一对应
        Map<String,Integer> map = new HashMap<>();
        for (String s : words){
            //看字符串s是否已经在map中有对应关系
            if (map.get(s) == null){
                map.put(s,1);
            }else {
                map.put(s,map.get(s) + 1);
            }
        }
        PriorityQueue<Map.Entry<String,Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())){
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<String,Integer> entry : map.entrySet()){
            if (minHeap.size() < k){
                minHeap.add(entry);
            }else {
                Map.Entry<String,Integer> top = minHeap.peek();
                //频率相同
                if (top != null && top.getValue().equals(entry.getValue())){
                    if (top.getKey().compareTo(entry.getKey()) > 0){
                        minHeap.poll();
                        minHeap.add(entry);
                    }
                }else {
                    if (top != null && top.getValue() < entry.getValue()){
                        minHeap.poll();
                        minHeap.add(entry);
                    }
                }
            }
        }
        System.out.println(minHeap);
        List<String> list = new ArrayList<>();
        for (int i = 0;i < k;i++){
            String pop = minHeap.peek().getKey();
            list.add(0,pop);
            minHeap.poll();
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = {12,34,23,66,44,32,78,56};
        Integer[] ret = findKNum(array,4);
        System.out.println(Arrays.toString(ret));
    }
}
