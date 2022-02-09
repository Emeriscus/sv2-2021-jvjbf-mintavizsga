package uniquefinder;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class UniqueFinderWithCollections {

    public List<Character> getUniqueChars(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Text is null.");
        }

        Set<Character> result = new LinkedHashSet<>();
//        for (char actual : word.toCharArray()) {
//            result.add(actual);
//        }
//        return result.stream().toList();

        word.chars()
                .mapToObj(c -> (char) c)
                .forEach(c -> result.add(c));
        return result.stream().toList();
    }
}
