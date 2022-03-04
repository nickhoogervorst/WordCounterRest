package nl.nickhoogervorst.countingwordsrest.wordcounter;

public class WordCounter implements WordFrequency {

    private final String word;

    private int frequency;

    public WordCounter(String word) {
        this.word = word;
        this.frequency = 1;
    }

    @Override
    public String getWord() {
        return this.word;
    }

    @Override
    public int getFrequency() {
        return this.frequency;
    }

    public void increaseFrequencyByOne() {
        this.frequency += 1;
    }

    public String toString() {
        return "(\"" + getWord() + "\", " + getFrequency() + ")";
    }

}
