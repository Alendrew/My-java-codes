package model.enums;

public enum Type {
	SOURCE(1),
	RESULT(2);
	
	private int code;

	private Type(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

}
