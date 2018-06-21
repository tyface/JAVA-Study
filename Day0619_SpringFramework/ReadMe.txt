Spring framework 프로젝트 만들기 
1. Maven설정(library 관리 툴),
   pom.xml(우리가 사용할 라이브러리 등록)
   :라이브러리를 등록하면 실제로 다운받아서 프로젝트에서 사용할 수 있게 만들어줌
   다운경로: C:\Users\{사용자이름}\.m2\repository
   
   메이븐이 멍청하면 m2 폴더에 있는 라이브러리 폴더 삭제 후 다시 다운받으시면 됩니다. 
 
 *** 프로젝트에서 메이븐 설정 삭제 / 재설정 하기 ***
 1. pom.xml 삭제 (내용이 혹시 필요하면 복사 해두기)
 2. 프로젝트 우클릭 > Maven > Disable Maven Nature
 3. 프로젝트 클린 후, Maven 프로젝트로 재 설정
  
   
 Spring Framework 는 제어역전과 의존성 주입을 지원한다.    
   제어역전(Inversion Of Control) : 어플리케이션에서 사용되는 객체들을 미리 Spring container에 등록해 두고 사용한다. 
        , 스프링컨테이너가 로딩될 때 등록된 Bean들의 객체를 생성해서 
                       어플리케이션에서 사용할 때 컨테이너에 보관된 객체를 사용. 
        ** Bean 객체 생성할 때, 예외가 발생하면, 스프링컨테이너 자체가 로딩되지 않음 **
 
 의존성 주입(Dependency Injection) : 객체간 의존성이 있을 때, 설정을 통해서 의존성을 주입할 수 있다. 
               - 설정자(setter) 주입
                                          설정파일에서는 <property> 사용
                 annotation 이용시 @Autowired 사용
               - 생성자 (constructor) 주입
                                          설정파일은 <constructor-arg> 사용
                 annotation 사용은 @Autowired 
    ***
    @Autowired : 타입우선 매칭 (주입하려는 setter의 데이터 타입의 bean을 spring container에서
                                        찾아와서 넣어준다. 단, @Qualifier 를 이용해서 id로 매칭 가능하다. 
                                        매칭된 bean이 많을 경우 예외 발생.  
                   
                                        
    
    
    
                
   bean 객체 생성방법
   1. 설정파일에 <bean> 태그 이용해서 직접 선언
      	bean id와 class, 의존성 주입 설정
   2. @Annotation 이용하는 방법
        bean으로 생성하고자 하는 클래스 위에 @Component Annotation 달아주고
                  설정파일에는  @Component 가 있는지 스캔하도록  <component-scan>을 작성해준다. 
        component-scan을 사용하려면 설정파일에 context namespace가 설정되어야 한다.           
   
   
   
   
   
   
   
   
   
   
   
StudentDao : 
ConnectionProvider
DaoTest : main








   
   
   
   
    