package edu.gorynych.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//"wordgoodgoodgoodbestword"
//["word","good","best","good"]

public class Substring_with_Concatenation_of_All_Words_30 {
    public static void main(String[] args) {
        var indices = new Solution().findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"});
        if (indices.equals(List.of(8))) {
            System.out.println("Success!");
        }
    }
}

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        var indices = new ArrayList<Integer>();

        var wordsCount = words.length;
        var wordsLength = words[0].length();

        var wordsMap = new HashMap<String, Integer>();
        for (var word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - wordsCount * wordsLength; i++) {
            if (isSubstringContainsAllWords(s.substring(i, i + wordsCount * wordsLength), wordsMap, wordsLength)) {
                indices.add(i);
            }
        }

        return indices;
    }

    private boolean isSubstringContainsAllWords(String substring, Map<String, Integer> wordsMap, int wordsLength) {
        var substringWordsMap = new HashMap<String, Integer>();
        for (int i = 0; i < substring.length(); i += wordsLength) {
            var wordFromSubstring = substring.substring(i, i + wordsLength);
            substringWordsMap.put(wordFromSubstring, substringWordsMap.getOrDefault(wordFromSubstring, 0) + 1);

            if (substringWordsMap.get(wordFromSubstring) > wordsMap.getOrDefault(wordFromSubstring, 0)) {
                return false;
            }
        }

        return substringWordsMap.equals(wordsMap);
    }
}
