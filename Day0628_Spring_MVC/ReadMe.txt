Spring MVC를 위한 라이브러리 설정
Spring : core, context, jdbc,aop,web,webmvc
Mybatis : Mybatis,Mybatis-spring
oracle : ojdbc
Aspectj: aspectjrt,aspectjweaver
log4j

스프링 MVC에서는 요청을 받고 응답하는 Servlet과 구성요소들을 포함하는 
Spring container의 역할을 Dispatcher-servlet이 담당한다. 

Dispatcher-servlet : Servlet과 container 역할을 동시에 한다.
     : 웹어플리케이션에 필요한 구성요소들을 bean으로 등록해서 포함하고 있다. 

servlet 등록 어떻게?
1. @WebServelt("/hello")  <<클래스 위에다가 직접 작성
2. web.xml에 등록 
<servlet>
	<servlet-name>dispatcher</servlet-name>
	<servlet-class></servlet-class>
</servlet>

Dispatcher-servlet의 경우 Spring container이다. 
: 설정파일의 기본 위치는 WEB-INF/{servlet-name}-servlet.xml
ex) 서블릿의 이름이 'dispatcher' 일때 
    설정파일의 경로는  WEB-INF/dispatcher-servlet.xml

dispatcher-servlet 기본 경로 변경하기 

 - <init-param>을 <servlet> 하위 태그로 추가 
   param-name, param-value를  지정하여 기본 경로 추가 

요청기능별 또는 요청을 구분하는 모듈 별로 servlet을 작성될 수 있다.
service, dao 등 DB관련 또는 공통 기능을 가지는 객체는 공통 컨테이너에 담아서 사용

먼저 dao 사용할 수 있도록 설정하기 
root-container : ContextLoaderListener
리스너(Listener)? 이벤트가 발생했을 때, 동작하도록 만들어진 클래스
웹 어플리케이션이 웹컨테이너에 로딩되는 이벤트를 받아서 처리하는 클래스

1. Contextleader



   
   
   
   













학생정보 읽어와서 화면에 출력하기 
요청 : studentList.do
화면 : studentList.jsp
Controller : HelloController
요청처리 메서드 : showStudentList()











 







