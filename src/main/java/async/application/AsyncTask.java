package async.application;

import async.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class AsyncTask {

    @Async
    public CompletableFuture<Void> calculateDiscountPrice(final Order order) {
        int price = order.calculatePrice(1000);
        log.info("{}의 할인 후 가격={}", order.orderName(), price);

        return CompletableFuture.completedFuture(null);
    }
}
