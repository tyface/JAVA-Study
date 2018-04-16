package abstract1;

public abstract class Shape {
	protected double area;
	protected int numOfLines;
	protected String name;

	public Shape() {
		area = 0;
		numOfLines = 0;
		name = "도형";
	}

	public Shape(double area, int numOfLines, String name) {
		super();
		this.area = area;
		this.numOfLines = numOfLines;
		this.name = name;
	}

	
	public abstract void draw();

	public abstract void calArea();

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public int getNumOfLines() {
		return numOfLines;
	}

	public void setNumOfLines(int numOfLines) {
		this.numOfLines = numOfLines;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Shape [area=" + area + ", numOfLines=" + numOfLines + ", name=" + name + "]";
	}

}
