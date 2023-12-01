package async.dto;

import async.domain.Order;

import java.util.List;

public record OrderRequest(
        List<Order> orders
) {
}
