package async.domain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Order {

    private String orderName;
    private int price;

    public Order(final String orderName, final int price) {
        this.orderName = orderName;
        this.price = price;
    }

    public int calculatePrice(final int discountPrice) {
        log.info("OrderName={}, Start Calculate Price", orderName);
        try {
            Thread.sleep(5000);
            log.info("OrderName={}, End Calculate Price", orderName);

            return price - discountPrice;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
