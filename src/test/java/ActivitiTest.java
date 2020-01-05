import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

/**
 * @author jiange
 * @version 1.0
 * @date 2020/1/4 13:14
 */
public class ActivitiTest {

    @Test
    public void testGenTable(){
        //创建ProcessEngineConfiguration
        ProcessEngineConfiguration configuration =
                ProcessEngineConfiguration
                        .createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        //通过ProcessEngineConfiguration创建ProcessEngine，此时会创建数据库
        ProcessEngine processEngine =
                configuration.buildProcessEngine();
        System.out.println(processEngine);
    }
}
