package itstack.demo.service.impl;

import itstack.demo.common.constants.Constants;
import itstack.demo.common.domain.Result;
import itstack.demo.common.utils.GsonUtils;
import itstack.demo.domain.po.ChannelUser;
import itstack.demo.domain.res.ChannelUserRes;
import itstack.demo.service.SocketServerService;
import itstack.demo.socket.cache.CacheChannelUser;
import itstack.demo.socket.netty.ServerSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: fuzhengwei1
 * Date: 16-3-2
 * Time: 下午12:00
 * To change this template use File | Settings | File Templates.
 */
@Service("socketServerService")
public class SocketServerServiceImpl implements SocketServerService {

    private Logger logger = LoggerFactory.getLogger(SocketServerServiceImpl.class);

    private ExecutorService executorService;
    private ServerSocket serverSocket;

    public SocketServerServiceImpl() {
        try {
            logger.info("启动netty服务端开始。");
            serverSocket = new ServerSocket();
            executorService = Executors.newCachedThreadPool();
            executorService.execute(serverSocket);
            logger.info("启动netty服务端完成。");
        } catch (Exception e) {
            logger.error("启动netty服务端失败。", e);
        }
    }


    @Override
    public ChannelUserRes queryChannelUsers() {
        ChannelUserRes channelUserRes = new ChannelUserRes();
        try {
            Collection<ChannelUser> channelUsers = CacheChannelUser.cacheChannel.values();
            channelUserRes.setResult(Result.buildSuccessResult());
            channelUserRes.setChannelUsers(channelUsers);
        } catch (Exception e) {
            logger.info("链接用户失败。",e);
            channelUserRes.setResult(Result.buildFailedResult(Constants.ResponseCode.UNKNOWN_ERROR,Constants.ResponseInfo.UNKNOWN_ERROR));
        }
        return channelUserRes;
    }
}
