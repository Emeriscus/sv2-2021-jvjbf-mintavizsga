package owlCounter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.util.SimpleTimeZone;

import static java.nio.file.Files.lines;
import static java.nio.file.Files.readAllLines;

public class OwlCounter {

    private Path path = Path.of("src/test/resources/owls.txt");

    public List<String> readFromFile(Path path) {
        try {
            List<String> lines = readAllLines(path);
            return lines;
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public int getNumberOfOwls(String county) {

        List<String> lines = readFromFile(path);

        for (String actual : lines) {
            if (getCountyFromLines(actual).equals(county.toLowerCase())) {
                return getNumberOfOwlsFromLines(actual);
            }
        }
        throw new IllegalArgumentException("No such county in Hungary!");
    }

    public int getNumberOfAllOwls() {

        List<String> lines = readFromFile(path);
        int sum = 0;

        for (String actual : lines) {
            sum += getNumberOfOwlsFromLines(actual);
        }
        return sum;
    }

    private String getCountyFromLines(String line) {
        String[] parts = line.toLowerCase().split("=");
        return parts[0];
    }

    private int getNumberOfOwlsFromLines(String line) {
        String[] parts = line.toLowerCase().split("=");
        return Integer.parseInt(parts[1]);
    }
}
