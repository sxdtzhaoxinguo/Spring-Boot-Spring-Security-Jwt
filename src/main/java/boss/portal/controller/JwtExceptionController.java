package boss.portal.controller;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName JwtExceptionController
 * @Description Jwt异常处理类
 * @Author zhaoxinguo
 * @Date 2021/11/26 15:58
 * @Version 1.0
 */
@RestController
public class JwtExceptionController {

    @RequestMapping("/expiredJwtException")
    public void expiredJwtException(HttpServletRequest request) throws ExpiredJwtException {
        if (request.getAttribute("expiredJwtException") instanceof ExpiredJwtException) {
            throw ((ExpiredJwtException) request.getAttribute("expiredJwtException"));
        }
    }

    @RequestMapping("/unsupportedJwtException")
    public void unsupportedJwtException(HttpServletRequest request) throws UnsupportedJwtException {
        if (request.getAttribute("unsupportedJwtException") instanceof UnsupportedJwtException) {
            throw ((UnsupportedJwtException) request.getAttribute("unsupportedJwtException"));
        }
    }

    @RequestMapping("/signatureException")
    public void signatureException(HttpServletRequest request) throws SignatureException {
        if (request.getAttribute("signatureException") instanceof SignatureException) {
            throw ((SignatureException) request.getAttribute("signatureException"));
        }
    }

    @RequestMapping("/illegalArgumentException")
    public void illegalArgumentException(HttpServletRequest request) throws IllegalArgumentException {
        if (request.getAttribute("illegalArgumentException") instanceof IllegalArgumentException) {
            throw ((IllegalArgumentException) request.getAttribute("illegalArgumentException"));
        }
    }

    @RequestMapping("/malformedJwtException")
    public void malformedJwtException(HttpServletRequest request) throws MalformedJwtException {
        if (request.getAttribute("malformedJwtException") instanceof MalformedJwtException) {
            throw ((MalformedJwtException) request.getAttribute("malformedJwtException"));
        }
    }

}