
public class StudentManagementTest {
	public static void main(String[] args) {
		StudentManagement2 sm = new StudentManagement2();
		
		//테스트용 데이터 입력
		sm.setStudents(new StudentList(new Student[] {
				new Student("유지상",7,80,77,91),
				new Student("김창목",2,60,72,95),
				new Student("유지상",1,70,71,85),
				new Student("이준성",5,87,73,73),
				new Student("홍길동",6,89,74,61),
		}));
		
		sm.strat();//시스템 시작
	}
}
