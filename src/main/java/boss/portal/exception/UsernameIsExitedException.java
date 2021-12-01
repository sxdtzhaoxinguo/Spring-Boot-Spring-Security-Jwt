package boss.portal.exception;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
public class UsernameIsExitedException extends ServiceException {

    public UsernameIsExitedException(String msg) {
        super(msg);
    }

    public UsernameIsExitedException(String msg, Throwable t) {
        super(msg, t);
    }
}