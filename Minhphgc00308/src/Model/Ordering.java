package Model;

public class Ordering {
	public String pcode;
	public String ccode;
	public Integer quantity;
	@Override
	public String toString() {
		return "Ordering [pcode=" + pcode + ", ccode=" + ccode + ", quantity=" + quantity + "]";
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getCcode() {
		return ccode;
	}
	public void setCcode(String ccode) {
		this.ccode = ccode;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Ordering(String pcode, String ccode, Integer quantity) {
		super();
		this.pcode = pcode;
		this.ccode = ccode;
		this.quantity = quantity;
	}
	public Ordering() {
		super();
		// TODO Auto-generated constructor stub
	}


}
