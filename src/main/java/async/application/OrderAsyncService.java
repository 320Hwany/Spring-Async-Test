package async.application;

import async.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class OrderAsyncService {

    private final AsyncTask asyncTask;

    public OrderAsyncService(final AsyncTask asyncTask) {
        this.asyncTask = asyncTask;
    }

    public void calculatePrice(final List<Order> orders) {
        LocalDateTime startTime = LocalDateTime.now();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(
                orders.stream()
                        .map(asyncTask::calculateDiscountPrice)
                        .toArray(CompletableFuture[]::new)
        );

        allOf.thenRun(() -> {
            LocalDateTime endTime = LocalDateTime.now();
            Duration duration = Duration.between(startTime, endTime);
            log.info("총 걸린 시간={}", duration);
        }).join();
    }
}
