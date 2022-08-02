package categorys;

public class Categorys {
	private int category_no;
	private String category_class;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public Categorys(int category_no,String category_class) {
		super();
		this.category_no=category_no;
		this.category_class=category_class;
	}

	public int getCategory_no() {
		return category_no;
	}

	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}

	public String getCategory_class() {
		return category_class;
	}

	public void setCategory_class(String category_class) {
		this.category_class = category_class;
	}
	
	
}
