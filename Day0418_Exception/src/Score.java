
public class Score {
	int total;

	public Score() {
		this.total = 0;
	}

	public Score(int total) {
		super();
		this.total = total;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) throws OddNumberException {

		if (total % 2 != 0) {
			throw new OddNumberException();
		}
		this.total = total;
	}

	public void showTotal() {
		System.out.println("점수 : " + total);

	}
}
