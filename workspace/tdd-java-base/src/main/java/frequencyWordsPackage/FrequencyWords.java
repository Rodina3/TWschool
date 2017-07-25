package frequencyWordsPackage;

import java.util.*;

/**
 * Created by rzhou on 25/07/2017.
 */
public class FrequencyWords {


    public String[] wordSplit(String str) {
        return str.split(" +");

    }

    public Map<String, Integer> countWordsFrequency(String[] words) {
        Map<String, Integer> wordsMap = new HashMap<String, Integer>();
        for (String s : words) {

            if (wordsMap.containsKey(s)) {
                wordsMap.put(s, wordsMap.get(s) + 1);
            } else {
                wordsMap.put(s, 1);
            }
        }
        return wordsMap;
    }

    public Map<String,Integer> sortWords(Map<String, Integer> wordsMap) {
        MapUtil sorting = new MapUtil();
        Map<String,Integer> wordsSorted =sorting.sortByValue(wordsMap);
        return wordsSorted;

    }

}
