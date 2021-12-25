package Tree;

public class Car {
    String name;
    int price;

    public Car() {
    }

    public Car(String xName, int xPrice) {
        name = xName;
        price = xPrice;
    }

    @Override
    public String toString() {
        return "("+ name +", " + price + ")";
    }
    
}
