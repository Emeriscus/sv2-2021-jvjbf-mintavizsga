package aquarium;

public class Kong extends Fish{

    public Kong(String name, int weight, String color) {
        super(name, weight, color);
    }

    @Override
    public boolean hasMemoryLoss() {
        return false;
    }

    @Override
    public void feed() {
        setWeight(getWeight()+2);
    }
}
