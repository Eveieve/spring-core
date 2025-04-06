package hello.core.order;

// 클라이언트는 서비스를 통해..
public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice); // 통해 주문한다.

}
