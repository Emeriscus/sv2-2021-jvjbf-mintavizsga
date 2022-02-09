package aquarium;

import java.util.ArrayList;
import java.util.Comparator;
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

//        for (Fish actual : fishes) {
//            actual.feed();
//        }

        fishes.stream().forEach(fish -> fish.feed());

    }

    public void removeFish(int maxWeight) {

//        List<Fish> result = new ArrayList<>();
//
//        for (Fish actual : fishes) {
//            if (actual.getWeight() <= maxWeight) {
//                result.add(actual);
//            }
//        }
//        fishes = result;

        fishes = fishes.stream()
                .filter(fish -> fish.getWeight() <= maxWeight)
                .toList();
    }

    public List<String> getStatus() {

//        List<String> result = new ArrayList<>();
//
//        for (Fish actual : fishes) {
//            result.add(actual.getStatus());
//        }
//        return result;

        return fishes.stream()
                .map(Fish::getStatus)
                .toList();
    }

    public int getNumberOfFishWithMemoryLoss() {

//        int result = 0;
//        for (Fish actual : fishes) {
//            if (actual.hasMemoryLoss())
//                result++;
//        }
//        return result;

        return (int) fishes.stream()
                .filter(fish -> fish.hasMemoryLoss())
                .count();
    }

    public boolean isThereFishWithGivenColor(String color) {

//        for (Fish actual : fishes) {
//            if (actual.getColor().equals(color)) {
//                return true;
//            }
//        }
//        return false;

        return fishes.stream()
                .anyMatch(fish -> color.equals(fish.getColor()));
    }

    public Fish getSmallestFish() {

//        int minweight = Integer.MAX_VALUE;
//        Fish result = null;
//
//        for (Fish actual : fishes) {
//            if (actual.getWeight() < minweight) {
//                minweight = actual.getWeight();
//                result = actual;
//            }
//        }
//        return result;

        return fishes.stream()
//                .min((f1, f2)->f1.getWeight()-f2.getWeight())
                // vagy:
                .min(Comparator.comparing(Fish::getWeight))
                .orElseThrow();
    }
}
