import java.util.*;

import static java.util.Collections.*;

public class WordBreak_139 {
//DFS
//    public static boolean wordBreak(String s, List<String> wordDict) {
//       Set<String> words = new HashSet<>(wordDict);
//       return subString(s, words);
//    }
//    public static boolean subString(String s, Set<String> words){
//        int len = s.length();
//        if (len == 0) {
//            return true;
//        }
//        for(int i =1; i<=len;i++){
//            System.out.print(s.substring(0,i)+"\t");
//            System.out.print(words.contains(s.substring(0,i))+"\t");
//            System.out.println(s.substring(i));
//            if(words.contains(s.substring(0,i)) && subString(s.substring(i), words)){
//                System.out.println("return true");
//                return true;
//            }
//        }
//        return false;
//    }

    //BFS
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        HashSet<String> v = new HashSet<>();
        while (!q.isEmpty()) {
            String t = q.poll();
            for (int i = 1; i <= t.length(); i++) {
                if (set.contains(t.substring(0, i))) {
                    if (i == t.length()) return true;
                    if (!v.contains(t.substring(i))) {
                        q.offer(t.substring(i));
                        v.add(t.substring( i));
                    }
                }
            }

        }
        return false;
    }

    public static void main(String[] args){
        List<String> test = new ArrayList<>();
        test.add("apple");
        test.add("pen");
        wordBreak("applepenapple",test);
    }
}
