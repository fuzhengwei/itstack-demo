package itstack.demo.web.test.dao;

import itstack.demo.common.utils.GsonUtils;
import itstack.demo.dao.AgentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: fuzhengwei1
 * Date: 16-3-1
 * Time: 下午5:24
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config.xml")
public class AgentDaoTest {

    @Autowired
    private AgentDao agentDao;

    @Test
    public void test_queryAgent() throws Exception{
        System.out.println("测试结果："+ GsonUtils.toJson(agentDao.queryAgent()));
    }

}
