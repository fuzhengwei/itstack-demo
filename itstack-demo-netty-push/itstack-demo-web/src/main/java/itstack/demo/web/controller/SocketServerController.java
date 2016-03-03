package itstack.demo.web.controller;

import itstack.demo.common.constants.Constants;
import itstack.demo.common.utils.GsonUtils;
import itstack.demo.domain.po.ChannelUser;
import itstack.demo.domain.res.ChannelUserRes;
import itstack.demo.domain.res.EasyResult;
import itstack.demo.service.SocketServerService;
import itstack.demo.socket.agreement.Body;
import itstack.demo.socket.agreement.Head;
import itstack.demo.socket.agreement.Message;
import itstack.demo.socket.cache.CacheChannelUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: fuzhengwei1
 * Date: 16-3-2
 * Time: 上午11:36
 * To change this template use File | Settings | File Templates.
 */
@Controller("socketServerController")
@RequestMapping("/socketServerController/")
public class SocketServerController {

    private Logger logger = LoggerFactory.getLogger(SocketServerController.class);

    @Autowired
    private SocketServerService socketServerService;


    @RequestMapping(value = "queryChannelUsers")
    @ResponseBody
    public Map<String, Object> queryChannelUsers() {
        ChannelUserRes channelUserRes = socketServerService.queryChannelUsers();
        if ("0000".equals(channelUserRes.getResult().getCode())) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", channelUserRes.getChannelUsers().size());
            map.put("rows", channelUserRes.getChannelUsers());
            return map;
        } else {
            return null;
        }
    }

    @RequestMapping(value = "doSendMessage")
    @ResponseBody
    public EasyResult doSendMessage(@RequestParam String channelId, @RequestParam String content) {
        String requestStr = GsonUtils.toJson(channelId) + GsonUtils.toJson(content);
        logger.info("发送消息。req：" + requestStr);
        try {
            // 查找对应id的channel
            ChannelUser channelUser = CacheChannelUser.cacheChannel.get(channelId);
            if (null != channelUser) {
                channelUser.getChannel().writeAndFlush(content);
            } else {
                return EasyResult.buildErrResult("对方已经下线");
            }
            return EasyResult.buildSuccessResult();
        } catch (Exception e) {
            logger.info("发送消息失败。req：" + requestStr, e);
            return EasyResult.buildErrResult(e);
        }
    }

}
