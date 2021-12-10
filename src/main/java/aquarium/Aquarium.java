package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private List<Fish> fishes = new ArrayList<>();
    static final int CAPACITY = 20;
    int actualcapacity;

    public void addFish(Fish fish) {

        if (actualcapacity == CAPACITY) {
            throw new IllegalStateException("Can not add fish because there is no more space.");
        }
        fishes.add(fish);
        actualcapacity += 5;
    }

    public void feed() {

        for (Fish actual : fishes) {
            actual.feed();
        }
    }

    public void removeFish(int maxWeight) {

        List<Fish> result = new ArrayList<>();

        for (Fish actual : fishes) {
            if (actual.getWeight() <= maxWeight) {
                result.add(actual);
            }
        }
        fishes = result;
    }

    public List<String> getStatus() {

        List<String> result = new ArrayList<>();

        for (Fish actual : fishes) {
            result.add(actual.getStatus());
        }
        return result;
    }

    public int getNumberOfFishWithMemoryLoss() {

        int result = 0;
        for (Fish actual : fishes) {
            if (actual.hasMemoryLoss())
                result++;
        }
        return result;
    }

    public boolean isThereFishWithGivenColor(String color) {

        for (Fish actual : fishes) {
            if (actual.getColor().equals(color)) {
                return true;
            }
        }
        return false;
    }

    public Fish getSmallestFish() {

        int minweight = Integer.MAX_VALUE;
        Fish result = null;

        for (Fish actual : fishes) {
            if (actual.getWeight() < minweight) {
                minweight = actual.getWeight();
                result = actual;
            }
        }
        return result;
    }
}
