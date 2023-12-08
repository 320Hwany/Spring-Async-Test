package async.presentation;

import async.application.OrderSyncService;
import async.application.OrderAsyncService;
import async.dto.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalDateTime;

@Slf4j
@RestController
public class OrderController {

    private final OrderSyncService orderSyncService;
    private final OrderAsyncService orderAsyncService;

    public OrderController(final OrderSyncService orderSyncService, final OrderAsyncService orderAsyncService) {
        this.orderSyncService = orderSyncService;
        this.orderAsyncService = orderAsyncService;
    }

    @PostMapping("/orders-sync")
    public void calculatePriceSync(@RequestBody final OrderRequest orderRequest) {
        orderSyncService.calculatePrice(orderRequest.orders());
    }

    @PostMapping("/orders-async/v1")
    public void calculatePriceAsyncV1(@RequestBody final OrderRequest orderRequest) {
        orderAsyncService.calculatePriceV1(orderRequest.orders());
    }

    @PostMapping("/orders-async/v2")
    public void calculatePriceAsyncV2(@RequestBody final OrderRequest orderRequest) {
        orderAsyncService.calculatePriceV2(orderRequest.orders());
    }
}
