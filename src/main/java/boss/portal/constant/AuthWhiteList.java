package boss.portal.constant;

/**
 * @author zhaoxg on 2023年03月14日 10:46
 */
public class AuthWhiteList {

    /**
     * 需要放行的URL
     */
    public static final String[] AUTH_WHITELIST = {
            // -- register url
            "/users/signup",
            "/users/addTask",
            "/users/userListV2",
            // -- swagger ui
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
            // other public endpoints of your API may be appended to this array
    };
}
