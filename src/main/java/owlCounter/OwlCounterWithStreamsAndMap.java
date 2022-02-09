package owlCounter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.nio.file.Files.readAllLines;

public class OwlCounterWithStreamsAndMap {

    private Path path = Path.of("src/test/resources/owls.txt");
    private Map<String, Integer> owls = new HashMap<>();

    public Map<String, Integer> getOwls() {
        return owls;
    }

    public List<String> readFromFile(Path path) {
        try {
            return readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public void linesToMap(List<String> lines) {
        for (String actual : lines) {
            String[] parts = actual.toLowerCase().split("=");
            owls.put(parts[0], Integer.parseInt(parts[1]));
        }
    }

    public int getNumberOfOwls(String county) {
//        Optional<Integer> opt = Optional.ofNullable(owls.get(county.toLowerCase()));
//        return opt.orElseThrow(() -> new IllegalArgumentException("No such county in Hungary!"));
        return Optional.ofNullable(owls.get(county.toLowerCase())).
                orElseThrow(() -> new IllegalArgumentException("No such county in Hungary!"));
    }

    public int getNumberOfAllOwls() {
        return owls.values().stream()
//                .mapToInt(i->i)// vagy:
                .mapToInt(Integer::intValue)
                .sum();
    }
}
