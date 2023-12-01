package async.presentation;

import async.application.OrderServiceV1;
import async.dto.OrderRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderServiceV1 orderServiceV1;

    public OrderController(final OrderServiceV1 orderServiceV1) {
        this.orderServiceV1 = orderServiceV1;
    }

    @PostMapping("/v1/orders")
    public int calculatePrice(@RequestBody final OrderRequest orderRequest) {
        return orderServiceV1.calculatePrice(orderRequest.orders());
    }
}
