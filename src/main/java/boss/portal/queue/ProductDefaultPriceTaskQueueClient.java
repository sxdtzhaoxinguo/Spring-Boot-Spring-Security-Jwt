package boss.portal.queue;

import boss.portal.base.AbstractRedisTask;
import org.springframework.stereotype.Service;

/**
 * @FileName: ProductDefaultPriceTaskQueueClient
 * @Author: zhaoxinguo
 * @Date: 2019/3/20 17:43
 * @Description: 更新商品默认价格队列Client
 */
@Service
public class ProductDefaultPriceTaskQueueClient extends AbstractRedisTask {

    public ProductDefaultPriceTaskQueueClient() {
        super("ydw_product_default_price_task", "boss.portal.queue.ProductDefaultPriceTaskComponent$UpdateProductDefaultPriceTask");
    }
}
