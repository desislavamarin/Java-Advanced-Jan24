package Ex06_DefiningClasses.P04_RawData;

public class Tire {

    private double tirePressure;
    private int tireAge;

    public Tire(double tirePressure, int tireAge) {
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;
    }

    public void setTirePressure(double tirePressure) {
        this.tirePressure = tirePressure;
    }

    public void setTireAge(int tireAge) {
        this.tireAge = tireAge;
    }

    public double getTirePressure() {
        return tirePressure;
    }

    public double getTireAge() {
        return tireAge;
    }
}
