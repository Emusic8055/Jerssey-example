package foo.bar;

public class Book {
	
	String Name;
	int id;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Book(String name, int id) {
		super();
		Name = name;
		this.id = id;
	}
	

}
