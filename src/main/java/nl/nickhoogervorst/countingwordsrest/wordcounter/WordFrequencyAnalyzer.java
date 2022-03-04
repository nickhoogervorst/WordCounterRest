package nl.nickhoogervorst.countingwordsrest.wordcounter;

import java.util.List;

public interface WordFrequencyAnalyzer {

    int calculateHighestFrequency(String text);
    int calculateFrequencyForWord(String text, String word);
    List<WordCounter> calculateMostFrequentNWords(String text, int n);

}
