package ex4;

import java.util.Scanner;

public class SportsAgency {
	// 운동선수 등록 조회 검색 하기 검색해서 play 시키기
	// 운동선수 종류 최소 3개이상 만들기
	// SportsPlayer
	// 운동선수들이 가지는 공통 속성 5개이상을 속성으로 가짐
	// 각변수에대한 게터셋터
	// 필수함수 play
	//
	// 나머지 서브 클래스는 이름알아서 만들고 서브클래스만 가지는 속성값 3개씩 추가\
	// play 메서드는 오버라이딩 하기

	private SportsPlayer player; // 선수 객체
	private SportsPlayer[] players; // 선수을 담을 배열 객채
	private String[] handlingEvent; // 관리중인 운동 종목을 담을 배역
	private int maxCount; // player 객체의 총개수를 저장

	private String[] menuArr; // 메뉴목록을 담을 배열
	private boolean isRun; // 프로그램 실행 상태
	private Scanner sc; // 스캐너 객체를 담을 변수

	public SportsAgency() { // 기본 생성자_정보를 기본값으로 초기화
		this.maxCount = 0;
		this.player = new SportsPlayer();
		this.players = new SportsPlayer[maxCount];
		this.handlingEvent = new String[] { "축구", "농구", "당구" };

		this.menuArr = new String[] { "선수정보보기", "선수정보추가", "선수검색", "선수삭제", "종료" };
		this.isRun = true;
	}

	public void strat() { // 프로그램을 시작하는 메소드
		while (isRun) {
			showMenu(); // 메뉴 목록을 띄우는 메소드
			selectMenu(); // 인풋으로 입력받은 값대로 해당하는 메소드를 실행하는 컨트롤러
		}
		sc.close(); // 스캐너 종료
	}

	public void showMenu() { // 메뉴 목록을 띄우는 메소드
		System.out.println("┌─────────────────  메뉴를 선택하세요   ────────────────────┐");
		System.out.print("│  ");
		// 배열에 담긴 메뉴 목록을 출력하는 반복문
		for (int i = 0; i < menuArr.length; i++) {
			System.out.printf("%d.%s   ", i + 1, menuArr[i]);
		}

		System.out.println(" │\r\n└─────────────────────────────────────────────────────┘");
	}

	public void selectMenu() { // 인풋으로 입력받은 값대로 해당하는 메소드를 실행하는 컨트롤러
		int num;
		sc = new Scanner(System.in);
		num = sc.nextInt();

		switch (num) {
		case 1:
			showAllPlayer();
			break;
		case 2:
			addPlayer(createPlayer());
			break;
		case 3:
			searchPlayer();
			break;
		case 4:
			deletePlayer();
			break;
		case 5:
			isRun = false;
			System.out.println("프로그램이 종료되었습니다.");
			break;
		default:
			System.out.println(" ※ 숫자 1번~5번중 선택해 주세요.");
			break;
		}

	}

	public void showAllPlayer() { // 모든 선수의 정보를 출력하는 메소드
		// players 배열 의 크기만큼 반복하면서 선수정보를 출력하는 반복문
		for (int i = 0; i < this.players.length; i++) {
			players[i].viewBaseInfo(); // 공통정보 출력하는 메소드
			players[i].viewInfo(); // 각 종목마다 다른 정보를 출력하는 메소드
		}
		System.out.println();
	}

	public SportsPlayer createPlayer() { // 데이터를 입력받아 player객체를 만들고 반환하는 메소드
		// 입력받을 값을 저장할 변수
		String name;
		String event;
		int age;
		double height;
		double weight;
		int selectMenu = 0;

		sc = new Scanner(System.in); // 스캐너 생성
		player = new SportsPlayer(); // player 객체 생성

		System.out.println("이름을 입력해주세요.");
		name = sc.nextLine();

		// 관리중인 종목을 표출하고 해당종목 이외의 입력값은 받지 않음
		boolean isTrue = true;
		while (isTrue) {

			System.out.println("종목을 선택해주세요.");

			// 관리중인 종목 출력하는 반목문
			for (int i = 0; i < handlingEvent.length; i++) {
				System.out.print(i + 1 + "." + handlingEvent[i] + " ");
			}
			selectMenu = sc.nextInt(); // 선택한 종목을 입력받음

			// 관리중인 종목 이외의 값을 입력받으면 반복문 재시작
			if (selectMenu < 1 || selectMenu > handlingEvent.length) {
				continue;
			}
			isTrue = false;
		} // while end
		event = handlingEvent[selectMenu - 1];

		System.out.println("나이를 입력해주세요.");
		age = sc.nextInt();

		System.out.println("신장를 입력해주세요.");
		height = sc.nextDouble();

		System.out.println("체중를 입력해주세요.");
		weight = sc.nextDouble();

		// 위에서 입력받은 기본정보를 토대로 해당 선수 객체를 생성후 해당하는 선수의 종목에 맞는 폼을 출력하고,
		// 입력을받아 해당객체 생성
		switch (selectMenu) {
		case 1:
			FootballPlayer footballP = new FootballPlayer(name, event, age, height, weight);

			System.out.println("누적득점을 입력해주세요");
			footballP.setTotalScore(sc.nextInt());
			sc.nextLine();

			System.out.println("주발을 입력해주세요");
			footballP.setMainFoot(sc.nextLine());

			System.out.println("누적레드카드를 입력해주세요");
			footballP.setTotalRedCard(sc.nextInt());

			player = footballP;
			break;
		case 2:
			BasketballPlayer basketballP = new BasketballPlayer(name, event, age, height, weight);

			System.out.println("누적득점을 입력해주세요");
			basketballP.setTotalScore(sc.nextInt());

			System.out.println("누적어시스트를 입력해주세요");
			basketballP.setTotalAassist(sc.nextInt());

			System.out.println("누적리바운드를 입력해주세요");
			basketballP.setTotalRebound(sc.nextInt());

			System.out.println("누적3점득점을 입력해주세요");
			basketballP.setTotalThreePoint(sc.nextInt());

			player = basketballP;
			break;
		case 3:
			BilliardPlayer billiardP = new BilliardPlayer(name, event, age, height, weight);

			System.out.println("평균점수를 입력해주세요");
			billiardP.setAvgGrade(sc.nextDouble());

			System.out.println("당구종목을 입력해주세요");
			sc.nextLine();
			billiardP.setBilliardEvent(sc.nextLine());

			System.out.println("제구능력을 입력해주세요");
			billiardP.setStrokeClass(sc.nextLine());

			player = billiardP;
			break;
		default:
			break;
		}
		System.out.println(" * 등록 되었습니다 * ");
		return player; // 생성된 player객체를 반환
	}

	public void addPlayer(SportsPlayer player) { // player 객체를 받아서 현제 players 배열에 추가하는 메소드
		maxCount++; // 선수을 추가할때마다 maxCount 증가
		SportsPlayer[] temp = new SportsPlayer[maxCount]; // 증가된 maxCount 크기만큼의 임시 배열 생성

		// 크기가 증가된 임시배열에 기존 Players배열 에있는 정보들을 삽입하는 반복문
		for (int i = 0; i < players.length; i++) {
			temp[i] = this.players[i];
		}

		temp[maxCount - 1] = player; // 비어있는 임시배열 마지막 인덱스에 새로운 Player객체를 입력
		players = temp; // 임시배열을 기존 Players배열 변수에 덮어씌움
	}

	public void searchPlayer() { // 선수의 이름을 입력받아 해당하는 선수정보를 출력하는 메소드
		System.out.println("검색하고싶은 선수의 이름을 입력해주세요.");
		int count = 0;// 검색된 선수의 수가 0일때 메소드를 종료 하기위한 변수
		sc = new Scanner(System.in); // 스캐너 생성
		String inputValue = sc.nextLine(); // 이름을 입력받음

		// 입력받은 이름과 같은경우에만 정보를 출력하는 반복문
		for (int i = 0; i < players.length; i++) {
			if (players[i].getName().equals(inputValue)) { // 이름 비교
				players[i].viewBaseInfo(); // 기본정보 출력
				this.players[i].viewInfo(); // 해당선수의 정보 출력
			}
		}

		if (count == 0) { // count가 0이라면 검색된 선수가 없으므로 메소드 종료
			System.out.println(" * 해당 이름의 선수가 존재하지 않습니다 * ");
			return;
		}

	}

	public void deletePlayer() { // 선수의 이름을 입력받아 해당 선수을 제외하고 players 배열에 다시 저장하는 메소드
		System.out.println("삭제하고 싶은 선수의 이름을 입력해주세요.");

		sc = new Scanner(System.in); // 스캐너 생성
		String inputValue = sc.nextLine(); // 이름을 입력받음
		int count = 0; // 이름이 같은 선수를 카운트하는 변수

		// 이름이 같은 선수가 몇명인지 확인하는 반복문
		for (int i = 0; i < players.length; i++) {
			if (players[i].getName().equals(inputValue)) {// 이름이 같다면 count증가
				count++;
			}
		}

		if (count == 0) { // count가 0이라면 검색된 선수가 없으므로 메소드 종료
			System.out.println(" * 해당 이름의 선수가 존재하지 않습니다 * ");
			return;
		}

		maxCount -= count; // 전체 선수를 뜻하는 maxCount 에서 count 만큼을 감소시킴
		SportsPlayer[] temp = new SportsPlayer[maxCount];// 감소된 크기만큼의 임시배열생성

		// 임시배열temp에 players배열에 있는 정보들을 옮기면서 이름이 같을경우 정보를 입력하지 않고 패스
		int tempIndex = 0;
		for (int i = 0; i < players.length; i++) {
			if (!players[i].getName().equals(inputValue)) { // 이름이 같지 않은경우에만 데이터를 옮김
				temp[tempIndex] = players[i];
				tempIndex++;
			}
		}
		players = temp; // 완성댄 temp배열을 기존 players 배열에 덮어씀

		System.out.println("삭제되었습니다.");
	}

	// getter,setter
	public SportsPlayer getPlayer() {
		return player;
	}

	public void setPlayer(SportsPlayer player) {
		this.player = player;
	}

	public SportsPlayer[] getPlayers() {
		return players;
	}

	public void setPlayers(SportsPlayer[] players) {
		this.players = players;
	}

	public String[] getHandlingEvent() {
		return handlingEvent;
	}

	public void setHandlingEvent(String[] handlingEvent) {
		this.handlingEvent = handlingEvent;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public String[] getMenuArr() {
		return menuArr;
	}

	public void setMenuArr(String[] menuArr) {
		this.menuArr = menuArr;
	}

	public boolean isRun() {
		return isRun;
	}

	public void setRun(boolean isRun) {
		this.isRun = isRun;
	}

}
