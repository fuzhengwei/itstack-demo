package itstack.demo.dao.impl;

import itstack.demo.common.dao.BaseDao;
import itstack.demo.dao.AgentDao;
import itstack.demo.domain.po.Agent;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fuzhengwei1
 * Date: 16-3-1
 * Time: 下午5:10
 * To change this template use File | Settings | File Templates.
 */
public class AgentDaoImpl extends BaseDao implements AgentDao {
    @Override
    public List<Agent> queryAgent() throws Exception {
        return this.queryForList("Agent.queryAgent");
    }
}
