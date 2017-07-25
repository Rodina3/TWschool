import frequencyWordsPackage.FrequencyWords;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rzhou on 25/07/2017.
 */
public class FrequencyWordsTest {
    @Test
    public void should_split_sentence_into_single_word_with_space() throws Exception {

        //Given
        FrequencyWords fq = new FrequencyWords();
        String str = "my name is tom     i am a teacher";
        String[] results = {"my", "name", "is", "tom", "i", "am", "a", "teacher"};

        //When
        String[] words = fq.wordSplit(str);

        //Then
        assertThat(words, is(results));

    }

    @Test
    public void should_count_word_frequency() throws Exception {

        //Given
        FrequencyWords fq = new FrequencyWords();
        String[] words = {"my", "name", "my", "a", "hello", "my", "a", "teacher"};
        Map<String, Integer> resultMap = new HashMap<String, Integer>();

        for (String s : words) {
            if (resultMap.containsKey(s)) {
                resultMap.put(s, resultMap.get(s) + 1);
            } else {
                resultMap.put(s, 1);
            }
        }

        //When
        Map<String, Integer> wordsMap = fq.countWordsFrequency(words);

        //Then
        assertThat(wordsMap, is(resultMap));
    }
}