
public class AnonymousTest3 {
	public static void main(String[] args) {
		Drawable d = new Drawable() {
			public void draw() {
				System.out.println("별을 그립니다.");
			}
		};
		
		d.draw();
		
	}
}
