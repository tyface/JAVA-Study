package ex3;

public class ShapeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Shape c = new Shape();
//		Shape s = new Rectangle(4,8);
//		Shape s = new Triangle(4,8);
		Circle c = new Circle(4);
		Shape s = (Shape)c;
		c = (Circle)s;
		s.draw();
//		b.calArea();
		c.c1();
//		System.out.println(s.getArea());
		
	}

}
