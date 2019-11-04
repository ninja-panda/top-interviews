package com.google.array;

import java.util.*;

class Replace {
    String source;
    String target;
    int startIndex;

    public Replace(String s, String t, int si) {
        source = s;
        target = t;
        startIndex = si;
    }
}


class StringReplaceSolution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        Map<Integer, Replace> replaceMap = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            Replace replace = new Replace(sources[i], targets[i], indexes[i]);
            replaceMap.put(replace.startIndex, replace);
        }

        int i = 0;
        StringBuffer result = new StringBuffer();
        while (i < S.length()) {
            Replace replace = replaceMap.get(i);
            if (replace == null) {
                result.append(S.charAt(i));
                i++;
            } else {
                String sourceFromS = S.substring(replace.startIndex, (replace.startIndex + replace.source.length()));
                if (sourceFromS.equals(replace.source)) {
                    result.append(replace.target);
                    i = i + replace.source.length();
                } else {
                    result.append(S.charAt(i));
                    i++;
                }
            }
        }
        return result.toString();
    }
}

public class StringReplace {

    public static void main(String[] args) {
        StringReplaceSolution stringReplaceSolution = new StringReplaceSolution();
        String S = "abcd";
        int[] indexes = {0, 2};
        String[] sources = {"ab", "ec"};
        String[] targets = {"eee", "ffff"};
        System.out.println(stringReplaceSolution.findReplaceString(S, indexes, sources, targets));
    }
}
