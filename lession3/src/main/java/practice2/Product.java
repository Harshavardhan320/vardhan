package practice2;

public class Product {
	
	
	private int id;
	private String product_name;
	private int product_prise;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_prise() {
		return product_prise;
	}
	public void setProduct_prise(int product_prise) {
		this.product_prise = product_prise;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", product_name=" + product_name + ", product_prise=" + product_prise + "]";
	}
	
	
	
}
