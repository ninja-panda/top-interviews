package com.google.array;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/*s = "aaabbcc"
dict = ["aaa","aab","bc"]
Output:
"<b>aaabbc</b>c"
"aaa",
"aab"
*/
class InsertBoldSolution {

    public String addBoldTag(String s, String[] dict) {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        if (s == null || dict == null || dict.length == 0) {
            return "";
        }
        Arrays.sort(dict);
        for (int i = 0; i < dict.length - 1; i++) {
            String first = dict[i];
            String second = dict[i + 1];
            String lastF = first.substring(first.length() - 1);
            String firstS = second.substring(0, 1);
            if (lastF.equals(firstS)) {
                String merged = merge(first, second);
                dict[i] = null;
                dict[i + 1] = merged;
            }
        }
        for (String word : dict) {
            if(word != null){
                if(s.contains(word)){
                    s = s.replace(word,"<b>" +  word + "</b>");
                }
            }
        }
        return s;
    }

    private String merge(String first, String second) {
        StringBuffer buffer = new StringBuffer();
        int lenF = first.length();
        int lenS = second.length();
        int fi = 0, si = 0;
        while (fi < lenF && si < lenS) {
            if (first.charAt(fi) == second.charAt(si)) {
                buffer.append(first.charAt(fi));
                fi++;
                si++;
            } else {
                buffer.append(first.charAt(fi));
                fi++;
            }
        }
        if (si <= (second.length() - 1)) {
            while (si < second.length()) {
                buffer.append(second.charAt(si));
                si++;
            }
        }
        return buffer.toString();
    }
}

public class InsertBold {

    public static void main(String[] args) {
        InsertBoldSolution insertBoldSolution = new InsertBoldSolution();
        String[] dict = {"aaa", "aab", "bc"};
        String s = insertBoldSolution.addBoldTag("aaab", dict);
        System.out.println(s);
    }
}
