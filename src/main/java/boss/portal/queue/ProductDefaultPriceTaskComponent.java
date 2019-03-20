package boss.portal.queue;

import boss.portal.base.TaskExecuteComponent;
import boss.portal.entity.User;
import boss.portal.repository.UserRepository;
import boss.portal.util.ApplicationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @FileName: ProductDefaultPriceTaskComponent
 * @Author: zhaoxinguo
 * @Date: 2019/3/20 17:44
 * @Description: 更新商品默认价格队列处理
 */
@Service
public class ProductDefaultPriceTaskComponent extends ProductDefaultPriceTaskQueueClient {

    public ProductDefaultPriceTaskComponent() {
        super();
        RETRY_EXCEPTION = false;    //异常不重试
        consumer = true; //队列运行模式，设置为消费者
    }

    public static class UpdateProductDefaultPriceTask implements TaskExecuteComponent {

        private static Logger logger = LoggerFactory.getLogger(UpdateProductDefaultPriceTask.class);

        private String taskId;

        private UserRepository userRepository;

        @Override
        public void setTask(String taskId) {
            this.taskId = taskId;
            userRepository = ApplicationUtil.getBean("userRepository");
        }

        @Override
        public void execute(){
            Long startTime = System.currentTimeMillis();
            logger.info("[UpdateProductDefaultPriceTask:{}] start.",taskId);
            try {
                Thread.sleep(5000);
                User user = userRepository.findByUsername("aaa");
                logger.info("user：{}", user);
                logger.info("执行任务：{}",taskId);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("[UpdateProductDefaultPriceTask:{}] end, time:{}ms", taskId, System.currentTimeMillis() - startTime);
        }
    }
}
