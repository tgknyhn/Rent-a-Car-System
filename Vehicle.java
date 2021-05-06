public interface Vehicle {
    int getDamage();
    //int getStock();

    double getPrice();
    double getDiscountPercent();
    double getDiscountedPrice();
    double getScore();

    String getModel();
    String getBrand();
    String getDescription();
    String getColor();

    boolean isAvailable();

    void giveScore(int score);

    void setDamage(int damage);
    void setPrice(double price);
    void setDescription(String description);
    void setDiscountPercent(double discountPercent);
    void setAvailable();
    /*void setColor(String color);
    void setModel(String model);
    void setStock(int a);*/
}
