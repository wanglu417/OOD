public class PetRock {
    private String name;
    private boolean happy = false; //default value is false
    private double mass; // in grams

    public PetRock(String name, double mass) {
        if (name.isEmpty()) {
            throw new IllegalStateException();
        }
        this.name = name;
        if (mass == 0.0) {
            throw new IllegalStateException();
        }
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public double getMass() {
        return mass;

    }

    public boolean isHappy() {
        return happy;
    }

    public void playWithRock() {
        happy = true;
    }

    public String getHappyMessage() {
        if (!happy) {
            throw new IllegalStateException();
        }
        return "I'm happy!";
    }

    public int getFavNumber() {
        return 42;
    }

    public String toString() {
        return "I am a Happy PetRock!";

    }
}