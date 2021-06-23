import java.util.Random;
public class Vehicle {
	private final String brand;
	private final String model;

	private boolean available;
	private int score;
	private int damage;

	private int price;
	private int discountPercent;

	private final String[] vehicleParts  = {"Engine","Headlight","Chassis","Brake System", "Wheels","Others"};
	private       int[] partsHealth      = {100,100,100,100,100,100};
	private       double[] costRatioOfPiece = {0.06,0.001,0.01,0.009,0.002,0.001};
	private final int numberOfParts = 6;
	private       int totalPriceOfCar;


/**/
	public void drive() {
		Random r=new Random();
		double a=r.nextInt(100);
		if(a<10){
			makeAccident();
		}
		else{
			for(int i=0;i<numberOfParts;i++) {
				a=r.nextInt(10);
				partsHealth[i]-=a;
			}
		}
	}
/**/
	private void makeAccident(){
		Random r=new Random();
		int a;
		for(int i=0;i<numberOfParts;i++){
			a=r.nextInt(60)+40;
			partsHealth[i]-=a;
		}
	}



	public String[] getVehicleParts(){
		return vehicleParts;
}

	public int[] getPartsHealth(){
	return partsHealth;
}

	public double[] getCostRatioOfPiece(){
	return costRatioOfPiece;
}

	public int getNumberOfParts(){
	return numberOfParts;
}

	public void setPartsHealth(int [] newPartsHealth){
		partsHealth = newPartsHealth;
}

	public int getTotalPriceOfCar(){
	return totalPriceOfCar;
}



	Vehicle(String brand, String model, int price) {
		this.brand = brand;
		this.model = model;
		this.price = price;
		damage = 0;
		discountPercent = 0;
		available = true;
		score = 0;
	}

    public Vehicle() {
		this.brand = null;
		this.model = null;
		this.price = 0;
		damage = 0;
		discountPercent = 0;
		available = true;
		score = 0;
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