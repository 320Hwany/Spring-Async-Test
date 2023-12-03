package async.presentation;

import async.application.OrderSyncService;
import async.application.OrderAsyncService;
import async.dto.OrderRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/orders-async")
    public void calculatePriceAsync(@RequestBody final OrderRequest orderRequest) {
        orderAsyncService.calculatePrice(orderRequest.orders());
    }
}
