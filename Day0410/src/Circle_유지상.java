
class Circle_유지상 {
	private Point_유지상 center;
	private int radius;

	public Circle_유지상() {
		center = new Point_유지상();
	}
	
	public Circle_유지상(Point_유지상 center,int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Circle_유지상(int x, int y ,int radius) {
		center = new Point_유지상();
		center.setX(x);
		center.setY(y);
		this.radius = radius;
	}
	
	@Override
	public String toString() {
		return "Circle [center=" + center + ", radius=" + radius + "]";
	}

	public Point_유지상 getCenter() {
		return center;
	}

	public void setCenter(Point_유지상 center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public double getArea(int radius) {
		return radius * radius * 3.14;
	}
	
	public double getRound(int radius) {
		return radius * 2 * 3.14;
	}
	
	public void printCenter() {
		System.out.println("x : " + center.getX() + "y : " + center.getY());
	}

}
