package boss.portal.handler;

import boss.portal.param.Result;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AuthenticationFailureHandler 用来解决身份验证失败的异常(适用表单登录方式)
 * @author zhaoxg on 2023年04月18日 10:15
 */
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        Result result = Result.error(500, exception.getMessage());
        String message = JSONUtil.toJsonStr(result);
        response.getWriter().write(message);
    }
}
