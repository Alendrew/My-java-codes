package entities;

public class Imported extends Product{
	
	private Double customFee;

	public Imported() {
	}
	
	public Imported(String name, Double price, Double customFee) {
		super(name, price);
		this.customFee = customFee;
	}

	public Double getCustomFee() {
		return customFee;
	}

	public void setCustomFee(Double customFee) {
		this.customFee = customFee;
	}
	
	public Double totalPrice() {
		return getPrice() + getCustomFee();
	}
	
	@Override
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName() + " ");
		sb.append("$ " + totalPrice()+" ");
		sb.append("(Custom fee: $ " + getCustomFee() + ")");
		return sb.toString();
	}
}
