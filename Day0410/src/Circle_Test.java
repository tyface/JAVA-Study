
public class Circle_Test {

	public static void main(String[] args) {

		Point_유지상 point = new Point_유지상();
		point.setX(3);
		point.setY(4);

		// Circle c = new Circle(point,5);
		//
		// System.out.println(c.toString());
		// System.out.println(c.getArea(5));
		// System.out.println(c.getRound(5));

		// Circle c1 = new Circle(2,3,5);
		//
		// System.out.println(c1.toString());
		// System.out.println(c1.getArea(5));
		// System.out.println(c1.getRound(5));

		Circle_유지상 c2 = new Circle_유지상();
		Point_유지상 center = c2.getCenter();
		center.setX(5);

		System.out.println(c2.toString());

		Point_유지상 p = new Point_유지상();
		p.setX(11);
		p.setY(5);

		Circle_유지상 c1 = new Circle_유지상(p,5);
		System.out.println(c1.toString());
		
		
	}

}