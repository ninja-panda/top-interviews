package com.google.array;

import java.util.LinkedList;
import java.util.List;

class Pair {
    int count;
    Character character;

    public Pair(Character ch, int count) {
        this.character = ch;
        this.count = count;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        Pair pair = (Pair) o;
        return this.character.equals(pair.character);
    }
}

class ExpressiveWordSolution {

    public int expressiveWords(String S, String[] words) {
        List<Pair> pairS = getPairList(S);
        int count = 0;
        for (String word : words) {
            if (isExpressive(word, pairS)) {
                count++;
                System.out.println("Expressive Word " + word);
            }
        }
        return count;
    }

    private boolean isExpressive(String word, List<Pair> pairS) {
        List<Pair> pairW = getPairList(word);
        if (pairS.size() != pairW.size()) {
            return false;
        }
        for (int i = 0; i < pairW.size(); i++) {
            Pair fromOriginal = pairS.get(i);
            Pair fromWord = pairW.get(i);
            int c1 = fromOriginal.count;
            int c2 = fromWord.count;
            if (!fromWord.equals(fromOriginal)) {
                return false;
            } else if (c1 == c2) {
                continue;
            } else if (c1 < c2) {
                return false;
            } else if (c1 >= 3 && c1 > c2) {
                continue;
            } else return false;
        }
        return true;
    }

    private List<Pair> getPairList(String s) {
        LinkedList<Pair> pairList = new LinkedList<>();
        if (s == null) {
            return pairList;
        }
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (pairList.isEmpty()) {
                Pair pair = new Pair(current, 1);
                pairList.add(pair);
            }else{
                Pair lastPair = pairList.getLast();
                if(lastPair.character == current){
                    lastPair.count += 1;
                }else {
                    Pair pair = new Pair(current, 1);
                    pairList.add(pair);
                }
            }
        }
        return pairList;
    }
}

public class ExpressiveWord {
    public static void main(String[] args) {
        ExpressiveWordSolution expressiveWordSolution = new ExpressiveWordSolution();
        String S = "yyrrrrrjaappoooyybbbebbbbriiiiiyyynnnvvwtwwwwwooeeexxxxxkkkkkaaaaauuuu";
        String[] words = {"yrrjappoyybbeebrriiynvvwwtwwoeexxkauu"};
        System.out.println(expressiveWordSolution.expressiveWords(S, words));
    }
}
