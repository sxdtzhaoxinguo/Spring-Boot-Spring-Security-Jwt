package boss.portal.web.controller;

import boss.portal.entity.User;
import boss.portal.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository applicationUserRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository myUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = myUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @RequestMapping("/userList")
    @ResponseBody
    public Map<String, Object> userList(){
        List<User> myUsers = applicationUserRepository.findAll();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("users",myUsers);
        return map;
    }

    /**
     * 该方法是注册用户的方法，默认放开访问控制
     * @param user
     */
    @PostMapping("/signup")
    public void signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }

}
