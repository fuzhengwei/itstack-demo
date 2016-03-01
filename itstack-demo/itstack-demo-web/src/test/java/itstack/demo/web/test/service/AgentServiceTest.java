package itstack.demo.web.test.service;

import itstack.demo.common.utils.GsonUtils;
import itstack.demo.domain.res.AgentRes;
import itstack.demo.service.AgentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * User: fuzhengwei1
 * Date: 16-3-1
 * Time: 下午6:13
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config.xml")
public class AgentServiceTest {

    @Autowired
    private AgentService agentService;

    @Test
    public void test_queryAgent() {
        AgentRes agentRes = agentService.queryAgent(null);
        System.out.println("测试结果：" + GsonUtils.toJson(agentRes));
    }

}
