package itstack.demo.socket.agreement;

/**
 * Created with IntelliJ IDEA.
 * User: fuzhengwei1
 * Date: 16-3-2
 * Time: 下午1:49
 * To change this template use File | Settings | File Templates.
 */
public class Head {

    // 发送类型
    private Integer sendType;
    // channelId
    private String channelId;

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
