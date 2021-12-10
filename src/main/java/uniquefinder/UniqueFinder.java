package uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {


    public List<Character> getUniqueChars(String word) {

        if (word == null) {
            throw new IllegalArgumentException("Text is null.");
        }

        List<Character> result = new ArrayList<>();

        for (Character actual : word.toCharArray()) {
            if (isUniqueCharacter(actual, result)) {
                result.add(actual);
            }
        }
        return result;
    }

    private boolean isUniqueCharacter(char character, List<Character> characterList) {

        for (char actual : characterList) {
            if (actual == character) {
                return false;
            }
        }
        return true;
    }
}