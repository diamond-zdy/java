import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/*longest-substring-without-repeating-characters
给定一个字符串，找出最长的不具有重复字符的子串的长度。例如，“abcabcbb”不具有重复字符的最长子串是“abc”，长度为3。对于“bbbbb”，最长的不具有重复字符的子串是“b”，长度为1。

        Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.

        示例1
        输入
        复制
        ""
        输出
        复制
        0*/
/*解题思路
    "滑动窗口"
    比方说 abcabccc 当你右边扫描到abca的时候你得把第一个a删掉得到bca，
    然后"窗口"继续向右滑动，每当加到一个新char的时候，左边检查有无重复的char，
    然后如果没有重复的就正常添加，
    有重复的话就左边扔掉一部分（从最左到重复char这段扔掉），在这个过程中记录最大窗口长度
*/
public class Solution {
    /*public static int lengthOfLongestSubstring (String s) {
        // write code here
        if(s == null || s.length() == 0 || s.equals("")){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            left = Math.max(left,(map.containsKey(c)?map.get(c)+1:0));
            max = Math.max(max,i-left+1);
            map.put(c,i);
        }
        return max;
    }*/
    public static int lengthOfLongestSubstring1 (String s){
        if(s == null || s.length() == 0 || s.equals("")){
            return 0;
        }
        Stack<Character> stack =new Stack<>();
        int max = 0;
        for (int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if (stack.contains(c)){
                int sizeOfStack = stack.size();
                if (sizeOfStack > max){
                    max = sizeOfStack;
                }
                Stack<Character> tmpStack = new Stack<>();
                while (!stack.isEmpty()){
                    char popChar = stack.pop();
                    if (popChar == c){
                        stack.clear();
                    }else {
                        tmpStack.add(popChar);
                    }
                }

                while (!tmpStack.isEmpty()){
                    stack.add(tmpStack.pop());
                }
                tmpStack.clear();
            }
            stack.add(c);
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String s = sc.nextLine();
            int max = lengthOfLongestSubstring1(s);
            System.out.println(max);
        }
    }
}
