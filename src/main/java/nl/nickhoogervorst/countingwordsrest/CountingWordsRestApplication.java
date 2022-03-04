package nl.nickhoogervorst.countingwordsrest;

import nl.nickhoogervorst.countingwordsrest.wordcounter.WordFrequencyCounter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountingWordsRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CountingWordsRestApplication.class, args);
    }

}
