package boss.portal.base;

/**
 * @FileName: TaskExecuteComponent
 * @Author: zhaoxinguo
 * @Date: 2019/2/28 19:51
 * @Description: 任务执行接口
 */
public interface TaskExecuteComponent {

    /**
     * 添加任务到队列
     * @param task
     */
    void setTask(String task);

    /**
     * 实际业务执行,抛出异常为执行失败
     */
    void execute();
}
