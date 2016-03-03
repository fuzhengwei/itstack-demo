package itstack.demo.domain.po;

import io.netty.channel.Channel;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: fuzhengwei1
 * Date: 16-3-2
 * Time: 上午11:14
 * To change this template use File | Settings | File Templates.
 */
public class ChannelUser {

    private String ip;            //ip
    private Integer port;        //端口
    private String channelid;   //channelid
    private Channel channel;    //channel
    private String shakedate;     //握手日期

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getShakedate() {
        return shakedate;
    }

    public void setShakedate(String shakedate) {
        this.shakedate = shakedate;
    }
}
