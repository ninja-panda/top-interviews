package com.google.array;

import java.util.*;

class TelephoneDigitCombinationSolution {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null) return result;
        Map<String,String> dict = new HashMap<>();
        dict.put("2","abc");
        dict.put("3","def");
        dict.put("4","ghi");
        dict.put("5","jkl");
        dict.put("6","mno");
        dict.put("7","pqrs");
        dict.put("8","tuv");
        dict.put("9","wxyz");
        String first = dict.get(digits);
        if(digits.length() == 1){
            result.add(first);
        }else{
        }



        return result;
    }
}

public class TelephoneDigitCombination {
    public static void main(String[] args) {
        TelephoneDigitCombinationSolution solution = new TelephoneDigitCombinationSolution();
        List<String> result = solution.letterCombinations("23");
        for(String s :result){
            System.out.print(s + " ,");
        }
    }
}
