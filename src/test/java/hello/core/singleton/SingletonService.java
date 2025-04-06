package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService(); // static 영역에 객체 instance 미리 생성하여 올려둠.

    public static SingletonService getInstance() { // 이 메서드를 통해서만 이 객체에 접근할 수 있음. 한개의 객체 인스턴스만 존재함.
        return instance; // 자기자신 반환
    }

    public static void main(String[] args) {
        SingletonService instance = SingletonService.getInstance();
    }

    // 외부에서 new 키워드 사용한 객체 생성 막는다.
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
