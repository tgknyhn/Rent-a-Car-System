public abstract class AbstractVehicle implements Vehicle {
    private final String brand;
    private final String model;
    private final String color;
    private String description;

    private double price;
    private double discountPercent;
    private double score;

    private int damage;
    private int scoreCount;

    private boolean available;

    AbstractVehicle(String brand, String model, String color, String description, double cost) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.description = description;
        this.price = cost;
        damage = 0;
        discountPercent = 0;
        available = true;
        score = 0;
        scoreCount = 0;
    }

    /* Interface methods*/

    @Override
    public void giveScore(int score) {
        this.score = ((this.score * scoreCount) + score) / (scoreCount + 1);
        scoreCount++;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public void setAvailable() {
        available = !available;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getDiscountPercent() {
        return discountPercent;
    }

    @Override
    public double getDiscountedPrice() {
        return price * (discountPercent / 100);
    }

    @Override
    public double getScore() {
        return score;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }
}
