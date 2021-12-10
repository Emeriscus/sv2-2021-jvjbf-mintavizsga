package aquarium;

public abstract class Fish {

    private String name;
    protected int weight;     // ha ez protected, akkor nem kell setter...
    private String color;

    public Fish(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public String getStatus() {
        return name + ", weight: " + weight + ", color: " + color + ", short-term memory loss: " + hasMemoryLoss();
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public abstract boolean hasMemoryLoss();

    public abstract void feed();
}
