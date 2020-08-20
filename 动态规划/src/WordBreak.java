import java.util.Set;
/*题目描述
        给定一个字符串s和一组单词dict，判断s是否可以用空格分割成一个单词序列，使得单词序列中所有的单词都是dict中的单词（序列可以包含一个或多个单词）。
        例如:
        给定s=“leetcode”；
        dict=["leet", "code"].
        返回true，因为"leetcode"可以被分割成"leet code".

        Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
        For example, given
        s ="leetcode",
        dict =["leet", "code"].

        Return true because"leetcode"can be segmented as"leet code".*/
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict){
        boolean[] canbreak = new boolean[s.length()+1];
        canbreak[0] = true;
        for (int i = 1;i <= s.length();i++){
            for (int j = i-1;j >=0 ;j--){
                if (canbreak[j] && dict.contains(s.substring(j,i))){
                    canbreak[i] = true;
                    break;
                }
            }
        }
        return canbreak[s.length()];
    }
}
