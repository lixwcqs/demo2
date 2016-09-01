package config;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by li on 2016/1/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//不能加载.properties文件，否则报错
@ContextConfiguration({"classpath:applicationContext.xml"})
@Transactional
@Component
public interface TestConfig {
    StrutsSpringTestCase xa = null;
}
