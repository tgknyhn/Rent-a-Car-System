public abstract class AbstractVehicle implements Vehicle {
    private final String name;
    private final String brand;
    private final String type;
    private String description;

    private double cost;
    private double discountPercent;

    private int damage;

    /*Technical variables: max speed, baggage capacity etc.*/

    AbstractVehicle(String name, String brand, String type, String description, double cost) {
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.description = description;
        this.cost = cost;
        damage = 0;
        discountPercent = 0;
    }

    /* Interface methods*/

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public double getDiscountedCost() {
        return cost * (discountPercent / 100);
    }

    /*Getters for technical variables*/
}