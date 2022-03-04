package nl.nickhoogervorst.countingwordsrest;

import nl.nickhoogervorst.countingwordsrest.wordcounter.WordCounter;
import nl.nickhoogervorst.countingwordsrest.wordcounter.WordFrequencyCounter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WordCountController {

    private WordFrequencyCounter wordFrequencyCounter;

    @GetMapping("/calculateHighestFrequency")
    public int wordCounter(@RequestParam String text) {

        this.wordFrequencyCounter = new WordFrequencyCounter();

        return wordFrequencyCounter.calculateHighestFrequency(text);

    }

    @GetMapping("/calculateFrequencyForWord")
    public int wordCounter(@RequestParam String text, @RequestParam String word) {

        this.wordFrequencyCounter = new WordFrequencyCounter();

        return wordFrequencyCounter.calculateFrequencyForWord(text, word);
    }

    @GetMapping("/calculateMostFrequentNWords")
    public String wordCounter(@RequestParam String text, @RequestParam int amountOfWords) {

        this.wordFrequencyCounter = new WordFrequencyCounter();

        return wordFrequencyCounter.calculateMostFrequentNWords(text, amountOfWords).toString();
    }

}
