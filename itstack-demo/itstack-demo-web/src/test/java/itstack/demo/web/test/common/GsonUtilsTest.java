package itstack.demo.web.test.common;

import itstack.demo.common.utils.GsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * User: fuzhengwei1
 * Date: 16-3-1
 * Time: 下午3:30
 * To change this template use File | Settings | File Templates.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("/spring-config.xml")
public class GsonUtilsTest {

    @Test
    public void test_toJson(){
        System.out.println(GsonUtils.toJson("1"));
    }


}
