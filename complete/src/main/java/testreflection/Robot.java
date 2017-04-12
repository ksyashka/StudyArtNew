package testreflection;

/**
 * Created by Yuriy on 12.04.2017.
 */
public class Robot {//POJO class-model: default const, get,set

    private int id;
    private String model;
    private double price;


    @Override
    public String toString() {
        return "Robot{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }

    public Robot(int id, String model, double price) {
        this.id = id;
        this.model = model;
        this.price = price;
    }

    public Robot() {

    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Robot robot = (Robot) o;

        return id == robot.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
