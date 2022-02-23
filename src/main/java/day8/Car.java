package day8;

public class Car {
    private int id;
    private double speed;
    private String name;
    private float horsepower;
    private char maker;
    private boolean ishatchback;
    private long carno;
    public Car(int id, double speed, String name, float horsepower, char maker, boolean ishatchback, long carno) {
        this.id = id;
        this.speed = speed;
        this.name = name;
        this.horsepower = horsepower;
        this.maker = maker;
        this.ishatchback = ishatchback;
        this.carno = carno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(float horsepower) {
        this.horsepower = horsepower;
    }

    public char getMaker() {
        return maker;
    }

    public void setMaker(char maker) {
        this.maker = maker;
    }

    public boolean isIshatchback() {
        return ishatchback;
    }

    public void setIshatchback(boolean ishatchback) {
        this.ishatchback = ishatchback;
    }

    public long getCarno() {
        return carno;
    }

    public void setCarno(long carno) {
        this.carno = carno;
    }
}
