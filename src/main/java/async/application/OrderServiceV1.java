package async.application;

import async.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class OrderServiceV1 {

    public int calculatePrice(final List<Order> orders) {
        LocalDateTime startTime = LocalDateTime.now();

        int totalPrice = 0;
        for (Order order : orders) {
            int price = order.calculatePrice(1000);
            totalPrice += price;
        }

        LocalDateTime endTime = LocalDateTime.now();
        Duration duration = Duration.between(startTime, endTime);

        log.info("총 걸린 시간={}", duration);

        return totalPrice;
    }
}
