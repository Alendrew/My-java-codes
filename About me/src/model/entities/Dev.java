package model.entities;

public class Dev {
	private String frontEnd;
	private String backEnd;
	
	public Dev() {
	}
	
	public Dev(String frontEnd, String backEnd) {
		this.frontEnd = frontEnd;
		this.backEnd = backEnd;
	}

	public String getFrontEnd() {
		return frontEnd;
	}

	public void setFrontEnd(String frontEnd) {
		this.frontEnd = frontEnd;
	}

	public String getBackEnd() {
		return backEnd;
	}

	public void setBackEnd(String backEnd) {
		this.backEnd = backEnd;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("André: ");
		sb.append("\n" + getFrontEnd());
		sb.append("\n" + getBackEnd());
		return sb.toString();
	}
}
