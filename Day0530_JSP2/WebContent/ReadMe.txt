화면에서 데이터를 입력받아서 DB로 데이터 처리 하기(DAO)
기능
- 로그인/로그아웃
- 회원가입
- 회원목록 보기
- 회원정보 수정 (보류)
------------------------------------------------
package
-dao
	ConnectionProvider.java
	MemberDao.java
		insertMember(Member)
		updateMember(Member) : where 조건 , id = member.id
		deleteMember(String id) : where 조건 , id = member.id
		selectOne(String id): where 조건 , id = member.id
		selectAll()
-servlet
	MemberServlet.java
	화면보여달라는 요청을 .jsp 가 아니라.... 요청을 따로 받을 거에요
	ex)loginForm 화면을 보고 싶다면
	요청 loginForm  >> loginForm.jsp으로 포워딩









요청목록
	loginForm : 로그인화면 보여달라는 요청
				loginForm.jsp로 포워딩
	login     : 로그인 로직처리 요청
	            MemberService.login()호출
	            login이 true반환하면,
	            session에 'userid'속성 지정하고 main 요청 redirect
	            false 반환하면 loginForm 요청 redirect
	logout    : 로그아웃 로직처리
				session에서 'userid' 속성 삭제
				loginForm 요청 redirect
	main      : 메인화면 보여달라는 요청
				(단, 로그인 되어있을 때만 메인화면 포워딩,
				 로그인 되어있지 않으면,loginForm 요청 redirect)
	memberList : 화면에 회원목록을 보여달라는 요청
				MemberService.allMembers() 메서드 이용해서
				회원목록 가져오고 요청에 데이터 담아서  memberList.jsp로 포워딩
	보류 modifyForm : 수정화면 보여달라는 요청
	보류 modify  : 수정로직처리 요청

	joinForm : 회원가입화면 요청
				joinForm.jsp로 포워딩
	join     : 회원가입 로직처리 요청
				joinForm에서 파라미터 전달받아서
				데이터 베이스에 넣기
				실패하면, joinForm 요청 redirect
				성공하면, loginForm 요청 redirect

-model
	Member.java (getter,setter 포함)
		id : 문자열
		pw : 문자열
		name : 문자열
		email : 문자열
		regDate : 날짜
-service
	MemberService.java : 실제로 로직을 처리하는 코드를 포함를 클래스
	login(String id,String pw):boolean
		id와 pw를 전달받아서 동일한 id 비밀번호가 존재하면 true
		아니면 false
	join(Member) : boolean
		Member의 속성으로 DB에 insert
		성공하면true, 실패하면 false
	modify(Member):boolean
	    Member의 속성으로 DB에 update
		성공하면true, 실패하면 false

------------------------------------------------
화면목록(jsp)
loginForm.jsp
	입력창: 아이디,비밀번호
	제출(submit): 로그인(login)
	버튼 : 회원가입버튼(joinForm)
joinForm.jsp
	입력창 : 아이디,이름,비번,이메일
	제출(submit) : 회원가입 (join)
memberList.jsp
	모든 회원 목록 출력: 출력 모양은 알아서 잘..이쁘게
	뒤로가기 버튼
보류 modifyForm.jsp
main.jsp
	아이디님 반갑습니다!!
	버튼 : 회원목록보기(memberList), 로그아웃(logout)

***main, memberList 화면은 로그인 상태일 때만 보여주기****
