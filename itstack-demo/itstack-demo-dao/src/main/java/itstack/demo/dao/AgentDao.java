package itstack.demo.dao;

import itstack.demo.domain.po.Agent;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fuzhengwei1
 * Date: 16-3-1
 * Time: 下午5:10
 * To change this template use File | Settings | File Templates.
 */
public interface AgentDao {

    public List<Agent> queryAgent() throws Exception;

}
