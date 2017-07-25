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

    public Map<String, Integer> sortWords(Map<String, Integer> wordsMap) {
        return MapUtil.sortByValue(wordsMap);
    }

    public String printWordFrequency(Map<String, Integer> sortedWordMap) {
        //StringBuilder printString = new StringBuilder(" ");
        String printString = "";
        for (Map.Entry<String, Integer> entry : sortedWordMap.entrySet()) {
            //printString.append(entry.getKey()).append(entry.getValue()).append("\n");
            printString += entry.getKey() + entry.getValue() + "\n";
        }

        //return printString.toString();
        return printString;
    }
}
