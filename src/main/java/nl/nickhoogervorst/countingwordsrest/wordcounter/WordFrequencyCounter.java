package nl.nickhoogervorst.countingwordsrest.wordcounter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WordFrequencyCounter implements WordFrequencyAnalyzer{

    @Override
    public int calculateHighestFrequency(String text) {

        //check if input is empty
        if (text.isEmpty()) {
            return 0;
        }

        List<WordCounter> wordFrequencyList = createWordCounterList(text);

        int highestFrequency = 0;

        for (WordCounter wordCounter: wordFrequencyList) {

            int wordFrequency = wordCounter.getFrequency();
            if (wordFrequency > highestFrequency) {
                highestFrequency = wordFrequency;
            }

        }

        return highestFrequency;
    }

    @Override
    public int calculateFrequencyForWord(String text, String word) {

        //check if input is empty
        if (text.isEmpty() || word.isEmpty()) {
            return 0;
        }

        List<WordCounter> wordFrequencyList = createWordCounterList(text);

        for (WordCounter wordCounter: wordFrequencyList) {

            if (wordCounter.getWord().equalsIgnoreCase(word)) {
                return wordCounter.getFrequency();
            }

        }

        return 0;
    }

    @Override
    public List<WordCounter> calculateMostFrequentNWords(String text, int n) {

        //check if input is empty
        if (text.isEmpty() || n == 0) {
            return null;
        }

        //create
        List<WordCounter> wordFrequencyList = createWordCounterList(text);

        wordFrequencyList.sort(Comparator.comparingInt(WordCounter::getFrequency).reversed()
                .thenComparing(WordCounter::getWord));

        int elementsToRemove = wordFrequencyList.size() - n;

        for (int i = 0; i < elementsToRemove; i++) {
            wordFrequencyList.remove(wordFrequencyList.size() - 1);
        }

        return wordFrequencyList;
    }

    private void addWordToWordFrequencyList(String word, List<WordCounter> wordCounters){

        //check if word is already in wordlist and increase frequency if true
        for (WordCounter wordCounter : wordCounters) {
            if (wordCounter.getWord().equalsIgnoreCase(word)) {
                wordCounter.increaseFrequencyByOne();
                return;
            }
        }

        //if not in wordlist add to wordlist
        WordCounter wordCounter = new WordCounter(word.toLowerCase());
        wordCounters.add(wordCounter);

    }

    private List<WordCounter> createWordCounterList(String text) {

        // make character array out of String input.
        // get number of location of last character in the character array.
        //      this is used later to check if the last character is a letter
        //      and therefore needs to be added to the current word.
        // arrayList is made to store all the words with their respective count
        // a String is made where each character that is a letter gets added to.
        //      at the end of each word if a non-letter gets encountered this string becomes empty again.
        char[] characters = text.toCharArray();
        int endCharacterNumber = characters.length - 1;
        List<WordCounter> wordArray = new ArrayList<>();
        String word = "";

        for (int i = 0; i < characters.length; i++) {

            char currentCharacter = characters[i];

            if (Character.isLetter(currentCharacter) && i != endCharacterNumber) {
                //check if character is letter, if true then add to word.
                word += currentCharacter;
            } else if (!Character.isLetter(currentCharacter) && !word.isEmpty()) {
                //check if character is not a letter, if true add word to words list and reset word to an empty string
                addWordToWordFrequencyList(word, wordArray);
                word = "";
            } else if(Character.isLetter(currentCharacter) && i == endCharacterNumber) {
                //check if last character in text is a letter, if true
                word += currentCharacter;
                addWordToWordFrequencyList(word, wordArray);
                word = "";
            }

        }
        return wordArray;
    }
}


