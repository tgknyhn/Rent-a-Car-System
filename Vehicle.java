
public class Vehicle {
	private final String brand;
	private final String model;
	private final String color;

	private boolean available;
	private int score;
	private int damage;

	private int price;
	private int discountPercent;

	/*
	private final  String[] vehicleParts  = {"Motor","Far","Sasi","Fren Sistemi", "Camlar","Aksesuarlar"};
	private final  int[] partsHealth      = {100,100,100,100,100,100};
	private final  int[] costRatioOfPiece = {0.4,0.02,0,1,0.05,0.06,0,07};
	private final  int numberOfParts = 6;
	*/



	Vehicle(String brand, String model, String color, String description, int cost) {
		this.brand = brand;
		this.model = model;
		this.color = color;
//		this.description = description;
		this.price = cost;
		damage = 0;
		discountPercent = 0;
		available = true;
		score = 0;
//		scoreCount = 0;
	}

	/* Interface methods*/
/*
	public void giveScore(int score) {
		this.score = ((this.score * scoreCount) + score) / (scoreCount + 1);
		scoreCount++;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
*/

	public void setPrice(int price) {
		this.price = price;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void setAvailable() {
		available = !available;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public int getDamage() {
		return damage;
	}

	public double getPrice() {
		return price;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public int getDiscountedPrice() {
		return price * (discountPercent / 100);
	}

	public double getScore() {
		return score;
	}

	public boolean isAvailable() {
		return available;
	}
	
}
