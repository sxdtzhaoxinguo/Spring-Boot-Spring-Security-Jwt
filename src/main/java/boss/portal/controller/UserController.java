package boss.portal.controller;

import boss.portal.entity.User;
import boss.portal.queue.ProductDefaultPriceTaskQueueClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
@RestController
@RequestMapping("/users")
public class UserController extends BaseController {

    @Autowired
    private ProductDefaultPriceTaskQueueClient productDefaultPriceTaskQueueClient;

    /**
     * 获取用户列表
     * @return
     */
    @GetMapping("/userList")
    public Map<String, Object> userList(){
        List<User> users = userRepository.findAll();
        logger.info("users: {}", users);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("users",users);
        return map;
    }

    /**
     * 查询用户权限
     * @return
     */
    @GetMapping("/authorityList")
    public List<String> authorityList(){
        List<String> authentication = getAuthentication();
        return authentication;
    }

    /**
     * 添加任务到队列
     */
    @GetMapping("/addTask")
    public void addTask(){
        for (int i=0; i< 10000; i++) {
            productDefaultPriceTaskQueueClient.addTask(i + "");
        }
    }

}
