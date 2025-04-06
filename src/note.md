## AppConfig 리팩터링 

## 새로운 구조와 할인 정책 적용 
- 할인 정책을 변경해보자. FixDiscountPolicy -> RateDiscountPolicy 
- AppConfig 코드만 고치면 됨. 
- AppConfig(구성영역)는 당연히 변경됨. 공연 기획자는 공연 참여자인 구현 객체들을 모두 알아야함. 
- 사용영역(OrderServiceImpl)은 전혀 변경할 필요 없음. 

## 전체 흐름 정리 
![img.png](img.png)

## 좋은 객체 지향 설계의 5가지 원칙 적용 

![img_1.png](img_1.png)

## IoC, DI 그리고 컨테이너 
![img_2.png](img_2.png)

## 동적인 객체 인스턴스 의존 관계 
![img_3.png](img_3.png)

## 스프링 빈 조회 - 상속관계 
- 부모 타입으로 조회하면, 자식 타입도 함께 조회된다. 
- 자바 객체 최고 부모인 Object 타입으로 조회하면, 모든 스프링 빈을 조회한다. 
![img_4.png](img_4.png)

## BeanFactory와 ApplicationContext 
- BeanFactory 
- 스프링 컨테이너의 최상위 인터페이스 
- 스프링 빈을 관리하고 조회함
- getBea()을 ㅈ제공함

<ApplicationContext>
- BeanFactory 기능을 모두 상속 받아 제공함 
- 둘의 차이는? 
- 애플리케이션 개발할때는 빈을 관리/조회하는 기능은 물론, 그 외 수 많은 부가 기능 필요함. 
- 메시지 소스를 활용한 국제화 기능. 
- 환경변수 
- 애플리케이션 이벤트 
- 편리한 리소스 조회 

### 정리 
- BeanFactory 를 직접 사용할 일은 거의 없다. 부가 기능이 포함된 ApplicationContext를 사용함. 
- BeanFactory 나 ApplicationContext 를 스프링 컨테이너라고 함. 

## 다양한 설정 형식 지원 - 자바코드, XML 

- 스프링 컨테이너는 다양한 형식의 설정 정보를 받아드릴 수 있음. 

### 애노테이션 기반 자바 코드 설정 사용 
### XML 설정 사용 
- 최근에 거의 사용하지 않음. 레거시만 
- 컴파일 없이 설정 정보 저장할 수 있는 장점은 있음. 
