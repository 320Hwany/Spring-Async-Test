package async.domain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Order(
        String orderName,
        int price
) {

    public int calculatePrice(final int discountPrice) {
        log.info("OrderName={}, Start Calculate Price", orderName);
        try {
            Thread.sleep(1000);
            log.info("OrderName={}, End Calculate Price", orderName);

            return price - discountPrice;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
