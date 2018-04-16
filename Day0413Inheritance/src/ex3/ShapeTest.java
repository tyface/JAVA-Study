package ex3;

public class ShapeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Shape s = new Shape();
//		Shape s = new Rectangle(4,8);
//		Shape s = new Triangle(4,8);
		Shape s = new Circle(4);
//		Shape b = (Circle)s;
		s.draw();
//		b.calArea();
		System.out.println(s.getArea());
		
	}

}
