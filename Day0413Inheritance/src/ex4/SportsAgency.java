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
	private SportsPlayer[] players; // 선수을 답을 배열 객채
	private String[] handlingEvent;
	private int count; // 선수 객체의 총개수를 저장

	private int menu; // 선택 메뉴의 번호
	private String[] menuArr; // 메뉴를 담을 배열
	private boolean isRun; // 종료키가 입력되기 전까지 true를 표출
	private Scanner sc; // 스캐너 객체를 담을 변수

	public SportsAgency() { // 기본 생성자_정보를 기본값으로 초기화
		this.player = new SportsPlayer();
		this.players = new SportsPlayer[count];
		this.handlingEvent = new String[] { "축구", "농구", "당구" };
		this.count = 0;

		this.menuArr = new String[] { "선수정보보기", "선수정보추가", "선수검색", "선수삭제", "종료" };
		this.isRun = true;
	}

	public void strat() { // 프로그램을 시작하는 메소드
		while (isRun) {
			showMenu(); // 메뉴 목록을 띄우는 메소드
			selectMenu(); // 인풋으로 입력받은 값대로 해당하는 메소드를 실행하는 컨트롤러
		}
	}

	public void showMenu() { // 메뉴 목록을 띄우는 메소드
		System.out.println("*****************  메뉴를 선택하세요   *********************");
		System.out.print("*  ");
		for (int i = 0; i < menuArr.length; i++) {
			System.out.printf("%d.%s   ", i + 1, menuArr[i]);
		}
		System.out.println("*\r\n******************************************************");
	}

	public void selectMenu() { // 인풋으로 입력받은 값대로 해당하는 메소드를 실행하는 컨트롤러
		sc = new Scanner(System.in);
		menu = sc.nextInt();

		switch (menu) {
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
			break;
		}
	}

	public void showAllPlayer() { // 모든 선수의 정보를 출력하는 메소드
		System.out.println("\r\n=============================================================================");
		for (int i = 0; i < this.players.length; i++) {

			System.out.printf("┎ 이름 : %s / 종목 : %s / 나이 : %d / 신장 : %.2f / 체중 : %.2f \r\n", players[i].getName(),
					players[i].getEvent(), players[i].getAge(), players[i].getHeight(), players[i].getWeight());
			this.players[i].viewInfo();
		}
		System.out.println("=============================================================================\r\n");
	}

	public SportsPlayer createPlayer() { // 데이터를 입력받아 player객체를 만들고 반환하는 메소드
		String name;
		String event;
		int age;
		double height;
		double weight;
		player = new SportsPlayer();
		sc = new Scanner(System.in);
		System.out.println("이름을 입력해주세요.");
		name = sc.nextLine();
		System.out.println("종목을 선택해주세요.");

		for (int i = 0; i < handlingEvent.length; i++) {
			System.out.print(i + 1 + "."+ handlingEvent[i] + " ");
		}
		int temp = sc.nextInt();
		event = handlingEvent[temp - 1];
		System.out.println("나이를 입력해주세요.");
		age = sc.nextInt();
		System.out.println("신장를 입력해주세요.");
		height = sc.nextDouble();
		System.out.println("체중를 입력해주세요.");
		weight = sc.nextDouble();

		switch (temp) {
		case 1:
			FootballPlayer fFlayer = new FootballPlayer(name,event,age,height,weight);
			System.out.println("누적득점을 입력해주세요");
			fFlayer.setTotalScore(sc.nextInt());
			System.out.println("주발을 입력해주세요");
			fFlayer.setMainFoot(sc.nextLine());
			System.out.println("누적레드카드를 입력해주세요");
			fFlayer.setTotalRedCard(sc.nextInt());
			player = fFlayer;
			break;
		case 2:
			BasketballPlayer bPlayer =  new BasketballPlayer(name,event,age,height,weight);
			System.out.println("누적득점을 입력해주세요");
			bPlayer.setTotalScore(sc.nextInt());
			System.out.println("누적어시스트를 입력해주세요");
			bPlayer.setTotalAassist(sc.nextInt());
			System.out.println("누적리바운드를 입력해주세요");
			bPlayer.setTotalRebound(sc.nextInt());
			System.out.println("누적3점득점을 입력해주세요");
			bPlayer.setTotalThreePoint(sc.nextInt());
			player = bPlayer;
			break;
		case 3:
			BilliardPlayer bPlayer2 =  new BilliardPlayer(name,event,age,height,weight);
			System.out.println("평균점수를 입력해주세요");
			bPlayer2.setAvgGrade(sc.nextDouble());
			System.out.println("당구종목을 입력해주세요");
			sc.nextLine();
			bPlayer2.setBilliardEvent(sc.nextLine());
			System.out.println("제구능력을 입력해주세요");
			bPlayer2.setStrokeClass(sc.nextLine());
			player = bPlayer2;
			break;
		default:
			break;
		}
		System.out.println("등록 되었습니다.");
		return player;
	}

	public void addPlayer(SportsPlayer player) { // player 객체를 받아서 현제 players 배열에 추가하는 메소드
		count++; // 선수을 추가할때마다 전체선수수 증가
		SportsPlayer[] temp = new SportsPlayer[count]; // 증가된 전체선수수 크기만큼의 임시 배열 생성

		// 크기가 증가된 임시배열에 기존 Players배열 에있는 정보들을 삽입하는 반복문
		for (int i = 0; i < players.length; i++) {
			temp[i] = this.players[i];
		}
		temp[count - 1] = player; // 임시배열 마지막 인덱스에 새로운 Player객체를 추가
		players = temp; // 임시배열을 기존 Playerㄴ배열 변수에 삽입
	}

	public void searchPlayer() { // 선수의 이름을 입력받아 해당하는 선수을 출력하는 메소드
		System.out.println("검색하고싶은 선수의 이름을 입력해주세요.");
		sc = new Scanner(System.in);
		String inputName = sc.nextLine();

		System.out.println("\r\n=============================================================================");
		for (int i = 0; i < players.length; i++) {
			if (players[i].getName().equals(inputName)) {
				System.out.printf("┎ 이름 : %s / 종목 : %s / 나이 : %d / 신장 : %.2f / 체중 : %.2f \r\n", players[i].getName(),
						players[i].getEvent(), players[i].getAge(), players[i].getHeight(), players[i].getWeight());
				this.players[i].viewInfo();
			}
		}
		System.out.println("=============================================================================\r\n");
	}

	public void deletePlayer() { // 선수의 이름을 입력받아 해당 선수을 제외하고 players 배열에 다시 저장하는 메소드
		System.out.println("삭제하고 싶은 선수의 이름을 입력해주세요.");
		sc = new Scanner(System.in);
		String inputName = sc.nextLine();
		int num = 0;

		for (int i = 0; i < players.length; i++) {
			if (players[i].getName().equals(inputName)) {
				num += 1;
			}
		}

		count -= num;
		SportsPlayer[] temp = new SportsPlayer[count];

		int tempIndex = 0;
		for (int i = 0; i < players.length; i++) {

			if (!players[i].getName().equals(inputName)) {
				temp[tempIndex] = players[i];
				tempIndex++;
			}
		}
		players = temp;

		System.out.println("삭제되었습니다.");
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

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

}
