//package boss.portal.handler;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @Auther: zhaoxinguo
// * @Date: 2018/9/20 14:58
// * @Description:
// */
//public class SimpleUrlAuthenticationFailureHandler implements AuthenticationFailureHandler {
//
//    protected final Log logger = LogFactory.getLog(getClass());
//
//    private String defaultFailureUrl;
//
//    public SimpleUrlAuthenticationFailureHandler() {
//    }
//
//    public SimpleUrlAuthenticationFailureHandler(String defaultFailureUrl) {
//        this.defaultFailureUrl = defaultFailureUrl;
//    }
//
//    @Override
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//        if (defaultFailureUrl == null) {
//            logger.debug("No failure URL set, sending 401 Unauthorized error");
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed: " + exception.getMessage());
//        } else {
//            logger.debug("defaultFailureUrl: {}" + defaultFailureUrl);
//        }
//    }
//}
