package config;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *  加载配置文件的基础类
 *
 * Created by li on 2015/8/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//不能加载.properties文件，否则报错
@ContextConfiguration({"classpath:applicationContext.xml"})
@Transactional
//@TransactionConfiguration
public class BaseTestConfig extends AbstractJUnit4SpringContextTests {
//public class BaseTestConfig  {

    protected static Logger logger = LoggerFactory.getLogger(BaseTestConfig.class);
}
