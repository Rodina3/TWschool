import frequencyWordsPackage.FrequencyWords;
import org.junit.Test;

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
}