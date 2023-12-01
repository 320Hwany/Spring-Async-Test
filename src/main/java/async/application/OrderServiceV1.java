package async.application;

import async.domain.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceV1 {

    public int calculatePrice(final List<Order> orders) {
        int totalPrice = 0;
        for (Order order : orders) {
            int price = order.calculatePrice(1000);
            totalPrice += price;
        }

        return totalPrice;
    }
}
