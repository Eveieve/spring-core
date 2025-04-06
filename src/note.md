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