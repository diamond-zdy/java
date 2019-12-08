import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("及时雨","宋江");
        map.put("黑旋风","李逵");
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }
}
