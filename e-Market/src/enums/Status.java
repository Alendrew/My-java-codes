package enums;

public enum Status {
	PENDING_PAYMENT(1),
	PROCESSING(2),
	SHIPPED(3),
	DELIVERD(4);
	
	private int code;
	
	Status(int code){
		this.code = code;
	}
	public int getCode() {
		return code;
	}
}
