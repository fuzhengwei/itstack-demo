package itstack.demo.domain.res;

import itstack.demo.common.domain.Result;
import itstack.demo.domain.po.ChannelUser;

import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fuzhengwei1
 * Date: 16-3-2
 * Time: 下午1:09
 * To change this template use File | Settings | File Templates.
 */
public class ChannelUserRes {

    private Result result;
    private Collection<ChannelUser> channelUsers;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Collection<ChannelUser> getChannelUsers() {
        return channelUsers;
    }

    public void setChannelUsers(Collection<ChannelUser> channelUsers) {
        this.channelUsers = channelUsers;
    }
}
