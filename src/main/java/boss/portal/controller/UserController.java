package boss.portal.controller;

import boss.portal.entity.User;
import boss.portal.exception.UsernameIsExitedException;
import boss.portal.param.Result;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
@Api(description = "用户管理", value = "用户管理")
@RestController
@RequestMapping("/users")
public class UserController extends BaseController {

    /**
     * 注册用户 默认开启白名单
     * @param user
     */
    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        User bizUser = userRepository.findByUsername(user.getUsername());
        if(null != bizUser){
            throw new UsernameIsExitedException("用户已经存在");
        }
        /*user.setPassword(DigestUtils.md5DigestAsHex((user.getPassword()).getBytes()));*/
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    /**
     * 获取用户列表
     * @return
     */
    @ApiModelProperty(value = "获取用户列表")
    @GetMapping("/userList")
    public Result userList(){
        List<User> users = userRepository.findAll();
        logger.info("users: {}", JSON.toJSON(users));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("users",users);
        return Result.ok(map);
    }

    /**
     * 获取用户权限
     * @return
     */
    @ApiModelProperty(value = "获取用户权限")
    @GetMapping("/authorityList")
    public Result authorityList(){
        List<String> authentication = getAuthentication();
        return Result.ok(authentication);
    }

    /**
     * 获取用户列表V2-验证不登录就可以直接请求该接口（前端传递token的情况下）
     * @return
     */
    @ApiModelProperty(value = "获取用户列表V2")
    @GetMapping("/userListV2")
    public Result userListV2(){
        List<User> users = userRepository.findAll();
        logger.info("users: {}", JSON.toJSON(users));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("users",users);
        return Result.ok(map);
    }

}
