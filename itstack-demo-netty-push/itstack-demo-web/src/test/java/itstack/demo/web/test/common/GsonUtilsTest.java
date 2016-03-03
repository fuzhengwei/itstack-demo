package itstack.demo.web.test.common;

import itstack.demo.common.constants.Constants;
import itstack.demo.common.utils.GsonUtils;
import itstack.demo.socket.agreement.Body;
import itstack.demo.socket.agreement.Head;
import itstack.demo.socket.agreement.Message;
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
public class GsonUtilsTest {

    @Test
    public void test_toJson(){
        Head head = new Head();
        head.setSendType(Constants.HeadSendType.ONE2ONE);
        head.setChannelId("edfbaefa");

        Body body = new Body();
        body.setContent("你好，我是hello");

        Message message = new Message();
        message.setHead(head);
        message.setBody(body);

        System.out.println(GsonUtils.toJson(message));
    }


}
